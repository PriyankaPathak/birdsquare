<!DOCTYPE html>
<html>
<head>
<#include "../includes.ftl">
<title> Birdsquare: search</title>
    <script type="text/javascript" src="javascript/birdnameautocomplete.js"></script>
</head>

<body>

<div data-role="page" id="search">
<#include "../headers/header-with-checkin.ftl">
    <div data-role="content">
        <ul data-role='listview' data-inset='true' data-filter='true'>
            <#list allbirds as item><li>${item}</li></#list>"
        </ul>
        <#--<label for="birdname-field" class="ui-hidden-accessible"></label>-->
        <#--<input type="text" name="birdName" id="birdname-field" placeholder="Bird name"/>-->

        <#--<input type="hidden" name="birdNameList" id="birdNameList" value="<#list allbirds as item>${item},</#list>"/>-->
    </div>

<#include "../footer.ftl">
</div><!-- /page -->

</body>
</html>