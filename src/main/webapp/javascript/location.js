function getLocation() {
    if (navigator.geolocation){
        navigator.geolocation.getCurrentPosition(showPosition, showError);
        console.log("getloca");
        }

    else
        alert("your browser does not support Geolocation");
}


function showPosition(position) {
    console.log("inside")
    var foursquareAPIURL = "https://api.foursquare.com/v2/venues/search?ll=" + position.coords.latitude + "," + position.coords.longitude + "&oauth_token=XQZOS4SH3WHZ32EKFAUX3YU45CFEJGYZTFR2C5F0KMB1EHCX&v=20121030"

    $.getJSON(foursquareAPIURL, function (data) {
        console.log(data);
        for (var i = 0; i < data.response.venues.length; i++) {

            var location = showLocations(data.response.venues[i]);
           document.getElementById("location-container").innerHTML +=
               "<form id='form-"+ i + "' method='post' action='birdcheckin'> " +
               " <input type='hidden' name='locationname' value=\"" + location.name +"\" /> " +
                   " <input type='hidden' name='latitude' value=" + location.lat +" /> " +
                   " <input type='hidden' name='longitude' value=" + location.lng +" /> " +
               " <a onclick=\"document.getElementById('form-"+ i + "').submit();\">  <li>"+ location.name +" </li></a> " +
                "</form>";
        }

        document.getElementById("addLocation").innerHTML +=
            "<form id='form-"+ i + "' method='post' action='birdcheckin'> " +
                " <input type='hidden' name='locationname' /> " +
                " <input type='hidden' name='latitude' value=" + position.coords.latitude +" /> " +
                " <input type='hidden' name='longitude' value=" + position.coords.longitude +" /> " +
                " <a onclick=\"document.getElementById('form-"+ i + "').submit();\"><h1 style='color: white;'> Add Location </h1> </a> " +
                "</form>";


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

function addLocation(){
    var locationFromTextBox = document.getElementById('txt_location');
    console.log("outside" +locationFromTextBox.disabled);

    if(locationFromTextBox.value != ""){
       console.log(locationFromTextBox.disabled);
         locationFromTextBox.disabled = "true";
   }

}