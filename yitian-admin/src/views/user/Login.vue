<template>
    <div class="container">
        <div class="login-form">
            <h1>{{$t("system.name")}}</h1>
            <a-form id="login">
                <a-form-item>
                    <a-input :placeholder='$t("login.hint_user_name")'>
                        <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-input type="password" :placeholder='$t("login.hint_password")'>
                        <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)"/>
                    </a-input>
                </a-form-item>
                <a-form-item>
                    <a-checkbox>{{$t('login.remember')}}</a-checkbox>
                    <router-link class="login-form-forgot" to="/forgot">{{$t('login.forgot')}}</router-link>
                    <a-button type="primary" html-type="submit" class="login-form-button">{{$t('login.login')}}</a-button>
                    <router-link to="/register">{{$t('login.register')}}</router-link>
                </a-form-item>
            </a-form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Login"
    };
</script>
<style>
    #login .login-form-forgot {
        float: right;
    }

    #login .login-form {
        max-width: 300px;
    }

    #login .login-form-button {
        width: 100%;
    }

    .container {
        margin-top: 100px;
        display: flex;
        justify-content: center;
        align-items: center;

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
        font-size: 3rem;
    }
</style>
