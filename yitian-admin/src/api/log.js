import request from '@/utils/http'

export function logList(data) {
    return request({
        url: `api/admin/system/log`,
        method: 'get',
        params: data

    })
}
