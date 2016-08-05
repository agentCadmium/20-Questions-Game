package unrestrictedguessinggame;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * MVC - PROGRAM'S GUI
 * 
 */

public class UnrestrictedGuessingGameView extends guessinggame.GuessingGameView {

	/**
	 * This dialog extends the application to let the user pick a thing that is
	 * not on the pre-specified list.
	 * 
	 * @param message
	 *            - question/request to the user
	 * @return user's input
	 */
	public String addNewThingDialog(String message) {
		// NEW JAVA CLASS: JOptionPane.
		// JOptionPane creates standard dialogs.
		
		// message
		String result = (String) JOptionPane.showInputDialog(this, message, 
				
				// title
				"Game Improvement", 
				
				// no icon
				JOptionPane.PLAIN_MESSAGE, null, 
				
				// if null we don't limit the user's choices
				null,
				
				// no is the default value
				null); 

		// If a string was returned
		if ((result != null) && (result.length() > 0)) {
			return result;
		} else
			return null;
	}

	/**
	 * This dialog is using to extend the application to let the user pick a
	 * thing that is not on the pre-specified list.
	 * 
	 * @param message message with a question to the user
	 *            
	 * @return user's decision
	 */
	public int yesNoDialog(String message) {
		ImageIcon icon = new ImageIcon("images/icon_question.png");		
		return JOptionPane.showConfirmDialog(this, message, // message
				"Game Improvement", // title
				JOptionPane.YES_NO_OPTION, // specify the set of buttons that
											// appear at the bottom of the
											// dialog
				JOptionPane.QUESTION_MESSAGE, icon); // icon
	}

}
