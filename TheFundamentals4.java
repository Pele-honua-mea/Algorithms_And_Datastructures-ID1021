/**@author: Pele Honua Mea
 * @based_on: https://algs4.cs.princeton.edu/13stacks/DoublyLinkedList.java & https://algs4.cs.princeton.edu/13stacks/Queue.java
 * @date: 2022-03-04
 * @brief: The following program is an implementation of a generic iterable circular linked list which allows the user to insert and remove 
 * elements to/from the front and back of the queue. A circular list means that the last node points to the first node by next pointer and 
 * first node points to the last node by previous pointer. Also, each element of the list is placed between brackets "[x]" and adjacent 
 * elements are separated by a comma ",".
 *
 * **/

import java.util.*;
public class TheFundamentals4<Item> implements Iterable<Item> {
	private Node before;
	private Node after;
	private int n;
	
	//nested class to define nodes
	private class Node{
		private Item item;
		private Node next;
		private Node prev;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public TheFundamentals4() {
		before = new Node();
		after = new Node();
		before.next = after;
		after.prev = before;
	}
	
	//method inserts items to the front of the list
	public void insertToFront(Item item) {
		Node first = before.next;
		Node nod = new Node();
		nod.item = item;
		nod.prev = before;
		nod.next = first;
		before.next = nod;
		first.prev = nod;
		n++;
		System.out.println(this);
	}
	
	//method inserts items to the end of the list
	public void insertToEnd(Item item) {
		Node last = after.prev;
		Node nod = new Node();
		nod.item = item;
		nod.prev = last;
		nod.next = after;
		after.prev = nod;
		last.next = nod;
		n++;
		System.out.println(this);
	}
	
	//method returns items from the front of the list
	public Item removeFromFront() {
		Node first = before.next;
		Node ret = first;
		first = first.next;
		first.prev = before;
		before.next = first;
		n--;
		return ret.item;
	}
	
	public Item removeFromBackEnd() {
		Node last = after.prev;
		Node ret = last;
		last = last.prev;
		last.next = after;
		after.prev = last;
		n--;
		return ret.item;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = before.next;
		private int id = 0;
		
		public boolean hasNext() {
			return id < n;
		}
		public Item next() {
			if(!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			id++;
			return item;
		}
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		Node nod = before.next;
		while(nod.item != null) {
			if(nod.next.item != null) {
				s.append("[" + nod.item + "],");
			}
			else {
				s.append("[" + nod.item + "]");
			}
			nod = nod.next;
		}
		return s.toString();
	}

}
