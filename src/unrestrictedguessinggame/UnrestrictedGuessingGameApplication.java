package unrestrictedguessinggame;

/**
 * Unrestricted 20 Questions Guessing Game
 * 
 */
public class UnrestrictedGuessingGameApplication {

	public static void main(String[] args) {

		// Create a game's model, view and call a controller to start a game
		new UnrestrictedGuessingGameController(new UnrestrictedGuessingGameModel("data/questions.xml"),
				new UnrestrictedGuessingGameView());
	}

}
