<html>
<head>
    <title>BirdSquare: Check In</title>
    <script type="text/javascript" src="javascript/validation.js"></script>

</head>

<body>
<div id="main-container">
    <form name="birdinformation" onsubmit="return validateForm()" action="status" method="post">
    <#include "../header.ftl">

        <div id="main-content">

            <h2>You are at</h2>
            <input class="TextBox" type ="text" name="location" placeholder="Enter location name" value="${locationname}" size="50" />
            <p></p>
            <h2>Please enter bird details:</h2>

            <p></p><input class="TextBox" placeholder="Bird Name" type="text" name="birdname" size="50"/>

            <p></p><input class="TextBox" placeholder="Number of birds seen"   type="text" name="number" size="50"/>
            <p></p>

            <input type="hidden" name="latitude" value="${latitude}"/>
            <input type="hidden" name="longitude" value="${longitude}"/>


            <p></p><textarea class="CommentBox" name="comments" rows=5 cols=37 placeholder="Comments"></textarea>

            <p></p>
            <input id="submitbutton" type="submit" value="Submit"/>
        </div>
    <#include "../footer.ftl">
    </form>
</div>
</body>

</html>
