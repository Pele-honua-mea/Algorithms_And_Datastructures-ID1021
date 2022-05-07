/**@author: Pele Honua Mea
 * @based_on: https://algs4.cs.princeton.edu/13stacks/DoublyLinkedList.java & https://algs4.cs.princeton.edu/13stacks/Queue.java
 * @date: 2022-05-07
 * @brief: The following program is an implementation of a generalized queue which allows the user to remove the kth element from
 * the queue with the assumption that the most recently added element has index 1. New elements are added at the end of the list
 * and the old ones are removed from the beginning of the list. Also, each element of the list is placed between brackets "[x]" and 
 * adjacent elements are separated by a comma ",".
 * **/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TheFundamentals5<Item> implements Iterable<Item> {
	private Node before;
	private Node after;
	private int n;
	
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
	
	public TheFundamentals5() {
		before = new Node();
		after = new Node();
		before.next = after;
		after.prev = before;
	}
	
	public Item removeKTH(int id) {
		if(id <= this.size() && id >= 1) {
			Node nod = before.next;
			for(int i = 1; i < id; i++) {
				nod = nod.next;
			}
			nod.prev.next = nod.next;
			nod.next.prev = nod.prev;
			Node ret = nod;
			n--;
			System.out.println("Given index: " + id);
			System.out.println(this);
			System.out.println("The removed value from the queue: " + nod.item + '\n');
			System.out.append("");
			return ret.item;
		}
		else if(id > this.size()) {
			System.out.println("Given index: " + id);
			System.out.println("Index " + id + " is too large. No item to remove.");
			return null;
		}
		else if(id < 1) {
			System.out.println("Index " + id + " is too small. No item to remove");
			return null;
		}
		else {
			System.out.println("Wrong type parameter. Index must be given as an integer.");
			return null;
		}
	}
	
	public void enqueue(Item item) {
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
	
	public Item dequeue() {
		Node first = before.next;
		Node ret = first;
		first = first.next;
		first.prev = before;
		before.next = first;
		n--;
		return ret.item;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = before.next;
		private Node last;
		private int id = 0;
		
		public boolean hasNext() {
			return id < n;
		}
		public Item next() {
			if(!hasNext())
				throw new NoSuchElementException();
			last = current;
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
				s.append("[" + nod.item + "]");
			}
			else {
				s.append("[" + nod.item + "]");
			}
			nod = nod.next;
		}
		return s.toString();
	}
	

}
