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
    }
}