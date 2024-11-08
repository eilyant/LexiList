import java.io.*;
import java.util.ArrayList;

public class DoublyLinkedList {

	Node head;
	private Node tail;
	private static int counter;

	/**
	 * Constructs an empty DoublyLinkedList.
	 */
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		DoublyLinkedList.counter = 0;
	}

	/**
	 * Adds a new vocab topic at the beginning of the list.
	 * 
	 * @param vocab The Vocab object to be added.
	 */
	public void addAtHead(Vocab vocab) {
		Node temp = head;
		head = new Node(vocab, null, head);

		if (tail == null) {
			tail = head;
		} else {
			temp.prev = head;
		}

		counter++;
	}

	/**
	 * Inserts a new vocab topic before a specified existing topic.
	 * 
	 * @param referenceTopic The topic before which the new topic is to be added.
	 * @param newTopic       The new topic to add.
	 */
	public void addBefore(Vocab referenceTopic, Vocab newTopic) {
		Node position = head;
		while (position != null && !position.vocab.equals(referenceTopic)) {
			position = position.next;
		}
		if (position != null && position.vocab.equals(referenceTopic)) {
			if (position == head) {
				addAtHead(newTopic);
			}
			Node n = new Node(newTopic, null, null);
			n.next = position;
			n.prev = position.prev;
			position.prev = n;
			n.prev.next = n;
		}
	}

	/**
	 * Adds a new vocab topic at the end of the list.
	 * 
	 * @param vocab The Vocab object to be added.
	 */
	public void addAtTail(Vocab vocab) {
		Node temp = tail;
		tail = new Node(vocab, tail, null);
		if (head == null) {
			head = tail;
		} else {
			temp.next = tail;
		}

		counter++;
	}

	/**
	 * Inserts a new vocab topic after a specified existing topic.
	 * 
	 * @param referenceTopic The topic after which the new topic is to be added.
	 * @param newTopic       The new topic to add.
	 */
	public void addAfter(Vocab referenceTopic, Vocab newTopic) {
		Node position = head;
		while (position != null && !position.vocab.equals(referenceTopic)) {
			position = position.next;
		}
		if (position != null && position.vocab.equals(referenceTopic)) {
			if (position.next == null) {
				addAtTail(newTopic);
			}
			Node n = new Node(newTopic, null, null);
			n.next = position.next;
			n.prev = position;
			n.next.prev = n;
			position.next = n;
			counter++;
		}
	}

	/**
	 * Removes the head (first element) of the list.
	 */
	public void removeHead() {
		if (head == null)
			return;

		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
			head.prev = null;
		}
		counter--;
	}

	/**
	 * Removes the tail (last element) of the list.
	 */
	public void removeTail() {
		if (tail == null)
			return;
		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.prev;
			tail.next = null;
		}
		counter--;
	}

	/**
	 * Removes a specific vocab topic from the list.
	 * 
	 * @param vocab The vocab to be removed.
	 */
	public void remove(Vocab vocab) {
		if (head == null)
			return;

		if (head.vocab.equals(vocab)) {
			removeHead();
			return;
		}

		if (tail.vocab.equals(vocab)) {
			removeTail();
			return;
		}

		Node current = head;
		while (current != null && !current.vocab.equals(vocab)) {
			current = current.next;
		}

		if (current != null) {
			current.prev.next = current.next;
			current.next.prev = current.prev;
			counter--;
		}
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return The number of elements in the list.
	 */
	public static int size() {
		return counter;
	}

	/**
	 * Searches for a topic by name and returns the corresponding Vocab object.
	 * 
	 * @param topicName The name of the topic to search for.
	 * @return The Vocab object if found, null otherwise.
	 */
	public Vocab findTopicByName(String topicName) {
		Node current = head;
		while (current != null) {
			if (current.vocab.getTopicName().equalsIgnoreCase(topicName)) {
				return current.vocab;
			}
			current = current.next;
		}
		return null;
	}

	/**
	 * Displays all vocab topics in the list.
	 */
	public void displayAllTopics() {

		int numtopics = 1;
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}

		Node current = head;

		while (current != null) {

			System.out.println(numtopics + " " + current.vocab.getTopicName());

			numtopics++;

			current = current.next;
		}
		System.out.println("0 Exit");
		System.out.println("-------------------------------");
	}

	/**
	 * Retrieves a vocab topic by its index in the list.
	 * 
	 * @param index The index of the topic to retrieve.
	 * @return The Vocab object at the specified index or null if index is out of
	 *         range.
	 */
	public Vocab getTopicByIndex(int index) {
		if (index <= 0 || index > counter) {
			System.out.println("Invalid topic number.");
			return null;
		}

		int currentIndex = 1;
		Node current = head;
		while (current != null) {
			if (currentIndex == index) {
				return current.vocab;
			}
			current = current.next;
			currentIndex++;
		}
		return null;
	}

	/**
	 * Searches for a specific word across all topics and lists where it is found.
	 * 
	 * @param searchWord The word to search for.
	 */
	public void searchForWord(String searchWord) {
		Node current = head;
		boolean found = false;
		System.out.println("Searching for the word '" + searchWord + "' in all topics:");
		while (current != null) {
			if (current.vocab.words.contains(searchWord)) {
				System.out.println("- Found in topic: " + current.vocab.getTopicName());
				found = true;
			}
			current = current.next;
		}

		if (!found) {
			System.out.println("The word '" + searchWord + "' was not found in any topic.");
		}
	}

	/**
	 * Lists all words starting with a specified letter across all topics.
	 * 
	 * @param startLetter The letter with which the words must start.
	 */
	public void showWordsStartingWith(char startLetter) {
		Node current = head;
		boolean found = false;
		System.out.println("Words starting with '" + startLetter + "':");

		while (current != null) {
			SinglyLinkedList words = current.vocab.words;
			SinglyLinkedList.Node wordNode = words.head;
			while (wordNode != null) {
				if (Character.toLowerCase(wordNode.value.charAt(0)) == Character.toLowerCase(startLetter)) {
					System.out.println(wordNode.value);
					found = true;
				}
				wordNode = wordNode.next;
			}
			current = current.next;
		}

		if (!found) {
			System.out.println("No words found starting with '" + startLetter + "'.");
		}
	}

	/**
	 * Inner class representing a node in the doubly linked list.
	 */
	private class Node {
		Vocab vocab;
		Node prev;
		Node next;

		/**
		 * Constructs a new node.
		 * 
		 * @param vocab The vocab object this node represents.
		 * @param prev  The previous node in the list.
		 * @param next  The next node in the list.
		 */
		Node(Vocab vocab, Node prev, Node next) {
			this.vocab = vocab;
			this.prev = prev;
			this.next = next;
		}
	}

	/**
	 * Saves the current state of the list to a file.
	 * 
	 * @param saveFilename The filename where the list's data will be saved.
	 */
	public void saveToFile(String saveFilename) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(saveFilename))) {
			Node current = head;
			while (current != null) {
				writer.write("#" + current.vocab.getTopicName() + "\n");
				SinglyLinkedList.Node wordNode = current.vocab.words.head;
				while (wordNode != null) {
					writer.write(wordNode.value + "\n");
					wordNode = wordNode.next;
				}
				current = current.next;
			}
			System.out.println("Data successfully saved to " + saveFilename);
		} catch (IOException e) {
			System.out.println("Failed to save data: " + e.getMessage());
		}
	}

	public ArrayList<String> getWordsStartingWith(char startLetter) {
		ArrayList<String> wordsStartingWith = new ArrayList<>();
		Node current = head;

		while (current != null) {
			SinglyLinkedList wordsList = current.vocab.getWords();
			SinglyLinkedList.Node wordNode = wordsList.head;

			while (wordNode != null) {
				String word = wordNode.value;
				if (word.length() > 0 && Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(startLetter)) {
					wordsStartingWith.add(word);
				}
				wordNode = wordNode.next;
			}
			current = current.next;
		}
		return wordsStartingWith;
	}
}
