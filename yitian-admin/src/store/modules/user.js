const user = {
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
}
export default user
