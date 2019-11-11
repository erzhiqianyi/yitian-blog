<template>
    <div>
        <a-row type="flex" justify="center" align="middle">
            <a-col :xl="8" :md="12" :sm="20" :xs="24">
                <div class="install-form">
                    <a-spin :spinning="spinning" :tip="spinningMsg">
                        <h1>{{$t('h1.install.title')}}</h1>
                        <div class="steps-form">
                            <a-steps :current="current">
                                <a-step v-for="item in steps" :key="item.title" :title="item.title"/>
                            </a-steps>
                            <a-divider dashed/>
                            <div class="steps-content">
                                <a-form id="install" layout="horizontal" :form="form">
                                    <div v-show="current == 0">
                                        <a-form-item>
                                            <a-input :placeholder='$t("form.install.email")'
                                                     v-decorator="['email',{ rules: emailRule}]">
                                                <a-icon slot="prefix" type="mail" class="icon"/>
                                            </a-input>
                                        </a-form-item>

                                        <a-form-item>
                                            <a-input :placeholder='$t("form.install.nickname")'
                                                     v-decorator="['nickname',{ rules: nicknameRule }]"
                                            >
                                                <a-icon slot="prefix" type="user" class="icon"/>
                                            </a-input>
                                        </a-form-item>

                                        <a-form-item>
                                            <a-input :placeholder='$t("form.install.password")'
                                                     v-decorator="['password',{ rules: passwordRule}]"
                                                     type="password"
                                            >
                                                <a-icon slot="prefix" type="lock" class="icon"/>
                                            </a-input>
                                        </a-form-item>

                                    </div>
                                    <div v-show="current == 1">
                                        <a-form-item>
                                            <a-input :placeholder='$t("form.install.domain")'
                                                     v-decorator="['domain',{ rules: domainRule}]">
                                                <a-icon slot="prefix" type="link" class="icon"/>
                                            </a-input>
                                        </a-form-item>

                                        <a-form-item>
                                            <a-input :placeholder='$t("form.install.system_name")'
                                                     v-decorator="['systemName',{ rules: systemNameRule}]">
                                                <a-icon slot="prefix" type="tag" class="icon"/>
                                            </a-input>
                                        </a-form-item>

                                    </div>

                                    <div v-show="current == 2">
                                        <a-form-item :label='$t("form.install.system_name")' :label-col="{ span: 5 }"
                                                     :wrapper-col="{ span: 12 }">
                                            {{form.getFieldValue("systemName")}}
                                        </a-form-item>
                                        <a-form-item :label='$t("form.install.domain")' :label-col="{ span: 5 }"
                                                     :wrapper-col="{ span: 12 }">
                                            {{form.getFieldValue("domain")}}
                                        </a-form-item>
                                        <a-form-item :label='$t("form.install.email")' :label-col="{ span: 5 }"
                                                     :wrapper-col="{ span: 12 }">
                                            {{form.getFieldValue("email")}}
                                        </a-form-item>
                                        <a-form-item :label='$t("form.install.nickname")' :label-col="{ span: 5 }"
                                                     :wrapper-col="{ span: 12 }">
                                            {{form.getFieldValue("nickname")}}
                                        </a-form-item>
                                        <a-form-item :label='$t("form.install.password")' :label-col="{ span: 5 }"
                                                     :wrapper-col="{ span: 12 }">
                                            {{form.getFieldValue("password")}}
                                        </a-form-item>

                                    </div>

                                </a-form>

                            </div>
                            <div class="steps-action">
                                <a-button v-if="current < steps.length - 1" type="primary" @click="next">
                                    {{$t('button.install.next')}}
                                </a-button>
                                <a-button v-if="current == steps.length - 1" type="primary" @click="handlerInstall"
                                          :disabled="installDisabled">
                                    {{$t('button.install.install')}}
                                </a-button>
                                <a-button v-if="current>0" @click="prev" class="ml-10" :disabled="installDisabled">
                                    {{$t('button.install.previous')}}
                                </a-button>
                            </div>
                        </div>
                    </a-spin>

                </div>
            </a-col>
        </a-row>

        <a-modal :title='$t("modal.alert")' v-model="visible" >
            <p>
                <span>{{$t('modal.install_msg')}}</span>
           </p>
            <template slot="footer">
                <a-button  @click="goToLogin">{{$t('button.install.login')}}</a-button>
            </template>
        </a-modal>

    </div>
</template>

<script>
    import {install_step} from '@/utils/step' // internationalization
    import {
        emailRule, passwordRule, nicknameRule, hasErrors, fieldError, domainRule, systemNameRule
    } from '@/utils/formRule'

    import {install, installed} from '@/api/system'
    import i18n from '@/locales' // internationalization

    export default {
        name: "Installation",
        data() {
            return {
                current: 0,
                steps: install_step,
                emailRule,
                passwordRule,
                nicknameRule,
                systemNameRule,
                domainRule,
                hasErrors,
                fieldError,
                form: this.$form.createForm(this, {name: 'install'}),
                installDisabled: false,
                spinning: true,
                visible:false,
                spinningMsg: i18n.t("tip.init")
            };
        },
        created() {
            this.verifyInstall()
        },
        mounted() {
            this.$nextTick(() => {
                //加载页面禁用button
                this.form.validateFields()
            });
        },

        methods: {
            next() {
                if (this.current == 0) {
                    this.form.validateFields((err) => {
                        if (err && (err.email || err.nickname || err.password)) {
                            return;
                        }
                        this.current++;
                    });
                } else if (this.current == 1) {
                    this.form.validateFields((err) => {
                        if (err && (err.domain || err.systemName)) {
                            return;
                        }
                        this.current++;
                    });
                }
            },
            prev() {
                this.current--;
            },
            handlerInstall(e) {
                e.preventDefault();
                this.form.validateFields((err, values) => {
                    if (!err) {
                        this.spinningMsg = i18n.t("tip.install")
                        this.spinning = true
                        this.installDisabled = true
                        this.install(values)
                    }
                });

            },
            install(values) {
                install(values).then(data => {
                    this.spinning = false
                    this.installDisabled = false
                    if (data.installed) {
                        this.visible = true
                    }
                }).catch(error => {
                    this.spinning = false
                    this.installDisabled = false
                });

            },
            verifyInstall() {
                installed().then(data => {
                    if (data.installed) {
                        this.goToLogin()
                    }else {
                        this.spinning = false
                    }
                }).catch(error => {
                    this.$router.push({name: 'Login'})
                });
            },
            goToLogin(){
                this.visible = false
                this.$router.push({name: 'Login'})
            }
        },
    }
</script>

<style scoped>


    .steps-action {
        margin-top: 24px;
    }

    .ml-10 {
        margin-left: 10px;
    }

    .install-form {
        padding: 50px;
        margin: 50px;
        background-color: #ffffff;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    }

    h1 {
        text-align: center;
        font-size: 2rem;
    }

    .icon {
        color: rgba(0, 0, 0, .25)
    }

</style>
