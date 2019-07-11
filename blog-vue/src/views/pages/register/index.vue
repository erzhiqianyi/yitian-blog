<template>
    <div class="app">
        <div class="container">
            <div class="form">
                <h1>{{$t("system.name")}}</h1>
                <el-form ref="register" :model="register" status-icon :rules="rules" label-width="100px">
                    <el-form-item :label='$t("register.name")' :required=true prop="name">
                        <el-input v-model="register.name" :placeholder='$t("register.name")'></el-input>
                    </el-form-item>
                    <el-form-item :label='$t("register.email")' :required=true prop="email">
                        <el-input v-model="register.email" :placeholder='$t("register.email")'></el-input>
                    </el-form-item>
                    <el-form-item :label='$t("register.password")' :required=true prop="password">
                        <el-input v-model="register.password" :placeholder='$t("register.password")'
                                  type="password"></el-input>
                    </el-form-item>
                    <el-form-item :label='$t("register.re_password")' :required=true prop="rePassword">
                        <el-input v-model="register.rePassword" :placeholder='$t("register.re_password")'
                                  type="password"></el-input>
                    </el-form-item>
                    <el-form-item :label='$t("register.code")' :required=true prop="code">
                        <el-col :span="10">
                            <el-input v-model="register.code" :placeholder='$t("register.code")'></el-input>
                        </el-col>
                        <el-col :span="5" class="ml-10">
                            <el-button type="primary" @click="getCode"
                                       :disabled="!(countDown.canClick && this.countDown.emailSate) ">
                                {{countDown.sendCodeMsg}}
                            </el-button>
                        </el-col>
                    </el-form-item>
                    <el-form-item :label='$t("register.protocol")' :required=true>
                        <el-switch v-model="register.protocol" active-color="#13ce66"></el-switch>
                        <el-form-item>
                            <el-link type="primary">{{$t("register.agree_protocol")}}</el-link>
                        </el-form-item>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="doRegister('register')" :disabled="!registerClick">
                            {{$t("button.register")}}
                        </el-button>
                        <el-form-item>
                            <el-link type="primary" @click="handleLink('login')">{{$t("register.login")}}</el-link>
                        </el-form-item>
                    </el-form-item>
                </el-form>
            </div>
        </div>

    </div>
</template>

<script>
    import {validEmail} from "@/utils/validator";
    import {registerByEmail} from '@/api/auth'
    import {getEmailCode} from '@/api/code'

    export default {
        name: "Register",
        data() {
            let checkRePassword = (rule, value, callback) => {
                if (value !== this.register.password) {
                    callback(new Error(this.$t("feedback.password_not_same")))
                } else {
                    callback()
                }
            }

            let checkEmail = (rule, value, callback) => {
                if (validEmail(value)) {
                    this.countDown.emailSate = true
                    callback()
                } else {
                    this.countDown.emailSate = false
                    callback(new Error(this.$t("feedback.email_format")))
                }
            }

            return {
                register: {
                    name: '1234',
                    email: '123@123.com',
                    password: '123456',
                    rePassword: '123456',
                    code: '12345',
                    protocol: true
                },
                countDown: {
                    sendCodeMsg: this.$t("button.get_code"),
                    totalTime: 60,
                    canClick: true,
                    emailSate: false
                },
                registerClick: true,
                rules: {
                    name: [
                        {required: true, message: this.$t("feedback.enter_name"), trigger: 'blur'},
                        {min: 3, max: 20, message: this.$t("feedback.name_length"), trigger: 'blur'}
                    ],
                    email: [
                        {required: true, message: this.$t("feedback.enter_email"), trigger: 'blur'},
                        {min: 3, max: 30, message: this.$t("feedback.email_length"), trigger: 'blur'},
                        {validator: checkEmail, trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: this.$t("feedback.enter_password"), trigger: 'blur'},
                        {min: 3, max: 20, message: this.$t("feedback.password_length"), trigger: 'blur'},
                    ],
                    rePassword: [
                        {required: true, message: this.$t("feedback.enter_re_password"), trigger: 'blur'},
                        {min: 3, max: 20, message: this.$t("feedback.password_length"), trigger: 'blur'},
                        {validator: checkRePassword, trigger: 'blur'}
                    ],
                    code: [
                        {required: true, message: this.$t("feedback.enter_code"), trigger: 'blur'},
                        {min: 4, max: 8, message: this.$t("feedback.code_length"), trigger: 'blur'},
                    ],

                }
            }
        }
        ,
        methods: {
            doRegister(formName) {
                let fieldValid = true;
                this.$refs[formName].validate((valid) => {
                    if (!valid) {
                        fieldValid = false;
                    }
                });

                if (!fieldValid) {
                    return false;
                }

                fieldValid = this.register.protocol;
                if (!fieldValid) {
                    this.$alert('', this.$t("feedback.agree_protocol"), {
                        confirmButtonText: this.$t("button.confirm"),
                        center: true,
                    });
                    return;
                }

                this.registerClick = false
                registerByEmail(this.register).then(data => {
                    console.log("注册成功")
                }).catch(error => {
                    this.registerClick = true
                    console.log("注册失败")
                });

            },
            getCode() {
                if (!this.countDown.canClick) {
                    return
                }
                this.countDown.canClick = false
                this.countDown.sendCodeMsg = this.countDown.totalTime + this.$t("button.get_code_after")
                let clock = window.setInterval(() => {
                    this.countDown.totalTime--
                    this.countDown.sendCodeMsg = this.countDown.totalTime + this.$t("button.get_code_after")
                    if (this.countDown.totalTime < 0) {
                        window.clearInterval(clock)
                        this.countDown.sendCodeMsg = this.$t("button.get_code")
                        this.countDown.totalTime = 60
                        this.countDown.canClick = true
                    }
                }, 1000);

                getEmailCode(this.register.email).then(data => {
                    console.log("获取成功成功")
                }).catch(error => {
                    window.clearInterval(clock)
                    this.countDown.sendCodeMsg = this.$t("button.get_code")
                    this.countDown.totalTime = 60
                    this.countDown.canClick = true
                    console.log("获取失败")
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
