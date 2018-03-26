var clusters;
var clusterMarkers = [];

function drawMarkers() {
    for(i=0; i<clusterMarkers.length; i++){
        clusterMarkers[i].setMap(null);
    }
    clusterMarkers = [];
    for(i=0;i<clusters.length;i++){
        var latitude = clusters[i].latitude;
        var longitude = clusters[i].longitude;
        var latLng = new google.maps.LatLng(latitude,longitude);
        var marker = new google.maps.Marker({
            position:latLng
        });
        marker.setMap(map);
        clusterMarkers.push(marker);
    }
}

function getClusters() {
    var minSizeValue = document.getElementById('minSize').value;
    var minPercentValue = document.getElementById('minPercent').value;
    clusters = $.post('getClusters', {
        minSize: minSizeValue,
        minPercent: minPercentValue
    }).done(function (response) {
        clusters = JSON.parse(response);
        drawMarkers();
    });
}