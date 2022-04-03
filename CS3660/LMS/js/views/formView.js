import View from "./view.js";

export default class FormView extends View {
  // similar to listView
  constructor(storageService, viewModel, parentView) {
    super(storageService, viewModel);
    this.entityViewModel = viewModel;
    this.currentItemId = null;
    this.formTemplateHtml = "";
    this.wrapperTemplateHtml = "";

    this.parentView = parentView;
    this.formChanged = false;
    this.newFormId = 6;
  }

  get fields() {
    return this.viewModel.form.fields;
  }

  // get edit() {
  //     return this.viewModel.editFormTitle;
  // }

  get formId() {
    return this.viewModel.form.id;
  }

  get $form() {
    return $("#" + this.formId);
  }

  get form() {
    return this.$form.get(0);
  }

  get formValid() {
    return this.form.checkValidity();
  }

  get $inputs() {
    return $("#" + this.formId + " input");
  }

//   async fillForm() {
//     return;
//   }

  async renderWrapper() {} // needed so parent class won't complain

  // similar to renderList
  async renderItem(data, edit) {
      // debugger;
    this.$formContainer.empty();
    this.data = data;
    if (!this.formTemplateHtml.length > 0) {
      this.formTemplateHtml = await this.utils.getFileContents(
        this.formTemplateUrl
      );
    }
    await this.renderTemplate(this.$formContainer, this.formTemplateHtml, {
      view: this,
      data: data,
    });
    // if (edit) {
    //   await this.fillForm();
    // }
    await this.bindItemEvents();
  }

  // similar to bindListEvents
  async bindItemEvents() {
    let $myFormModal = this.parentView.$formModal;
    let inputs = this.$inputs;
    let storageService = this.storage;
    let parentView = this.parentView;
    let newFormId = this.newFormId;
    this.$form.submit(function (ev) {
      ev.preventDefault();
      ev.stopPropagation();

      if (this.checkValidity()) {
        let inputFields = {};
        for (let input of inputs) {
          inputFields[input.id] = input.value;
        }
        //TODO: check to see if id exits which means its an update and not create
        // let checkExist = storageService.read(inputFields.id);
        // if (checkExist == null) {
        //   //create function
        // } else {
        //   //edit function
        // }
        inputFields.id = ++newFormId;
        inputFields["teamPhoto"] = "images/Smash_Ball.png";
        storageService
          .create(inputFields)
          .then((out) => {
            parentView.renderItem();
            $myFormModal.modal("hide");
          })
          .catch((error) => {
            console.log(error);
          });
      }
    });

    this.$inputs.on("change", function (ev) {
      this.formChanged = true;
      console.log("input changed");
    });
  }

  async bindWrapperEvents() {} // needed so parent class won't complain
}
