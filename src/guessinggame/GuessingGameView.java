package guessinggame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * MVC - PROGRAM'S GUI
 * 
 */

public class GuessingGameView extends JFrame {

	private JLabel questionLabel;
	private JButton yesBtn, noBtn;

	/**
	 * Constructor
	 */
	public GuessingGameView() {

		// Create a JFrame
		super("Guessing Game");
		
		// Add icon to the JFrame		
		setIconImage(new ImageIcon("images/icon_restaurants.png").getImage());
		
		// Add picture to the JFrame
		add(new JLabel(new ImageIcon("images/places_to_eat.png")), BorderLayout.PAGE_START);

		// Create a label for questions and add it to the frame
		questionLabel = new JLabel("Please read the instruction.");
		
		questionLabel.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		add(questionLabel, BorderLayout.CENTER);
		
		createButtonsPanel();

		// Set size of the frame
		setSize(400, 300);

		// Exit normally on closing the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// The window is placed in the center of the screen
		setLocationRelativeTo(null); // if the component is null the window is
										// placed in the center of the screen
		
		// Show frame
		setVisible(true);
	}
	
	
	/**
	 * Create a panel that will hold the buttons 
	 * 
	 * @return JPanel
	 */
	public JPanel createButtonsPanel() {

		// Create a panel for buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());

		// Create yes&no buttons and add them to the panel
		yesBtn = new JButton("Yes");
		noBtn = new JButton("No");
		buttonsPanel.add(yesBtn);
		buttonsPanel.add(noBtn);

		add(buttonsPanel, BorderLayout.PAGE_END);

		return buttonsPanel;
	}

	/**
	 * Shows the user a list of things (for example, an animal) and asks the
	 * user thinks of one of them.
	 */
	public void showListOfThings(String listOfThings) {
		ImageIcon icon = new ImageIcon("images/icon_information.png");
		
		// NEW JAVA CLASS: JOptionPane.
		// JOptionPane creates standard dialogs. It is used it to show the
		// user a list of restaurants and asks the user to think of one of them.
		JOptionPane.showMessageDialog(this,
				"Please think of one of these places to eat:\n" + listOfThings
						+ "\n\nThe computer asks a series of yes/no questions \n"
						+ "to try to determine which place you're thinking of.\n\n",
				"Instructions", JOptionPane.INFORMATION_MESSAGE, icon);
	}

	/**
	 * This method is necessary for registering the controller's listener for the
	 * yes button
	 * 
	 * @param listener
	 */
	public void setYesBtnAction(ActionListener listener) {
		yesBtn.addActionListener(listener);
	}

	/**
	 * This method is necessary for registering a controller's listener for the
	 * no button
	 * 
	 * @param listener
	 */
	public void setNoBtnAction(ActionListener listener) {
		noBtn.addActionListener(listener);
	}

	
	/**
	 * Shows questions/answers
	 * 
	 * @param questions/answers that are shown to the user
	 *           
	 * @param isAnswer true when this is an answer not a question
	 *           
	 */
	public void showQuestion(String question, Boolean isAnswer) {

		if (isAnswer) {
			question = "My quess is: " + question + ". Am I right?";
		}
		
		//tag <html> allows to show a long question as multiple lines
		questionLabel.setText("<html>" + question + "</html>"); 
		
	}

	/**
	 * Shows a dialog with a question to restart a game
	 * 
	 * @return user's decision
	 * @param message message with a question to the user
	 *            
	 */
	public int showDialogStartNewGame(String message) {
		ImageIcon icon = new ImageIcon("images/icon_question.png");

		// Set the titles of buttons
		Object[] titlesOfButton = { "Yes", "No, thanks!" };

		// question
		return JOptionPane.showOptionDialog(this, message + "Start a new game?", 
				
				// title
				"A Simple Question", 
				
				// the values of buttons
				JOptionPane.YES_NO_OPTION, 
				
				// question icon
				JOptionPane.QUESTION_MESSAGE,
				
				// custom icon
				icon, 
				
				// the titles of buttons
				titlesOfButton, 
				
				// default button title (Yes)
				titlesOfButton[0]);
	}
}
