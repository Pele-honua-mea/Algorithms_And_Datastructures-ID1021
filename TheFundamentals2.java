/**@author: Pele Honua Mea
 * @based_on: https://algs4.cs.princeton.edu/13stacks/Stack.java.html
 * @date: 2022-03-01
 * @brief:
 * ¤ methods: two different approaches for the same output The methods, iterative and recursive, read characters
 * from stdin until a newline character is read and then print them on stdout in reverse order. 
 * 		¤ method recursive: gets one character from the user's input at a time and if the newline has not been reached yet
 * 		(base condition not met), it puts the character on a "stack" when the method calls itself (until the condition is
 * 		met -> loop broken). It does that with all input characters and at the end the last added character will be the 
 * 		first one to go from the "stack".
 * 		
 * 		¤ method iterative: gets characters from the user's input one by one and stores them on a stack using push() method -> newly
 * 		added characters is stored (pushed) on the top of the stack. When all characters are stored on the stack, the pop() method pushes
 * 		all characters, one by one, from the stack starting with the one on top of the stack -> LIFO (last-in-first-out).
 * @expected_output:
 * Depends on the user's input -> The input string will be printed out in reversed order. 
 * 
 * @question_1: The test tests for both the recursive method and the iterative method respectively. The iterative version, as asked in the
 *  assignment, is implemented using one of the ADTs suggested in Algorithms ch. 1.3, namely Stack.
 * @question_2: The test is sufficient to validate the correctness of the implementation, as it correctly outputs in reverse the string given
 * by the user.  
 *
 * **/

import java.util.Scanner;
import java.io.IOException;
import java.util.Iterator;

class Stack<Item> implements Iterable<Item>{
	private Node<Item> first;	// top of stack
	private int n;				// size of the stack
	
	// helper linked list class
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	// is the stack empty?
	public boolean isEmpty() {
		return first == null;
	}
	
	// size of the stack
	public int size() {
		return n;
	}
	
	// LIFO
	public void push(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		n--;
		if(n > 0) {
		}
		return item;
	}
	
	
	
	
	// returns an iterator to this stack that iterates through the items in LIFO
	public Iterator<Item> iterator(){
		return new ListIterator(first);
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node<Item> current;
		public ListIterator(Node<Item> first) {
			current = first;
		}
		public boolean hasNext() {
			return current != null;
		}
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}


	
}

public class TheFundamentals2 {
	public static void main(String[] args) throws IOException{
		System.out.println("Write your string: ");
		Recursive();
		System.out.print('\n');
		System.out.println("Write your string: ");
		Iterative();
	}
	
	static void Recursive() throws IOException{
		char ch;
		ch = (char) System.in.read();
		if(ch != '\n') {
			Recursive();
		}
		System.out.print(ch);	
	}
	
	static void Iterative() throws IOException{
		Stack<Character> c = new Stack<Character>();
		char ch = 0;
		Scanner sc = new Scanner(System.in);
		try {
			while(ch != '\n') {
				ch = (char) System.in.read();
				c.push(ch);
			}
			
			while(!c.isEmpty()) {
				System.out.print(c.pop());
			}
		} finally {
			sc.close();
		} 
	}
	
}
