<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
    <script src="javascript/JQMsliderHelper.js"></script>

    <title> BirdSquare: Home</title>
</head>

<body>
<div data-role="page" id="homepage">
<#include "../headers/header-with-checkin.ftl">

    <div data-role="content" id="home-content">
        <div class="ui-grid-b" id="picnamelocation">
            <div id="fbpic" class="ui-block-a"></div>

            <div id="userdetails" class="ui-block-b">
                <div  class="ui-bar ui-bar-e">
                    <div id="username"></div>
                    <div id="city"></div>
                </div>
                <div id="userpoints" class="ui-bar ui-bar-e">
                    <div class="subheading-a">LIFETIME POINTS</div>
                    <div id="userpoints-number">${points}</div>
                </div>
            </div>
        </div>

        <div id="progressbar">
            <label for="slider-fill">Points for last 7 days:</label>
            <input type="range" name="slider-fill" id="slider-fill" value="${temppoints}" min="0" max="${maxpoints}" data-highlight="true" />
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
