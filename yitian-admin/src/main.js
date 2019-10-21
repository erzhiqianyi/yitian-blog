import Vue from 'vue'
import App from './App.vue'
import './plugins/ant-esign-vue.js'
import i18n from './locales'

Vue.config.productionTip = false

new Vue({
  i18n,
  render: h => h(App)
}).$mount('#app')


