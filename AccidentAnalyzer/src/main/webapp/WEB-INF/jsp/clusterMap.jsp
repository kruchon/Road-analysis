<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<input id="minSize"/><br>
<input id="minPercent"/><br>
<button onclick="javascript:getClusters()">get clusters</button>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="resources/js/getClusters.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBabJb3jjzPnYgXi6o5QsWclNPj7MRso-w&callback=initMap"
        async defer></script>
<script src="resources/js/initMap.js"></script>

</body>
</html>