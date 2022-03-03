/**@author: Pele Honua Mea
 * @based_on: 
 * @date: 2022-03-03
 * @brief: The following test tests the implementation of a generic iterable FIFO-queue based on a double linked circular list of
 * TheFundamentals3. It checks for the enqueue method, as well the dequeue method. Also it tests if the queue has been emptied.
 * @expected_output:
 * Enqueue(int)
[1]
[1],[2]
[1],[2],[3]
[1],[2],[3],[4]
End of enqueue


Dequeue
[1],[2],[3],[4]
[2],[3],[4]
[3],[4]
[4]
End of dequeue


Queue empty? false/true
false


Enqueue (string)
[ae]
[ae],[b]
[ae],[b],[c]
[ae],[b],[c],[d]
End of enqueue


Dequeue
[ae],[b],[c],[d]
[b],[c],[d]
[c],[d]
[d]

End of dequeue


Queue empty? false/true
true
 * **/
public class TheFundamentals3_test {
	public static void main(String[] args) {
		TheFundamentals3<Integer> circular = new TheFundamentals3<Integer>();
		
		System.out.println("Enqueue(int)");
		circular.enqueue(1);
		circular.enqueue(2);
		circular.enqueue(3);
		circular.enqueue(4);
		
		System.out.println("End of enqueue\n");
		System.out.println("");
		
		System.out.println("Dequeue");
		
		System.out.println(circular.toString());
		circular.dequeue();
		System.out.println(circular.toString());
		circular.dequeue();
		System.out.println(circular.toString());
		circular.dequeue();
		System.out.println(circular.toString());
		
		System.out.println("End of dequeue\n");
		System.out.println("");
		System.out.println("Queue empty? false/true");
		System.out.println(circular.isEmpty());
	
		System.out.println("");
		System.out.println("");
		TheFundamentals3<String> circularString = new TheFundamentals3<String>();
		System.out.println("Enqueue (string)");
		circularString.enqueue("ae");
		circularString.enqueue("b");
		circularString.enqueue("c");
		circularString.enqueue("d");
		System.out.println("End of enqueue\n");
		System.out.println("");
		
		System.out.println("Dequeue");
		
		System.out.println(circularString.toString());
		circularString.dequeue();
		System.out.println(circularString.toString());
		circularString.dequeue();
		System.out.println(circularString.toString());
		circularString.dequeue();
		System.out.println(circularString.toString());
		circularString.dequeue();
		System.out.println(circularString.toString());

		
		System.out.println("End of dequeue\n");
		System.out.println("");
		System.out.println("Queue empty? false/true");
		System.out.println(circularString.isEmpty());
	}

}
