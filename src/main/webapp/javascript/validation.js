validateForm=function()
{
    var birdName=document.forms["birdinformation"]["birdName"].value;
    birdName = birdName.replace(/^\s\s*/, '').replace(/\s\s*$/, '');

    var number=document.forms["birdinformation"]["number"].value;

    var locationName=document.forms["birdinformation"]["locationName"].value;
    locationName = locationName.replace(/^\s\s*/, '').replace(/\s\s*$/, '');

    var birdNameString = document.forms["birdinformation"]["birdNameList"].value;

    var birdNameList = birdNameString.split(",");

       var errMessage = "";
    if (!validate_bird_name_field(birdName, birdNameList))
        errMessage += "[Bird Name] Please select bird name from given list.\n";

    if(!validate_number_of_birds_field(number))
        errMessage += "[Number of birds] Please enter valid integer greater than zero.\n";

    if (!is_not_an_empty_field(locationName))
        errMessage += "[Location Name]Location name must be filled out\n";

    if (errMessage !== ""){
        alert(errMessage);
        return false;
    }
    else {
        alert("You have checked in " + number + " " + birdName + "(s) successfully in "+locationName+".");
        document.forms["birdinformation"]["birdName"].value = getScientificNameOfBird(birdName);
        return true;
    }
};

function validate_bird_name_field(birdName, birdNameList){
    return (bird_name_belongs_in_database(birdName, birdNameList) &&
            is_not_an_empty_field(birdName));
}

function validate_number_of_birds_field(number){
    return (contains_number_atleast_greater_than_zero(number) &&
            is_not_an_empty_field(number) &&
            is_a_valid_number(number));
}

function getScientificNameOfBird(birdName) {
    return birdName.substring(birdName.indexOf("(")+1, (birdName.indexOf(")")));
};

var is_a_valid_number = function(input){
    return !isNaN(input);
};

var is_not_an_empty_field = function(input){
    return !(input==null || input=="");
};

var does_not_contain_special_characters=function(input){
    var iChars = "!@#$%^&*+=[]\\;,./{}|\":<>?";
    for (var i = 0; i < input.length; i++) {
        if (iChars.indexOf(input.charAt(i)) != -1) {
            return false;
        }
    }
    return true;
};

var contains_number_atleast_greater_than_zero = function(input){
    return !(input <= 0);
}

var bird_name_belongs_in_database = function( birdName , birdNameList){
    var foundIt = birdNameList.indexOf(birdName);
    return (foundIt >= 0);
}

