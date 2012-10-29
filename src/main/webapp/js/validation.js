validateForm=function()
{
    var birdname=document.forms["birdinformation"]["birdname"].value;
    var number=document.forms["birdinformation"]["number"].value;
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
    if(does_not_contain_numbers(number))
    {
        alert("Enter a valid number");
        return false;

    }
    else if(!is_not_an_empty_field(number))
    {
        alert("Number of birds must be filled out");
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

    var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";
    for (var i = 0; i < input.length; i++) {
        if (iChars.indexOf(input.charAt(i)) != -1) {
            return false;
        }
    }
    return true;

};


