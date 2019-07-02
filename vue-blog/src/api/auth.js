import request from '@/utils/http'

export function loginByPassword(data) {
    return request({
        url: '/api/auth/login/password',
        method: 'post',
        data
    })
}
