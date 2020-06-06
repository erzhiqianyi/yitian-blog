import {siteInfo} from '@/api/config'

const configs = {
    state: {
        siteInfo: {}
    },
    mutations: {
        setSiteInfo(state, payload) {
            state.siteInfo = payload
        }
    },
    actions: {
        loadSiteInfo({commit}) {
            return new Promise(async (resolve, reject) => {
                siteInfo()
                    .then(response => {
                        commit('setSiteInfo', response)
                        resolve()
                    }).catch(error => {
                    reject(error)
                })
            })
        }
    }
}
export default configs