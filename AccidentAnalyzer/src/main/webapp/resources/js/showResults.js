function showResults(summaryId){
    var editSummaryDiv = document.getElementById("editSummary");
    var summaryResultsTableDiv = document.getElementById("summaryResultsTable");
    editSummaryDiv.style.display = "none";
    summaryResultsTableDiv.style.display = "block";
    $.get('getSummaryResults', {
        summaryId: summaryId
    }).done(function (response) {
        var results = JSON.parse(response);
        var tableColumns = document.getElementById("tableColumns");
        var tableValues = document.getElementById("tableValues");
        tableColumns.innerText = "";
        tableValues.innerText = "";
        var anyColumn;
        for(var columnName in results){
            var th = document.createElement("th");
            th.innerText = columnName;
            tableColumns.appendChild(th);
            anyColumn = columnName;
        }

        //govnokod, remake column view
        for(var row = 0; row<anyColumn.length; row++){
            var tr = document.createElement("tr");
            for(var columnName in results){
                var value = results[columnName][row];
                var td = document.createElement("td");
                td.innerText = value;
                tr.appendChild(td);
            }
            tableValues.appendChild(tr);
        }
    });
}
