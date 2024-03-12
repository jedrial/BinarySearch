package BinarySearch;

/**
 * Binary Search Class
 * @author Jamille Edrial
 * @version Spring 2024 Software Engineering
 */
public class BinarySearch {
	
	/**
	 * Binary Search Implementation using middle index
	 * @param array of ints we are looking through
	 * @param target int we are looking for in array
	 * @return index of target, -1 if not there
	 */
	public static int binarySearch(int[] array, int target) {
		
		Arrays.sort(array);

		
		int min = 0;
		int max = array.length - 1;
		
		while (min <= max) {
			int mid = min + (max - min);
			if(array[mid] == target) {
				return mid;
			}else if(array[mid] < target) {
				min += 1;
			}else {
				max -= 1;
			}
		} // end while
		
		return -1;
	}
	
	/**
	 * Search Algorithm for randomly generated
	 * @param array of ints we are looking through
	 * @param target int we are looking for in array
	 * @return index of target, -1 if not there
	 */
	public static int slowerSearch(int[] array, int target) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == target) {
				return i;
			}
			/** Only if sorted */
//			else if(array[i] > target) {
//				break;
//			}
		}
		return -1;
	}
	
//	public static void main (String[] args) {
//		int[] myArray = {1, 2, 3, 4, 5};
//		int x = binarySearch(myArray, 1);
//		System.out.println(x);
//	}
	
}
