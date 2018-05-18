<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Simple Map</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="resources/js/getClusters.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBabJb3jjzPnYgXi6o5QsWclNPj7MRso-w&callback=initMap"
            async defer></script>
    <script src="resources/js/initMap.js"></script>

    <style>
        #map{
            height: 100%;
            width: 100%;
        }

        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>

<nav role="navigation" class="navbar navbar-default" style="margin-bottom: 0;">
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="/accidentAnalyzer/summariesList">Summaries</a></li>
            <li class="active"><a href="/accidentAnalyzer/clusterMap">Cluster map</a></li>
        </ul>
    </div>
</nav>

<div style="height: 100%; width:100%;">
<table style="height: 100%; width:100%;">
    <tr>
        <td style="width:10%;  height: 100%;">
            <div class="panel panel-default" style="width:100%;  height: 100%;">
                <div class="panel-heading" style="width:100%;  height: 100%;">
                    <br>
                    <label for="minSize">Min size:</label>
                    <input id="minSize" type="text" class="form-control" style="width: 100%;">
                    <br>
                    <label for="minPercent">Min percent:</label>
                    <input id="minPercent" type="text" class="form-control" style="width: 100%;">
                    <br>
                    <button type="button" class="btn btn-primary btn-md" onclick="javascript:getClusters()" style="margin-top: 5px;">Get clusters</button>
                </div>
            </div>
        </td>
        <td>
            <div id="map" style="height: 100%;"></div>
        </td>
    </tr>
</table>
</div>


</body>
</html>