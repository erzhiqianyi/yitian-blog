import axios from 'axios'

const request = axios.create({
  baseURL: getBaseUrl(),//根据环境获取基础url
  timeout: 5000 // 超时时间
})

export function getBaseUrl() {
  // 环境切换
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


export default request