function saveSummary(){
    var summary;
    if(!newSummary) {
        summary = summaries.find(summary => summary.id === selectedSummaryId);
    } else {
        summary = {};
        summary.id = selectedSummaryId;
    }
    var newName = document.getElementById("summaryName").value;
    var newQuery = document.getElementById("summaryQuery").value;
    summary.name = newName;
    summary.query = newQuery;
    if(newSummary){
        addButton(summary);
        newSummary = false;
    }
    sendSaveSummaryRequest(summary);
    reloadButton(summary.id, newName);
}

function reloadButton(summaryId, newName){
    var button = document.getElementById(summaryId+"_id");
    button.innerText = newName;
}

//govnokod
function sendSaveSummaryRequest(summary){
    $.post('mergeSummary', {
        id: summary.id,
        name: summary.name,
        query: summary.query
    }).done(function (response) {

    });
}