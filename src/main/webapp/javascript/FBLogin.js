window.fbAsyncInit = function () {
    FB.init({
        appId:'454719261240892', // App ID from the App Dashboard
        status:true, // check the login status upon init?
        cookie:true, // set sessions cookies to allow your server to access the session?
        xfbml:true  // parse XFBML tags on this page?
    });

    FB.Event.subscribe('auth.login', function (response) {
        document.cookie = 'fbuid=' + uid;
        redirectToReferrerPage();
    });

    FB.Event.subscribe('auth.logout', function (response) {
        document.cookie = '';
        redirectToLogin();
    });

    FB.getLoginStatus(function (response) {
        if (response.status === 'connected') {
            // the user is logged in and has authenticated your
            // app, and response.authResponse supplies
            // the user's ID, a valid access token, a signed
            // request, and the time the access token
            // and signed request each expire

            var uid = response.authResponse.userID;
            var accessToken = response.authResponse.accessToken;
            setFbuidInPage(uid);
            fetchUserData(response);
            document.cookie = 'fbuid=' + uid;

//            if (document.URL ===  getBaseUrl() + '/home') {
//                fetchUserData(response);
//            }
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

    function getBaseUrl() {
        return document.URL.replace(/\/[^\/]+$/, '');
    }

    function fetchUserData(response) {
        if (document.URL === 'http://' + 'http://' + window.location.host + '/home') {
            FB.api('/me', function (response) {
                console.log("hello fetching fb data")
                $("#username").append(response.name);
                if (response.location != null)
                    $('#city').append(response.location.name);
                $('#fbpic').append("<img style='width:100px; height:100px' src='http://graph.facebook.com/" + response.id + "/picture'/>")
            });
        }
    }
};

function loginUser() {
    console.log("hello i'm trying to log in");
    FB.login(function (response) {
        }, {scope:'user_likes, offline_access'}
    );
    console.log("after log in");
}
;

function logOutUser() {
    FB.logout(function (response) {
    });
}