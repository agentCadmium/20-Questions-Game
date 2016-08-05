package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import datastructures.BinaryTree;
import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

/**
 * Reads an XML file containing the data for the game
 * 
 * @author Saverchenko
 *
 */
public class XMLReader {

	/**
	 * Reads an XML file.
	 * 
	 * @return expression BinaryTree corresponding to file.
	 **/
	public static BinaryTree<String> readXmlFile(String fileName) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(fileName));
			return parseQuestionsFile(doc);

		} catch (SAXException e) {
			// Error generated during parsing
			e.printStackTrace();
		} catch (IOException e) {
			// I/O error
			System.out.println("File not found");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// Parser with specified options can't be built
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Parses an XML file.
	 * 
	 * @return parsed BinaryTree.
	 **/
	private static BinaryTree<String> parseQuestionsFile(Document document) {
		BinaryTree<String> tree = new DefaultBinaryTree<String>();

		// Get a root and parse all data
		Element root = (Element) document.getDocumentElement();
		tree.setRoot(parseDecisionTree(root));
		return tree;
	}

	/**
	 * Parses a decision tree.
	 * 
	 * @return BinaryTreeNode represented by element.
	 **/
	private static BinaryTreeNode<String> parseDecisionTree(Element node) {

		if (node.getNodeName().equals("node")) {
			String question = "";
			question = node.getAttribute("question");

			// Create node
			BinaryTreeNode<String> newNode = new DefaultBinaryTreeNode<String>();
			newNode.setData(question);

			if (node.hasChildNodes()) {

				// Get children
				NodeList nodeList = node.getChildNodes();

				BinaryTreeNode<String> leftNode = null;
				BinaryTreeNode<String> rightNode = null;
				Element currentElement;

				for (int i = 0; i < nodeList.getLength(); i++) {

					if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

						currentElement = (Element) nodeList.item(i);
						if (currentElement.getAttribute("answer").equals("yes"))
							// IF yes then put in the left node
							leftNode = parseDecisionTree(currentElement);

						// Otherwise, put in the right node
						else
							rightNode = parseDecisionTree(currentElement);
					}
				}

				// Set left and right children
				newNode.setLeftChild(leftNode);
				newNode.setRightChild(rightNode);
			}
			return newNode;
		} else {
			if (node.hasChildNodes()) {
				NodeList nodeList = node.getChildNodes();
				for (int i = 0; i < nodeList.getLength(); i++) {
					if (nodeList.item(i).getNodeName().equals("node")) {
						return parseDecisionTree((Element) nodeList.item(i));
					}
				}
				return null;
			} else
				return null;
		}

	}

}
