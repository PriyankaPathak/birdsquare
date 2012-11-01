<html>
<head>
    <title> BirdSquare: Home</title>
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <#--<script src="//connect.facebook.net/en_US/all.js"></script>-->
</head>

<body>

<div id="main-container">
<#include "../header.ftl">
   <div id="main-content">
        <p>
            Welcome to BirdSquare
        </p>
       <p>
           LOGIN haha
       </p>


       <!-- Display a login if you're coming to the app from outside of facebook -->
       <div id="login">
           <p><button onClick="loginUser();">Login</button></p>
       </div>

       <div id="logout">
           <p><button  onClick="FB.logout();">Logout</button></p>
       </div>

       <script>
           function loginUser() {
               FB.login(function(response) { }, {scope:'email'});
           }
       </script>

       <p>Misc page content here...</p>

       <!-- Initialize the fb javascript SDK -->
       <script>
           window.fbAsyncInit = function() {
               FB.init({ appId: '382365808510578',
                   status: true,
                   cookie: true,
                   xfbml: true,
                   oauth: true});
               FB.Event.subscribe('auth.statusChange', handleStatusChange);
           };
       </script>

       <!-- Callback triggered when the user authenticates -->
       <script>
           function handleStatusChange(response) {
               document.body.className = response.authResponse ? 'connected' : 'not_connected';
               if (response.authResponse) {
                   console.log(response);

                   updateUserInfo(response);
               }
           }
       </script>

       <!-- fb javascript SDK import -->
       <div id="fb-root"></div>
       <script>
           (function() {
               var e = document.createElement('script'); e.async = true;
               e.src = document.location.protocol + '//connect.facebook.net/en_US/all.js';
               document.getElementById('fb-root').appendChild(e);
           }());
       </script>

       <!--Display the user's face when they log in -->
       <div id="user-info"></div>
       <script>
           function updateUserInfo(response) {
               FB.api('/me', function(response) {
                   document.getElementById('user-info').innerHTML = '<img src="https://graph.facebook.com/' + response.id + '/picture">' + response.name;
               });
           }
       </script>

       <!-- This style sheet changes the name of the body to reflect logged in status, thereby
cueing to the login logout buttons which one should be visible -->
       <style>
           body.connected #login { display: none; }
           body.connected #logout { display: block; }
           body.not_connected #login { display: block; }
           body.not_connected #logout { display: none; }
       </style>



    </div>
<#include "../footer.ftl">
</div>
</body>
</html>