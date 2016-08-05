package guessinggame;

import datastructures.BinaryTree;
import datastructures.BinaryTreeNode;
import datastructures.LinkedList;
import xml.XMLReader;

/**
 * MVC - MODEL
 * 
 */
public class GuessingGameModel {
	protected BinaryTree<String> decisionTree;
	protected BinaryTreeNode<String> currentQuestion;
	private LinkedList<String> listOfThings;

	/**
	 * Constructor
	 */
	public GuessingGameModel(String xmlFileName) {

		// Get a binary tree with questions
		decisionTree = XMLReader.readXmlFile(xmlFileName);
		getFirstQuestion();
	}

	/**
	 * Starts a new game. Use it when starting the game and
	 * restarting it.
	 */
	public void getFirstQuestion() {

		// Get the first question from the list
		currentQuestion = decisionTree.getRoot();
	}

	/**
	 * Returns the current question or answer
	 * 
	 * @return the current question/answer
	 */
	public String getCurrentQuestion() {
		return currentQuestion.getData();
	}

	/**
	 * Moves on to the next question
	 * 
	 * @param user response
	 * 
	 * @return true if this is a question and not an answer
	 */
	public Boolean nextQuestion(String answer) {
		if (currentQuestion.isLeaf()) {
			
			//the node is a leaf so stop the traversal
			return false; 
		} 
		else {
			
			if (answer == "yes") {
				currentQuestion = currentQuestion.getLeftChild();
			} else {
				currentQuestion = currentQuestion.getRightChild();
			}
			return true;
		}
	}

	/**
	 * Checks whether this is an answer
	 * 
	 * @return true if this is an answer (a leaf of a tree)
	 */
	public Boolean isAnswer() {
		if (currentQuestion.isLeaf()) {
			return true;
		} else
			return false;
	}

	/**
	 * Traverses the binary tree with questions and creates a list of answers
	 * 
	 * @return a string with things
	 */
	public String getListOfThings() {
		listOfThings = new LinkedList<String>();

		// Call a method which gets all leaves with answers
		findLeaves(decisionTree.getRoot());

		//build a list of answers 
		String result = new String("");
		while (!listOfThings.isEmpty()) {
			result = result + "\n" + listOfThings.getLast();
			listOfThings.deleteLast();
		}
		return result;
	}

	/**
	 * Traverses the binary tree and find leaves with answers
	 * 
	 * @param node current node
	 */
	public void findLeaves(BinaryTreeNode<String> node) {
		
		if (node != null) {
			
			//add to list if the node is an answer
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				listOfThings.insertFirst(node.getData());
			}
			findLeaves(node.getLeftChild());
			findLeaves(node.getRightChild());
		}
	}

}
