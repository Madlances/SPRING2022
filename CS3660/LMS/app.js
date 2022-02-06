// let alertPlaceholder = document.getElementById('alert');
// let alertTrigger = document.getElementById('myBtn');
// let confModal = $('#confirmationModal');
// let confModalTitle = document.getElementById("confirmationModalLabel");
// let teamName = document.getElementById("team").innerText;
// let coach = document.getElementById("coach").innerText;
// let phone = document.getElementById("phone").innerText;
// let players = document.getElementById("players").innerText;
// let popover = document.getElementById("kirby");

// function alert(message, type) {
//   let wrapper = document.createElement('div');
//   wrapper.innerHTML = '<div class="alert alert-' + type + ' alert-dismissible" role="alert">' + message + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
//   alertPlaceholder.append(wrapper);
// }

// if (alertTrigger) {
//   confModalTitle.textContent=`Delete Team ${teamName}`;
//   alertTrigger.addEventListener('click', function () {

//     alert(`Your Team ${teamName} has been deleted.`, 'success');
//     confModal.modal('hide');
// })
// };

let popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
let popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
  return new bootstrap.Popover(popoverTriggerEl);
});

$(document).ready(function(ev){
  let $confModal = $("#confirmationModal");

  $confModal.on("show.bs.modal", function(ev){  //fired when modal is about to be shown
    
    let button = ev.relatedTarget
    // Extract info from data-bs-* attributes
    let teamId = button.getAttribute('data-id')
    let teamName = button.getAttribute('data-name')

    
    let $confTitle = $('.modal-title')

    $confTitle.text(`Delete Team ${teamName}`);
    $confModal.attr("data-id", teamId);
    $confModal.attr("data-name", teamName);
  });

  $("#confirm").click(function(ev){    //fired when 'Yes' button is clicked
       addAlert($confModal.attr("data-name"))   //insert an alert in 'alertContainer'
  })
   
   function addAlert(teamName){
     let alertHtml=`<div id="deleteAlert" class="alert alert-success alert-dismissible fade show" role="alert">
                       Your Team ${teamName} has been deleted.
                       <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                   </div>`;
     $("#alertContainer").html(alertHtml);

   }
})