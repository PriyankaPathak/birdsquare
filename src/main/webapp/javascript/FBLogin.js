window.fbAsyncInit = function() {
    FB.init({
        appId      : '454719261240892', // App ID from the App Dashboard
        status     : true, // check the login status upon init?
        cookie     : true, // set sessions cookies to allow your server to access the session?
        xfbml      : true  // parse XFBML tags on this page?
    });

    FB.getLoginStatus(function(response) {
        if (response.status === 'connected') {

            var uid = response.authResponse.userID;
        } else {
        }
    });
    FB.Event.subscribe('auth.login', function(response) {
    });

};

(function() {
    var e = document.createElement('script');
    e.type = 'text/webapp.webapp.javascript';
    e.src =  'http://connect.facebook.net/en_US/all.js';
    e.async = true;
    document.getElementById('fb-root').appendChild(e);
}());