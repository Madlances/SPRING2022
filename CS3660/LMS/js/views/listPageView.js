class ListPageView {
    constructor(storageService, viewModel) {
        this.storage = storageService;
        this.viewModel = viewModel;
        this.listTemplateHtml = "";
        this.wrapperTemplateHtml = "";
    }

    get listViewModel() {
        return this.viewModel.list;
    }

    get fieldViewModel() {
        return this.viewModel.list.columns;
    }

    get $listContainer() {
        return $("#"+this.viewModel.listContainerId);
    }

    get listTemplateUrl() {
        return this.viewModel.listTemplateUrl;
    }

    get wrapperTemplateUrl() {
        return this.viewModel.wrapperTemplateUrl;
    }

    get $wrapperContainer() {
        return $("#"+this.viewModel.wrapperContainerId);
    }

    reset() {
        this.storage.reset();
        this.render();
    }

    render() {
        renderWrapper().then(() => {
            renderList().then(() => {
                this.bindWrapperEvents();
            })
        });
    }

    async renderWrapper() {
        this.$wrapperContainer.empty();
        if (this.wrapperTemplateHtml.length > 0) {
            this.wrapperTemplateHtml = await this.getTemplateHtml(this.wrapperTemplateHtml);
        }
        this.$wrapperContainer.html(ejs.render(this.wrapperTemplateHtml), {view.this.viewModal});

     this.bindWrapperEvents();
    }

    async renderList() {}

    bindListEvents(data) {
        let that = this;
        data.forEach(function(val) {
            $("#remove" + val.id).off("click").on("click", () => {
                that.deleteListItem(val.id);
            });
        });

        this.fieldViewModel.forEach(function(field) {});
    }

    bindWrapperEvents() {
        let that = this;
        // finish modal here

        $('#resetView').off("click").on("click", (e) => {
            this.reset();
        });

        $('#searchInput').off("input").on("input", (e) => {
            this.searchVal = $(e.target).val();
            this.runSearch();
        });

        $('#clearSearch').off("click").on("click", (e) => {
            $('#searchInput').val("");
            this.storage.filterStr = "";
            this.renderList();
        });
    }

    runSearch() {
        clearTimeout(this.searchWaiter);
        this.searchWaiter = setTimeout(() => {
            if (this.searchVal.length > 1) {
                this.storage.filterStr = this.searchVal;
                this.storage.filterCol = this.storage.sortCol;
                this.renderList();
            }
        }, 250);
    }

    deleteListItem(id) {
        this.storage.delete(id);
        this.renderList();
    }

    async getTemplateHtml(url) {
        return await $.get(url);
    }
}