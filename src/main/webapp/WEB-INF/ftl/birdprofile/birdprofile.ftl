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
    <div data-role="content" id="birdprofile-content" >
        <p><b>Common Name</b> : ${birdname}</p>
        <p><b>Scientific Name</b> : ${scientificname}</p>
        <p><b>Family Name </b>: ${familyname}</p>
        <p><b>Order Name </b>: ${ordername}</p>
        <img style="width: 300px;height: 300px" src="${linkToBirdImage}">
    </div>
    <div id="wikibutton">
        <a href="http://en.wikipedia.org/wiki/${birdname}" data-role="button" target="_blank" data-theme='e'>Read More On Wiki</a>
    </div>


<#include "../footer.ftl">
</div>
</body>
</html>
