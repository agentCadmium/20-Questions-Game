package unrestrictedguessinggame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * MVC - CONTROLLER
 * Extends controller from the restricted version of the game 
 */
public class UnrestrictedGuessingGameController extends guessinggame.GuessingGameController {

	/**
	 * Constructor
	 * Specifies that this controller is working with the unrestricted model and view 
	 */
	public UnrestrictedGuessingGameController(UnrestrictedGuessingGameModel unrestrictedGuessingGameModel,
			UnrestrictedGuessingGameView unrestrictedGuessingGameView) {

		// Call the constructor of the superclass
		super(unrestrictedGuessingGameModel, unrestrictedGuessingGameView, true);

		// Set the actions to be performed when the user press the no button
		setNoBtnAction(unrestrictedGuessingGameModel, unrestrictedGuessingGameView);
	}

	/**
	 * Sets the actions to be performed when the user press the no button
	 */
	protected void setNoBtnAction(UnrestrictedGuessingGameModel unrestrictedGuessingGameModel,
			UnrestrictedGuessingGameView unrestrictedGuessingGameView) {

		//the actions for the no button is set in here rather than in the restricted version because 
		//the no button in the unrestricted version also asks to record the question for an unfamiliar answer
		unrestrictedGuessingGameView.setNoBtnAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Move on to the next question with the no tag
				if (unrestrictedGuessingGameModel.nextQuestion("no")) {
					unrestrictedGuessingGameView.showQuestion(unrestrictedGuessingGameModel.getCurrentQuestion(),
							unrestrictedGuessingGameModel.isAnswer());

					
				} 
				
				
				// If the guess is wrong extend the application to let the
				// user pick a thing that is not on the pre-specified list
				else {
					String message = "";
					String newThing = unrestrictedGuessingGameView
							.addNewThingDialog("What restaurant were you thinking of?");
					
					if ((newThing != null) && (newThing.length() > 0)) {
						String newQuestion = unrestrictedGuessingGameView.addNewThingDialog(
								"Please give me a yes/no question that would have determined your thing.");
						
						if ((newQuestion != null) && (newQuestion.length() > 0)) {
							if (unrestrictedGuessingGameView.yesNoDialog(
									"Is the answer to your question yes or no?") == JOptionPane.YES_OPTION) {
								unrestrictedGuessingGameModel.addNewThing(newQuestion, newThing, true);
							} 
							
							else {
								unrestrictedGuessingGameModel.addNewThing(newQuestion, newThing, false);
							}
							message = "Thank you! ";
						}
					}

					// Ask the user to restart the game
					if (unrestrictedGuessingGameView.showDialogStartNewGame(message) == JOptionPane.YES_OPTION) {
						restartGame(unrestrictedGuessingGameModel, unrestrictedGuessingGameView);
					}
					
					else{
						// Exit from the game
						System.exit(0);
					}
				}
			}
		});
	}

}
