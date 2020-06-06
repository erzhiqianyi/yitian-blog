<template>
    <div>
        <div style="margin-bottom: 16px;float: right">
            <a-button type="primary" style="margin-left: 10px" @click="showDrawer"> {{$t('button.article.publish')}}
            </a-button>
        </div>
        <div style="margin-bottom: 16px">
            <a-input v-model="title.title" :placeholder='$t("article.hint_input_title")'
                     @change="setArticleLink"/>
        </div>
        <div>
            <mavon-editor v-model="content.content" class="mavonEditor"/>
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
                                        <a-form-item :label='$t("article.article_link")'
                                                     :help="'/blog/'+ (link.url ? link.url :
                                                     title.title)">
                                            <a-input :placeholder='$t("article.hint_input_link")'
                                                     v-model="link.url"/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>
                                <a-row>
                                    <a-col>
                                        <a-form-item :label='$t("article.password")'>
                                            <a-input :placeholder='$t("article.hint_input_password")'
                                                     v-model="link.password"/>
                                        </a-form-item>
                                    </a-col>
                                </a-row>
                                <a-row>
                                    <a-col>
                                        <a-form-item>
                                            <span>{{$t('article.recommend')}}</span>
                                            <a-switch :checkedChildren='$t("basic.Y")'
                                                      :unCheckedChildren='$t("basic.N")'
                                                      v-model="recommend.recommend"
                                            />
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
                                                      v-model="comment.allow"
                                            />
                                        </a-form-item>
                                    </a-col>
                                    <a-col>
                                        <a-form-item>
                                            <span>{{$t('article.check_comment')}}</span>
                                            <a-switch :checkedChildren='$t("basic.Y")'
                                                      :unCheckedChildren='$t("basic.N")'
                                                      v-model="comment.check"
                                            />
                                        </a-form-item>
                                    </a-col>
                                </a-row>

                                <a-row>
                                    <a-col>
                                        <a-form-item :label='$t("article.publish_time")'>
                                            <a-select labelInValue :defaultValue="{ key: 'NOW' }"
                                                      v-model="publish.trigger">
                                                <a-select-option value="NOW">立即发布</a-select-option>
                                                <a-select-option value="TIMING">定时发布</a-select-option>
                                            </a-select>
                                        </a-form-item>
                                        <a-form-item>
                                            <a-date-picker show-time format="YYYY-MM-DD HH:mm:ss"
                                                           v-model="publish.time"
                                            />
                                        </a-form-item>
                                    </a-col>
                                </a-row>

                                <!--
                                                                <a-row>
                                                                    <a-col>
                                                                        <a-form-item label="标签">
                                                                            <a-select mode="tags" style="width: 100%" placeholder="Tags Mode"
                                                                                      v-model="article.tags">
                                                                                <a-select-option>
                                                                                </a-select-option>
                                                                            </a-select>
                                                                        </a-form-item>

                                                                    </a-col>
                                                                </a-row>
                                 -->

                            </div>


                        </a-form>

                        <div class="bottom-control">
                            <a-button class="m-8" @click="onClose">保存草稿</a-button>
                            <a-button class="m-8">保存</a-button>
                            <a-button class="m-8" type="primary" @click="post">发布</a-button>
                        </div>
                    </div>
                </div>
            </a-drawer>
        </div>

    </div>
</template>

<script>
    import {mavonEditor} from 'mavon-editor'
    import 'mavon-editor/dist/css/index.css'
    import {postArticle} from '@/api/article'


    export default {
        name: "ArticleEditor",
        components: {
            mavonEditor
        },
        data() {
            return {
                visible: false,
                placement: 'right',
                title: {
                    title: '测试标题'
                },
                content: {
                    content: '测试内容'
                },
                link: {
                    url: '',
                    password: ''
                },
                publish: {
                    trigger: 'NOW',
                    time: null,
                },
                comment: {
                    allow: true,
                    check: true
                },
                recommend: {
                    recommend: true
                },
                switch:{
                    true:"OPEN",
                    false:"CLOSE"
                }
            }
        },
        methods: {
            showDrawer() {
                this.visible = true;
            },
            onClose() {
                this.visible = false;
            },
            post() {
                var article = {
                    title: this.title,
                    content: this.content,
                    config:{
                        link:this.link,
                        publish: {

                        },
                        comment:{
                            allow: this.switch[this.comment.allow]
                        }
                    }
                }
                postArticle(article).then(data => {
                    console.log(data)
                }).catch(error => {
                    console.log(error)
                });
            },
            setArticleLink() {
                this.link.link = this.title.title
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


    .mavonEditor {
        width: 100%;
        height: 100%;
        z-index: inherit;
    }
</style>
