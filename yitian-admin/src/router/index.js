import Vue from 'vue'
import Router from 'vue-router'

//引入组件
import BasicLayout from '@/layout/BasicLayout'
import BlankLayout from '@/layout/BlankLayout'
import ArticleList from '@/views/article/ArticleList'
import ArticleEditor from '@/views/article/ArticleEditor'
import ArticleCategoryList from '@/views/article/ArticleCategoryList'
import ArticleTagList from '@/views/article/ArticleTagList'
import ArticleComment from '@/views/article/ArticleComment'
import DashBoard from '@/views/dashboard/DashBoard'
import Notification from '@/views/notification/Notification'
import UserList from '@/views/user/UserList'
import UserCenter from '@/views/user/UserCenter'
import Login from '@/views/user/Login'
import Register from '@/views/user/Register'
import Setting from '@/views/system/Setting'
import Installation from '@/views/system/Installation'
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
            component: BasicLayout,
            children: [
                {
                    name: 'Home',
                    path: '',
                    component: DashBoard
                }
            ]
        },
        //文章列表路由
        {
            path: '/article', //路由路径
            component: BasicLayout,
            children: [
                {
                    name: 'ArticleList', //路由名字
                    path: '',
                    component: ArticleList //映射组件
                },
            ]
        },
        //发表文章路由
        {
            path: '/article/edit', //路由路径
            component: BasicLayout,
            children: [
                {
                    name: 'ArticleEditor', //路由名字
                    path: '',
                    component: ArticleEditor //映射组件
                }
            ],
        },
        //分类路由
        {
            path: '/article/category',
            component: BasicLayout,
            children: [
                {
                    name: 'ArticleCategoryList',
                    path: '',
                    component: ArticleCategoryList
                }
            ]
        },
        //标签路由
        {
            path: '/article/tag',
            component: BasicLayout,
            children: [
                {
                    name: 'ArticleTagList',
                    path: '',
                    component: ArticleTagList
                }
            ]
        },
        //评论路由
        {
            path: '/article/comment',
            component: BasicLayout,
            children: [
                {
                    name: 'ArticleComment',
                    path: '',
                    component: ArticleComment
                }
            ]
        },
        //首页路由
        {
            path: '/dashboard',
            component: BasicLayout,
            children: [
                {
                    name: 'DashBoard',
                    path: '',
                    component: DashBoard
                }
            ]
        },
        //通知路由
        {
            path: '/notification',
            component: BasicLayout,
            children: [
                {
                    name: 'Notification',
                    path: '',
                    component: Notification
                }
            ]
        },
        //用户列表路由
        {
            path: '/user',
            component: BasicLayout,
            children: [
                {
                    name: 'UserList',
                    path: '',
                    component: UserList
                }
            ]
        },
        //博客设置路由
        {
            path: '/system/setting',
            component: BasicLayout,
            children: [
                {
                    name: 'Setting',
                    path: '',
                    component: Setting
                }
            ],
        },
        //小工具路由
        {
            path: '/tools',
            component: BasicLayout,
            children: [
                {
                    name: 'Tools',
                    path: '',
                    component: Tools
                }
            ],
        },
        //关于路由
        {
            path: '/about',
            component: BasicLayout,
            children: [
                {
                    name: 'About',
                    path: '',
                    component: About
                }
            ]
        },
        //个人中心路由
        {
            path: '/user/profile',
            component: BasicLayout,
            children: [
                {
                    name: 'UserCenter',
                    path: '',
                    component: UserCenter
                }
            ]
        },
        //登录路由
        {
            path: '/login',
            component: BlankLayout,
            children: [
                {
                    name: 'Login',
                    path: '',
                    component: Login
                }
            ]
        },
        //注册路由
        {
            path: '/Register',
            component: BlankLayout,
            children: [
                {
                    name: 'Register',
                    path: '',
                    component: Register
                }
            ]
        },
        //安装向导路由
        {
            path: '/install',
            component: BlankLayout,
            children: [
                {
                    name: 'Install',
                    path: '',
                    component: Installation
                }
            ]
        },
    ]
})
