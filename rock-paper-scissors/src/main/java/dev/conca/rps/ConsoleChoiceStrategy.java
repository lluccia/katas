package dev.conca.rps;

import java.io.IOException;

public class ConsoleChoiceStrategy implements ChoiceStrategy {

	public Choice choose() {
		System.out.println("Choose [r]ock, [p]aper, [s]cissors: ");
		
		char rps;
		try {
			rps = (char) System.in.read();
			
			System.in.read(); //drop next char (line break)
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		Choice choice = null;
		if (rps == 'r')
			choice = Choice.rock;
		else if (rps == 'p')
			choice = Choice.paper;
		else if (rps == 's')
			choice = Choice.scissors;
		else
			choice = choose();
		
		return choice;
	}
}
