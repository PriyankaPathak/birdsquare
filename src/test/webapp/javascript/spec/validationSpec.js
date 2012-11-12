describe("bird name validation", function () {

    it("should not accept an empty entry", function () {

        var result = is_not_an_empty_field("");
        expect(result).not.toBe(true);
    });

    it("should accept a valid entry", function () {

        var result = is_not_an_empty_field("Pigeon");
        expect(result).toBe(true);
    });

    it("should not accept zero as number of birds", function () {
        var result = contains_number_atleast_greater_than_zero("0");
        expect(result).not.toBe(true);
    });

    it("should not accept negative value as number of birds", function () {
        var result = contains_number_atleast_greater_than_zero("-2");
        expect(result).not.toBe(true);
    });

    it("should accept only digits as number of birds", function () {
        var result = is_a_valid_number("a1");
        expect(result).not.toBe(true);
    });

    it("should split the scientific and common name and store only scientific name", function () {
        var result = get_scientific_name_of_bird("Pigeon(SN)");
        expect(result).toEqual("SN");
    });

    it("should not accept a bird name not in database", function () {
        var birdNameList = new Array("Priyanka", "Nazneen", "Suet", "Ashwin", "Wei", "Naval", "Ritika", "Sneha", "Varun");
        var birdName = "Scott";
        var inBirdList = bird_name_belongs_in_database(birdName, birdNameList);
        expect(inBirdList).toBeFalsy();
    });

    it("should accept a bird name which is in database", function () {
        var birdNameList = new Array("Priyanka", "Nazneen", "Suet", "Ashwin", "Wei", "Naval", "Ritika", "Sneha", "Varun");
        var birdName = "Priyanka";
        var inBirdList = bird_name_belongs_in_database(birdName, birdNameList);
        expect(inBirdList).toBeTruthy();
    });

    it("should validate a bird name that belongs in the database to be true", function () {
        var birdNameList = ["Priyanka", "Nazneen", "Suet", "Ashwin", "Wei", "Naval", "Ritika", "Sneha", "Varun"];
        var birdName = "Priyanka";
        var validated = validate_bird_name_field(birdName, birdNameList);
        expect(validated).toBeTruthy();
    });

    it("should validate a bird name that does not belong in the database to be false", function () {
        var birdNameList = ["Priyanka", "Nazneen", "Suet", "Ashwin", "Wei", "Naval", "Ritika", "Sneha", "Varun"];
        var birdName = "Scott";
        var validated = validate_bird_name_field(birdName, birdNameList);
        expect(validated).toBeFalsy();
    });

    it("should validate a bird name field that is empty to be false", function () {
        var birdNameList = ["Priyanka", "Nazneen", "Suet", "Ashwin", "Wei", "Naval", "Ritika", "Sneha", "Varun"];
        var birdName = "";
        var validated = validate_bird_name_field(birdName, birdNameList);
        expect(validated).toBeFalsy();
    });

    it("should validate a number of birds field that is empty to be false", function () {
        var validated = validate_number_of_birds_field("");
        expect(validated).toBeFalsy();
    });

    it("should validate a number of birds field that is a negative number to be false", function () {
        var validated = validate_number_of_birds_field("-999");
        expect(validated).toBeFalsy();
    });

    it("should validate a number of birds field that contains non-integer characters to be false", function () {
        var validated = validate_number_of_birds_field("abcde");
        expect(validated).toBeFalsy();
    });

    it("should validate a number of birds field that contains a positive integer to be true", function () {
        var validated = validate_number_of_birds_field("5");
        expect(validated).toBeTruthy();
    });
});
