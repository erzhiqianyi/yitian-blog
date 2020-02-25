import {listOpenConfigs} from '@/api/config'
import store from "../index";


const keys = [
    'INSTALL_TIME',
    'DOMAIN',
    'SYSTEM_NAME'
]
const configs = {
    state: {
        configs: []
    },
    mutations: {
        setConfigs(state, payload) {
            state.configs = payload
        }
    },
    actions: {
        loadConfigs({commit}) {
            return new Promise((resolve, reject) => {
                listOpenConfigs(keys)
                    .then(response => {
                        commit('setConfigs', response)
                        resolve(response)
                    }).cache(error => {
                    reject(error)
                })
            })
        }
    }
}
export default configs