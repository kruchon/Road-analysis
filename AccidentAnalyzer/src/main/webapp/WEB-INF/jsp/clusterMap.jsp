<!DOCTYPE html>
<html>
<head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
        #map {
            height: 80%;
        }
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div id="map"></div>
<form id="getClustersForm" action="getClusters" method="GET">
    Min cluster size: <input id="minSize" type="text"><br>
    Min accident type percent <input id="minPercent" type="text"><br>
    <button type="submit">Get clusters</button>
</form>
<script>
    var map;
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });
    }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBabJb3jjzPnYgXi6o5QsWclNPj7MRso-w&callback=initMap"
        async defer></script>
</body>
</html>