<html>
<head>
    <title>BirdSquare: Check In</title>
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <script type="text/javascript" src="js/validation.js"></script>
    <script
        src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
    </script>
    <script type="text/javascript" src="js/location.js"></script>
    <script type="text/javascript">window.onload=getLocation;</script>
</head>

<body>
<div id="main-container">
<form name="birdinformation" onsubmit="return validateForm()" action="status">
<#include "../header.ftl">
    <#--<div class="header-left">-->
        <#--<h3><a href=home>BirdSquare Logo</a></h3>-->
    <#--</div>-->

    <#--<div class="header-right">-->
        <#--<h3><button><img src="../../img/checkin.png"></button></h3>-->
    <#--</div>-->


    <div id="main-content">

        <br>Bird Name *<br>
        <input class="TextBox" type ="text" name="birdname" size="50" />

        <br>Number of Birds *<br>
        <input class="TextBox" type ="text" name="number" value="1" size="50" />

        <br>Bird Location *<br>
        <p id="location"></p>

        <br>Comments <br>
        <textarea name="comments" rows=5 cols=50></textarea>
        <input type="submit" value="submit"/>
    </div>
<#include "../footer.ftl">
</form>
</div>
</body>

</html>