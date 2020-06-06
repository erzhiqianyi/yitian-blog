import request from '@/utils/http'

export function postArticle(data) {
    return request({
        url: `api/admin/article`,
        method: 'post',
        data
    })
}
