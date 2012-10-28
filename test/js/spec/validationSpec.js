describe("bird name validation", function() {
  
  it("should not accept an empty entry",function(){

    var result = is_not_an_empty_field("");
    expect(result).not.toBe(true);
  });

    it("should accept a valid entry",function(){

        var result = is_not_an_empty_field("Pigeon");
        expect(result).toBe(true);
    });

    it("should accept a valid entry",function(){

        var result = does_not_contain_numbers("Pigeon");
        expect(result).toBe(true);
    });



    it("should not accept name with numbers",function(){
    var result = does_not_contain_numbers("Pigeon123");  
    expect(result).not.toBe(true);
  });

  it("should not accept name with special characters", function (){
        var result=does_not_contain_special_characters("Pigeon#$");
        expect(result).not.toBe(true);
    });


  
});
