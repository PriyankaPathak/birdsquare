
describe("should show list of nearby location on passing location data", function () {

    beforeEach(function() {
        document.getElementById('txt_location').disabled = false;
    });

    it("should show names of location", function () {
        var data = {
            response:{
                venues:[
                    {
                        "name":"ThoughtWorks",
                        "location":{
                            "lat":12.92,
                            "lng":77.62
                        }
                    }
                ]
            }
        };

        var location = showLocations(data.response.venues[0]);
        expect("ThoughtWorks").toEqual(location.name);
    });

    it("should disable location textbox if value is not null",function(){
       document.getElementById('txt_location').value="Thoughtworks";
       addLocation();
       expect(document.getElementById('txt_location').disabled).toBe(true);

    });

    it("should not disable location textbox if value is null",function(){
       document.getElementById('txt_location').value="";
       addLocation();
       expect(document.getElementById('txt_location').disabled).toBe(false);
    });

});