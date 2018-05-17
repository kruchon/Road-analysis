var summaries;
var newSummary = false;
var buttonsWithSummaries;
window.onload = addButtonsWithSummaries();

function addButton(summary){
    var buttonsWithSummaries=document.getElementById("buttonsWithSummaries");
    var summaryButton = document.createElement("button");
    var summaryId = summary.id;
    summaryButton.setAttribute("summary_id",summaryId);
    summaryButton.setAttribute("id",summaryId+"_id")
    summaryButton.innerText = summary.name;
    summaryButton.setAttribute("class","btn btn-md btn-default dropdown-toggle");

    summaryButton.setAttribute("data-toggle","dropdown");
    var span = document.createElement("span");
    span.setAttribute("class","caret");
    summaryButton.appendChild(span);

    var dropdownMenu = document.createElement("ul");
    dropdownMenu.setAttribute("class","dropdown-menu");

    var resultAction = document.createElement("li");
    dropdownMenu.appendChild(resultAction);
    var resultLink = document.createElement("a");
    resultLink.setAttribute("href","#");
    resultLink.innerText = "Results";
    resultAction.appendChild(resultLink);

    var editAction = document.createElement("li");
    dropdownMenu.appendChild(editAction);
    var editLink = document.createElement("a");
    editLink.setAttribute("summary_id",summaryId);
    editLink.setAttribute("onclick","javascript:initEditSummary("+summaryId+");");
    editLink.innerText = "Edit";
    editAction.appendChild(editLink);

    var removeAction = document.createElement("li");
    dropdownMenu.appendChild(removeAction);
    var removeLink = document.createElement("a");
    removeLink.setAttribute("href","#");
    removeLink.innerText = "Remove";
    removeAction.appendChild(removeLink);

    var buttonWithMenu = document.createElement("div");
    buttonWithMenu.appendChild(summaryButton);
    buttonWithMenu.appendChild(dropdownMenu);
    buttonWithMenu.setAttribute("class","dropdown");
    summaryButton.setAttribute("style","display: inline-block; height: 40px; width: 100%;");
    buttonWithMenu.setAttribute("style","padding: 5px");
    buttonsWithSummaries.appendChild(buttonWithMenu);
}

function addButtonsWithSummaries(){
    buttonsWithSummaries=document.getElementById("buttonsWithSummaries");
    $.get( "getSummaries", function( response ) {
        summaries = JSON.parse(response);
        summaries.forEach(function (summary, itemNum) {
            addButton(summary);
        });
    });
}