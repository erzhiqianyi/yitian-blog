<template>
    <BasicLayout/>
</template>
<style>

</style>

<script>
    import zh_CN from 'ant-design-vue/lib/locale-provider/zh_CN'
    import BasicLayout from '@/layout/BasicLayout'
    export default {
        name: 'app',
        components: {BasicLayout},
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
