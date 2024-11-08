/**
 * <p>Name and ID: Eilya Nasertorabi - 40183363</p>
 * <p>Course: COMP249</p>
 * <p>Assignment #: 3</p>
 * <p>Due Date: April 15th</p>
 * 
 */

/**
 * Represents a vocabulary topic containing a list of words as a singly linked
 * list.
 */
public class Vocab {

	String TopicName;
	SinglyLinkedList words;

	/**
	 * Constructs a new Vocab object with a specified topic name.
	 * 
	 * @param topicName The name of the vocabulary topic.
	 */
	public Vocab(String topicName) {
		this.TopicName = topicName;
		this.words = new SinglyLinkedList();
	}

	/**
	 * Returns the name of the vocabulary topic.
	 * 
	 * @return The topic name.
	 */
	public String getTopicName() {
		return TopicName;
	}

	/**
	 * Sets the name of the vocabulary topic.
	 * 
	 * @param topicName The new name for the topic.
	 */
	public void setTopicName(String topicName) {
		TopicName = topicName;
	}

	/**
	 * Gets the list of words in this vocabulary topic.
	 * 
	 * @return A SinglyLinkedList representing the list of words.
	 */
	public SinglyLinkedList getWords() {
		return words;
	}

	/**
	 * Sets the list of words for this vocabulary topic.
	 * 
	 * @param words The new list of words as a SinglyLinkedList.
	 */
	public void setWords(SinglyLinkedList words) {
		this.words = words;
	}

	/**
	 * Adds a new word to the vocabulary list.
	 * 
	 * @param word The word to be added.
	 */
	public void addWord(String word) {
		words.insert(word);
	}

	/**
	 * Removes a word from the vocabulary list.
	 * 
	 * @param word The word to be removed.
	 */
	public void removeWord(String word) {
		words.removeValue(word);
	}

	/**
	 * Replaces an existing word in the vocabulary list with a new word.
	 * 
	 * @param oldWord The word to replace.
	 * @param newWord The new word to replace the old word with.
	 */
	public void changeWord(String oldWord, String newWord) {
		if (words.find(oldWord) != null) {
			words.replace(oldWord, newWord);
		} else {
			System.out.println("Word not found");
		}
	}

	/**
	 * Displays the number of words in the vocabulary list.
	 */
	public void displayWordSize() {
		SinglyLinkedList.size();
	}

	/**
	 * Displays the size of the outer list in the doubly linked list context.
	 */
	public void displayTopic() {
		DoublyLinkedList.size();
	}

	/**
	 * Displays all words within this vocabulary topic.
	 */
	public void displayWords() {
		System.out.println("Topic: " + TopicName);
		words.display();
		System.out.println();
	}
}
