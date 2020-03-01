import Vue from 'vue'
import Router from 'vue-router'
import i18n from '@/locales' // internationalization

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
import Log from '@/views/system/Log'

//使用Router
Vue.use(Router)

//将组件 (components) 映射到路由
export default new Router({
    routes: [
        //根路径,默认到首页
        {
            path: '/',
            component: BasicLayout,
            children: [
                {
                    name: 'Home',
                    path: '',
                    component: DashBoard,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.dashboard")
                    }

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
                    component: ArticleList,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.articleList")
                    }

                },
            ]
        },
        //发表文章路由
        {
            path: '/article/edit',
            component: BasicLayout,
            children: [
                {
                    name: 'ArticleEditor',
                    path: '',
                    component: ArticleEditor,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.articleEdit")
                    }

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
                    component: ArticleCategoryList,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.articleCategory")
                    }

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
                    component: ArticleTagList,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.articleTag")
                    }

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
                    component: ArticleComment,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.articleComment")
                    }

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
                    component: DashBoard,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.dashboard")
                    }

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
                    component: Notification,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.notification")
                    }

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
                    component: UserList,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.user")
                    }

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
                    component: Setting,
                    title:i18n.t("page.title.setting")
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
                    component: Tools,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.tools")
                    }

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
                    component: About,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.about")
                    }

                }
            ]
        },
        //日志路由
        {
            path: '/log',
            component: BasicLayout,
            children: [
                {
                    name: 'Log',
                    path: '',
                    component: Log,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.log")
                    }

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
                    component: UserCenter,
                    meta: {
                        requireAuth: true,
                        title:i18n.t("page.title.userCenter")
                    }

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
                    component: Login,
                    meta: {
                        requireAuth: false,
                        title:i18n.t("page.title.login")
                    }
                },
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
                    component: Register,
                    meta: {
                        requireAuth: false,
                        title:i18n.t("page.title.register")
                    }

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
                    component: Installation,
                    meta: {
                        requireAuth: false,
                        title:i18n.t("page.title.install")
                    }

                }
            ]
        },
    ]
})
