<html>
<head>
    <title>BirdSquare: Check In</title>
    <script type="text/javascript" src="javascript/validation.js"></script>

</head>

<body>
<div id="main-container">
    <form name="checkin" onsubmit="return validateForm()" action="status" method="post">
    <#include "../header.ftl">

        <div id="main-content">

            <br>Bird Name *<br>
            <input class="TextBox" type ="text" name="birdname" size="50" />

            <br>Number of Birds *<br>
            <input class="TextBox" type ="text" name="number" value="1" size="50" />

            <br>Bird Location *<br>
            <input class="TextBox" type ="text" name="location" value="${locationname}" size="50" />

            <input type="hidden" name="latitude" value="${latitude}"/>
            <input type="hidden" name="longitude" value="${longitude}"/>

            <br>Comments <br>
            <textarea name="comments" rows=5 cols=50></textarea>
            <p></p>
            <input type="submit" value="submit" />
        </div>
    <#include "../footer.ftl">
    </form>
</div>
</body>

</html>
