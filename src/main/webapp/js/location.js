function getLocation(){
    if(navigator.geolocation)
        var pos = navigator.geolocation.getCurrentPosition(showPosition, errorGeoSupport);
    else
        alert("your browser does not support geolocation");
}


function showPosition(position){
    var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);

    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({'latLng': latlng}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[1]) {
                document.getElementById("location").innerHTML="<input value=\" "  +
                    results[1].formatted_address +
                    "\" size=\"35\" type =\"text\" name=\"location\"  >";
            }
        } else {
            alert("Geocoder failed due to: " + status);
            document.getElementById("location").innerHTML="<input value=\" "  +
                "Enter location" +
                "\" size=\"35\" type =\"text\" name=\"location\"  >";

        }
    });
}

function errorGeoSupport(){
    alert("GooGle map failure: No Internet Connection. Please, enter location manually");
    document.getElementById("location").innerHTML="<input value=\" "  +
        "Enter location" +
        "\" size=\"35\" type =\"text\" name=\"location\"  >";

}