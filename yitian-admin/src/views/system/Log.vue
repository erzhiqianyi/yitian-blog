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

            <div style="margin: 30px ;text-align: center">

                <a-table :columns="columns" :dataSource="data" :bordered="true" :pagination="{pageSize: 10}">

                </a-table>
            </div>
        </a-card>

    </div>

</template>

<script>
    const columns = [
        {
            title: '时间',
            dataIndex: 'time',
            key: 'time',
            width: '20%',
        },
        {
            title: '类型',
            dataIndex: 'type',
            key: 'type',
            width: '20%',
        },
        {
            title: '操作人',
            dataIndex: 'operator',
            key: 'operator',
            width: '20%',
        },
        {
            title: '状态',
            dataIndex: 'status',
            key: 'status',
            width: '10%',
        },

        {
            title: '说明',
            dataIndex: 'remark',
            key: 'remark',
            width: '30%',
        },

   ];

    const data = [
        {
            time: '2019-11-16 08:11:11',
            type: '博客初始化',
            operator:"系统管理员",
            status: "成功",
            remark: '系统初始化',
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