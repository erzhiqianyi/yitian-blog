import i18n from '@/locales' // internationalization

export var article_column = [
    {
        title: i18n.t("table.article.title"),
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


export var log_column = [
    {
        title: i18n.t("table.log.time"),
        dataIndex: 'createAt',
        key: 'createAt',
        width: '20%',
        sorter: true,
    },
    {
        title: i18n.t("table.log.type"),
        dataIndex: 'type',
        key: 'type',
        width: '20%',
        scopedSlots: {customRender: 'type'},
        filters: [
            {
                value: "LOGIN",
                text:  i18n.t("filter.log.type.login")
            },
            {
                value: "SYSTEM_INITIALIZATION",
                text: i18n.t("filter.log.type.system_initialization")
            },
            {
                value: "ADD_ADMINISTRATOR",
                text: i18n.t("filter.log.type.add_administrator")
            },
            {
                value: "ADD_SYSTEM_CONFIG",
                text: i18n.t("filter.log.type.add_system_config")
            },
            {
                value: "POST_ARTICLE",
                text: i18n.t("filter.log.type.post_article")
            },
            {
                value: "EDIT_ARTICLE",
                text: i18n.t("filter.log.type.edit_article")
            },

        ],

    },
    {
        title: i18n.t("table.log.createBy"),
        dataIndex: 'createBy',
        key: 'createBy',
        width: '20%',
    },
    {
        title: i18n.t("table.log.status"),
        dataIndex: 'status',
        key: 'status',
        scopedSlots: {customRender: 'status'},
        filters: [
            {text: '成功', value: 'SUCCESS'},
            {text: '失败', value: 'FAIL'}
        ],
        width: '10%',
    },

    {
        title: i18n.t("table.log.remark"),
        dataIndex: 'remark',
        key: 'remark',
        width: '30%',
    },

]
