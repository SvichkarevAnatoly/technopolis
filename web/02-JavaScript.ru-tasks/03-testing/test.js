describe("pow", function () {
    it("2^3 = 8", function () {
        assert.equal(pow(2, 3), 8);
    });

    it("3^2 = 9", function () {
        assert.equal(pow(3, 2), 9);
    });

    it("0^0 = NaN", function () {
        assert(isNaN(pow(0, 0)), "pow(0, 0) is NaN");
    });
});
