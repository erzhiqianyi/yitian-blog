import Vue from 'vue'
import App from './App.vue'
import './plugins/ant-esign-vue.js'
import i18n from './locales'
import router from "./router"
import './permission'

Vue.config.productionTip = false
new Vue({
  i18n,
  router,
  render: h => h(App)
}).$mount('#app')


