<html>
<head>
    <title>BirdSquare: Check In</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="javascript/validation.js"></script>
    <script type="text/javascript" src="javascript/location.js"></script>
    <script type="text/javascript" src="javascript/birdnameautocomplete.js"></script>
</head>

<body>
<div id="main-container">
    <form name="birdinformation" onsubmit="return validateForm()" action="status" method="post">
    <#include "../header.ftl">

        <div id="main-content">

            <p class="instructions">You are at</p>
            <input class="TextBox" type ="text" name="locationName" placeholder="Enter location name" value="${locationName}" size="20" id="txt_location"/>
            <p></p>
            <p class="instructions">Enter bird details</p>

            <p></p><input class="TextBox" placeholder="Bird Name" type="text" name="birdName" size="20"/>

            <p></p><input class="TextBox" placeholder="Number of birds seen" type="text" name="number" size="20.5"/>
            <p></p>

            <p></p><textarea class="CommentBox" name="comments" rows=5 cols=22 placeholder=" Comments"></textarea>

            <p></p>
            <input id="submitbutton" type="submit" value="Submit"/>
            <p></p>

            <input type="hidden" name="latitude" value="${latitude}"/>
            <input type="hidden" name="longitude" value="${longitude}"/>
            <#--<input type="hidden" id="allbirds" value="${allbirds}"/>-->

        </div>
    <#include "../footer.ftl">
    </form>
</div>
</body>
</html>
