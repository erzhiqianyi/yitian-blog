import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import i18n from './lang' // internationalization
import router from "./router"

new Vue({
  i18n ,
  router,
  render: h => h(App),
}).$mount('#app')
