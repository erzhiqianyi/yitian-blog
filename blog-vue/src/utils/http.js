import axios from 'axios'
import { Message} from 'element-ui'
import i18n from '@/locales' // internationalization

const request = axios.create({
    baseURL: getBaseUrl(),//根据环境获取基础url
    timeout: 5000 // 超时时间
})


//请求拦截器
request.interceptors.request.use(
    config => {
        //添加请求头
        config.headers['auth'] = getToken()
        return config
    },
    error => {
        // 请求错误
        console.log(error) // for debug
        return Promise.reject(error)
    }
)

// 返回拦截器
request.interceptors.response.use(
    /**
     * 根据需求返回response, 具体业务逻辑不应该再处理HTTP状态，直接返回业务所需结果。
     * 如果业务需要http信息，如返回头，状态码等，则直接返回  response => response
     * 服务端返回结果应该要统一。
     */

    /**
     * 根据服务端返回结果进行处理，可以根据HTTP状态码或自定义状态码判断
     * 后端统一返回结果格式为
     * {
     *    "code":20000,//服务端自定义代码
     *    "msg":"请求成功",//返回信息
     *    "data": "成功"// 业务所需数据
     * }
     */
    response => {
        //请求成  response.status == 200
        const res = response.data
        //后台返回结果不为0，表示请求失败,没有业务数据
        if (res.code !== 0) {
            //请求失败，可以统一弹出提示，或自定义提示
            Message({
                message: res.msg,
                type: 'error',
                duration: 5 * 1000
            })
            return Promise.reject(res.msg || 'error')
        } else {
            return res.data;
        }
    },
    error => {
        //请求失败
        //请求错误，弹出提示
        Message({
            message: i18n.t('feedback.system_error'),
            type: 'error',
            duration: 5 * 1000
        })
        return Promise.reject(error)
    }
)

// 环境切换
export function getBaseUrl() {
    if (process.env.NODE_ENV == 'development') {
        return "proxyApi"
    } else if (process.env.NODE_ENV == 'debug') {
        return ""
    } else if (process.env.NODE_ENV == 'production') {
        return ""
    }
}

//获取token
export function getToken() {
    return "token"
}

export default request
