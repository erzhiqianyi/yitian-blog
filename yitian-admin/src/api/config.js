import request from '@/utils/http'

export function listOpenConfigs(keys) {
    return request({
            url: `api/open/site/config`,
            method: 'get',
            params: {
                key: keys
            }
        }
    )
}

