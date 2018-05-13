<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<head>
    <meta name="http-equiv" content="Content-type: text/html; charset=UTF-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="resources/js/printButtonsOnSummariesPageLoad.js" charset="utf-8"></script>
</head>
<body>
<style>
    body {
        background-color: #C0C0C0;
    }
</style>
<nav role="navigation" class="navbar navbar-default">
    <!-- default menu -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Summaries</a></li>
            <li><a href="#">Cluster map</a></li>
            <li><button type="button" class="btn btn-primary btn-md" style="margin-top:6%;">Create summary</button></li>
        </ul>
    </div>
</nav>

<div id="buttonsWithSummaries">
    <table id="buttonsWithSummariesTable" style="width:100%">
    <!-- content will be printed by 'printButtonsOnSummariesPageLoad.js' -->
    </table>
</div>

</body>
</html>