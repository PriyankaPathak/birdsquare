function getLocation() {
    if (navigator.geolocation)
        navigator.geolocation.watchPosition(showPosition, showError);
    else
        alert("your browser does not support Geolocation");
}


function showPosition(position) {
    var foursquareAPIURL = "https://api.foursquare.com/v2/venues/search?ll=" + position.coords.latitude + "," + position.coords.longitude + "&oauth_token=XQZOS4SH3WHZ32EKFAUX3YU45CFEJGYZTFR2C5F0KMB1EHCX&v=20121030"
    $.getJSON(foursquareAPIURL, function (data) {
        for (var i = 0; i < data.response.venues.length; i++) {

            var location = showLocations(data.response.venues[i]);
           document.getElementById("location-container").innerHTML += "<a class='nearBy' method='POST' " +
                " id="+location.name+" style='color: black;' href=\"birdcheckin?name="+location.name+"&lat=" + location.lat + "&lng=" + location.lng + "\" > <li>"+ location.name +" </li></a>";

        }
    });
}

function showLocations(data) {
    var locationList = new Array();
    var location = {
        "name":data.name,
        "lat":data.location.lat,
        "lng":data.location.lng
    };
    return location;
}

function showError(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED:
            alert("User denied the request for Geolocation.");
            break;
        case error.POSITION_UNAVAILABLE:
            alert("Location information is unavailable.");
            break;
        case error.TIMEOUT:
            alert("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
            alert("An unknown error occurred.");
            break;
    }
}
