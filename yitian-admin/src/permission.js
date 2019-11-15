import router from "./router"
import store from "./store";

router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) {
        //判断是否已经登录，如果已经登录，直接next()
        let now = new Date()
        let expire = Date.parse(store.state.token.expire)
        let login = store.state.token && expire > now
        if (login) {
            next()
        } else {
            next({
                name: "Login",
                query: {
                    redirect: to.fullPath
                }
            })
        }

    } else {
        next()
    }
})



