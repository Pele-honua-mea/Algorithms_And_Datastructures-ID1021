/**@author: Pele Honua Mea
 * @date: 2022-05-07
 * @brief: The following test tests the implementation of a generalized queue which allows the user to remove the kth element from
 * the queue with the assumption that the most recently added element has index 1.
 * @expected_output: 
Enqueuing a list of integers:
[1]
[1][2]
[1][2][3]
[1][2][3][4]
[1][2][3][4][5]
[1][2][3][4][5][6]
[1][2][3][4][5][6][7]

Removing items at a given index: 

Given index: 5
[1][2][3][4][6][7]
The removed value from the queue: 5

Given index: 1
[2][3][4][6][7]
The removed value from the queue: 1

Given index: 7
Index 7 is too large. No item to remove.
Index 0 is too small. No item to remove
 * */
public class TheFundamentals5_test {
	public static void main(String[] args) {
		TheFundamentals5<Integer> general = new TheFundamentals5<Integer>();
		System.out.println("Enqueuing a list of integers:");
		general.enqueue(1);
		general.enqueue(2);
		general.enqueue(3);
		general.enqueue(4);
		general.enqueue(5);
		general.enqueue(6);
		general.enqueue(7);
		
		System.out.println("");
		System.out.println("Removing items at a given index: \n");
		general.removeKTH(5);
		general.removeKTH(1);
		general.removeKTH(7);
		general.removeKTH(0);
	}

}
