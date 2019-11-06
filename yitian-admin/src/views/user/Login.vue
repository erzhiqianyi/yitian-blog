<template>
    <div class="container">
        <a-row type="flex" justify="center" align="middle">
            <a-col :xl="8" :md="12" :sm="20" :xs="24">
                <div class="login-form">
                    <h1>{{$t("system.name")}}</h1>
                    <a-form id="login" :form="form" @submit="handleLogin">
                        <a-form-item>
                            <a-input :placeholder='$t("form.login.email")'
                                     v-decorator="['email',{ rules: emailRule}]"
                            >
                                <a-icon slot="prefix" type="mail"  class="icon"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-input type="password" :placeholder='$t("form.login.password")'
                                     v-decorator="['password',{ rules: passwordRule}]"
                            >
                                <a-icon slot="prefix" type="lock"  class="icon"/>
                            </a-input>
                        </a-form-item>
                        <a-form-item>
                            <a-checkbox>{{$t('checkbox.login.remember')}}</a-checkbox>
                            <router-link class="login-form-forgot" to="/forgot">{{$t('link.login.forgot')}}
                            </router-link>
                            <a-button type="primary" html-type="submit" class="login-form-button"
                                      :disabled="(hasErrors(form.getFieldsError()) || !loginCanClick)">
                                {{$t('button.login.login')}}
                            </a-button>
                            <router-link to="/register">{{$t('link.login.register')}}</router-link>
                        </a-form-item>
                    </a-form>
                </div>
            </a-col>
        </a-row>
    </div>
</template>

<script>
    import {emailRule, passwordRule, hasErrors} from '@/utils/formRule'
    import {loginByPassword} from '@/api/auth'

    export default {
        name: "Login",
        data() {
            return {
                hasErrors,
                emailRule,
                passwordRule,
                form: this.$form.createForm(this, {name: 'login'}),
                loginCanClick: true
            };
        },
        mounted() {
            this.$nextTick(() => {
                //加载页面禁用button
                this.form.validateFields();
            });
        },
        methods: {
            handleLogin(e) {
                console.log("登录")
                e.preventDefault();
                this.form.validateFields((err, values) => {
                    if (!err) {
                        this.loginCanClick = false;
                        this.login(values);
                    }
                });
            }
            ,
            login(values) {
                loginByPassword(values).then(data => {
                    this.loginCanClick = true;
                }).catch(error => {
                    this.loginCanClick = true;
                });

            }
        }
    };
</script>
<style>
    #login .login-form-forgot {
        float: right;
    }

    #login .login-form-button {
        width: 100%;
    }


    .login-form {
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

    .icon{
        color: rgba(0,0,0,.25)
    }
</style>
