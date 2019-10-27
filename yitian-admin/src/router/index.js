import Vue from 'vue'
import Router from 'vue-router'

//引入组件
import ArticleList from '@/views/article/ArticleList'
import ArticleEditor from '@/views/article/ArticleEditor'

//使用Router
Vue.use(Router)

//将组件 (components) 映射到路由
export default new Router({
    routes: [
        //根路径,默认到文章页面
        {
            path: '/',
            name: 'Home',
            component: ArticleList
        },
        //文章列表路由
        {
            path: '/article', //路由路径
            name: 'ArticleList', //路由名字
            component: ArticleList //映射组件
        }  ,
        //发表文章路由
        {
            path: '/article/edit', //路由路径
            name: 'ArticleEditor', //路由名字
            component: ArticleEditor //映射组件
        }
    ]
})
