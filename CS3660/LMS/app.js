let toastTrigger = document.getElementById("toast");
let toastLiveExample = document.getElementById("liveToast");
if (toastTrigger) {
    toastTrigger.addEventListener("click", function () {
        let toast = new bootstrap.Toast(toastLiveExample);

        toast.show();
    });
}
