window.onload = function(){
    var summaries;
    $.get( "getSummaries", function( response ) {
        var buttonsWithSummaries = document.getElementById("buttonsWithSummaries");
        summaries = JSON.parse(response);
        summaries.forEach(function (summary) {
            var summaryButton = document.createElement("button");
            var summaryId = summary.id;
            var summaryName = "temp name";
            summaryButton.setAttribute("summary_id",summaryId);
            summaryButton.setAttribute("id",summaryId+"_id")
            summaryButton.innerText = summaryName;
            summaryButton.setAttribute("class","btn btn-primary dropdown-toggle");
            summaryButton.setAttribute("style","height: 50%; width: 40%; margin-left: 5%; margin-rigth: auto;");
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
            editLink.setAttribute("href","#");
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

            buttonsWithSummaries.appendChild(buttonWithMenu);
        });
    });
}