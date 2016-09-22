require "test/unit"
require 'test/unit/ui/console/testrunner'

require_relative "game"

class TestGame < Test::Unit::TestCase
  def setup
    @g = Game.new()
  end

  def roll_many(times, pins)
    for i in 1..times
      @g.roll(pins)
    end
  end

  def test_gutterGame
    roll_many 20, 0

    assert_equal(0, @g.score())
  end

  def test_allOnes
    roll_many 20, 1

    assert_equal(20, @g.score())
  end

  def test_oneSpare
    roll_many 2, 5
    roll_many 2, 4
    roll_many 17, 0

    assert_equal(22, @g.score())
  end

  def test_oneStrike
    roll_many 1, 10
    roll_many 2, 4
    roll_many 17, 0

    assert_equal(26, @g.score())
  end
  
  def test_perfectGame
    roll_many 13, 10

    assert_equal(300, @g.score())
  end

end