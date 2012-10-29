function getLocation(){
    if(navigator.geolocation)
        navigator.geolocation.watchPosition(showPosition, showError);
    else
        alert("your browser does not support Geolocation");
}


function showPosition(position){
    alert("in here");

    var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);

    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({'latLng': latlng}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[1]) {
                document.getElementById("location").innerHTML="<textarea rows=\"2\" "+
                "cols=\"30\" name=\"location\">" + results[1].formatted_address + "</textarea>";
            }
        } else {
            alert("Geocoder failed due to: " + status);
            document.getElementById("location").innerHTML="<input class = \"TextBox\" value=\" "  +
                "Enter location" +
                "\" size=\"50\" type =\"text\" name=\"location\"  >";

        }
    });
}

function showError(error)
{
    switch(error.code)
    {
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


function errorGeoSupport(){
    alert("GooGle map failure: No Internet Connection. Please, enter location manually");
    document.getElementById("location").innerHTML="<input value=\" "  +
        "Enter location" +
        "\" size=\"35\" type =\"text\" name=\"location\"  >";

}