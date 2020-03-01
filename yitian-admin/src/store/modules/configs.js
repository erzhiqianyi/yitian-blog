import {siteInfo} from '@/api/config'
import store from "../index";


const keys = [
    'INSTALL_TIME',
    'DOMAIN',
    'SYSTEM_NAME'
]
const configs = {
    state: {
        configs: [],
        siteInfo: {}
    },
    mutations: {
        setConfigs(state, payload) {
            state.configs = payload
        },
        setSiteInfo(state, payload) {
            console.log("配置信息")
            state.siteInfo = payload
            console.log(state.siteInfo)
        }
    },
    actions: {
        loadConfigs({commit}) {

        },
        loadSiteInfo({commit}) {
            return new Promise(async (resolve, reject) => {
                siteInfo()
                    .then(response => {
                        commit('setSiteInfo', response)
                        resolve()
                    }).cache(error => {
                    reject(error)
                })
            })
        }
    }
}
export default configs