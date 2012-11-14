<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
    <title> BirdSquare: Login</title>
</head>

<body>

<div data-role="page" id="loginpage">

    <div data-role="content" id="login-content" style="text-align: center; vertical-align:middle;">
        <p></p>
        <h1>
            Welcome!
        </h1>

        <a id="facebookLogin"  onClick="loginUser(); return false;"><img src="img/button.jpg" style="cursor:pointer"/></a>

    </div>

    <script type="text/javascript" src="javascript/FBLogin.js"></script>
</div>

</body>

</html>
