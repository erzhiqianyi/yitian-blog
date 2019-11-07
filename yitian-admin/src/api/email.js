import request from '@/utils/http'

export function getRegisterVerifyCode(data) {
    return request({
        url: '/api/code/email/register',
        method: 'get',
        data
    })
}
