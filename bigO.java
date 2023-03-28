import java.util.ArrayList;
import java.util.List;

public class bigO {

	public static void main(String[] args) {

		// Declare array
		List<Integer> list = new ArrayList<Integer>();

		// O(n) algorithm - method that sequentially inserts an element into a list
		addElement(list, 5);
		addElement(list, 4);
		addElement(list, 6);
		addElement(list, 3);
		addElement(list, 9);
		addElement(list, 12);
		addElement(list, 15);

		// Display on console the result after element is added
		System.out.println("List after element is added O(n) method used:\n" + list + "\n");

		// Write an O(n2) algorithm that iterates over a 2D array of integers.
		int[][] array2D = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// Display on console the items in the 2d array
		System.out.println("O(n2) algorithm that prints the iterates over a 2D array of integers.");
		iterationOver2DArray(array2D);
		
		// Write an O(log n) algorithm that sequentially inserts an element into a list.
		// Declare number that want to add
		int numberToAdd = 4;

		// Use method to do binary search where the element must be added and add element to the list
		list.add(searchElementPlacementPosition(list, numberToAdd), numberToAdd);

		// Display on console the result after element is added
		System.out.println("\nList after element is added - O(log n) search method used:\n" + list);
	}

	// O(n) algorithm that sequentially inserts an element into a list
	public static void addElement(List<Integer> list, int number) {

		// Get the size of the list Array
		int listSize = list.size();

		// If there is no elements, add the number
		if (list.size() == 0) {
			list.add(number);
		}
		// If number is smaller than smallest number, add at beginning
		else if (number <= list.get(0)) {
			list.add(0, number);
		}
		// If number is bigger than biggest number, add at end
		else if (number > list.get(list.size() - 1)) {
			list.add(list.size(), number);
		}
		// Else run though each number in the Array list with a for loop
		else {
			for (int i = 0; i < listSize - 1; i++) {
				// If current number is smaller than the number and next number is bigger than
				// the number to be added
				if (list.get(i) < number && list.get(i + 1) >= number) {
					// Add at the next position
					list.add(i + 1, number);
				}
			}
		}
	}
	
	// Write an O(n2) algorithm that iterates over a 2D array of integers.
	public static void iterationOver2DArray(int[][] array2D) {
		// Run a for loop for the length of the array
		for (int i = 0; i < array2D.length; i++) {
			// Run a for loop for the length of the objects inside the array' array
			for (int x = 0; x < array2D[i].length; x++) {
				// Print next to one another the items in the array
				System.out.print(array2D[i][x] + " ");
			}
		}
		// Console print line to end the line
		System.out.println("");
	}
	
	// Use Binary search - O(log n) To search where the element should be placed
	public static int searchElementPlacementPosition(List<Integer> list, int number) {
		// Declare start position
		int start = 0;
		// Declare end position -1 because of index is -1 size
		int end = list.size() - 1;
		// The half (middle) position
		int middle;

		// Search method by halving to search if the element is in the array
		while (start <= end) {
			// Get the middle
			middle = ((start + end) / 2);

			// If middle element is the same as element to be added, return this position
			if (list.get(middle) == number) {
				return middle;
			}
			// If element is smaller than middle element, bring the end to the middle (-1)
			else if (number < list.get(middle)) {
				end = middle - 1;
			}
			// Else if bigger then start is equal to middle position + 1
			else {
				start = middle + 1;
			}
		}
		// If the while loop does not return before Start is > than End(Search result not found)
		// Return end +1 as position where element should be placed in the array
		return end + 1;
	}
}
