window.fbAsyncInit = function() {
    FB.init({
        appId      : '454719261240892', // App ID from the App Dashboard
        status     : true, // check the login status upon init?
        cookie     : true, // set sessions cookies to allow your server to access the session?
        xfbml      : true  // parse XFBML tags on this page?
    });

    FB.Event.subscribe('auth.login', function(response) {
        redirectToReferrerPage();
    });

    FB.Event.subscribe('auth.logout', function(response) {
        redirectToLogin();
    });

    FB.getLoginStatus(function(response) {
        if (response.status === 'connected') {
            // the user is logged in and has authenticated your
            // app, and response.authResponse supplies
            // the user's ID, a valid access token, a signed
            // request, and the time the access token
            // and signed request each expire

            var uid = response.authResponse.userID;
            var accessToken = response.authResponse.accessToken;
            setFbuidInPage(uid);
//            } else if (response.status === 'not_authorized') {
//                // the user is logged in to Facebook,
//                // but has not authenticated your app
        } else {
            // the user isn't logged in to Facebook.
            redirectToLogin();
        }
    });


    function redirectToReferrerPage() {
        if (document.URL === 'http://' + window.location.host + '/login') {
            window.location.href = document.referrer;
        }
    }

    function redirectToLogin() {
        if (document.URL != 'http://' + window.location.host + '/login') {
           window.location.href = '/login';
        }
    }

    function setFbuidInPage(uid) {
        if (document.URL === 'http://' + window.location.host + '/checkinform') {
            document.getElementById('fbuid').value = uid;
        }
    }

};

//(function() {
//    var e = document.createElement('script');
//    e.type = 'text/webapp.webapp.javascript';
//    e.src =  'http://connect.facebook.net/en_US/all.js';
//    e.async = true;
//    document.getElementById('fb-root').appendChild(e);
//}());