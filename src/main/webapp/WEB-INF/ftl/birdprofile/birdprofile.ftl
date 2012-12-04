<!DOCTYPE html>
<html>
<head>
    <title> Birdsquare:birdprofile</title>
</head>

<body>
<div id="fb-root"></div>
<#include "../includes.ftl">
<div data-role="page" id="birdprofile">
<#include "../headers/header-with-checkin.ftl">
    <div data-role="content" id="birdprofile-content">
        <p>Common Name : ${birdname}</p>
        <p>Scientific Name : ${scientificname}</p>
        <p>Family Name : ${familyname}</p>
        <p>Order Name : ${ordername}</p>
        <img style="width: 300px;height: 300px" src="${linkToBirdImage}">
    </div>

<#include "../footer.ftl">
</div>
</body>
</html>
