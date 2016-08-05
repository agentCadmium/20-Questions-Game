package guessinggame;

/**
 * The 20 Questions Guessing Game We have 16 pre-specified answers
 * 
 * @author Anastasia Saverchenko
 *
 */
public class GuessingGameApplication {

	public static void main(String[] args) {

		// Create a game's model, view and call a controller to start a game
		new GuessingGameController(new GuessingGameModel("data/questions.xml"), new GuessingGameView());
	}

}

