import Vue from 'vue'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

//全局注入Element插件，作为全局组件，不需要在每个组件文件中都import Element
Vue.use(Element)
