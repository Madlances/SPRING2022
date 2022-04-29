import Utils from "../utils/utilities.js";
/* Class Router-handles hash routing and nav link state for application */
export default class Router {
  constructor(window, routes, containerId, templateUrl) {
    this.window = window;
    this._routes = routes;
    this.templateUrl = templateUrl;
    this.containerId = containerId;
    this.utils = new Utils();
    (async () => {
      await this.init();
    })();
  }
  get routes() {
    return this._routes;
  }
  get defaultRoute() {
    return this._routes.find((r) => r.isDefaultView);
  }
  get curRoute() {
    return this.routes.find((element) => element.name == window.location.hash);
  }
  get $container() {
    return $(`#${this.containerId}`);
  }
  async init() {
    $(".nav-link").click((e) => {
      $(".nav-link").removeClass("active");
      $(e.currentTarget).addClass("active");
    });
    $(window).on("hashchange", (e) => {
      this.loadHash();
    });
    this.setDefaultHash();
    this.loadHash();
  }
  setDefaultHash() {
    let curRoute = this.defaultRoute;
    window.location.hash = curRoute.name;
  }
  loadHash() {
    let urlObj = this.parseHash(window.location.hash);
    let curRoute = this.routes.find(
      (element) => element.name == `#${urlObj.api}`
    );
    if (urlObj.api) {
      $("body").trigger("loadView", [curRoute]);
    }
  }

  parseHash(hash) {
    let urlObj = {
      api: null,
      action: null,
      id: null,
    };

    if (!hash.includes("#")) {
      return urlObj;
    }
    let parts = hash.split("#");
    urlObj.api = parts[1];
    return urlObj;
  }

  async render() {
    let template = await this.utils.getFileContents(
      "../js/views/partials/nav.ejs"
    );
    let html = await ejs.render(template);
    $("#navContainer").html(html);
  }
}
