<html>
<head>
    <title> BirdSquare: Home</title>
    <link rel="stylesheet" type="text/css" href="css/header.css">
</head>

<body>
<div id="main-container">
<#include "../header.ftl">
   <div id="main-content">
        <p>
            Welcome to BirdSquare
        </p>
       <p>
           LOGIN
       </p>

       <div id="fb-root"></div>
       <script>
           window.fbAsyncInit = function() {
               FB.init({
                   appId      : 382365808510578, // App ID
                   channelUrl : www.birdsquare.in, // Channel File
                   status     : true, // check login status
                   cookie     : true, // enable cookies to allow the server to access the session
                   xfbml      : true  // parse XFBML
               });

               FB.Event.subscribe('auth.statusChange', handleStatusChange);
           };

           // Load the SDK Asynchronously
           (function(d){
               var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
               if (d.getElementById(id)) {return;}
               js = d.createElement('script'); js.id = id; js.async = true;
               js.src = "//connect.facebook.net/en_US/all.js";
               ref.parentNode.insertBefore(js, ref);
           }(document));
       </script>

    </div>
<#include "../footer.ftl">
</div>
</body>
</html>