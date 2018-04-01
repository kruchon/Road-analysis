var clusters;
var clusterMarkers = [];
var accidentMarkers = [];

function drawMarkers() {
    for(i=0; i<clusterMarkers.length; i++){
        clusterMarkers[i].setMap(null);
    }
    for(i=0; i<accidentMarkers.length; i++){
        accidentMarkers[i].setMap(null);
    }

    clusterMarkers = [];
    accidentMarkers = [];
    for(i=0;i<clusters.length;i++){
        var latitude = clusters[i].latitude;
        var longitude = clusters[i].longitude;
        var latLng = new google.maps.LatLng(latitude,longitude);
        var marker = new google.maps.Marker({
            position:latLng
        });
        var accidents = clusters[i].accidents;
        for(j=0;j<accidents.length;j++){
            var accident = accidents[j];
            var accidentLatitude = accident.latitude;
            var accidentLongitude = accident.longitude;
            var accidentLatLng = new google.maps.LatLng(accidentLatitude,accidentLongitude);
            var accidentMarker = new google.maps.Marker({
                position:accidentLatLng
            });
            accidentMarker.setIcon('http://maps.google.com/mapfiles/ms/icons/green-dot.png');
            accidentMarker.setMap(map);
            accidentMarkers.push(accidentMarker);
        }
        marker.setMap(map);
        clusterMarkers.push(marker);
    }
}

function getClusters() {
    var minSizeValue = document.getElementById('minSize').value;
    var minPercentValue = document.getElementById('minPercent').value;
    $.post('getClusters', {
        minSize: minSizeValue,
        minPercent: minPercentValue
    }).done(function (response) {
        clusters = JSON.parse(response);
        drawMarkers();
    });
}