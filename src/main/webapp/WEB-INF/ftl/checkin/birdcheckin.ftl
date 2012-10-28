<html>
<head>
    <title>BirdSquare: Check In</title>
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <script type="text/javascript" src="js/validation.js"></script>
</head>

<body>
<div id="main-container">
<form action="status" name="birdinformation" method="POST" action="status.html" onsubmit="return validateForm()">
<#include "../header.ftl">

    <div id="main-content">

        <br>BirdName *<br>
        <input type ="text" name="birdname"/>

        <br>Bird Number *<br>
        <input type ="text" name="number" value="1"/>

        <br>Bird Location *<br>
        <input type ="text" name="location" value="Bangalore"/>

        <br>Comments <br>
        <input type ="text" name="comments"/>


        <input type="submit" value="submit"/>
    </div>
<#include "../footer.ftl">
</form>
</div>
</body>

</html>