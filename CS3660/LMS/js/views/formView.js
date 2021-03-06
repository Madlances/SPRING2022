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

    this.lookupsPopulated = false;
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

  get $selects() {
    return $('#' + this.formId + " select");
  }

  async getViewData() {
    if (!this.lookupsPopulated) {    //add lookupsPopulated=false to the constructor
      await this.populateLookups();
    }
    if (this.currentItemId)
      return await this.storage.read(this.currentItemId);
    else
      return {}; //return empty object for 'create' action
  }

  async populateLookups() {
    for (let field of this.fields) {
      if ('lookupName' in field) {
        await this.storage.getLookup(field.lookupName)
      }
    }
    this.lookupsPopulated = true;
  }

  async renderWrapper() {} // needed so parent class won't complain

  // similar to renderList
  async renderItem(data) {
    this.$formContainer.empty();
    this.data = data;
    await this.getViewData();
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
    let selects = this.$selects
    let storageService = this.storage;
    let parentView = this.parentView;
    let currentItemId = this.viewModel.form.currentItemId;
    const league_id = 1;
    let that = this;

    $('label[for="id"]').hide(); // hide id in form
    this.$form.submit(function (ev) {
      ev.preventDefault();
      ev.stopPropagation();
      if (this.checkValidity()) {
        let inputFields = {};
        for (let input of inputs) {
          inputFields[input.id] = input.value;
        }
        for (let select of selects) {
          inputFields[select.id] = storageService.lookups.find(coach => coach.label === select.value).value;
        }
        inputFields['league_id'] = league_id;
        inputFields["teamPhoto"] = "images/Smash_Ball.png";
        let requestPromise;
        if (currentItemId == undefined) {
          inputFields.id = storageService.newId();
          requestPromise = storageService.create(inputFields);
        } else {
          inputFields.id = currentItemId;
          requestPromise = storageService.update(currentItemId, inputFields);
        }
        requestPromise.then((out) => {
            parentView.renderItem();
            $myFormModal.modal("hide");
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        $(this).addClass("was-validated");
      }
    });

    if (currentItemId == undefined) {
      $("#cancelButton").click(function () {
        $myFormModal.modal("hide");
      });
    } else {
      $("#cancelButton").click(function () {
        const hasChanged = Array.from(inputs).some(input => 
          that.data.form.fields.find(field => field.name == input.id).defaultValue != input.value
        );
        if (!hasChanged || confirm("Are you sure you want to cancel your changes?")) {
          $myFormModal.modal("hide");
        }
      });
    }
  }

  async bindWrapperEvents() {} // needed so parent class won't complain
}
