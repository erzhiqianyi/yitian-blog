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
                  <h2>{{$t('login.login')}}</h2>
                  <p class="text-muted">{{$t('login.desc')}}</p>
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
                        :placeholder="$t('login.username')"
                        :state="usernameState"
                        autocomplete="username email"
                        v-model.trim="username"
                      />
                    </b-input-group>
                  </b-form-group>
                  <b-form-group
                    id="passwordLabel"
                    label-for="username"
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
                  <b-row>
                    <b-col cols="6">
                      <b-button
                        variant="primary"
                        class="px-4"
                        @click="login"
                        :disabled="!(usernameState && passwordState) || loading"
                      >
                        <b-spinner v-show="loading" small type="grow"></b-spinner>
                        <span>{{loginState}}</span>
                      </b-button>
                    </b-col>
                    <b-col cols="6" class="text-right">
                      <b-button variant="link" class="px-0">{{$t('login.forgot_password')}}</b-button>
                    </b-col>
                  </b-row>
                </b-form>
              </b-card-body>
            </b-card>
            <b-card no-body class="text-white bg-primary py-5 d-md-down-none">
              <b-card-body class="text-center">
                <div>
                  <h2>{{$t('login.register')}}</h2>
                  <p>{{sologan}}</p>
                  <b-button
                    variant="primary"
                    class="active mt-3"
                    :to="{path: 'register'}"
                  >{{$t('login.register_now')}}</b-button>
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
import { validSize } from "@/utils/validate";
import axios from "axios";
import { loginByPassword  } from '@/api/auth'
import { async } from 'q';
export default {
  name: "Login",
  computed: {
    usernameState() {
      return (
        validSize(this.username, 3, 20, this.$t("login.username")).length === 0
      );
    },
    usernameInvalidFeedback() {
      return validSize(this.username, 3, 20, this.$t("login.username"));
    },
    passwordState() {
      return (
        validSize(this.password, 6, 30, this.$t("login.password")).length === 0
      );
    },
    passwordInvalidFeedback() {
      return validSize(this.password, 6, 30, this.$t("login.password"));
    }
  },

  data() {
    return {
      username: "1235464",
      password: "123345",
      loading: false,
      logo:
        "https://github.com/erzhiqianyi/spring-boot-vue-blog/blob/master/image/logo.png?raw=true",
      systemName: "一天博客系统",
      loginState: this.$t("login.login"),
      sologan: "一天，世界，记录点滴，如此美好"
    };
  },
  methods: {
     login : function() {
      let payload = {
        username: this.username,
        password: this.password
      };
      this.loading = true;
      this.loginState = this.$t("login.login_loading");
      const result =   loginByPassword(payload)
      console.log(result)
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
