function loginUser() {
    FB.login(function(response) { }, {scope:'email'});
}

function handleStatusChange(response) {
    document.body.className = response.authResponse ? 'connected' : 'not_connected';
    if (response.authResponse) {
        console.log(response);

        updateUserInfo(response);
    }
}
(function() {
    var e = document.createElement('script'); e.async = true;
    e.src = document.location.protocol + '//connect.facebook.net/en_US/all.js';
    document.getElementById('fb-root').appendChild(e);
}());

function updateUserInfo(response) {
    FB.api('/me', function(response) {
        document.getElementById('user-info').innerHTML = '<img src="https://graph.facebook.com/' + response.id + '/picture">' + response.name
            +response.location.address.name;
    });
};

function ashwinWish(){
    FB.init({ appId: '382365808510578',
        status: true,
        cookie: true,
        xfbml: true,
        oauth: true});
    FB.Event.subscribe('auth.statusChange', handleStatusChange);
};