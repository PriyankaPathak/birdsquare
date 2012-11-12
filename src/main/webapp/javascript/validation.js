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
        document.forms["birdinformation"]["birdName"].value = get_scientific_name_of_bird(birdName);
        return true;
    }
};

function validate_bird_name_field(birdName, birdNameList){
    return (bird_name_belongs_in_database(birdName, birdNameList) &&
            is_not_an_empty_field(birdName));
};

function validate_number_of_birds_field(number){
    return (is_not_an_empty_field(number) &&
        is_a_valid_number(number) &&
        contains_number_atleast_greater_than_zero(number));
};

function get_scientific_name_of_bird(birdName) {
    return birdName.substring(birdName.indexOf("(")+1, (birdName.indexOf(")")));
};

var is_a_valid_number = function(input){
    return !isNaN(input);
};

var is_not_an_empty_field = function(input){
    return !(input==null || input=="");
};

var contains_number_atleast_greater_than_zero = function(input){
    return !(input <= 0);
};

var bird_name_belongs_in_database = function(birdName, birdNameList){
    if (birdNameList == null) return false;
//    had to add this in because when gradle runs jasmine tests, arrays dont have a function named indexOf
    if(!Array.prototype.indexOf) {
        Array.prototype.indexOf = function(needle) {
            for(var i = 0; i < this.length; i++) {
                if(this[i] === needle) {
                    return i;
                }
            }
            return -1;
        };
    }
    return (birdNameList.indexOf(birdName) >= 0);
};

