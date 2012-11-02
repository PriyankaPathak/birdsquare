<html>
<head>
    <title>BirdSquare: Check In</title>
    <script
            src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
    </script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="javascript/location.js"></script>
    <script type="text/javascript">window.onload=getLocation;</script>

</head>

<body>
<div id="main-container">

<#include "../header.ftl">
    <div id="main-content">
        <input type="hidden" name="locationName">
        <input type="hidden" id="latitude" value="">
        <input type="hidden" id="longitude" value="">


    </div>
<#include "../footer.ftl">
</div>

</body>

</html>