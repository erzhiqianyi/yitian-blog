import axios from 'axios'

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

// 环境切换
export function getBaseUrl() {
  if (process.env.NODE_ENV == 'development') {
    return "proxyApi"
  }
  else if (process.env.NODE_ENV == 'debug') {
    return ""
  }
  else if (process.env.NODE_ENV == 'production') {
    return ""
  }
}

//获取token
export function getToken() {
  return "token"
}



export default request