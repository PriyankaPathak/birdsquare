<html>
<head>
    <title>My Facebook Login Page</title>
    <script src="//connect.facebook.net/en_US/all.js"></script>
    <script type="text/javascript" src="libs/javascript/jquery-1.8.2.min.js"></script>
    <script src="//connect.facebook.net/en_US/all.js"></script>
    <script type="text/javascript" src="javascript/fblogin_new.js"></script>
</head>
<body>

<div class="fb-login-button" data-show-faces="true" data-width="200" data-max-rows="1"></div>

<div id="fb-root"></div>
<script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=APP_ID";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


<#--<script>-->
    <#--window.fbAsyncInit = function() {-->
        <#--FB.init({-->
            <#--appId      : '382365808510578', // App ID-->
            <#--channelUrl : 'home.html', // Channel File-->
            <#--status     : true, // check login status-->
            <#--cookie     : true, // enable cookies to allow the server to access the session-->
            <#--xfbml      : true  // parse XFBML-->
        <#--});-->
    <#--};-->

<#--</script>-->

<#--<div align="center">-->
    <#--<img id="image"/>-->
    <#--<div id="name"></div>-->
<#--</div>-->

</body>
</html>