package tester;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import guessinggame.GuessingGameModel;




/**
 * JUnit tests for methods in the model of the restricted and unrestricted game 
 */
public class GameLogicTester {
	
	GuessingGameModel model;
	
	
	
	/**
	 * Instantiate the model
	 */
	@Before 
	public void setUp(){
		
		model = new GuessingGameModel("data/questions.xml");
	}
	
	

	/**
	 * Tests method that traverses the binary tree with questions and creates a list of things
	 */
	@Test
	public void testGetListOfThings(){
		assertEquals("Testing GetListOfThings() from the model", model.getListOfThings(), "\n" +"McDonald's" +"\n" +"Wendy's" + "\n"+ "Subway" + 
				"\n" + "Burger King" + "\n" + "Domino's Pizza" + "\n" + "Pizza Hut"+"\n" + "KFC" +"\n" + "Panera Bread"+"\n" + "T.G.I. Friday's"
				+"\n" + "Applebee's"+"\n" + "Olive Garden"+"\n" + "Red Lobster"+"\n" + "Berkshire Yogurt"+"\n" + "Dunkin' Donuts"+"\n" + "Starbucks"
				+"\n" + "Baskin-Robbins");
	}
	
	
	
	/**
	 * Tests method that determines whether the next question is an answer or question. 
	 */
	@Test
	public void nextQuestionTest(){
		
		//testing for the first node in the tree, which is a question
		assertEquals("Testing nextQuestion() from model", model.nextQuestion("yes"), true);
	}
	

}
