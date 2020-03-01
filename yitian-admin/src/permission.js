import router from "./router"
import store from "./store";
import i18n from '@/locales' // internationalization

router.beforeEach((to, from, next) => {
    if (!store.getters.siteName) {
        store.dispatch('loadSiteInfo')
            .then(() => {
                checkPermission(to, from, next)
            })
    } else {
        checkPermission(to, from, next)
    }
})

function checkPermission(to, from, next) {
    checkInstalled(to, next)
    let title = to.meta.title ? to.meta.title : ''
    title = title + "-" + (store.getters.siteName ?
        store.getters.siteName : i18n.t("system.name"))
    document.title = title
    if (to.meta.requireAuth) {
        //判断是否已经登录，如果已经登录，直接next()
        if (store.getters.token) {
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
}


function checkInstalled(to, next) {
    if (!store.getters.installed) {
        if (to.name != "Install") {
            next({
                name: "Install",
                query: {
                    redirect: to.fullPath
                }
            })
        } else {
            next();
        }
    }
}
