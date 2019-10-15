import Vue from 'vue'
import App from './App.vue'
import './plugins/ant-esign-vue.js'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
