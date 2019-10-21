import Vue from 'vue'
import VueI18n from 'vue-i18n'
import enLocale from './en'
import zhLocale from './zh'


//全局注入VueI18插件
Vue.use(VueI18n)

//配置语言
const messages = {
    en: {
        ...enLocale,
    },
    zh: {
        ...zhLocale,
    },
}

const i18n = new VueI18n({
    // set locale
    // options: en | zh
    locale: getLanguage(),
    // set locale messages
    messages
})


export function getLanguage() {
    return process.env.VUE_APP_I18N_LOCALE || 'zh'  //从配置中读取当前语言环境,如果没有配置，默认使用zh
}

export default i18n
