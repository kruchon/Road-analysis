function initEditSummary(summaryId){
    var summary = summaries.find(x=>x.id === summaryId);
    var summaryNameField = document.getElementById("summaryName");
    var summaryQueryField = document.getElementById("summaryQuery");
    summaryNameField.setAttribute("value",summary.name);
    summaryQueryField.innerText = summary.query;
}