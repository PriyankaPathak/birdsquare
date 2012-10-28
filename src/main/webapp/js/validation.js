validateForm=function()
{
    var birdname=document.forms["birdinformation"]["birdname"].value;
    if (!is_not_an_empty_field(birdname))
    {
        alert("Bird name must be filled out");
        return false;
    }
    else if (!does_not_contain_numbers(birdname))
    {
        alert("Field must not have numeric characters");

        return false;
    }
    else  if(!does_not_contain_special_characters(birdname)) {
        alert('Bird name should not contain special characters');
        return false;

    }
    return true;
};


does_not_contain_numbers = function(input){
    return !(/\d/.test(input));

};

is_not_an_empty_field = function(input){
    if(input==null || input=="")
    {
        return false;
    }
    return true;

};

does_not_contain_special_characters=function(input){
    var pattern = /^\\d\{5\}([\\-]\\d\{4\})?$/;
    if (!pattern.test(input)) {

        return false;
    }
    return true;

};


