validateForm=function()
{
    var birdName=document.forms["birdinformation"]["birdName"].value;

    birdName = birdName.replace(/^\s\s*/, '').replace(/\s\s*$/, '');

    var number=document.forms["birdinformation"]["number"].value;

    var locationName=document.forms["birdinformation"]["locationName"].value;
    locationName = locationName.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
    if (!is_not_an_empty_field(birdName))
    {
        alert("Bird name must be filled out");
        return false;
    }
    else if (!does_not_contain_numbers(birdName))
    {
        alert("Bird name must not have numeric characters");

        return false;
    }
    else  if(!does_not_contain_special_characters(birdName)) {
        alert('Bird name should not contain special characters');
        return false;
    }
    if(does_not_contain_numbers(number))
    {
        alert("Enter a valid number");
        return false;

    }
    else if(!contains_number_atleast_greater_than_zero(number)){
        alert("Invalid Number");
        return false;
    }
    else if(!is_not_an_empty_field(number))
    {
        alert("Number of birds must be filled out");
        return false;

    }
    else if(!is_a_valid_number(number))
    {
        alert("Please enter a valid number");
        return false;
    }
    if (!is_not_an_empty_field(locationName))
    {
        alert("Location name must be filled out");
        return false;
    }

//   showPopup(number, birdName, locationName);
    alert("You have checked in " + number + " " + birdName + "(s) successfully in "+locationName+".");
    document.forms["birdinformation"]["birdName"].value = getScientificNameOfBird(birdName);
    return true;
};


////function showPopup(number, birdName, locationName){
//////    alert('inside popup');
////
////}
//
//$('#birdinformation').submit(function() {
//    $('<div>').simpledialog2({
//        mode: 'blank',
//        headerText: 'Some Stuff',
//        headerClose: true,
//        position : 'absolute',
//        blankContent :
//            "<div><p>Hello We Are ine popup</p>" +
//                "<a rel='close' data-role='button' href='#'>Close</a></div>"
//    })
//    return true;
//});
function getScientificNameOfBird(birdName) {
    birdName = birdName.substring(birdName.indexOf("(")+1, (birdName.indexOf(")")));
    return birdName;
}

var is_a_valid_number = function(input){

    return !isNaN(input);
}


var does_not_contain_numbers = function(input){
    return !(/\d/.test(input));
};

var is_not_an_empty_field = function(input){
    if(input==null || input=="")
    {
        return false;
    }
    return true;
};

does_not_contain_special_characters=function(input){
    var iChars = "!@#$%^&*+=[]\\;,./{}|\":<>?";
    for (var i = 0; i < input.length; i++) {
        if (iChars.indexOf(input.charAt(i)) != -1) {
            return false;
        }
    }
    return true;
};

var contains_number_atleast_greater_than_zero = function(input){
    if(input <= 0) {
        return false;
    }
    return true;
}



