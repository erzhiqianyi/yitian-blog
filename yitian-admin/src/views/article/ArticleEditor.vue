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
                                        <a-form-item :label='$t("article.article_link")'>
                                            <a-input :placeholder='$t("article.hint_input_link")'/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>
                                <a-row>
                                    <a-col>
                                        <a-form-item :label='$t("article.password")'>
                                            <a-input :placeholder='$t("article.hint_input_password")'/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>
                                <a-row>
                                    <a-col>
                                        <a-form-item>
                                            <span>{{$t('article.recommend')}}</span>
                                            <a-switch :checkedChildren='$t("basic.Y")'
                                                      :unCheckedChildren='$t("basic.N")'/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>

                                <a-row>
                                    <a-col>
                                        <a-form-item>
                                            <span>{{$t('article.comment')}}</span>
                                            <a-switch defaultChecked
                                                      :checkedChildren='$t("basic.open")'
                                                      :unCheckedChildren='$t("basic.close")'
                                            />
                                        </a-form-item>
                                    </a-col>
                                    <a-col>
                                        <a-form-item>
                                            <span>{{$t('article.check_comment')}}</span>
                                            <a-switch :checkedChildren='$t("basic.Y")'
                                                      :unCheckedChildren='$t("basic.N")'/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>

                                <a-row>
                                    <a-col>
                                        <a-form-item :label='$t("article.publish_time")'>
                                            <a-select labelInValue :defaultValue="{ key: 'instance' }">
                                                <a-select-option value="instance">立即发布</a-select-option>
                                                <a-select-option value="time">定时发布</a-select-option>
                                            </a-select>
                                        </a-form-item>
                                        <a-form-item>
                                            <a-date-picker show-time format="YYYY-MM-DD HH:mm:ss"/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>

                                <a-row>
                                    <a-col>
                                        <a-form-item label="标签">
                                            <a-select mode="tags" style="width: 100%" placeholder="Tags Mode">
                                                <a-select-option v-for="i in 25" :key="(i + 9).toString(36) + i"
                                                >{{(i + 9).toString(36) + i}}
                                                </a-select-option>
                                            </a-select>
                                        </a-form-item>

                                    </a-col>
                                </a-row>

                            </div>


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

    span {
        margin-right: 20px;
    }

    .ant-row {
        padding-bottom: 1px;
    }
</style>
