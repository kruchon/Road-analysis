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
    <script src="resources/js/initEditSummary.js"></script>
    <script src="resources/js/saveSummary.js"></script>
    <script src="resources/js/createSummary.js"></script>
    <script src="resources/js/showResults.js"></script>
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
            <li><button type="button" class="btn btn-primary btn-md" onclick="javascript:createSummary()" style="margin-top:6%;">Create summary</button></li>
        </ul>
    </div>
</nav>

<table>
    <tr>
        <td>
            <div id="buttonsWithSummaries" style="height:90vh;width:300px; overflow-y:scroll;">
                <!-- content will be printed by 'printButtonsOnSummariesPageLoad.js' -->
            </div>
        </td>
        <td>
            <div style="padding:30px;">
                <div id="editSummary" class="panel panel-default" style="width: 600px; height:85vh; display: none;">
                    <div class="panel-heading"><h4>Edit Summary</h4></div>
                    <div class="panel-body">
                        <label for="summaryName">Name:</label>
                        <input type="text" class="form-control" id="summaryName" style="width: 300px;">
                        <br>
                        <label for="summaryQuery">SQL Query:</label>
                        <textarea class="form-control" rows="27" id="summaryQuery" style="width: 100%;"></textarea>
                        <button type="button" class="btn btn-primary btn-md" onclick="javascript:saveSummary()" style="margin-top: 5px;">Save</button>
                    </div>
                </div>
                <div class="table-bordered" style="height:85vh; overflow-y: scroll; background-color: #FFFFFF;">
                    <table id="summaryResults" class="table">
                        <!-- content will be printed by 'showResults.js' -->
                        <thead>
                        <tr id="tableColumns">

                        </tr>
                        </thead>
                        <tbody id="tableValues">

                        </tbody>
                    </table>
                </div>
            </div>
        </td>
    </tr>
</table>

</body>
</html>