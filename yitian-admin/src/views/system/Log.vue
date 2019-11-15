<template>
    <div>
        <a-card :bordered="false" :bodyStyle="{ padding: '16px' }">
            <div>
                <a-form layout="inline">
                    <a-row :gutter="48">
                        <a-col :md="6" :sm="24">
                            <a-form-item :label='$t("log.keyword")'>
                                <a-input v-model="queryParam.keyword"/>
                            </a-form-item>
                        </a-col>

                        <a-col :md="6" :sm="24">
                            <a-form-item :label='$t("log.type")'>
                                <a-select v-model="queryParam.status" placeholder='$t("article.select_status")'>
                                    <a-select-option value="draft">系统配置</a-select-option>
                                    <a-select-option value="publish">文章</a-select-option>
                                    <a-select-option value="publish">评论</a-select-option>
                                    <a-select-option value="publish">用户</a-select-option>
                                </a-select>
                            </a-form-item>
                        </a-col>


                        <a-col :md="6" :sm="24"><span class="table-page-search-submitButtons">
                            <a-button type="primary">{{$t('log.query')}}</a-button>
                            <a-button style="margin-left: 8px;">{{$t('log.reset')}}</a-button>
                        </span>
                        </a-col>
                    </a-row>
                </a-form>
            </div>

            <div style="margin-top: 20px">
                
            </div>

            <div style="margin: 30px ;text-align: center">

                <a-table :columns="columns" :dataSource="data" :bordered="true" :pagination="{pageSize: 10}">
                    <span slot="tags" slot-scope="tags">
                        <a-tag v-for="tag in tags"
                               :color="tag==='loser' ? 'volcano' : (tag.length > 5 ? 'geekblue' : 'green')" :key="tag">
                            {{tag.toUpperCase()}}
                        </a-tag>
                    </span>
                    <span slot="action">
                        <a href="javascript:;">{{$t('basic.edit')}}</a>
                        <a-divider type="vertical"/>
                        <a href="javascript:;">{{$t('basic.delete')}}</a>
                    </span>
                </a-table>
            </div>
        </a-card>

    </div>

</template>

<script>
    const columns = [
        {
            title: '标题',
            dataIndex: 'title',
            key: 'title',
        },
        {
            title: '状态',
            dataIndex: 'status',
            key: 'status',
        },
        {
            title: '分类',
            dataIndex: 'category',
            key: 'category',
        },

        {
            title: '标签',
            key: 'tags',
            dataIndex: 'tags',
            scopedSlots: {customRender: 'tags'},
        },
        {
            title: '访问',
            dataIndex: 'hit',
            key: 'hit',
        },
        {
            title: '评论',
            dataIndex: 'comment',
            key: 'comment',
        },

        {
            title: '操作',
            key: 'action',
            scopedSlots: {customRender: 'action'},
        },
    ];

    const data = [
        {
            key: '1',
            title: 'Hello 一天',
            status: '草稿',
            category: '编程',
            hit: 1,
            comment: 1,
            tags: ['博客', '测试'],
        }

    ];
    export default {
        name: "Log",
        data() {
            return {
                queryParam: {
                    page: 0,
                    size: 10,
                    sort: null,
                    keyword: null,
                    categoryId: null,
                    status: null,

                },
                data,
                columns,
            }
        },
        methods: {
            toArticleEditor() {
                this.$router.push({path: 'article/edit'});
            }
        }
    }
</script>

<style scoped>

</style>