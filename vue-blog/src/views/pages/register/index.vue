<template>
  <div class="app">
    <div class="container">
      <b-row class="justify-content-center">
        <b-media>
          <b-img slot="aside" :src="logo" fluid-grow></b-img>
          <h1>{{systemName}}</h1>
        </b-media>
      </b-row>
      <b-row class="justify-content-center">
        <b-col md="8">
          <b-card-group>
            <b-card no-body class="p-4">
              <b-card-body>
                <b-form>
                  <h2>{{$t('register.register')}}</h2>
                  <p class="text-muted">{{$t('register.desc')}}</p>
                  <b-form-group
                    id="emailLabel"
                    label-for="email"
                    :invalid-feedback="emailInvalidFeedback"
                    :state="emailState"
                  >
                    <b-input-group class="mb-3">
                      <b-input-group-prepend>
                        <b-input-group-text>
                          <i class="icon-user"></i>
                        </b-input-group-text>
                      </b-input-group-prepend>
                      <b-form-input
                        id="email"
                        type="text"
                        class="form-control"
                        :placeholder="$t('register.email')"
                        :state="emailState"
                        autocomplete="username email"
                        v-model.trim="email"
                      />
                    </b-input-group>
                  </b-form-group>
                  <b-form-group
                    id="usernameLabel"
                    label-for="username"
                    :invalid-feedback="usernameInvalidFeedback"
                    :state="usernameState"
                  >
                    <b-input-group class="mb-3">
                      <b-input-group-prepend>
                        <b-input-group-text>
                          <i class="icon-user"></i>
                        </b-input-group-text>
                      </b-input-group-prepend>
                      <b-form-input
                        id="username"
                        type="text"
                        class="form-control"
                        :placeholder="$t('register.username')"
                        :state="usernameState"
                        autocomplete="username email"
                        v-model.trim="username"
                      />
                    </b-input-group>
                  </b-form-group>
                  <b-form-group
                    id="passwordLabel"
                    label-for="password"
                    :invalid-feedback="passwordInvalidFeedback"
                    :state="passwordState"
                  >
                    <b-input-group class="mb-4">
                      <b-input-group-prepend>
                        <b-input-group-text>
                          <i class="icon-lock"></i>
                        </b-input-group-text>
                      </b-input-group-prepend>
                      <b-form-input
                        id="password"
                        type="password"
                        class="form-control"
                        :placeholder="$t('login.password')"
                        :state="passwordState"
                        autocomplete="current-password"
                        v-model.trim="password"
                      />
                    </b-input-group>
                  </b-form-group>
                  <b-form-group
                    id="rePasswordLabel"
                    label-for="rePassword"
                    :invalid-feedback="rePasswordInvalidFeedback"
                    :state="rePasswordState"
                  >
                    <b-input-group class="mb-4">
                      <b-input-group-prepend>
                        <b-input-group-text>
                          <i class="icon-lock"></i>
                        </b-input-group-text>
                      </b-input-group-prepend>
                      <b-form-input
                        id="rePassowrd"
                        type="password"
                        class="form-control"
                        :placeholder="$t('login.re_password')"
                        :state="rePasswordState"
                        autocomplete="current-password"
                        v-model.trim="rePassword"
                      />
                    </b-input-group>
                  </b-form-group>
                  <b-form-group
                    id="codeLabel"
                    label-for="code"
                    :invalid-feedback="codeInvalidFeedback"
                    :state="codeState"
                  >
                    <b-input-group>
                      <b-form-input 
                        id="code"
                        type="text"
                        class="form-control"
                        :placeholder="$t('register.code')"
                        :state="codeState"
                        v-model.trim="code"
                      ></b-form-input>
                      <b-button  variant="primary" :disabled="!emailState" >获取验证码</b-button>
                      
                    </b-input-group>
                  </b-form-group>
                  <b-row>
                    <b-col cols="6">
                      <b-button
                        variant="primary"
                        class="px-4"
                        @click="login"
                        :disabled="!( emailState && usernameState && passwordState && rePasswordState) || loading"
                      >
                        <b-spinner v-show="loading" small type="grow"></b-spinner>
                        <span>{{registerState}}</span>
                      </b-button>
                    </b-col>
                    <b-col cols="6" class="text-right">
                      <b-button variant="link" class="px-0">{{$t('register.login')}}</b-button>
                    </b-col>
                  </b-row>
                </b-form>
              </b-card-body>
            </b-card>
            <b-card no-body class="text-white bg-primary py-5 d-md-down-none">
              <b-card-body class="text-center">
                <div>
                  <h2>{{$t('system.user_protocol')}}</h2>
                  <p>{{protocol}}</p>
                </div>
              </b-card-body>
            </b-card>
          </b-card-group>
        </b-col>
      </b-row>
    </div>
  </div>
</template>

<script>
import { validSize, validEmail } from "@/utils/validate";
import axios from "axios";
export default {
  name: "Register",
  computed: {
    usernameState() {
      return (
        validSize(this.username, 3, 20, this.$t("register.username")).length ===
        0
      );
    },
    usernameInvalidFeedback() {
      return validSize(this.username, 3, 20, this.$t("register.username"));
    },
    passwordState() {
      return (
        validSize(this.password, 6, 30, this.$t("login.password")).length === 0
      );
    },
    passwordInvalidFeedback() {
      return validSize(this.password, 6, 30, this.$t("login.password"));
    },
    rePasswordState() {
      return this.rePassword == this.password;
    },
    rePasswordInvalidFeedback() {
      return this.rePassword != this.password
        ? this.$t("register.wrong_password")
        : "";
    },

    emailState() {
      return (
        validEmail(this.email, 5, 50, this.$t("register.email")).length === 0 &&
        validEmail(this.email).length === 0
      );
    },
    emailInvalidFeedback() {
      return (
        validSize(this.email, 5, 50, this.$t("register.email")) ||
        validEmail(this.email)
      );
    },
    codeState() {
      return validSize(this.code, 6, 6, this.$t("register.code")).length === 0;
    },
    codeInvalidFeedback() {
      return validSize(this.code, 6, 6, this.$t("register.code"));
    }
  },

  data() {
    return {
      username: "",
      password: "",
      rePassword: "",
      email: "",
      code: "",
      loading: false,
      logo:
        "https://github.com/erzhiqianyi/spring-boot-vue-blog/blob/master/image/logo.png?raw=true",
      systemName: "一天博客系统",
      registerState: this.$t("register.register"),
      protocol: "注册即代表你同意以下条款"
    };
  },
  methods: {
    login: function() {
      let payload = {
        username: this.username,
        password: this.password
      };
      this.loading = true;
      this.registerState = this.$t("register.register_loading");
      axios
        .post("api/auth/login", payload)
        .then(response => {
          console.log(response);
        })
        .catch(error => {
          this.loading = false;
          this.registerState = this.$t("register.register");
        });
    }
  }
};
</script>
<style>
h1 {
  display: flex;
  align-items: center;
  min-height: 20vh;
}
</style>