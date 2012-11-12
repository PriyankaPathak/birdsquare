<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
    <title> BirdSquare: Home</title>
</head>

<body>
<div data-role="page" id="homepage">
<#include "../headers/header-with-checkin.ftl">

    <div data-role="content" id="home-content">

        <p class="fbuser"></p>
        <p class="fbpic"></p>
        <p></p>
        <div></div>
        <a onclick="logOutUser();" data-role="button" rel="external" data-theme="b" class="ui-btn-middle">Log out</a>

    </div>
<#include "../footer.ftl">
</div>


</body>

</html>
