import request from '@/utils/http'

export function siteInfo() {
    return request({
            url: `api/open/site/info`,
            method: 'get',
        }
    )
}

