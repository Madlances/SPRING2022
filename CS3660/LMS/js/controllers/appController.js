import LocalStorageService from "../models/localStorageService.js";
import RestStorageService from "../models/restStorageService.js";
import Router from "../routers/router.js";
import GenericView from "../views/genericView.js";
import ListPageView from "../views/listView.js";
export default class AppController {
  constructor(appViewModel) {
    this.appViewModel = appViewModel;
    this.router = new Router(window, appViewModel.routes, appViewModel.navContainerId, appViewModel.navTemplateUrl)
        //event pattern, decouples the router and controller
        $("body").on("loadView", (event, route) => {
            this.loadView(route);
        })
  }

  get $containerId() {
    return $(`#${this.appViewModel.containerId}`)
}

loadView(route) {
  this.$containerId.empty(); //empty app container
  switch (route.viewType) {
      case "generic":
          this._view = new GenericView(null, route.viewModel);
          this._view.render();
          break;
      case "list":
          this.storageService = new RestStorageService(route.viewModel.entity, route.viewModel.entitySingle, route.viewModel.list.options, this.appViewModel.endPoint)
          this._view = new ListPageView(this.storageService, route.viewModel);
          this._view.render();
          break;
  }
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
    await this.router.render();
    await this.loadView(this.router.routes[0]);
    // await this.view.render();
  }
}
