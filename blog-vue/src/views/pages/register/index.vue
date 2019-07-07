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
                        <el-col :span="10" class="ml-10">
                            <el-button type="primary" @click="onSubmit">{{$t("register.get_code")}}</el-button>
                        </el-col>
                    </el-form-item>
                    <el-form-item :label='$t("register.protocol")'>
                        <el-switch v-model="register.protocol" active-color="#13ce66"></el-switch>
                        <el-form-item>
                            <el-link type="primary">{{$t("register.agree_protocol")}}</el-link>
                        </el-form-item>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit('register')">
                            {{$t("register.register")}}
                        </el-button>
                        <el-form-item>
                            <el-link type="primary">{{$t("register.login")}}</el-link>
                        </el-form-item>
                    </el-form-item>
                </el-form>
            </div>
        </div>

    </div>
</template>

<script>
    import {validEmail} from "@/utils/validator";

    export default {
        name: "Register",
        data() {
            var checkRePassword = (rule, value, callback) => {
                if (value !== this.register.password) {
                    callback(new Error(this.$t("feedback.password_not_same")))
                } else {
                    callback();
                }
            }

            return {
                register: {
                    name: '',
                    email: '',
                    password: '',
                    rePassword: '',
                    code: '',
                    protocol: false
                },
                rules: {
                    name: [
                        {required: true, message: this.$t("feedback.enter_name"), trigger: 'blur'},
                        {min: 3, max: 20, message: this.$t("feedback.name_length"), trigger: 'blur'}
                    ],
                    email: [
                        {required: true, message: this.$t("feedback.enter_email"), trigger: 'blur'},
                        {min: 3, max: 30, message: this.$t("feedback.email_length"), trigger: 'blur'},
                        {validator: validEmail, trigger: 'blur'}
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
                    protocol: [
                        {required: true, message: this.$t("feedback.enter_code"), trigger: 'change'},
                    ]


                }
            }
        }
        ,
        methods: {
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (!valid) {
                        console.log("不提交")
                        return false;
                    } else {
                        console.log("提交")
                    }
                });
            },
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
        background-color: #ffffff;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    }

    h1 {
        text-align: center;
    }
</style>
