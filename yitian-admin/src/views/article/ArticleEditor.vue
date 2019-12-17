<template>
    <div>
        <div style="margin-bottom: 16px;float: right">
            <a-button type="primary" style="margin-left: 10px" @click="showDrawer"> {{$t('button.article.publish')}}
            </a-button>
        </div>
        <div style="margin-bottom: 16px">
            <a-input/>
        </div>
        <div>
            <MarkdownEditor v-model="content"/>
        </div>
        <div>
            <a-drawer
                    :title='$t("article.article_setting")'
                    :placement="placement"
                    :closable="false"
                    @close="onClose"
                    :width="360"
                    :visible="visible"
                    :wrapStyle="{height: 'calc(100% - 108px)',overflow: 'auto',paddingBottom: '108px'}"
            >
                <div>
                    <div>
                        <a-form layout="vertical">
                            <div>
                                <a-row>
                                    <a-col>
                                        <a-form-item label="文章链接">
                                            <a-input placeholder="请输入文章链接"/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>
                                <a-row>
                                    <a-col>
                                        <a-form-item label="访问密码">
                                            <a-input placeholder="请输入文章链接"/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>
                                <a-row>
                                    <a-col>
                                        <a-form-item label="是否置顶：">
                                            <a-switch checkedChildren="是" unCheckedChildren="否"/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>

                                <a-row>
                                    <a-col>
                                        <a-form-item label="开启评论：">
                                            <a-switch defaultChecked checkedChildren="开" unCheckedChildren="关"/>
                                        </a-form-item>
                                    </a-col>
                                    <a-col>
                                        <a-form-item label="审核评论：">
                                            <a-switch checkedChildren="是" unCheckedChildren="否"/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>
                            </div>

                            <a-divider/>

                        </a-form>

                        <div class="bottom-control">
                            <a-button class="m-8" @click="onClose">保存草稿</a-button>
                            <a-button class="m-8">保存</a-button>
                            <a-button class="m-8" type="primary">发布</a-button>
                        </div>
                    </div>
                </div>
            </a-drawer>
        </div>

    </div>
</template>

<script>

    import MarkdownEditor from '@/components/markdown' // internationalization

    export default {
        name: "ArticleEditor",
        components: {MarkdownEditor},
        data() {
            return {
                content: '',
                visible: false,
                placement: 'right',
            }
        },
        methods: {
            showDrawer() {
                this.visible = true;
            },
            onClose() {
                this.visible = false;
            }

        },
    }
</script>

<style scoped>

    .bottom-control {
        position: absolute;
        bottom: 0px;
        width: 100%;
        border-top: 1px solid rgb(232, 232, 232);
        padding: 10px 16px;
        text-align: right;
        left: 0px;
        background: rgb(255, 255, 255);
        border-radius: 0px 0px 4px 4px;
    }

    .m-8 {
        margin-right: 8px;
    }

</style>
