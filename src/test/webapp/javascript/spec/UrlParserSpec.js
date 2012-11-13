
function UrlParser(url) {
    this.contextPath = function(){
        var result = url.split('/')[3];

        if (result != "") {
            return "/" + result;
        }

        return "";
    }

};


describe("UrlParser", function () {

    it("returns empty for applications not running in a context", function () {
        var urlParser = new UrlParser("http://foo.com/");
        expect("").toEqual(urlParser.contextPath());
    });

    it("returns the context path if one exists", function() {
        var urlParser = new UrlParser("http://foo.com/context/");
        expect("/context").toEqual(urlParser.contextPath());
    });

    it("empty if the root path is to a known route", function() {
        var urlParser = new UrlParser("http://foo.com/checkinform/");
        expect("").toEqual(urlParser.contextPath());
    });


});

BS_contextPath = "";