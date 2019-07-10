import request from '@/utils/http'

export function getEmailCode(email) {
    return request({
        url: '/api/auth/code/email/'+email,
        method: 'get',
    })

}
