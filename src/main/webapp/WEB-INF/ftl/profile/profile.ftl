<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
    <title> Birdsquare:profile</title>

</head>

<body>
<div data-role="page" id="profile">
<#include "../headers/header-with-checkin.ftl">
    <div data-role="content" id="profile-content">
        <p>${message}</p>
        <div data-role="popup" id="popupBasic">
            <p>This is a completely basic popup, no options set.<p>
        </div>

    </div>

<#include "../footer.ftl">
</div>
</body>
</html>