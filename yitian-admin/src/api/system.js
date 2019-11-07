import request from '@/utils/http'

export function install(data) {
    return request({
        url: '/api/system/install',
        method: 'post',
        data
    })
}
