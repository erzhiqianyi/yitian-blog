<template>
    <a-layout id="components-layout-demo-top" class="layout">
        <a-layout-header>
            <a-menu theme="dark" mode="horizontal"
                    :defaultSelectedKeys="['article']"
                    :style="{ lineHeight: '64px' }"
                    @click="handleClick">
                <a-sub-menu key="center">
                    <span slot="title"><a-icon type="user"/><span>{{$t('menu.user_center')}}</span></span>
                    <a-menu-item key="/user/profile">{{$t('menu.user_profile')}}</a-menu-item>
                    <a-menu-item key="/logout">{{$t('menu.logout')}}</a-menu-item>
                </a-sub-menu>

                <a-menu-item key="/dashboard">
                    <a-icon type="dashboard"/>
                    {{$t('menu.index')}}
                </a-menu-item>

                <a-sub-menu key="/article">
                    <span slot="title"><a-icon type="edit"/><span>{{$t('menu.article')}}</span></span>
                    <a-menu-item key="/article">{{$t('menu.articleList')}}</a-menu-item>
                    <a-menu-item key="/article/edit">{{$t('menu.article_post')}}</a-menu-item>
                    <a-menu-item key="/article/category">{{$t('menu.category')}}</a-menu-item>
                    <a-menu-item key="/article/tag">{{$t('menu.tag')}}</a-menu-item>
                </a-sub-menu>

                <a-menu-item key="/article/comment">
                    <a-icon type="appstore"/>
                    {{$t('menu.comment')}}
                </a-menu-item>

                <a-menu-item key="/notification">
                    <a-icon type="notification"/>
                    {{$t('menu.notification')}}
                </a-menu-item>

                <a-menu-item key="/user">
                    <a-icon type="team"/>
                    {{$t('menu.user')}}
                </a-menu-item>


                <a-sub-menu key="/system">
                    <span slot="title"><a-icon type="setting"/><span>{{$t('menu.system')}}</span></span>
                    <a-menu-item key="/system/setting">{{$t('menu.setting')}}</a-menu-item>
                    <a-menu-item key="/tools">{{$t('menu.tools')}}</a-menu-item>
                    <a-menu-item key="/about">{{$t('menu.about')}}</a-menu-item>
                </a-sub-menu>


            </a-menu>
        </a-layout-header>
        <a-layout-content style="padding: 0 50px">
            <a-breadcrumb style="margin: 16px 0">
                <a-breadcrumb-item>{{$t('menu.index')}}</a-breadcrumb-item>
                <a-breadcrumb-item>{{$t('menu.article')}}</a-breadcrumb-item>
                <a-breadcrumb-item>{{$t('menu.article_post')}}</a-breadcrumb-item>
            </a-breadcrumb>
            <div :style="{ background: '#fff', padding: '24px', minHeight: '1000px' }">
                <router-view/>
            </div>
        </a-layout-content>
        <a-layout-footer style="text-align: center ">
            一天 ©2019 Created by 一天
        </a-layout-footer>
    </a-layout>
</template>
<script>
    export default {
        name: "BasicLayout",
        data() {
            return {
                current: ['dashboard'],
            };
        },
        methods: {
            handleClick(e) {
                this.$router.push({path: e.key});
            },
        }
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
