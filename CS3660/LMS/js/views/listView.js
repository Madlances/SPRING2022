import View from "./view.js"
import FormView from "./formView.js"

export default class ListView extends View {
    constructor(storageService, viewModel) {
        super(storageService, viewModel);
        this.entityViewModel = viewModel;
        this.listTemplateHtml = "";
        this.wrapperTemplateHtml = "";
    }

    // taking most of the functions from listPageView
    get list() {
        return this.viewModel.list;
    }

    get view() {
        return this.viewModel;
    }

    // get wrapperTemplateUrl() {
    //     return this.view.wrapperTemplateUrl;
    // }

    // get $wrapperContainer() {
    //     return $("#"+this.view.wrapperContainerId);
    // }

    // get $listContainer() {
    //     return $("#"+this.view.listContainerId);
    // }

    // get listTemplateUrl() {
    //     return this.view.listTemplateUrl;
    // }

    get formModal() {return this.viewModel.formContainerId}
    get $formModal() {return $('#'+this.viewModel.formContainerId)}

    get columns() {
        return this.list.columns;
    }

    get $alertContainer() {
        return $("#"+this.view.alertContainerId);
    }

    get $modal() {
        return $("#"+this.view.modalContainerId);
    }

    get $headerIcon() {
        return $(`#${this.storage.sortCol}-${this.storage.sortDir}`);
    }

    reset() {
        this.storage.reset();
        this.render();
    }

    // async render() {
    //     await this.renderWrapper();
    //     await this.renderItem();
    // }

    async getViewData() {
        return await this.storage.list();
    }

    async renderWrapper() {
        this.$wrapperContainer.empty();
        if (!this.wrapperTemplateHtml.length > 0) {
            this.wrapperTemplateHtml = await this.utils.getFileContents(this.wrapperTemplateUrl);
        }
        // this.$wrapperContainer.html(ejs.render(this.wrapperTemplateHtml, {view: this.viewModel}));
        this.renderTemplate(this.$wrapperContainer, this.wrapperTemplateHtml, {view: this.viewModel});
        await this.bindWrapperEvents();
    }

    async renderItem() {
        this.$listContainer.empty();
        this.data = await this.getViewData();
        if (!this.listTemplateHtml.length > 0) {
            this.listTemplateHtml = await this.utils.getFileContents(this.listTemplateUrl);
        }
        // this.$listContainer.html(ejs.render(this.listTemplateHtml, {view: this, data: this.data}));
        this.renderTemplate(this.$listContainer, this.listTemplateHtml, {view: this, data: this.data});
        this.$headerIcon.show();
        this.bindItemEvents(this.data);
    }

    bindItemEvents(data) {
        let that = this;

        for (let col of this.columns) {
            $(`th[data-name='${col.name}']`).off("click").on("click", (e) => {
                const dataName = $(e.currentTarget).attr("data-name");
                let curDirection = this.storage.sortDir;
                $(`#${dataName}-${curDirection}`).hide();

                if (that.storage.sortCol === dataName) {
                    that.storage.sortDir = (curDirection == "asc" ? "desc" : "asc");
                }
                else {
                    that.storage.sortDir = "asc";
                }

                $(`#${dataName}-${this.storage.sortDir}`).show();
                that.storage.sortCol = dataName;
                that.renderItem();
            });
        }
        this.initPopver();
    }

    async bindWrapperEvents() {
        let that = this;
        let $myModal = that.$modal;

        $myModal.on("show.bs.modal", function(ev){
            let button = ev.relatedTarget;
            let rowItemId = $(button).closest("tr").attr('data-id');

            let dataItem = that.data[that.storage.getItemIndex(rowItemId)];
            let dataName = dataItem[that.list.nameCol];

            var $modalTitle = $('.modal-title');

            $modalTitle.text(`Delete Team ${dataName}`);
            $myModal.attr("data-id", rowItemId);
            $myModal.attr("data-name", dataName);
        });

        $("#yesButton").click((e) => {
            let itemName = $myModal.attr("data-name");
            let itemId = $myModal.attr("data-id");
            this.addAlert(itemName);

            this.deleteListItem(itemId).then((out) => {
                this.renderItem();
            }).catch((e) => {
                console.error(e);
            });
        });

        // add in form modal
        let $myFormModal = this.$formModal;
        let viewData = this.view;
    
        $myFormModal.on("show.bs.modal", function(ev) {
            let button = ev.relatedTarget;

            if (button.id == viewData.addTeamId) {
                viewData.form.currentItemId = undefined;
                that.createTeam(viewData);
            }
            if (button.id == viewData.editTeamId) {
                viewData.form.currentItemId = "asdf";
                that.editTeam(viewData);
            }
        });

        $('#resetView').off("click").on("click", (e) => {
            this.reset();
        });

        $('#searchInput').off("input").on("input", (e) => {
            this.searchVal = $(e.target).val();
            if (this.searchVal == "") {
                this.storage.filterStr = "";
                this.renderItem();
            }
            this.runSearch();
        });

        $('#clearSearch').off("click").on("click", (e) => {
            $('#searchInput').val("");
            this.storage.filterStr = "";
            this.renderItem();
        });
    }

    addAlert(itemName) {
        let alertHtml = `<div class="alert alert-secondary alert-dismissible fade show" role="alert" data-tor="show:[rotateX.from(90deg) @--tor-translateZ(-5rem; 0rem) pull.down(full)] slow">
                       Your Team ${itemName} has been deleted.
                       <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                   </div>`;
        this.$alertContainer.html(alertHtml);
    }

    runSearch() {
        clearTimeout(this.searchWaiter);
        this.searchWaiter = setTimeout(() => {
            if (this.searchVal.length > 1) {
                this.storage.filterStr = this.searchVal;
                this.storage.filterCol = this.storage.sortCol;
                this.renderItem();
            }
        }, 250);
    }

    async deleteListItem(id) {
        this.storage.delete(id);
        this.renderItem();
    }

    initPopver() {
        let that = this;
      $('[data-bs-toggle="popover"]').popover({
        html: true,
        trigger : 'hover',
        delay: { show: 200 },
        title : function(){
            var index = $(this).attr("data-id");
            let item = that.data[that.storage.getItemIndex(index)];
            return `<img class="img-fluid rounded-circle" src="${item[that.view.list.logoCol]}" width="40" height="40">  ${item[that.view.list.nameCol]} `;
        },
        content : function() {
          var index = $(this).attr("data-id");
          let item = that.data[that.storage.getItemIndex(index)];
          let htmlContent = "";
          that.columns.forEach((col, idx) => {
            if (col.popover)
              htmlContent+=`<p>${col.label}: ${item[col.name]}</p>`;
          })
          return htmlContent;
        }
    });
    }

    async createTeam(data) {
        // debugger;
        let formView = new FormView(this.storage, this.viewModel, this);
        await formView.renderItem(data, false);
    }

    async editTeam(data) {
        let formView = new FormView(this.storage, this.viewModel, this);
        await formView.renderItem(data, true);
    }
}