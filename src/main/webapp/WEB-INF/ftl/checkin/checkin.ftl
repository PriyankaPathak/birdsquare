<#include "../header.ftl">
    <title>BirdSquare: Locations</title>
    <script
            src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
    </script>
    <script type="text/javascript" src="javascript/location.js"></script>
    <script type="text/javascript">getLocation(); </script>
</head>

<body>

<div data-role="page" id="checkin"><#--this div is closed in footer-->
    <div data-role="header" style="font-size: 15px">
        <h1 style="margin-left:-100px;">BirdSquare</h1>
        <a onclick="document.getElementById('form-addlocation').submit();"data-role='button' rel='external' data-theme='e' class='ui-btn-right' id="addLocation">New Location</a>
    </div>

    <div data-role="content" >
        <p>Select location:</p>

        <ul id="location-container" data-role='listview' data-inset='true' data-filter='true'></ul>

    </div><!-- /content -->

<#include "../footer.ftl">
