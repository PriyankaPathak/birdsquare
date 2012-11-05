<html>
<head>
    <title>BirdSquare: Check In</title>
    <script
            src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
    </script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="javascript/location.js"></script>


</head>

<body>
<div id="main-container">

<#include "../header.ftl">
        <div id="main-content">
            <p class="instructions">Select Location</p>

            <div id="location-container">

            </div>

        </div>
<#include "../footer.ftl">
</div>

</body>
<script type="text/javascript">getLocation(); </script>
</html>