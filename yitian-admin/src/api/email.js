import request from '@/utils/http'

const baseUrl = "api/admin"

export function getRegisterVerifyCode(data) {
    return request({
        url: `${baseUrl}/auth/code/email/register`,
        method: 'get',
        data
    })
}
