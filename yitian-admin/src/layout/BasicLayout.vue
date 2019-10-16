<template>
    <div id="app">
        <a-menu v-model="current" mode="horizontal">
            <a-menu-item key="index">
                <a-icon type="setting"/>
                一天
            </a-menu-item>
            <a-menu-item key="app">
                <a-icon type="appstore"/>
                仪表盘
            </a-menu-item>
            <a-sub-menu>
                <span slot="title" class="submenu-title-wrapper"><a-icon
                        type="setting"/>文章</span>
                <a-menu-item key="setting:1">所有文章</a-menu-item>
                <a-menu-item key="setting:2">写文章</a-menu-item>
                <a-menu-item key="setting:3">分类</a-menu-item>
                <a-menu-item key="setting:4">标签</a-menu-item>
            </a-sub-menu>
            <a-menu-item key="app">
                <a-icon type="appstore"/>
                评论
            </a-menu-item>

            <a-menu-item key="app">
                <a-icon type="appstore"/>
                用户
            </a-menu-item>
            <a-sub-menu>
                <span slot="title" class="submenu-title-wrapper"><a-icon
                        type="setting"/>系统</span>
                <a-menu-item key="setting:1">博客设置</a-menu-item>
                <a-menu-item key="setting:2">工具</a-menu-item>
                <a-menu-item key="setting:4">关于</a-menu-item>
            </a-sub-menu>


        </a-menu>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                current: ['mail'],
            };
        },
    };
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }
</style>
