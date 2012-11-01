<html>
<head>
    <title> BirdSquare: Home</title>
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <script type="text/javascript" src="javascript/FBLogin.js"></script>

</head>

<body>

<div id="main-container">
<#include "../header.ftl">
   <div id="main-content">
        <p>
            Welcome to BirdSquare
        </p>
       <!-- Display a login if you're coming to the app from outside of facebook -->
       <div id="login">
           <p><button onClick="loginUser();">Login</button></p>
       </div>

       <div id="logout">
           <p><button  onClick="FB.logout();">Logout</button></p>
       </div>

       <p>Misc page content here...</p>

       <!-- Initialize the fb javascript SDK -->

       <!-- Callback triggered when the user authenticates -->

       <!-- fb javascript SDK import -->
       <div id="fb-root"></div>
       <!--Display the user's face when they log in -->
       <div id="user-info"></div>
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