# LexiList
Overview

LexiList is a Java-based vocabulary management system that leverages singly and doubly linked lists to store, organize, and process a collection of vocabulary words. Designed to help users efficiently manage vocabulary across various categories, LexiList allows for the organization of terms, quick access, and flexible list operations.

Features

	1.	Vocabulary Categories: Organize words into categories like “Clothes,” “Education,” “Technology,” etc.
	2.	Linked List Implementation:
	•	Singly Linked List: Ideal for basic list operations where sequential access is sufficient.
	•	Doubly Linked List: Provides bidirectional traversal, enhancing flexibility for complex list operations.
	3.	Efficient List Management: Add, remove, and search words quickly, thanks to the linked list structures.
	4.	File-Based Input: Reads vocabulary data from a text file (A3_input_file.txt), supporting easy data setup and management.

File Structure

	•	Driver.java: Main program entry point, handling user interactions and coordinating list operations.
	•	Vocab.java: Contains vocabulary-related classes and methods for adding, organizing, and managing words.
	•	SinglyLinkedList.java: Implements a singly linked list to store vocabulary items.
	•	DoublyLinkedList.java: Implements a doubly linked list for flexible management of vocabulary items.
	•	A3_input_file.txt: Sample input file containing categorized vocabulary words.

How It Works

Data Input

The vocabulary data is read from a structured file (A3_input_file.txt). Each line of the file represents a word, organized under categories like “Clothes and Accessories,” “Communications and Technology,” and so on. This file allows easy setup and customization of vocabulary.

List Operations

	•	Adding Words: Dynamically add new words to the singly or doubly linked list.
	•	Removing Words: Remove specific words as needed.
	•	Searching Words: Search for vocabulary items within the list, making retrieval quick and efficient.

Sample Vocabulary Data

The A3_input_file.txt file should follow this structure:
'''
#Category
word1
word2
word3
...
'''
For example:
'''
#Clothes and Accessories
backpack
perfume
hat
shirt
'''
Prerequisites

	•	Java Development Kit (JDK) 11 or higher
Example Usage

Upon running the program, LexiList will load vocabulary from A3_input_file.txt, displaying the available categories. You can then choose options to add, remove, or search vocabulary items interactively.

Future Improvements

Potential areas for future enhancement:
	•	Graphical Interface: Add a GUI for better user interaction.
	•	Additional Data Structures: Incorporate other data structures like hash maps for faster lookups.
	•	Synonym Grouping: Group similar words for a richer vocabulary learning experience.
