import router from "./router"
import store from "./store";

router.beforeEach((to, from, next) => {
    console.log("初始化")
    console.log(store.getters.config.length)
    if (store.getters.config.length ===0 ) {
        console.log("加载配置")
        store.dispatch('loadOptions').then()
        if (store.getters.config.)

    }
    //
    // //todo 判断系统是否已经初始化
    // //todo 获取系统配置
    // if (to.meta.requireAuth) {
    //     //判断是否已经登录，如果已经登录，直接next()
    //     if (store.getters.token) {
    //         next()
    //     } else {
    //         next({
    //             name: "Login",
    //             query: {
    //                 redirect: to.fullPath
    //             }
    //         })
    //     }
    // } else {
    //     next()
    // }
})



