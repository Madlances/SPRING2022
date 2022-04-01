import AppController from "./controllers/appController.js";
import appViewModel from "./views/viewModels/appViewModel.js";

(async function() {
    let app = new AppController(appViewModel);
    await app.render();
})();