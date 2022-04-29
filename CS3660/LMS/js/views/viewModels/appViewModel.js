/* App View Model-contains application level meta data */
import teamViewModel from "./teamViewModel.js";
import homePageViewModel from "./homePageViewModel.js";
var routes = [
  {
    name: "#home",
    title: "Home",
    defaultOptions:null,
    isDefaultView: true,
    viewType:"generic",
    viewModel: homePageViewModel
  },
  {
    name: "#teams",
    title: "Teams",
    defaultOptions: {sortCol:'name', sortDir:'asc'},
    viewType:"list",
    viewModel: teamViewModel,
    isDefaultView: false,
  },
]

var appViewModel = {
  conatinerId: "app_container",
  endPoint: 'localhost:8080',
  routes: routes,
  navContainerId: "navContainer",
  navTemplateUrl: "js/views/partials/nav.ejs"
};
export default appViewModel;
