<template>
    <div>
        <a-card :bordered="false" :bodyStyle="{ padding: '16px' }">
            <div>
                <a-form layout="inline">
                    <a-row :gutter="48">
                        <a-col :md="6" :sm="24">
                            <a-form-item :label='$t("log.keyword")'>
                                <a-input/>
                            </a-form-item>
                        </a-col>

                        <a-col :md="6" :sm="24">
                            <a-form-item :label='$t("log.type")'>
                                <a-select placeholder='$t("article.select_status")'>
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
                <a-table
                        :columns="columns"
                        :dataSource="data"
                        :bordered="true"
                        :pagination="pagination"
                        :loading="loading"
                        @change="handleTableChange"
                >
                   <span slot="type" slot-scope="type">
                           {{types[type]}}
                   </span>
                   <span slot="status" slot-scope="status">
                            <a-tag :color="status === 'SUCCESS' ? 'green' : 'volcano' ">
                              {{statusType[status]}}
                            </a-tag>
                   </span>
                </a-table>
            </div>
        </a-card>

    </div>

</template>

<script>

    import {logList} from '@/api/log'

    const columns = [
        {
            title: '时间',
            dataIndex: 'createAt',
            key: 'createAt',
            width: '20%',
            sorter: true,
        },
        {
            title: '类型',
            dataIndex: 'type',
            key: 'type',
            width: '20%',
            scopedSlots: {customRender: 'type'},
        },
        {
            title: '操作人',
            dataIndex: 'createBy',
            key: 'createBy',
            width: '20%',
        },
        {
            title: '状态',
            dataIndex: 'status',
            key: 'status',
            scopedSlots: {customRender: 'status'},
            width: '10%',
        },

        {
            title: '说明',
            dataIndex: 'remark',
            key: 'remark',
            width: '30%',
        },

    ]

    const types = {
        LOGIN: "登录",
        SYSTEM_INITIALIZATION: "系统初始化",
        ADD_ADMINISTRATOR: "添加管理员",
        ADD_SYSTEM_CONFIG: "添加系统配置",
    }

    const statusType = {
        SUCCESS: "成功",
        FAIL: "失败"
    }

    export default {
        name: "Log",
        mounted() {
            this.fetch({
                size: 10,
                pase: 1
            });
        },
        data() {
            return {
                data: [],
                pagination: {},
                loading: false,
                columns,
                types,
                statusType
            }
        },
        methods: {
            handleTableChange(pagination, filters, sorter) {
                const pager = {...this.pagination};
                pager.current = pagination.current;
                this.pagination = pager;
                this.fetch({
                    size: pagination.pageSize,
                    page: pagination.current,
                    sortField: sorter.field,
                    sortOrder: sorter.order,
                    ...filters,
                });
            },
            fetch(params = {}) {
                console.log("请去参数")
                console.log(params)
                this.loading = true
                logList(params).then(data => {
                    this.loading = false
                    this.data = data.results
                    const pagination = {...this.pagination};
                    pagination.total = data.total;
                    this.loading = false;
                    this.data = data.results;
                    this.pagination = pagination;
                }).catch(error => {
                    this.loading = false
                    console.log("错误")
                });

            }
        }
    }
</script>

<style scoped>

</style>