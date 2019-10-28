import Vue from 'vue'
import Router from 'vue-router'

//引入组件
import ArticleList from '@/views/article/ArticleList'
import ArticleEditor from '@/views/article/ArticleEditor'
import ArticleCategoryList from '@/views/article/ArticleCategoryList'
import ArticleTagList from '@/views/article/ArticleTagList'
import ArticleComment from '@/views/article/ArticleComment'
import DashBoard from '@/views/dashboard/DashBoard'
import Notification from '@/views/notification/Notification'
import UserList from '@/views/user/UserList'
import UserCenter from '@/views/user/UserCenter'
import Setting from '@/views/system/Setting'
import Tools from '@/views/system/Tools'
import About from '@/views/system/About'

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
        },
        //发表文章路由
        {
            path: '/article/edit', //路由路径
            name: 'ArticleEditor', //路由名字
            component: ArticleEditor //映射组件
        },
        //分类路由
        {
            path: '/article/category',
            name: 'ArticleCategoryList',
            component: ArticleCategoryList
        },
        //标签路由
        {
            path: '/article/tag',
            name: 'ArticleTagList',
            component: ArticleTagList
        },
        //评论路由
        {
            path: '/article/comment',
            name: 'ArticleComment',
            component: ArticleComment
        },
        //首页路由
        {
            path: '/dashboard',
            name: 'DashBoard',
            component: DashBoard
        },
        //通知路由
        {
            path: '/notification',
            name: 'Notification',
            component: Notification
        },
        //用户列表路由
        {
            path: '/user',
            name: 'UserList',
            component: UserList
        },
        //博客设置路由
        {
            path: '/system/setting',
            name: 'Setting',
            component: Setting
        },
        //小工具路由
        {
            path: '/tools',
            name: 'Tools',
            component: Tools
        },
        //关于路由
        {
            path: '/about',
            name: 'About',
            component: About
        },
         //个人中心路由
        {
            path: '/user/profile',
            name: 'UserCenter',
            component: UserCenter
        },
    ]
})
