<template>
    <div>
        <div>
            <a-form-item>
                <a-input v-model="title" :placeholder='$t("article.hint_input_title")'/>
            </a-form-item>
            <div style="margin-top: 20px">
                <a-button type="primary" @click="postArticle">{{$t('article.post_article')}}
                </a-button>
            </div>
        </div>
        <div id="editor">
            <textarea v-model="input"/>
            <div v-html="compiledMarkdown"></div>
        </div>

    </div>
</template>

<script>
    import marked from 'marked';
    export default {
        name: "ArticleEditor",
        data() {
            return {
                title: '',
                input: '# hello'
            }
        },
        computed: {
            compiledMarkdown: function () {
                return marked(this.input, {sanitize: true})
            }
        },
        methods: {
            postArticle(){
                alert("post success")
            }
        }
    }
</script>

<style scoped>
    html, body, #editor {
        margin: 10px;
        height: 100%;
        font-family: 'Helvetica Neue', Arial, sans-serif;
        color: #333;
    }

    textarea, #editor div {
        display: inline-block;
        width: 49%;
        height: 100%;
        vertical-align: top;
        box-sizing: border-box;
        padding: 0 20px;
        background-color: #f6f6f6;
    }

    textarea {
        border: none;
        border-right: 1px solid #ccc;
        resize: none;
        outline: none;
        background-color: #f6f6f6;
        font-size: 14px;
        font-family: 'Monaco', courier, monospace;
        padding: 20px;
        height: 500px;
    }

    code {
        color: #f66;
    }
</style>
