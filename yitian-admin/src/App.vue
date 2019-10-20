<template>
    <a-layout id="components-layout-demo-top" class="layout">
        <a-layout-header>
            <a-menu
                    theme="dark"
                    mode="horizontal"
                    :defaultSelectedKeys="['2']"
                    :style="{ lineHeight: '64px' }"
            >
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
            <div :style="{ background: '#fff', padding: '24px', minHeight: '1024px' }">Content</div>
        </a-layout-content>
        <a-layout-footer style="text-align: center">
            一天 ©2019 Created by 一天
        </a-layout-footer>
    </a-layout>
</template>
<style>
    #components-layout-demo-top .logo {
        width: 120px;
        height: 31px;
        background: rgba(255, 255, 255, 0.2);
        margin: 16px 24px 16px 0;
        float: left;
    }
</style>

<script>
    import zh_CN from 'ant-design-vue/lib/locale-provider/zh_CN'

    export default {
        name: 'app',
        data() {
            return {
                zh_CN,
            }
        },

    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        color: #2c3e50;
    }


</style>
