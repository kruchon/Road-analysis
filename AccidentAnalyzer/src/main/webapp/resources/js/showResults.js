function showResults(summaryId){
    var resultsTable = document.getElementById("summaryResults");
    var thead = document.createElement("thead");
    var theadTr = document.createElement("tr");
    var tbody = document.createElement("tbody");
    resultsTable.appendChild(thead);
    resultsTable.appendChild(tbody);
    thead.appendChild(theadTr);
    resultsTable.innerHTML = "";
    $.get('getSummaryResults', {
        summaryId: summaryId
    }).done(function (response) {
        var results = JSON.parse(response);

        for(var columnName in results){
            var columnValues = results[columnName];
            var theadTd = document.createElement("td");
            theadTd.innerText = columnName;
            theadTr.appendChild(theadTd);
            var td = document.createElement("td");
            resultsTable.appendChild(td);
            columnValues.forEach(function (value){
                var tr = document.createElement("tr");
                tr.innerText = value;
                td.appendChild(tr);
            });
        }
    });
}