<template>
    <a-locale-provider :locale="locale">
        <router-view/>
    </a-locale-provider>
</template>
<style>

</style>

<script>
    import zhCN from 'ant-design-vue/lib/locale-provider/zh_CN';
    export default {
        name: 'app',
        data() {
            return {
                locale: zhCN,
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
