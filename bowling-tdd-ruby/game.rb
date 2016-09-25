class Game
  def initialize
    @currentRoll = 0
    @rolls = Array.new(21, 0)
  end

  def roll(pins)
    @rolls[@currentRoll] = pins
    @currentRoll += 1
  end

  def score
    score = 0

    first_ball_in_frame = 0
    for frame in 1..10
      if is_strike(first_ball_in_frame)
        score += 10 + next_two_balls_for_strike(first_ball_in_frame)
        first_ball_in_frame += 1
      elsif is_spare(first_ball_in_frame)
        score += 10 + next_ball_for_spare(first_ball_in_frame)
        first_ball_in_frame += 2
      else
        score += sum_two_balls_in_frame(first_ball_in_frame)
        first_ball_in_frame += 2
      end

    end

    score
  end

  
  private
  
  def is_strike(first_ball_in_frame)
    @rolls[first_ball_in_frame] == 10
  end

  def is_spare(first_ball_in_frame)
    @rolls[first_ball_in_frame] + @rolls[first_ball_in_frame+1] == 10
  end

  def next_two_balls_for_strike(first_ball_in_frame)
    @rolls[first_ball_in_frame+1] + @rolls[first_ball_in_frame+2]
  end

  def next_ball_for_spare(first_ball_in_frame)
    @rolls[first_ball_in_frame+2]
  end

  def sum_two_balls_in_frame(first_ball_in_frame)
    @rolls[first_ball_in_frame] + @rolls[first_ball_in_frame+1]
  end
end