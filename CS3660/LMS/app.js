let popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
let popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
    return new bootstrap.Popover(popoverTriggerEl);
});

$(document).ready(function () {
    let img = `<img class="imgPopover" src="images/Smash_Ball.png">`;
    ["Samus", "Bayonetta", "Lucas", "Mario", "Pacman", "Kirby", "Luigi"].forEach((name) => {
        $(`#${name}`).popover({
            title: img + " Team Info",
            trigger: "hover",
            placement: "bottom",
            html: true,
            delay: { show: 200 },
        });
    });
});

$(document).ready(function (ev) {
    let $confModal = $("#confirmationModal");

    $confModal.on("show.bs.modal", function (ev) {
        let button = ev.relatedTarget;
        let teamName = button.getAttribute("data-team");
        let $confTitle = $(".modal-title");

        $confTitle.text(`Delete Team ${teamName}`);
        $confModal.attr("data-team", teamName);
    });

    $("#confirm").click(function () {
        alert($confModal.attr("data-team"));
    });

    function alert(teamName) {
        let alertHtml = `<div class="alert alert-success alert-dismissible fade show" role="alert" data-tor="show:[rotateX.from(90deg) @--tor-translateZ(-5rem; 0rem) pull.down(full)] slow">
                       Your Team ${teamName} has been deleted.
                       <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                   </div>`;
        $("#alert").html(alertHtml);
    }
});
