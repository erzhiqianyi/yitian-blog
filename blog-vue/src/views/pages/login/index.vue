<template>
    <div class="app">
        <div class="container">
            <div class="form">
                <h1>{{$t("system.name")}}</h1>
                <el-form ref="login" :model="login" status-icon :rules="rules" label-width="120px">
                    <el-form-item :label='$t("login.email")' :required=true prop="email">
                        <el-input v-model="login.email" :placeholder='$t("login.email")'></el-input>
                    </el-form-item>
                    <el-form-item :label='$t("register.password")' :required=true prop="password">
                        <el-input v-model="login.password" :placeholder='$t("register.password")'
                                  type="password"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="doLogin('login')" :disabled="!loginClick">
                            {{$t("button.login")}}
                        </el-button>
                    </el-form-item>

                    <el-form-item>
                        <el-link type="primary" @click="handleLink('register')">{{$t("login.register")}}</el-link>
                        <el-link type="danger" class="ml-10">{{$t("login.find_password")}}</el-link>
                    </el-form-item>


                </el-form>
            </div>
        </div>

    </div>
</template>

<script>

    import {validEmail} from "@/utils/validator";
    import {loginByPassword} from '@/api/auth'

    export default {
        name: "Login",
        data() {
            let checkEmail = (rule, value, callback) => {
                if (validEmail(value)) {
                    callback()
                } else {
                    callback(new Error(this.$t("feedback.email_format")))
                }
            }

            return {
                login: {
                    email: '123@123.com',
                    password: '123456',
                },
                loginClick: true,
                rules: {
                    email: [
                        {required: true, message: this.$t("feedback.enter_email"), trigger: 'blur'},
                        {min: 3, max: 20, message: this.$t("feedback.email"), trigger: 'blur'},
                        {validator: checkEmail, trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: this.$t("feedback.enter_password"), trigger: 'blur'},
                        {min: 3, max: 20, message: this.$t("feedback.password_length"), trigger: 'blur'},
                    ],
                }
            }
        }
        ,
        methods: {
            doLogin(formName) {
                let fieldValid = true;
                this.$refs[formName].validate((valid) => {
                    if (!valid) {
                        fieldValid = false;
                    }
                });

                if (!fieldValid) {
                    return false;
                }

                this.loginClick = false
                loginByPassword(this.login).then(data => {
                    console.log("登录成功")
                }).catch(error => {
                    this.loginClick = true
                    console.log("登录失败")
                });
            },
            handleLink(link) {
                this.$router.push({path: link});
            }
        }

    }
</script>

<style scoped>
    .ml-10 {
        margin-left: 10px;
    }

    .container {
        margin-top: 100px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .form {
        padding: 20px;
        width: 500px;
        background-color: #ffffff;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    }

    h1 {
        text-align: center;
    }
</style>
