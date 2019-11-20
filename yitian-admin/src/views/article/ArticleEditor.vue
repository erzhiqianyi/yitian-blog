<template>
    <div>
        <div style="margin-bottom: 16px">
            <a-input >
                <a-icon slot="addonAfter" type="save" />
            </a-input>
        </div>
        <MarkdownEditor v-model="content"/>

    </div>
</template>

<script>

    import MarkdownEditor from "../../components/markdown";

    export default {
        name: "ArticleEditor",
        components: {MarkdownEditor},
        data() {
            return {
                content: '',
            }
        },
    }
</script>

<style scoped>

</style>
