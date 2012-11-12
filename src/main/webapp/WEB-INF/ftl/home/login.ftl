<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
    <title> BirdSquare: Login</title>
    <script type="text/javascript" src="http://connect.facebook.net/en_US/all.js"></script>
</head>

<body>

<div data-role="page" id="loginpage">

    <div data-role="content" id="home-content" style="text-align: center; vertical-align:middle;">
        <p></p>
        <p>
            Please login using your facebook credentials
        </p>

         <fb:login-button autologoutlink="true" onlogin="OnRequestPermission();"></fb:login-button>

    </div>

    <script type="text/javascript" src="javascript/FBLogin.js"></script>
</div>

</body>

</html>
