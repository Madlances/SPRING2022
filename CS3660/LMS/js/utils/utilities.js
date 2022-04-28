export default class Utilities {
    constructor() {
        this.files = {}
    }

    async getFileContents(url) {
        if (!(url in this.files)) {
            this.files[url] = await $.get(url);
        }
        return this.files[url]
    }

    cloneObject(obj) {
        return JSON.parse(JSON.stringify(obj));
    }

    getQueryString(options) {
        let queryString = '?'
        let queryList = []
        for (let key in options) {
        if (options[key]) {
            queryList.push(`${key}=${options[key]}`)
        }
        }
        queryString += queryList.join('&')
        return queryString
    }
}