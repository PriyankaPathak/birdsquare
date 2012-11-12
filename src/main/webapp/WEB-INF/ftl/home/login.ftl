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
        <h1>
            Welcome!
        </h1>

         <#--<fb:login-button autologoutlink="true" onlogin="OnRequestPermission();"></fb:login-button>-->

        <#--<div class="fb-login-button" data-show-faces="true" data-width="200" data-max-rows="1"><img src="img/button.gif"/></div>-->

        <#--<div class="fb-login-button" autologoutlink="true" data-show-faces="false" data-width="200" data-max-rows="1"></div>-->

        <#--<fb:login-button>-->
            <#--Login with Facebook-->
        <#--</fb:login-button>-->



        <a onClick="loginUser(); return false;"><img src="img/button.jpg" /></a>

    </div>

    <script type="text/javascript" src="javascript/FBLogin.js"></script>
</div>

</body>

</html>
