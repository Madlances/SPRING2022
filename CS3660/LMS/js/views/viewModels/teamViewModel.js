import mockTeamData from "../../models/mock/mockTeamData.js";
var teamViewModel = {
  entity: "teams",
  entitySingle: "team",
  wrapperContainerId: "teamPageWrapper",
  wrapperTemplateUrl: "js/views/partials/listPageWrapper.ejs",
  listContainerId: "tableContainer",
  listTemplateUrl: "js/views/partials/listView.ejs",
  modalContainerId: "myModal",
  alertContainerId: "alertContainer",
  data: mockTeamData,
  addTeamId: "addTeam",
  editTeamId: "editTeam",
  formContainerId: "formModal",
  list: {
    options: {
      sortCol: "name",
      sortDir: "asc",
      limit: 100,
      offset: null,
      filterCol: "",
      fiterStr: "",
    },

    listTitle: "Teams",

    id: "my-list",
    tableClasses: "table table-hover mt-2",
    thClasses: "w-25 p-3 bg-black bg-gradient text-white",

    logoCol: "teamPhoto",
    nameCol: "name",
    columns: [
      {
        label: "Team Name",
        name: "name",
        popover: "true",
      },
      {
        label: "Coach Name",
        name: "coachName",
        popover: "true"
      },
      {
        label: "Coach Phone",
        name: "coachPhone",
        popover: "true"
      },
      {
        label: "Coach Email",
        name: "coachEmail",
        popover: "true"
      },
    ],
  },
  form: {
    id: "team-form",
    wrapperContainerId: "",
    wrapperTemplateUrl: "",

    templateUrl: "js/views/partials/formView.ejs",
    containerId: "formContainer",

    addFormTitle: "Add Team",
    editFormTitle: "Edit Team",
    currentItemId: "",

    actionUrl: "", // use default
    method: "POST",

    fields: [
      {
        //'id' field is required on the form and will be hidden
        label: "id",
        name: "id",
        tag: "input",
        defaultValue: "",
        attributes: {
          type: "hidden",
        },
        validation: {
          required: false,
        },
      },
      {
        label: "Team Name",
        name: "name", //name field, write this as both name and id
        tag: "input", //tag type
        defaultValue: "", //default value of input, 'value' tag will get either data being edited or default value
        //attributes is a simple associative array containing any additional attributes you wish to add during render
        attributes: {
          type: "text",
          placeholder: "Enter your Team name here",
          class: "form-control",
        },
        //validation rules.  If required, write the requiredMessage into the .invalid-feedback div
        validation: {
          required: true,
          requiredMessage: "Team Name is required",
        },
      },
      {
        label: "Coach",
        lookupName: "coaches",     //lookup name to use for /lookups/:lookupName  API
        name: "coach_id",
        tag: "select",
        defaultValue: -1, //default value for dropdown, usually the value that matches 'Select a Coach'
        attributes: {
          id: "coach_id",
          name: "coach_id",
          placeholder: "Select a Coach"
        },
        validation: {
          required: true,
          requiredMessage: "Coach is required"
        },
      },
      {
        label: "Coach Phone",
        name: "coachPhone",
        tag: "input",
        defaultValue: "",
        attributes: {
          type: "text",
          placeholder: "Coach phone",
          //pattern will allow you to customize your validation.
          pattern:
            "[+]?[1 ]?[-]?[(]?[0-9]{3}[)]?[-s.]?[0-9]{3}[-s.]?[0-9]{4,6}",
          //use the title tag to explain the format required
          title: "Phone Number (Format: +1 (999)999-9999)",
          class: "form-control",
        },
        validation: {
          required: true,
          requiredMessage: "Coach Phone is required",
        },
      },
      {
        label: "Coach Email",
        name: "coachEmail",
        tag: "input",
        defaultValue: "",
        attributes: {
          type: "email",
          placeholder: "Coach Email",
          class: "form-control",
        },
        validation: {
          required: true,
          requiredMessage: "Coach Email is required",
        },
      },
      {
        label: "Team Notes",
        name: "notes",
        tag: "input",
        defaultValue: "",
        attributes: {
          type: "text",
          placeholder: "Enter your Team notes here",
          class: "form-control",
        },
        validation: {
          required: true,
          requiredMessage: "Team Note is required",
        },
        
      },
    ],
  },
};
export default teamViewModel;
