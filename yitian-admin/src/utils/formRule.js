import i18n from '@/locales' // internationalization
const emailPattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
export var emailRule = [
    {required: true, message: i18n.t("rule.email_required")},
    {max: 50, message: i18n.t("rule.email_length")},
    {min: 3, message: i18n.t("rule.email_length")},
    {pattern: emailPattern, message: i18n.t("rule.email_format")}

];
export var passwordRule = [
    {required: true, message: i18n.t("rule.password_required")},
    {max: 30, message: i18n.t("rule.password_length")},
    {min: 8, message: i18n.t("rule.password_length")},
]


export var confirmPasswordRule = [
    {required: true, message: i18n.t("rule.confirm_password_required")},
    {max: 30, message: i18n.t("rule.confirm_password_length")},
    {min: 8, message: i18n.t("rule.confirm_password_length")},
]

export var nicknameRule = [
    {required: true, message: i18n.t("rule.nickname_required")},
    {max: 20, message: i18n.t("rule.nickname_length")},
    {min: 2, message: i18n.t("rule.nickname_length")},
]

export var registerCaptchaRule = [
    {required: true, message: i18n.t("rule.register_captcha_required")},
    {len: 6, message: i18n.t("rule.register_captcha_length")},
]

export var checkBoxRule = [
    {required: true, message: i18n.t("rule.register_agree")}
]

export function hasErrors(fieldsError) {
    return Object.keys(fieldsError).some(field => fieldsError[field]);
}

export function fieldError(form,field) {
    return form.getFieldError(field)
}


