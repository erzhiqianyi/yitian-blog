import i18n from '@/locales' // internationalization

export function validEmail(rule, value, callback) {
    const reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    if (!reg.test(value)) {
        callback(new Error(i18n.t('feedback.email_format')));
    } else {
        callback()
    }
}

export function checkProtocol(rule, value, callback) {
    console.log(value)
    if (value) {
        callback()
    } else {
        callback(new Error(i18n.t('feedback.email_format')));
    }
}







