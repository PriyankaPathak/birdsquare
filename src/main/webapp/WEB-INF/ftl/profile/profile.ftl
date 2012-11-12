<!DOCTYPE html>
<html>
<head>
    <title> Birdsquare:profile</title>

</head>

<body>
<div id="fb-root"></div>
<#include "../includes.ftl">
<div data-role="page" id="profile">
<#include "../headers/header-with-checkin.ftl">
    <div data-role="content" id="profile-content">
        <p>You have earned ${points} points.</p>
    </div>

<#include "../footer.ftl">
</div>
</body>
</html>