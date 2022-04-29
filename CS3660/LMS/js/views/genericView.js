import View from "./view.js";

export default class GenericView extends View {
    constructor (storageService, viewModel) {
        super (storageService, viewModel['generic']);
    }

    getViewData() {
        return this.viewModel.data;
    }

    get $container() {
        return $("#" + this.viewModel.containerId);
    }

    get templateUrl() {
        return this.viewModel.templateUrl;
    }

    bindItemEvents () {} // need so parent class doesn't complain

    async renderItem() {
        this.data = await this.getViewData();
        this.templateHtml = await this.utils.getFileContents(this.templateUrl)
        await this.renderTemplate(this.$container, this.templateHtml, {
            view: this.viewModel,
            data: this.data
        });
        await this.bindItemEvents(this.data);
    }

    renderWrapper() {} // need so parent class doesn't complain

    bindWrapperEvents() {} // need so parent class doesn't complain
}