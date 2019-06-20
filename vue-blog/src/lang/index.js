import Vue from 'vue'
import VueI18n from 'vue-i18n'
import enLocale from './en'
import zhLocale from './zh'
import Cookies from 'js-cookie'

Vue.use(VueI18n)

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
  const chooseLanguage = Cookies.get('language')
  if (chooseLanguage) return chooseLanguage

  return 'zh'
}

export default i18n