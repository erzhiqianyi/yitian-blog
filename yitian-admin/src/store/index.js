import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        token: {
            expire: '',
            token: ''
        }
    },
    mutations: {
        setToken(state, payload) {
            state.token.expire = payload.expirationAt
            state.token.token = payload.token
        }
    }
})

export default store;
