<template>
    <div class="container">
        <div class="register-form">
            <h1>{{$t("system.name")}}</h1>
            <a-form id="register">
                <a-form-item  :label='$t("register.label_email")'>
                    <a-input />
                </a-form-item>
                <a-form-item  :label='$t("register.label_password")'>
                    <a-input type="password"/>
                </a-form-item>
                <a-form-item  :label='$t("register.label_confirm_password")'>
                    <a-input type="password" />
                </a-form-item>
                <a-form-item :label='$t("register.label_nickname")'>
                    <a-input/>
                </a-form-item>
               <a-form-item :label='$t("register.label_captcha")'>
                    <a-row :gutter="8">
                        <a-col :span="12">
                            <a-input/>
                        </a-col>
                        <a-col :span="12">
                            <a-button>{{$t('register.get_captcha')}}</a-button>
                        </a-col>
                    </a-row>
                </a-form-item>
                <a-form-item>
                    <a-checkbox>
                        {{$t('register.hint_read')}}
                        <a href="">
                            {{$t('register.agreement')}}
                        </a>
                    </a-checkbox>
                </a-form-item>
                <a-form-item >
                    <a-button type="primary" html-type="submit" class="login-form-button">{{$t('register.register')}}</a-button>
                    <router-link to="/login">{{$t('register.login')}}</router-link>
                </a-form-item>
            </a-form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Register"
    };
</script>
<style>

    #register .register-form {
        max-width: 300px;
    }
    #register .login-form-button {
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
