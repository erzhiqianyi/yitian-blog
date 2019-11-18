import request from '@/utils/http'
import qs from 'qs'
export function logList(data) {
    return request({
        url: `api/admin/system/log`,
        method: 'get',
        params: data,
        paramsSerializer: function(params) {
            return qs.stringify(params, {arrayFormat: 'repeat'})
        }

    })
}
