$(document).ready(function(){

    var list = $('#birdNameList').val();
    var arrList = list.split(',');
    console.log(list);
    console.log(arrList);

    $("#birdname-field").autocomplete({
        source: arrList
    });

})