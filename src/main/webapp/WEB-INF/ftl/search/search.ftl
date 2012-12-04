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
    <div data-role="content" id="birdlist" >
        <ul data-role='listview' data-inset='true' data-filter='true'>
            <#list allbirds as item><li><a id="birdnumber" href="birdprofile/${item.id}" rel="external">${item.common_name+"("+item.scientific_name+")"}</a></li></#list>"
        </ul>
    </div>

<#include "../footer.ftl">
</div><!-- /page -->

</body>
</html>