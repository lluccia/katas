package tennis;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TennisTest {
	
	private Game g;
	
	@Before
	public void setup() {
		g = new Game();
	}
	
	@Test
	public void points() {
		assertThat(g.getScore(), is("0-0"));
		points(0);
		assertThat(g.getScore(), is("15-0"));
		points(0);
		assertThat(g.getScore(), is("30-0"));
		points(0);
		assertThat(g.getScore(), is("40-0"));
		points(0);
		assertThat(g.getScore(), is("Game-0"));
	}
	
	@Test
	public void deuce() {
		points(0, 0, 0, 1, 1, 1);
		
		assertThat(g.getScore(), is("Deuce-Deuce"));
	}
	
	@Test
	public void advantage() {
		points(0, 0, 0, 1, 1, 1);

		assertThat(g.getScore(0), is("Deuce"));
		assertThat(g.getScore(1), is("Deuce"));
		
		points(0);
		
		assertThat(g.getScore(0), is("Advantage"));
		assertThat(g.getScore(1), is("Deuce"));
	}
	
	@Test
	public void gameAfterAdvantage() {
		points(0, 0, 0, 1, 1, 1);

		assertThat(g.getScore(0), is("Deuce"));
		assertThat(g.getScore(1), is("Deuce"));
		
		points(0);
		
		assertThat(g.getScore(0), is("Advantage"));
		assertThat(g.getScore(1), is("Deuce"));
		
		points(0);
		
		assertThat(g.getScore(0), is("Game"));
		assertThat(g.getScore(1), is("Deuce"));
	}
	
	@Test
	public void deuceAfterAdvantage() {
		points(0, 0, 0, 1, 1, 1);

		assertThat(g.getScore(0), is("Deuce"));
		assertThat(g.getScore(1), is("Deuce"));
		
		points(0);
		
		assertThat(g.getScore(0), is("Advantage"));
		assertThat(g.getScore(1), is("Deuce"));
		
		points(1);

		assertThat(g.getScore(0), is("Deuce"));
		assertThat(g.getScore(1), is("Deuce"));
	}
	
	private void points(int... players) {
		for (int player : players)
			g.point(player);
	}
}
