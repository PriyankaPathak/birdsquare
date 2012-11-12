window.fbAsyncInit = function () {
    FB.init({
        appId:'454719261240892', // App ID from the App Dashboard
        status:true, // check the login status upon init?
        cookie:true, // set sessions cookies to allow your server to access the session?
        xfbml:true  // parse XFBML tags on this page?
    });

    FB.Event.subscribe('auth.login', function (response) {
        redirectToReferrerPage();
    });

    FB.Event.subscribe('auth.logout', function (response) {
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

//            if (document.URL ===  getBaseUrl() + '/home') {
                fetchUserData(response);
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
        if (document.URL === getBaseUrl() + '/login') {
            window.location.href = document.referrer;
        }
    }

    function redirectToLogin() {
        var loginUrl = getBaseUrl()+'/login';
        var cleanLoginUrl =  loginUrl.replace('//', '/');

        if (document.URL != loginUrl) {

            window.location.href = loginUrl;
        }
    }

    function setFbuidInPage(uid) {
        if (document.URL === getBaseUrl() + '/checkinform') {
            document.getElementById('fbuid').value = uid;
        }
    }

    function getBaseUrl() {
        return document.URL.replace(/\/[^\/]+$/, '');
    }

    function fetchUserData(response) {

            FB.api('/me', function (response) {
                document.getElementsByClassName('fbuser')[0].innerHTML += response.name + "<br>";
                document.getElementsByClassName('fbpic')[0].innerHTML += "<img src='http://graph.facebook.com/" +
                    response.id + "/picture' />" + "<br>";
            });
        }
};

function loginUser() {
    FB.login(function (response) {
        }, {scope:'user_likes, offline_access'}
    );
}
;

function logOutUser() {
    FB.logout(function (response) {
    });
}