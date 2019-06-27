import Vue from 'vue'
import Router from 'vue-router'

//引入登录和注册组件
import Login from '@/views/pages/login'
import Register from '@/views/pages/register'

//使用Router
Vue.use(Router)

//将组件 (components) 映射到路由 
export default new Router({
    routes: [
        //根路径,默认跳转到登录页面
        {
            path: '/',
            name: 'Home',
            component: Login
        },
        //登录路由
        {
            path: '/login', //路由路径
            name: 'Login', //路由名字
            component: Login //映射组件
        }  ,
        //注册路由
        {
            path: '/register', //路由路径
            name: 'Resiger', //路由名字
            component: Register //映射组件
        }
    ]
})