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
}