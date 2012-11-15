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
        <div id="username"></div>
        <div id="city"></div>
        <div id="userpoints">
            POINTS (LAST 7 DAYS)
            <p id="userpoints-number">${points}</p>
        </div>

        <div id="leaderboard">
            <h3>Leaderboard</h3>
            <ul data-role='listview'>
                <#list leaderboardlist as user>
                    <li id="${user.id}">${user.username},  ${user.points}</li>
                </#list>
            </ul>
        </div>

        <div id="fb-logout-btn"><a onclick="logOutUser();" data-role="button" rel="external" data-theme="b" class="ui-btn-middle">Log out</a></div>

    </div>
<#include "../footer.ftl">
</div>


</body>

</html>

<script>
    $(document).ready(function(){

    }
</script>

