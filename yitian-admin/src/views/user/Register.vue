<template>
    <div class="container">
        <div class="register-form">
            <h1>{{$t("system.name")}}</h1>
            <a-form id="register" :form="form" @submit="handleRegister">
                <a-form-item>
                    <a-input :placeholder='$t("form.register.email")'
                             v-decorator="['email',{ rules: emailRule}]"
                    >
                        <a-icon slot="prefix" type="mail" style="color: rgba(0,0,0,.25)"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input :placeholder='$t("form.register.nickname")'
                             v-decorator="['nickname',{ rules: nicknameRule }]"
                    >
                        <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input :placeholder='$t("form.register.password")'
                             v-decorator="['password',{ rules: passwordRule}]"
                             type="password"
                    >
                        <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input :placeholder='$t("form.register.confirm_password")'
                             v-decorator="['confirmPassword',{ rules: confirmPasswordRule}]"
                             type="password"
                    >
                        <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-row :gutter="8">
                        <a-col :span="12">
                            <a-input :placeholder='$t("form.register.captcha")'
                                     v-decorator="['captcha',{ rules: registerCaptchaRule}]"
                            />
                        </a-col>
                        <a-col :span="12">
                            <a-button :disabled="fieldError(form,'email') || !countDown.canClick "
                                      @click="handleGetCaptcha">
                                {{countDown.get_captcha}}
                            </a-button>
                        </a-col>
                    </a-row>
                </a-form-item>
                <a-form-item>
                    <a-checkbox
                            v-decorator="['agree',{ rules: checkBoxRule}]">
                        {{$t('checkbox.register.read_agreement')}}
                        <a href="">
                            {{$t('link.register.agreement')}}
                        </a>
                    </a-checkbox>
                </a-form-item>
                <a-form-item>
                    <a-button type="primary" html-type="submit" class="register-form-button"
                              :disabled="hasErrors(form.getFieldsError())">
                        {{$t('button.register.register')}}
                    </a-button>
                    <router-link to="/login">{{$t('link.register.login')}}</router-link>
                </a-form-item>
            </a-form>
        </div>
        <a-modal :title='$t("modal.alert")' v-model="visible" @ok="closeConfirmAgreement">
            <p>
                <span>{{$t('modal.agree')}}</span>
                <a href="">
                    {{$t('link.register.agreement')}}
                </a>
            </p>
        </a-modal>
    </div>
</template>

<script>

    import i18n from '@/locales' // internationalization
    import {
        emailRule, passwordRule, confirmPasswordRule, registerCaptchaRule,
        checkBoxRule, nicknameRule, hasErrors, fieldError
    } from '@/utils/formRule'

    import axios from 'axios'

    export default {
        name: "Register",
        data() {
            let checkRePassword = (rule, value, callback) => {
                if (value != this.form.getFieldValue("password")) {
                    callback(new Error(i18n.t("rule.confirm_password_wrong")))
                } else {
                    callback()
                }
            }
            confirmPasswordRule.push(checkRePassword);
            return {
                hasErrors,
                emailRule,
                passwordRule,
                confirmPasswordRule,
                nicknameRule,
                registerCaptchaRule,
                checkBoxRule,
                fieldError,
                form: this.$form.createForm(this, {name: 'register'}),
                countDown: {
                    get_captcha: i18n.t("button.register.get_captcha"),
                    totalTime: 10,
                    canClick: true
                },
                visible: false

            };
        },
        mounted() {
            this.$nextTick(() => {
                //加载页面禁用button
                this.form.validateFields();
            });
        },
        methods: {
            handleRegister(e) {
                e.preventDefault();
                this.form.validateFields((err, values) => {
                    if (!values.agree) {
                        this.showConfirmAgreement()
                        return
                    }
                    if (!err) {
                        this.register(values)
                    }
                });
            },
            register(values) {
                axios
                    .post('register', values)
                    .then(response => {
                        console.log("success")
                    })
                    .catch(error => {
                        console.log("fail");
                    });

            },
            showConfirmAgreement() {
                this.visible = true
            },
            closeConfirmAgreement() {
                this.visible = false
            },
            handleGetCaptcha() {
                if (!this.countDown.canClick) {
                    return
                }
                this.countDown.canClick = false
                this.countDown.get_captcha = this.countDown.totalTime + i18n.t("button.register.get_captcha_waiting");
                let clock = window.setInterval(() => {
                    this.countDown.totalTime--
                    this.countDown.get_captcha = this.countDown.totalTime + i18n.t("button.register.get_captcha_waiting");
                    if (this.countDown.totalTime < 0) {
                        window.clearInterval(clock)
                        this.countDown.get_captcha = i18n.t("button.register.get_captcha");
                        this.countDown.totalTime = 10
                        this.countDown.canClick = true
                    }
                }, 1000);

                this.getCaptcha(clock)

            },
            getCaptcha(clock){
                axios
                    .post('code', this.form.getFieldValue("email"))
                    .then(response => {
                        console.log("success")
                    })
                    .catch(error => {
                        window.clearInterval(clock)
                        console.log("fail");
                        this.countDown.get_captcha = i18n.t("button.register.get_captcha");
                        this.countDown.totalTime = 10
                        this.countDown.canClick = true

                    });

            }
        }

    };
</script>
<style>

    #register .register-form {
        max-width: 500px;
        min-width: 200px;
    }

    #register .register-form-button {
        width: 100%;
    }

    .container {
        margin: 10px 0 10px;
        display: flex;
        justify-content: center;
        align-items: center;

    }

    .register-form {
        padding: 50px;
        margin: 50px;
        background-color: #ffffff;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    }

    h1 {
        text-align: center;
        font-size: 3rem;
    }
</style>
