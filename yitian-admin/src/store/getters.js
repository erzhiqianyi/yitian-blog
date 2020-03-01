const getters = {
    token: state => state.user.token.token,
    siteInfo: state => state.configs.siteInfo,
    siteName: state => state.configs.siteInfo.name ,

    installed: state => state.configs.siteInfo.installed
}

export default getters
