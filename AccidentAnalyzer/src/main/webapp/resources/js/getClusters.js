var clusters;
function getClusters() {
    var minSizeValue = document.getElementById('minSize').value;
    var minPercentValue = document.getElementById('minPercent').value;
    clusters = $.post('getClusters', {
        minSize: minSizeValue,
        minPercent: minPercentValue
    }).done(function (response) {
        clusters = response;
    });
}