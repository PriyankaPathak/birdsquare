<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
    <title> BirdSquare: Login</title>
    <script type="text/javascript" src="http://connect.facebook.net/en_US/all.js"></script>
</head>

<body>

<div data-role="page" id="loginpage">

    <div data-role="content" id="login-content" style="text-align: center; vertical-align:middle;">
        <p></p>
        <h1>
            Welcome!
        </h1>

        <a onClick="loginUser(); return false;"><img src="img/button.jpg" /></a>

    </div>

    <script type="text/javascript" src="javascript/FBLogin.js"></script>
</div>

</body>

</html>
