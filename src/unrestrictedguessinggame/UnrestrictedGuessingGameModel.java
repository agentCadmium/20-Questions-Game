package unrestrictedguessinggame;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTreeNode;
import xml.XMLWriter;

/**
 * MVC - MODEL
 */
public class UnrestrictedGuessingGameModel extends guessinggame.GuessingGameModel {
	private String xmlFileName; // XML file name

	/**
	 * Constructor
	 */
	public UnrestrictedGuessingGameModel(String xmlFileName) {

		// Call the constructor of the superclass
		super(xmlFileName);

		this.xmlFileName = xmlFileName;
	}

	/**
	 * Modify the decision tree, add a new question and an answer
	 */
	public void addNewThing(String newQuestion, String newThing, Boolean isYesAnswer) {
		// Save the last answer
		String lastThing = currentQuestion.getData();

		// Create the left node
		BinaryTreeNode<String> leftNode = new DefaultBinaryTreeNode<String>();

		// Create the right node
		BinaryTreeNode<String> rightNode = new DefaultBinaryTreeNode<String>();

		// Modify the decision tree based on the answer
		if (isYesAnswer) {
			leftNode.setData(newThing);
			rightNode.setData(lastThing);
		} else {
			leftNode.setData(lastThing);
			rightNode.setData(newThing);
		}
		currentQuestion.setLeftChild(leftNode);
		currentQuestion.setRightChild(rightNode);
		currentQuestion.setData(newQuestion);

		// Save the modified decision tree to an XML file for the next game
		XMLWriter.writeXmlFile(decisionTree, xmlFileName);
	}

}
