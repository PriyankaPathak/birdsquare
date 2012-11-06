
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

});