<#include "../header.ftl">
    <title>BirdSquare: Check In</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="javascript/validation.js"></script>
    <script type="text/javascript" src="javascript/location.js"></script>
    <script type="text/javascript" src="javascript/birdnameautocomplete.js"></script>
</head>

<body>

<div data-role="page" id="birdcheckin">

<#include "../checkinLink.ftl">

<div data-role="content">

    <form name="birdinformation" onsubmit="return validateForm()" action="status" method="post" data-ajax="false">

        <label for="txt_location" class="ui-accessible">You are at</label>
        <input type ="text" name="locationName" placeholder="Enter location name" value="${locationName}" size="20" id="txt_location"/>
            <p></p>

            <div class="ui-widget" style="font-family: 'Arial'">

            <label for="BirdName" class="ui-accessible">Enter check in details</label>
            <input type="text" name="birdName" id="BirdName" placeholder="Bird name"/>

            <p></p><input  placeholder="Number of birds seen"   type="text" name="number"/>
            <p></p>

            <input type="hidden" name="latitude" value="${latitude}"/>
            <input type="hidden" name="longitude" value="${longitude}"/>


            <p></p>
            <label for ="Comments" class="ui-hidden-accessible">Comments:</label>
            <textarea id="Comments" name="Comments" placeholder="Comments"></textarea>

            <p></p>
            <input type="submit" value="Submit"/>
            <p></p>

            <input type="hidden" name="latitude" value="${latitude}"/>
            <input type="hidden" name="longitude" value="${longitude}"/>
            <#list allbirds as item>${item}</#list>
        </div>
    </form>
</div>

<#include "../footer.ftl">

