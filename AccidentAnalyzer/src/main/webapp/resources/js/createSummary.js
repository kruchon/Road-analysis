function createSummary(){
    selectedSummaryId = Math.max.apply(Math,summaries.map(function(o){return o.id;}))+1;
    var summaryNameField = document.getElementById("summaryName");
    var summaryQueryField = document.getElementById("summaryQuery");
    summaryNameField.value = "";
    summaryQueryField.value = "";
    var editSummaryDiv = document.getElementById("editSummary");
    editSummaryDiv.style.display = "block";
    newSummary = true;
}