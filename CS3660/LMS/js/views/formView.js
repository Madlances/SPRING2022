import View from "./view.js";

export default class FormView extends View {
  // similar to listView
  constructor(storageService, viewModel, parentView) {
    super(storageService, viewModel);
    this.entityViewModel = viewModel;
    this.formTemplateHtml = "";
    this.wrapperTemplateHtml = "";

    this.parentView = parentView;
    this.formChanged = false;
    this.newFormId = 6;
  }

  get fields() {
    return this.viewModel.form.fields;
  }

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

  async renderWrapper() {} // needed so parent class won't complain

  // similar to renderList
  async renderItem(data) {
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
    await this.bindItemEvents();
  }

  // similar to bindListEvents
  async bindItemEvents() {
    let $myFormModal = this.parentView.$formModal;
    let inputs = this.$inputs;
    let storageService = this.storage;
    let parentView = this.parentView;
    let newFormId = this.newFormId;
    let currentItemId = this.viewModel.form.currentItemId;

    this.$form.submit(function (ev) {
      ev.preventDefault();
      ev.stopPropagation();
      if (currentItemId == undefined) {
        if (this.checkValidity()) {
          let inputFields = {};
          for (let input of inputs) {
            inputFields[input.id] = input.value;
          }
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
        } else {
          $(this).addClass("was-validated");
        }
      } else {
        if (this.checkValidity()) {
          let inputFields = {};
          for (let input of inputs) {
            inputFields[input.id] = input.value;
          }
          inputFields.id = newFormId;
          inputFields["teamPhoto"] = "images/Smash_Ball.png";
          storageService
            .update(inputFields)
            .then((out) => {
              parentView.renderItem();
              $myFormModal.modal("hide");
            })
            .catch((error) => {
              console.log(error);
            });
        } else {
          $(this).addClass("was-validated");
        }
      }
    });

    this.$inputs.on("change", function (ev) {
      this.formChanged = true;
      console.log("inputChanged")
    });

    // still need to figure out when a input has been changed
    if (currentItemId == undefined) {
      $("#cancelButton").click(function() {
        $myFormModal.modal("hide")
      });
    } else {
      // if (this.formChanged == true) {
        $("#cancelButton").click(function() {
          if (confirm("Are you sure you want to cancel your changes?")) {
            $myFormModal.modal("hide");
          }
        });
      // }
    }
  }

  async bindWrapperEvents() {} // needed so parent class won't complain
}
