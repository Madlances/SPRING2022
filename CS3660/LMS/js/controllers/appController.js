import LocalStorageService from "../models/localStorageService.js";
import RestStorageService from "../models/restStorageService.js";
import ListPageView from "../views/listView.js";
export default class AppController {
  constructor(appViewModel) {
    this.appViewModel = appViewModel;
    // this.storageService = new LocalStorageService(
    //   this.data,
    //   this.entity,
    //   this.list.options
    // );
    this.storageService = new RestStorageService(
        this.entity,
        this.entitySingle,
        this.list.options,
        this.endPoint
    );
    this._view = new ListPageView(this.storageService, this.listViewModel);
  }

  get data() {
    return this.appViewModel.viewModel.data;
  }

  get entity() {
    return this.appViewModel.viewModel.entity;
  }

  get list() {
    return this.appViewModel.viewModel.list;
  }

  get listViewModel() {
    return this.appViewModel.viewModel;
  }

  get endPoint() {
    return this.appViewModel.endPoint;
  }

  get view() {
    return this._view;
  }

  reset() {
    this.view.reset();
  }

  async render() {
    await this.view.render();
  }
}
