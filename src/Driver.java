
/**
 * <p>Name and ID: Eilya Nasertorabi - 40183363</p>
 * <p>Course: COMP249</p>
 * <p>Assignment #: 3</p>
 * <p>Due Date: April 15th</p>
 * 
 */

import java.util.*;

import java.io.*;

/**
 * The Driver class serves as the main controller for managing a vocabulary
 * system based on a doubly linked list. It offers a command-line interface for
 * various operations such as adding, removing, and modifying topics, searching
 * for words, and loading/saving data from/to a file.
 */
public class Driver extends Exception {

	static DoublyLinkedList myLinkedList = new DoublyLinkedList();
	static ArrayList<String> words = new ArrayList<>();

	/**
	 * Main method which serves as the entry point for the application. It handles
	 * user interactions and invokes different operations based on user input.
	 * 
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {

			while (true) {
				DisplayMenu();
				System.out.println("please pick a menu option: ");
				int menuOption = sc.nextInt();

				sc.nextLine(); // Consume the leftover newline character

				switch (menuOption) {

				case 1:
					browseTopic(sc);
					break;
				case 2:
					insertTopicBefore(sc);
					break;
				case 3:
					insertTopicAfter(sc);
					break;
				case 4:
					removeTopic(sc);

					break;
				case 5:
					modifyTopic(sc);

					break;

				case 6:
					System.out.println("Enter the word to search for in the topics:");
					String word = sc.nextLine();
					myLinkedList.searchForWord(word);
					break;
				case 7:
					System.out.println("Enter the name of the file you wish to load");
					String filename = sc.nextLine();
					ReadFile(filename);
					myLinkedList = ReadFile(filename);
					System.out.println("Data loaded successfully.");
					break;
				case 8:
					showWordsStartingWithLetter(sc);

					break;
				case 9:
					System.out.println("Enter the name of the file you wish to save at");
					String saveFilename = sc.nextLine();
					System.out.println("saving to file....");
					myLinkedList.saveToFile(saveFilename);
					Thread.sleep(2000);
					System.out.println("saving complete");
					// SaveFile(newfilename);
					break;
				case 0:
					System.out.println("thank you for using the code have a good day");
					System.exit(0);

				}
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * Displays the main menu of the application with available operations.
	 */
	public static void DisplayMenu() {
		System.out.println("-------------------------------");
		System.out.println("  Vocabulary Control Center");
		System.out.println("-------------------------------");
		System.out.println(" 1  browse a topic ");
		System.out.println(" 2  insert a new topic before another one");
		System.out.println(" 3  insert a new topic after another one");
		System.out.println(" 4  remove a topic");
		System.out.println(" 5  modify a topic");
		System.out.println(" 6  search topics for a word");
		System.out.println(" 7  load from a file");
		System.out.println(" 8  show all words starting with a given letter");
		System.out.println(" 9  save to file");
		System.out.println(" 0  exit");
		System.out.println("-----------------------------------------------------------");
	}

	/**
	 * Loads vocabulary topics and words from a specified file.
	 * 
	 * @param filename The path to the file from which data is to be read.
	 * @return A DoublyLinkedList populated with vocab topics and words.
	 * @throws IOException If an I/O error occurs reading from the file.
	 */
	public static DoublyLinkedList ReadFile(String filename) throws IOException {

		DoublyLinkedList storeTopics = new DoublyLinkedList();

		try (BufferedReader reader = new BufferedReader(new FileReader("./src/" + filename))) {
			String line;
			Vocab currentVocab = null;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("#")) { // This line indicates a new topic
					String topicName = line.substring(1).trim();
					currentVocab = new Vocab(topicName);
					storeTopics.addAtTail(currentVocab); // Add the new topic to the list
					// System.out.println("Added topic: " + topicName); // Debug statement
				} else if (!line.isEmpty() && currentVocab != null) {
					currentVocab.words.insert(line.trim());
					// System.out.println("Added word: " + line.trim() + " to " +
					// currentVocab.getTopicName()); // Debug statement
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		return storeTopics;
	}

	/**
	 * Displays the topics and their corresponding words in the vocabulary list,
	 * allowing the user to browse through the topics and view the words under each
	 * topic.
	 * 
	 * @param sc Scanner object for user input
	 */
	private static void browseTopic(Scanner sc) {

		myLinkedList.displayAllTopics();
		System.out.println("Enter the number of the topic you want to browse, or 0 to cancel:");
		int index = sc.nextInt();
		sc.nextLine(); // Consume the newline character

		if (index == 0) {
			return; // User chose to cancel
		}

		Vocab selectedVocab = myLinkedList.getTopicByIndex(index);
		if (selectedVocab != null) {
			System.out.println("Topic: " + selectedVocab.getTopicName());
			selectedVocab.words.display(); // Assuming `display` method in SinglyLinkedList prints all words
		} else {
			System.out.println("Invalid topic selection.");
		}
	}

	/**
	 * Inserts a new topic before another specified topic in the vocabulary list.
	 * 
	 * @param sc Scanner object for user input
	 */
	private static void insertTopicBefore(Scanner sc) {
		System.out.println("Enter the name of the new topic:");
		String newTopicName = sc.nextLine();
		Vocab newTopic = new Vocab(newTopicName); // Assuming Vocab constructor takes the topic name

		System.out.println("Enter the name of the topic before which to insert the new topic:");
		String referenceTopicName = sc.nextLine();
		Vocab referenceTopic = myLinkedList.findTopicByName(referenceTopicName);

		if (referenceTopic == null) {
			System.out.println("Reference topic not found.");
			return;
		}

		myLinkedList.addBefore(referenceTopic, newTopic);
		System.out.println("New topic '" + newTopicName + "' inserted before '" + referenceTopicName + "'.");
	}

	/**
	 * Inserts a new topic after another specified topic in the vocabulary list.
	 * 
	 * @param sc Scanner object for user input
	 */

	private static void insertTopicAfter(Scanner sc) {
		System.out.println("Enter the name of the new topic:");
		String newTopicName = sc.nextLine();
		Vocab newTopic = new Vocab(newTopicName); // Assuming Vocab constructor takes the topic name

		System.out.println("Enter the name of the topic after which to insert the new topic:");
		String referenceTopicName = sc.nextLine();
		Vocab referenceTopic = myLinkedList.findTopicByName(referenceTopicName);

		if (referenceTopic == null) {
			System.out.println("Reference topic not found.");
			return;
		}

		myLinkedList.addAfter(referenceTopic, newTopic);
		System.out.println("New topic '" + newTopicName + "' inserted after '" + referenceTopicName + "'.");
	}
	/**
	 * Removes a specified topic from the vocabulary list.
	 * 
	 * @param sc Scanner object for user input
	 */
	public static void removeTopic(Scanner sc) {
		System.out.println("Enter the name of the topic you want to remove:");
		String topicName = sc.nextLine();
		Vocab topic = myLinkedList.findTopicByName(topicName);
		if (topic == null) {
			System.out.println("Topic not found.");
			return;
		}

		myLinkedList.remove(topic);
		System.out.println("Topic '" + topicName + "' has been removed.");
	}
	/**
	 * Modifies the name of a specified topic in the vocabulary list.
	 * 
	 * @param sc Scanner object for user input
	 */
	public static void modifyTopic(Scanner sc) {
		System.out.println("Enter the name of the topic you want to modify:");
		String oldTopicName = sc.nextLine();
		Vocab topic = myLinkedList.findTopicByName(oldTopicName);
		if (topic == null) {
			System.out.println("Topic not found.");
			return;
		}

		System.out.println("Enter the new name for the topic:");
		String newTopicName = sc.nextLine();
		topic.setTopicName(newTopicName); // Assuming setTopicName is a method in Vocab
		System.out.println("Topic name has been changed from '" + oldTopicName + "' to '" + newTopicName + "'.");
	}
	/**
	 * Searches for a specified word in the topics of the vocabulary list.
	 * 
	 * @param sc Scanner object for user input
	 */
	public static void searchForWord(Scanner sc) {
		System.out.println("Enter the word to search for in the topics:");
		String searchWord = sc.nextLine();
		myLinkedList.searchForWord(searchWord);
	}
	/**
	 * Displays all words in the vocabulary list that start with a specified letter,
	 * sorted in alphabetical order.
	 * 
	 * @param sc Scanner object for user input
	 */
	public static void showWordsStartingWithLetter(Scanner sc) {
		System.out.println("Enter a letter: ");
		String letter = sc.nextLine().trim();
		if (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
			System.out.println("Please enter a single alphabetical character.");
			return;
		}

		char startLetter = letter.charAt(0);
		ArrayList<String> wordsStartingWith = myLinkedList.getWordsStartingWith(startLetter);
		Collections.sort(wordsStartingWith);

		System.out.println("Sorted words starting with '" + startLetter + "':");
		for (String word : wordsStartingWith) {
			System.out.println(word);
		}
	}

}
