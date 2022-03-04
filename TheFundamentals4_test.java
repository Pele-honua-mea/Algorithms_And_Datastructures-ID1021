/**@author: Pele Honua Mea
 * @date: 2022-03-04
 * @brief: The following test tests the implementation of a generic iterable FIFO-queue based on a double linked circular list of
 * TheFundamentals3. It checks for the enqueue method, as well the dequeue method. Also it tests if the queue has been emptied.
 * @expected_output:
Testing insert: 

Inserting an element at the end of the list: 
[1]
Inserting an element at the beginning of the list: 
[2],[1]
Inserting an element at the end of the list: 
[2],[1],[3]
Testing remove: 

[2],[1],[3]
Last element removed from the list
[2],[1]
First element removed from the list
[1]
Last element removed from the list


Queue empty? false/true
true
 * */
public class TheFundamentals4_test {
	public static void main(String[] args) {
		TheFundamentals4<Integer> generic = new TheFundamentals4<Integer>();
		System.out.println("Testing insert: ");
		System.out.println("");
		
		System.out.println("Inserting an element at the end of the list: ");
		generic.insertToEnd(1);
		System.out.println("Inserting an element at the beginning of the list: ");
		generic.insertToFront(2);
		System.out.println("Inserting an element at the end of the list: ");
		generic.insertToEnd(3);

		System.out.println("Testing remove: ");
		System.out.println("");
		
		System.out.println(generic.toString());
		generic.removeFromBackEnd();
		System.out.println("Last element removed from the list");
		System.out.println(generic.toString());
		generic.removeFromFront();
		System.out.println("First element removed from the list");

		System.out.println(generic.toString());
		generic.removeFromBackEnd();
		System.out.println("Last element removed from the list");
		System.out.println("");

		System.out.println("");
		System.out.println("Queue empty? false/true");
		System.out.println(generic.isEmpty());
			
	}

}