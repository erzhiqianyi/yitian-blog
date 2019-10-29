<template>
    <div class="blank">
        <a-layout>
            <a-layout-content>
                <div>
                    <router-view/>
                </div>
            </a-layout-content>
        </a-layout>
    </div>
</template>
<script>
    export default {
        name: "BasicLayout",
        data() {
            return {};
        },
        methods: {}
    };
</script>

<style>
    .blank{
        background: #F0F2F5;
        height: 100%;
    }


</style>
