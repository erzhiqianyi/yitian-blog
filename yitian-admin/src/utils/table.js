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


