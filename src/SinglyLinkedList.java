/**
 * <p>Name and ID: Eilya Nasertorabi - 40183363</p>
 * <p>Course: COMP249</p>
 * <p>Assignment #: 3</p>
 * <p>Due Date: April 15th</p>
 * 
 */
/**
 * Represents a singly linked list for managing a sequence of words.
 */
public class SinglyLinkedList {

	Node head;
	private static int size;

	/**
	 * Constructs an empty SinglyLinkedList.
	 */
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Adds a word at the beginning of the list.
	 * 
	 * @param value The word to add.
	 */
	public void addAtHead(String value) {
		head = new Node(value, head);
		size++;
	}

	/**
	 * Inserts a word at the end of the list.
	 * 
	 * @param value The word to insert.
	 */

	public void insert(String value) {
		if (head == null) {
			addAtHead(value);
		} else {
			Node position = head;
			while (position.next != null) {
				position = position.next;
			}

			Node n = new Node(value, null);
			position.next = n;

			size++;
		}
	}

	/**
	 * Removes and returns the first word of the list.
	 * 
	 * @return The word removed from the list, or null if the list is empty.
	 */
	public String removeHead() {
		if (head != null) {
			Node temp = head;
			head = head.next;
			size--;
			temp.next = null;
			return temp.value;
		}
		return null;
	}

	/**
	 * Removes a specific word from the list.
	 * 
	 * @param value The word to remove.
	 * @return The removed word, or null if the word is not found.
	 */
	public String removeValue(String value) {
		if (head == null) {
			return null;
		}
		if (head.value.equals(value)) {
			return removeHead();
		}
		Node position = head;
		while (position.next != null && !position.next.value.equals(value)) {
			position = position.next;
		}
		if (position.next != null && position.next.value.equals(value)) {
			Node temp = position.next;
			position.next = position.next.next;
			size--;
			return temp.value;
		}
		return null;
	}

	/**
	 * Finds a node containing a specific word.
	 * 
	 * @param value The word to find.
	 * @return The node containing the word, or null if not found.
	 */
	public Node find(String value) {
		Node node = head;

		while (node != null) {
			if (node.value.equals(value)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	/**
	 * Replaces an existing word with a new word.
	 * 
	 * @param oldvalue The word to be replaced.
	 * @param newvalue The new word.
	 */
	public void replace(String oldvalue, String newvalue) {
		Node node = find(oldvalue);
		if (node != null) {
			node.value = newvalue;
		} else {
			System.out.println("word not found");
		}
	}

	/**
	 * Returns the size of the list.
	 * 
	 * @return The number of elements in the list.
	 */
	public static int size() {
		return size;
	}

	/**
	 * Displays all words in the list.
	 */
	public void display() {
		Node current = head;
		int wordCount = 1;
		while (current != null) {
			System.out.print(wordCount + ". " + current.value);
			System.out.print("    ");
			current = current.next;
			wordCount++;
		}
	}

	/**
	 * Checks if a particular word is contained in the list.
	 * 
	 * @param targetWord The word to check.
	 * @return true if the word is found, otherwise false.
	 */
	public boolean contains(String targetWord) {
		Node current = head;
		while (current != null) {
			if (current.value.equalsIgnoreCase(targetWord)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * Retrieves a word by its index in the list.
	 * 
	 * @param index The index of the word to retrieve.
	 * @return The word at the specified index, or null if the index is out of
	 *         range.
	 */
	public Vocab getWordsbByIndex(int index) {
		if (index <= 0 || index > size) {
			System.out.println("Invalid topic number.");
			return null;
		}

		Node current = head;
		int currentIndex = 1;

		while (current != null) {
			if (currentIndex == index) {
				return current.Vocab;
			}
			current = current.next;
			currentIndex++;
		}

		return null;
	}

	/**
	 * Inner class representing a node in the singly linked list.
	 */
	class Node {

		public final Vocab Vocab = null;
		String value;
		Node next;

		/**
		 * Constructs a new Node with a specified value and next node reference.
		 * 
		 * @param value The word value of the node.
		 * @param next  The next Node in the list.
		 */

		public Node(String value, Node next) {
			this.value = value;
			this.next = null;
		}
	}

}
