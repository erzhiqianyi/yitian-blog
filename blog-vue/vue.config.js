module.exports = {
    devServer: {
        proxy: {
            '/proxyApi': {
                target: 'http://localhost:8080',
                changeOrigin: true,
                pathRewrite: {
                    '/proxyApi': ''
                }
            }
        }
    },
    pluginOptions: {
        i18n: {
            locale: 'zh',
            fallbackLocale: 'zh',
            localeDir: 'locales',
            enableInSFC: false
        }
    },

}
