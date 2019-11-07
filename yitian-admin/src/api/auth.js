import request from '@/utils/http'

const baseUrl = "api/admin"

export function loginByPassword(data) {
    return request({
        url: `${baseUrl}/auth/login/password`,
        method: 'post',
        data
    })
}

export function registerByEmail(data) {
    return request({
        url: `${baseUrl}/auth/register/email`,
        method: 'post',
        data
    })
}
