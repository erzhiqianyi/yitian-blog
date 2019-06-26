import i18n from '@/lang' // internationalization

/**
 * @param {string} email
 * @returns {Boolean}
 */
export function validEmail(email) {
    let valiedSize = validSize(email,3,50,i18n.t('register.email') )
    if(validSize(email).length > 0 ){
        return validSize
    }
    const reg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    let checkEmail =  reg.test(email);
    if(checkEmail){
        i18n.t('register.email')
    }else{
        i18n.t('register.email')
    }
}

/**
 * @param {string} value
 * @param {min} min size
 * @param {max} max size
 * @returns {string} valid result
 */
export function validSize(value, min, max, msg) {
    if (!value) {
       return  i18n.t('valid.input') + msg
    }
    if (value.length <= max && value.length >= min) {
        return "";
    }
    return msg + i18n.t('valid.maxSize') + max + "，" + i18n.t('valid.minSize')  + min;
}
