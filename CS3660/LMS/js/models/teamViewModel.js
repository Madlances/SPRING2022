var teamViewModel = {
    entity: "teams",
    wrapperContainerId: "teamPageWrapper",
    wrapperTemplateUrl: "js/views/partials/listPageWrapper.ejs",
    listContainerId: "tableContainer",
    listTemplateUrl: "js/views/partials/listView.ejs",
    modalContainerId: "myModal",
    alertContainerId: "alertContainer",
    data: mockTeamData,
    list: {
        options: {
            sortCol: "name",
            sortDir: "asc",
            limit: "",
            offset: "",
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
                popver: "true"
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
                label: "# of Players",
                name: "numPlayers",
                popover: "true"
            }
        ]
    }
}