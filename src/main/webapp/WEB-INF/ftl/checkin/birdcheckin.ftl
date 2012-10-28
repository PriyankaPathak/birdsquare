<html>
<head>
    <title>BirdSquare: Home Page</title>
</head>

<body>

<div id="main-container">

<form action="status" name="birdinformation" method="POST">
<#include "../header.ftl">

    <div id="main-content">

       <br>BirdName *<br>
        <input type ="text" name="birdname"/>

        <br>Bird Number *<br>
        <input type ="text" name="number"/>

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