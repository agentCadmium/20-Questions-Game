package guessinggame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * MVC - CONTROLLER
 *
 */
public class GuessingGameController {

	/**
	 * Constructor 
	 * 
	 * Functionality will be used for the restricted version of the game
	 * 
	 * @param guessingGameModel program's model
	 * @param guessingGameView program's GUI
	 */
	public GuessingGameController(GuessingGameModel guessingGameModel, GuessingGameView guessingGameView) {

		// Set the actions to be performed when the user presses the yes button
		setYesBtnAction(guessingGameModel, guessingGameView);

		// Set the actions to be performed when the user press the no button
		setNoBtnAction(guessingGameModel, guessingGameView);

		// Get the list of things from the program's model and call the
		// program's GUI to show it
		guessingGameView.showListOfThings(guessingGameModel.getListOfThings());

		// Call the program's GUI to show the first question
		guessingGameView.showQuestion(guessingGameModel.getCurrentQuestion(), guessingGameModel.isAnswer());
	}

	/**
	 * Constructor 
	 * 
	 * Functionality will be used for the unrestricted version of the game
	 * 
	 * @param guessingGameModel program's model          
	 * @param guessingGameView program's GUI          
	 * @param flag: when it's set we use this constructor
	 *            
	 */
	public GuessingGameController(GuessingGameModel guessingGameModel, GuessingGameView guessingGameView,
			Boolean flag) {

		// Set the actions to be performed when the user presses the yes button
		// Functionality of the Yes button will be the same for both versions of the game
		// unlike for the NO button
		setYesBtnAction(guessingGameModel, guessingGameView);

		// Get the list of things from the program's model and call the
		// program's GUI to show it
		guessingGameView.showListOfThings(guessingGameModel.getListOfThings());

		// Call the program's GUI to show the first question
		guessingGameView.showQuestion(guessingGameModel.getCurrentQuestion(), guessingGameModel.isAnswer());
	}

	/**
	 * Sets the actions to be performed when the user presses the yes button
	 */
	protected void setYesBtnAction(GuessingGameModel guessingGameModel, GuessingGameView guessingGameView) {
		guessingGameView.setYesBtnAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				// Move on to the next question with the yes tag
				if (guessingGameModel.nextQuestion("yes")) {
					guessingGameView.showQuestion(guessingGameModel.getCurrentQuestion(), 
							guessingGameModel.isAnswer());

				} 
				
				// When the guess is right ask the user to restart the game
				else {
					if (guessingGameView.showDialogStartNewGame("I won! ") == JOptionPane.YES_OPTION) {
						restartGame(guessingGameModel, guessingGameView);

						// Exit the game
					} else
						System.exit(0);
				}
			}
		});
	}

	/**
	 * Sets the actions to be performed when the user presses the no button
	 */
	protected void setNoBtnAction(GuessingGameModel guessingGameModel, GuessingGameView guessingGameView) {
		guessingGameView.setNoBtnAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Move on to the next question with the no tag
				if (guessingGameModel.nextQuestion("no")) {
					guessingGameView.showQuestion(guessingGameModel.getCurrentQuestion(), 
							guessingGameModel.isAnswer());

				} 
				
				// When the guess is wrong ask the user to restart the game
				else {
					if (guessingGameView.showDialogStartNewGame("I'm sorry. ") == JOptionPane.YES_OPTION) {
						restartGame(guessingGameModel, guessingGameView);

						// Exit the game
					} else
						System.exit(0);
				}
			}
		});
	}

	/**
	 * Restarts the game
	 */
	protected void restartGame(GuessingGameModel guessingGameModel, GuessingGameView guessingGameView) {

		// Get the list of things from the program's model and call the
		// program's GUI to show it again
		guessingGameView.showListOfThings(guessingGameModel.getListOfThings());

		// Move back to the first question
		guessingGameModel.getFirstQuestion();

		// Get the first question from the program's model and call the
		// program's GUI to show it
		guessingGameView.showQuestion(guessingGameModel.getCurrentQuestion(), guessingGameModel.isAnswer());
	}

}
