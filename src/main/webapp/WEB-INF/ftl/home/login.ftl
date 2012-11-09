<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
    <title> BirdSquare: Login</title>
</head>

<body>

<div data-role="page" id="loginpage">

<#include "../headers/header-with-checkin.ftl">

    <div data-role="content" id="home-content">
        <p>
            Welcome to BirdSquare
        </p>

        <div id="fb-root"></div>
        <div class="fb-login-button" autologoutlink="true" data-show-faces="true" data-width="200" data-max-rows="1"></div>
        <div id="user-info"></div>

    </div>

    <script type="text/javascript" src="javascript/FBLogin.js"></script>

<#include "../footer.ftl">
</div>

</body>

</html>
