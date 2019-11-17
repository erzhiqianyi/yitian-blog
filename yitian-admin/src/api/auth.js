import request from '@/utils/http'

export function loginByPassword(data) {
    return request({
        url: `api/admin/auth/login/password`,
        method: 'post',
        data
    })
}

export function registerByEmail(data) {
    return request({
        url: `api/admin/auth/register/email`,
        method: 'post',
        data
    })
}
