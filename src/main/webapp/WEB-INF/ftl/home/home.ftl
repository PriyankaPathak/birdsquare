<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">

    <title> BirdSquare: Home</title>
</head>

<body>
<div data-role="page" id="homepage">
<#include "../headers/header-with-checkin.ftl">

    <div data-role="content" id="home-content">

        <div id="fbpic"></div>

        <div id="userdetails">
            <div id="username"></div>
            <div id="city"></div>
        </div>

        <div id="userpoints">
            <div class="subheading-a">LIFETIME POINTS</div>
            <p id="userpoints-number">${points}</p>
        </div>

        <div id="leaderboard">
            <div class="subheading-b">LEADERBOARD</div>
            <ol data-role='listview'>
                <#list leaderboardlist as user>
                    <li id="${user.id}"> ${user.username} <div class="leaderboard-points">${user.points}</div></li>
                </#list>
            </ol>
        </div>


        <div id="fb-logout-btn"><a onclick="logOutUser();" data-role="button" rel="external" data-theme="b" class="ui-btn-middle">Log out</a></div>


    </div>
<#include "../footer.ftl">
</div>

</body>

</html>
