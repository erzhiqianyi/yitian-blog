<template>
       <a-layout id="components-layout-demo-top" class="layout">
        <a-layout-header>
            <a-menu theme="dark" mode="horizontal" :defaultSelectedKeys="['article']" :style="{ lineHeight: '64px' }">
                <a-sub-menu key="center">
                    <span slot="title"><a-icon type="user"/><span>个人中心</span></span>
                    <a-menu-item key="setting">个人资料</a-menu-item>
                    <a-menu-item key="logout">退出</a-menu-item>
                </a-sub-menu>

                <a-menu-item key="dashboard">
                    <a-icon type="dashboard"/>
                    首页
                </a-menu-item>

                <a-sub-menu key="article">
                    <span slot="title"><a-icon type="edit"/><span>文章</span></span>
                    <a-menu-item key="article">所有文章</a-menu-item>
                    <a-menu-item key="article/post">写文章</a-menu-item>
                    <a-menu-item key="category">分类</a-menu-item>
                    <a-menu-item key="tag">标签</a-menu-item>
                </a-sub-menu>

                <a-menu-item key="comment">
                    <a-icon type="appstore"/>
                    评论
                </a-menu-item>

                <a-menu-item key="notification">
                    <a-icon type="notification"/>
                    通知
                </a-menu-item>

                <a-menu-item key="user">
                    <a-icon type="team"/>
                    用户
                </a-menu-item>


                <a-sub-menu key="system">
                    <span slot="title"><a-icon type="setting"/><span>系统</span></span>
                    <a-menu-item key="setting">博客设置</a-menu-item>
                    <a-menu-item key="tools">小工具</a-menu-item>
                    <a-menu-item key="about">关于</a-menu-item>
                </a-sub-menu>


            </a-menu>
        </a-layout-header>
        <a-layout-content style="padding: 0 50px">
            <a-breadcrumb style="margin: 16px 0">
                <a-breadcrumb-item>首页</a-breadcrumb-item>
                <a-breadcrumb-item>文章</a-breadcrumb-item>
                <a-breadcrumb-item>写文章</a-breadcrumb-item>
            </a-breadcrumb>
            <div :style="{ background: '#fff', padding: '24px', minHeight: '1000px' }">
                <ArticleList/>
            </div>
        </a-layout-content>
        <a-layout-footer style="text-align: center ">
            一天 ©2019 Created by 一天
        </a-layout-footer>
    </a-layout>
</template>
<script>
    import ArticleList from '@/views/article/ArticleList'
    export default {
        name: "BasicLayout",
        components: {ArticleList},
        data() {
            return {
                current: ['dashboard'],
            };
        },
    };
</script>

<style>

    #app .ant-layout-header {
    }

    #app .ant-menu {
        height: 100%;
    }

    #app .ant-menu-submenu {
        height: 100%;
        padding: 15px
    }

    #app .ant-menu-item {
        height: 100%;
        padding: 15px
    }


    #app .ant-layout-footer {
        color: #fff;
    }

    #app .ant-layout-footer {
        line-height: 1.5;
    }

</style>
