package tester;

import xml.XMLReader;
import xml.XMLWriter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import datastructures.BinaryTree;
import guessinggame.GuessingGameModel;

/**
 * Tester
 *
 */
public class GuessingGameTester {
	private BinaryTree<String> decisionTree;

	@Before
	public void setUp() throws Exception {
		decisionTree = XMLReader.readXmlFile("data/test_questions.xml");
	}

	@Test
	/**
	 * Reads an XML file with test questions
	 * 
	 **/
	public void testXMLReader() {

		// check that it's in order
		assertEquals("read xml file with questions", decisionTree.inorderString(),
				"A1-> Q8-> A2-> Q4-> A3-> Q9-> A4-> Q2-> A5-> Q10-> A6-> Q5-> A7-> "
						+ "Q11-> A8-> Q1-> A9-> Q12-> A10-> Q6-> A11-> Q13-> A12-> Q3-> "
						+ "A13-> Q14-> A14-> Q7-> A15-> Q15-> A16");
	}


	@Test
	/**
	 * Writes an XML file and checks parses/i/o errors
	 * 
	 **/
	public void testXMLWriter() {

		assertEquals("check creating an xml file", XMLWriter.writeXmlFile(decisionTree, "data/test_tmp.xml"), true);

	}

	@Test
	/**
	 * Writes an XML file and checks it's structure
	 * 
	 **/
	public void testXMLWriterStructure() {

		// Save a binary tree to an XML file
		XMLWriter.writeXmlFile(decisionTree, "data/test_tmp.xml");

		// Read the created XML file and check it's structure with the original
		// binary tree
		assertEquals("check an xml file structure", XMLReader.readXmlFile("data/test_tmp.xml").inorderString(),
				decisionTree.inorderString());

	}

}
