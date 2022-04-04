import Utils from "../utils/utilities.js";

export default class View {
  constructor(storage, viewModel) {
    this.storage = storage;
    this.viewModel = viewModel;
    this.utils = new Utils();
    this.data = null;
  }

  get wrapperTemplateUrl() {
    return this.viewModel.wrapperTemplateUrl;
  }

  get hasWrapper() {
    return this.viewModel.wrapperTemplateUrl;
  }

  get $wrapperContainer() {
    return $("#" + this.viewModel.wrapperContainerId);
  }

  get $listContainer() {
    return $("#" + this.viewModel.listContainerId);
  }

  get listTemplateUrl() {
    return this.viewModel.listTemplateUrl;
  }

  get formTemplateUrl() {
    return this.viewModel.form.templateUrl;
  }

  get $formContainer() {
    return $("#" + this.viewModel.form.containerId);
  }

  async render() {
    await this.renderWrapper();
    await this.renderItem();
  }

  async renderTemplate($container, templateHtml, viewData) {
    $container.html(ejs.render(templateHtml, viewData));
  }

  async renderWrapper() {
    throw new Error("Subclasses must implement renderWrapper");
  }

  async renderItem() {
    throw new Error("Subclasses must implement renderItem");
  }

  async getViewData() {
    throw new Error("Subclasses must implement getViewData");
  }

  async reset() {
    await this.storage.reset();
    await this.render();
  }

  async bindItemEvents() {
    throw new Error("Subclasses must implement bindItemsEvents");
  }

  async bindWrapperEvents() {
    throw new Error("Subclasses must implement bindWrapperEvents");
  }

  readCachedItem(id) {
    return this.storage.getItem(id);
  }
}
