import request from '@/utils/http'

export function install(data) {
    return request({
        url: `api/admin/system/install`,
        method: 'post',
        data
    })
}


