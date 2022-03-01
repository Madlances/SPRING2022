var teamViewModal = {
    entity: "teams",
    wrapperContainerId: "teamPageWrapper",
    wrapperTemplateUrl: "js/views/partials/listPageWrapper.ejs",
    listContainerId: "tableContainer",
    listTemplateUrl: "js/views/partials/listPageView.ejs",
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

        listTitle: "Team List",
        listButtonId: "teamButton",

        id: "",
        tableClasses: "",
        thClasses: "",
        columns: [
            {
                label: "Team Name",
                name: "name",
            },

            {
                label: "Coach Name",
                name: "coachName",
            },

            {
                label: "Coach Phone",
                name: "coachPhone",
            },

            {
                label: "# of Players",
                name: "numPlayers",
            }
        ]
    }
}