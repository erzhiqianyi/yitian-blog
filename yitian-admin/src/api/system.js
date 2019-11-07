import request from '@/utils/http'

const baseUrl = "api/admin"

export function install(data) {
    return request({
        url: `${baseUrl}/system/install`,
        method: 'post',
        data
    })
}

export function installed() {
    return request({
        url: `${baseUrl}/system/installed`,
        method: 'get',
    })
}
