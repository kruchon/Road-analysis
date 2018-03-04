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
<input type="hidden" value="${clusters}"/>
<div id="map"></div>
<form:form action="/accidentAnalyzer/getClusters" method="post" id="getClustersForm" commandName="getClustersRequest">
    <form:input path="minSize"/><br>
    <form:input path="minPercent"/><br>
    <input type="submit" value="Get clusters"/>
</form:form>
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