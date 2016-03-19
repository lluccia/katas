function Game() {

	this.pins = [];
	
	for (var i = 0; i < 22; i++)
		this.pins.push(0);
	
	this.currentRoll = 0;
	
	this.roll = function(pins) {
		this.pins[this.currentRoll++] = pins
	};
	
	
	this.score = function() {
		var score = 0;
		
		var firstBallInFrame = 0;
		
		for (var frame = 0; frame < 10; frame++) {
			if(this.isStrike(firstBallInFrame)) {
				score += 10 + this.pins[firstBallInFrame+1] + this.pins[firstBallInFrame+2];
				firstBallInFrame++;
			} else if(this.isSpare(firstBallInFrame)) {
				score += 10 + this.pins[firstBallInFrame+2];
				firstBallInFrame += 2;
			} else {
				score += this.pins[firstBallInFrame] + this.pins[firstBallInFrame+1];
				firstBallInFrame += 2;
			}
		}
		
		return score;
	};
	
	this.isStrike = function(firstBallInFrame) {
		return this.pins[firstBallInFrame] === 10;
	};
	
	this.isSpare = function(firstBallInFrame) {
		return this.pins[firstBallInFrame] + this.pins[firstBallInFrame+1] === 10;
	};

};