package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import datastructures.BinaryTree;
import datastructures.BinaryTreeNode;

/**
 * Writes an XML file containing the data for the binary tree
 * 
 */
public class XMLWriter {

	/**
	 * Writes XML file.
	 * Follows example on Oracle 
	 * @return true if no errors during an XML file creating
	 **/
	public static Boolean writeXmlFile(BinaryTree<String> tree, String fileName) {
		// Obtain default parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			File file = new File(fileName);
			// Get DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.newDocument();// parse(file);

			// Create a root
			Element root = createBinaryTreeElement(tree, document);

			// Add the root node to the document
			document.appendChild(root);

			// Write document
			transformXml(document, new StreamResult(file));

			return true;

		} catch (ParserConfigurationException pce) {
			// Parser with specified options
			// cannot be built
			pce.printStackTrace();
		}
		return false;
	}

	/**
	 * Creates a transformer object, uses the DOM to construct a source object,
	 * and uses System.out to construct a result object. Tells the transformer
	 * to operate on the source object and output to the result object.
	 **/
	private static void transformXml(Document document, StreamResult result) {
		try {
			// Use a Transformer for output
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();

			DOMSource source = new DOMSource(document);
			transformer.transform(source, result);
		} catch (TransformerConfigurationException tce) {
			System.out.println("* Transformer Factory error");
			System.out.println(" " + tce.getMessage());

			Throwable x = tce;
			if (tce.getException() != null)
				x = tce.getException();
			x.printStackTrace();
		} catch (TransformerException te) {
			System.out.println("* Transformation error");
			System.out.println(" " + te.getMessage());

			Throwable x = te;
			if (te.getException() != null)
				x = te.getException();
			x.printStackTrace();
		}

	}

	/**
	 * Creates an element corresponding to tree.
	 * 
	 * @return element for structure
	 **/
	private static Element createBinaryTreeElement(BinaryTree<String> tree, Document document) {

		// Create a root element "decision_tree"
		Element element = document.createElement("decision_tree");

		// Add all nodes from the binary tree to the document
		element.appendChild(createNodeElement(tree.getRoot(), document, ""));
		return element;
	}

	/**
	 * Creates an element corresponding to node.
	 * 
	 * @return element for node.
	 **/
	private static Element createNodeElement(BinaryTreeNode<String> node, Document document, String answer) {
		Element element = document.createElement("node");
		switch (answer) {
		case "yes":
			element.setAttribute("answer", "yes");
			break;
		case "no":
			element.setAttribute("answer", "no");
			break;
		}

		// If this is the last node then this is an answer
		if (node.isLeaf()) {

			// Set value
			element.setAttribute("question", node.getData().toString());

			// Otherwise this is a question with child's nodes
		} else {
			element.setAttribute("question", node.getData().toString());

			// Recursively add notes
			if (node.getLeftChild() != null)
				element.appendChild(createNodeElement(node.getLeftChild(), document, "yes"));
			if (node.getRightChild() != null)
				element.appendChild(createNodeElement(node.getRightChild(), document, "no"));
		}
		return element;
	}

}
