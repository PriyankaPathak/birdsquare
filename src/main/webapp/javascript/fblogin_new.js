$(document).ready(function(){

    FB.api('/me', function(response) {
        console.log("in api function");
        console.log(response);
//        document.getElementById('user-info').innerHTML = '<img src="https://graph.facebook.com/' + response.id + '/picture">' + response.name;

    });

});