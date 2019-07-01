import request from '@/utils/http'

export function loginByPassword(data) {
    return request({
        url: '/login/password',
        method: 'post',
        data
    })
}
