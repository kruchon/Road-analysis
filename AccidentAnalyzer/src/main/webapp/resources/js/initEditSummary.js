var selectedSummaryId;
function initEditSummary(summaryId){
    newSummary = false;
    var summary = summaries.find(x=>x.id === summaryId);
    selectedSummaryId = summary.id;
    var summaryNameField = document.getElementById("summaryName");
    var summaryQueryField = document.getElementById("summaryQuery");
    summaryNameField.value = summary.name;
    summaryQueryField.value = summary.query;
    var editSummaryDiv = document.getElementById("editSummary");
    var summaryResultsTableDiv = document.getElementById("summaryResultsTable");
    editSummaryDiv.style.display = "block";
    summaryResultsTableDiv.style.display = "none";
}