/**@author: Pele Honua Mea
 * @based_on: https://algs4.cs.princeton.edu/13stacks/DoublyLinkedList.java & https://algs4.cs.princeton.edu/13stacks/Queue.java
 * @date: 2022-03-03
 * @brief: The following program is an implementation of a generic iterable FIFO-queue based on a double linked circular list. Doubly linked
 * list which means that two consecutive nodes and linked by previous and next pointer. A circular list means that the last node points to
 * to first node by next pointer and first node points to the last node by previous pointer. Due to FIFO-queue, the element that was added
 * first is also being discarded first. In this case, the new element is being added at the end of the queue and discarded from the beginning
 * of the queue. Also, each element of the list is placed between brackets "[x]" and adjacent elements are separated by a comma ",".
 *
 * **/

import java.util.Iterator;
import java.util.NoSuchElementException;


public class TheFundamentals3<Item> implements Iterable<Item> {
	private Node before;	//sentinel before the first item
	private Node after;		//sentinel after the last item
	private int n;			//number of items in the queue
	
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
	
	/*Circular double linked list:
	 * two consecutive items are linked by previous and next pointer
	 * last node points to the first node of the list
	 * first node points to the last node of the list*/
	public TheFundamentals3() {
		before = new Node();
		after = new Node();
		before.next = after;	// before points to the next element (after)
		after.prev = before;	// after points to the previous element (before)
	}
	
	/*FIFO (First-in-first-out) queue implementation*/
	//the methods adds items at the end of the list
	public void enqueue(Item item) {
		Node last = after.prev;	// last contains the last element of the queue
		Node nod = new Node();
		nod.item = item;
		nod.prev = last;	 // nod points to the previous element (last)
		last.next = nod; 	 // last points to the next element (nod)
		nod.next = after;	 // nod points to the next element (after)
		after.prev = nod;	 // after points to the previous element (nod)
		n++;
		System.out.println(this);
	}
	
	//the method removes items from the beginning of the list
	public Item dequeue() {
		Node first = before.next; 	//first contains the first element of the queue
		Node ret = first;			//content of first stored in Node ret
		first = first.next;			//first contains the pointer to next element of the list
		first.prev = before;		//first points to the previous element (before)
		before.next = first;		//before points to the next element (first)
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
	
	//method for brackets and comas
	public String toString()
    {
        StringBuilder s = new StringBuilder();
        
        Node nod = before.next;
        while(nod.item != null)
        {
            if(nod.next.item != null)
            {
                s.append("[" + nod.item + "],");
            }
            else
            {
                s.append("[" + nod.item + "]");
            }
            nod = nod.next;
        }
        
        return s.toString();
    }
	
}
