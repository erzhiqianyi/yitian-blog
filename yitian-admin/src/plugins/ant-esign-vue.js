import Vue from 'vue'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';

//全局注入Antd插件，作为全局组件，不需要在每个组件文件中都import Antd
Vue.use(Antd)
