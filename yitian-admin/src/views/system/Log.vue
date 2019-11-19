<template>
    <div>
        <a-card :bordered="false" :bodyStyle="{ padding: '16px' }">
            <div>
                <a-form layout="inline">
                    <a-row :gutter="48">
                        <a-col :md="12" :sm="24">
                            <a-form-item :label='$t("log.keyword")'>
                                <a-input v-model="param.keyWord"/>
                            </a-form-item>
                        </a-col>

                        <a-col :md="12" :sm="24"><span class="table-page-search-submitButtons">
                            <a-button type="primary" @click="query">{{$t('log.query')}}</a-button>
                            <a-button style="margin-left: 8px;" @click="reset">{{$t('log.reset')}}</a-button>
                        </span>
                        </a-col>
                    </a-row>
                </a-form>
            </div>

            <div style="margin: 30px ;text-align: center">
                <a-table
                        :columns="log_column"
                        :dataSource="data"
                        :bordered="true"
                        :pagination="pagination"
                        :loading="loading"
                        @change="handleTableChange"
                >
                   <span slot="type" slot-scope="type">
                           {{log_enum.types[type]}}
                   </span>
                    <span slot="status" slot-scope="status">
                            <a-tag :color="status === 'SUCCESS' ? 'green' : 'volcano' ">
                                {{log_enum.status[status]}}
                            </a-tag>
                   </span>
                </a-table>
            </div>
        </a-card>

    </div>

</template>

<script>

    import {logList} from '@/api/log'
    import {log_column} from '@/utils/table'
    import {log_type, log_status} from '@/utils/select'
    import {log_enum} from '@/utils/enums'

    export default {
        name: "Log",
        mounted() {
            this.fetch({
                size: 10,
                page: 1
            });
        },
        data() {
            return {
                data: [],
                pagination: {},
                loading: false,
                log_type,
                log_status,
                log_column,
                log_enum,
                param: {
                    keyWord: null,
                }
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
                    keyWord: this.param.keyWord,
                    ...filters,
                });
            },
            fetch(params = {}) {
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
                });

            },
            reset() {
                this.param.keyWord = null
                this.fetch({
                    size: 10,
                    page: 1
                });
            },
            query() {
                this.pagination.current = 1
                this.fetch({
                    size: 10,
                    page: 1,
                    ...this.param,
                });

            }
        }
    }
</script>

<style scoped>

</style>