import Vue from 'vue';
import Vuex from 'vuex';
import getters from './getters'
import user from './modules/user'
import configs from './modules/configs'

Vue.use(Vuex);

const store = new Vuex.Store({
    modules: {
        user,
        configs
    },
    state: {},
    mutations: {},
    actions: {},
    getters
})

export default store;
