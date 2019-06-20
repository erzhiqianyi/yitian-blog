import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import i18n from './lang' // internationalization

new Vue({
  i18n ,
  render: h => h(App),
}).$mount('#app')
