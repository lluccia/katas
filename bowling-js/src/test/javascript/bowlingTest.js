
describe("Bowling", function() {
	
	var game;
	
	beforeEach(function() {
		game = new Game();
	});
	
	var rollMany = function(times, pins) {
		for (var i = 0; i < times; i++)
			game.roll(pins);
	};
	
	it("initial score is 0", function() {
		expect(game.score()).toBe(0);
	});
	
	it("gutter game score is 0", function() {
		rollMany(20, 0);
		
		expect(game.score()).toBe(0);
	});
	
	it("all ones score is 20", function() {
		rollMany(20, 1);
		
		expect(game.score()).toBe(20);
	});
	
	it("one spare", function() {
		rollMany(1, 4);
		rollMany(1, 6);
		rollMany(1, 4);
		rollMany(17, 0);
		
		expect(game.score()).toBe(18);
	});
	
	it("one strike", function() {
		rollMany(1, 10);
		rollMany(1, 4);
		rollMany(1, 2);
		rollMany(16, 0);
		
		expect(game.score()).toBe(22);
	});
	
	it("perfect game", function() {
		rollMany(12, 10);
		
		expect(game.score()).toBe(300);
	});
});
