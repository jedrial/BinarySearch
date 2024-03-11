package BinarySearch;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
 * JUnit Tests for Binary Search
 * @author Jamille Edrial
 * @version Spring 2024 Software Engineering
 */
class BinarySearchTests {
	
	private BinarySearch bin;
	private int[] nums;
	private int target;
	
	/** Initializes random array and target */
	@BeforeEach
	public void setupRand() {
		Random random = new Random();
        nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
        	/** Fills the array with ints between 0-999 */
            nums[i] = random.nextInt(1000);
        }
        /** Assigns a random int between 0-999 to target */
        target = random.nextInt(1000);
	}
	
	/** Initializes random array and target */
	@BeforeEach
	public void setup() {
		bin = new BinarySearch();
		nums = new int[0];
		target = -1;
	}
	
	/** Resets values of array and target */
	@AfterEach
	public void breakdown() {
		bin = new BinarySearch();
		nums = new int[0];
		target = -1;
	}
	
	/** Tests the basic array functions with & without target*/
	@Test
	public void testBasicFunctions() {
		setup();
		int[] nums = {1, 2, 3, 4, 5};
		System.out.println(bin.binarySearch(nums, 1));
        assertEquals(0, bin.binarySearch(nums, 1));
        assertEquals(-1, bin.binarySearch(nums, 0));
	}
	
	/** Tests for boundary cases min and max */
	@Test
	public void testBoundaries() {
		setup();
		int[] nums = {Integer.MIN_VALUE, 0, Integer.MAX_VALUE};
        assertEquals(0, bin.binarySearch(nums, Integer.MIN_VALUE));
        assertEquals(1, bin.binarySearch(nums, 0));
        assertEquals(2, bin.binarySearch(nums, Integer.MAX_VALUE));
	}
	
	/** Tests for extreme indices and target values */
	@Test
	public void testExtremeIndicesAndTargets() {
		setup();
		nums = new int[1000000];
		nums[0] = -1000000;
		nums[999999] = 1000000;
        assertEquals(0, bin.binarySearch(nums, -1000000));
        assertEquals(999999, bin.binarySearch(nums, 1000000));
	}
	
	/** Tests for extreme array sizes and sizes near powers of 2 */
	@Test
	public void testExtremeArraySizes() {
		setup();
		nums = new int[Integer.MAX_VALUE / 3]; /** Large array */
        assertEquals(-1, bin.binarySearch(nums, 1));
        breakdown();
        nums = new int[1]; /** Small array */
        assertEquals(-1, bin.binarySearch(nums, 1));
	}
	
	/** Tests randomly generated arrays and targets */
	@Test
	public void testRandomArraysAndTargets() {
		setupRand();
        assertEquals(bin.slowerSearch(nums,target), 
        		bin.binarySearch(nums, target));
	}
	
	/** Tests slower search if correct target is in index */
	@Test
	public void testRandomSlowerSearch() {
		setupRand();
		int expectedIndex = bin.slowerSearch(nums, target);
        assertEquals(target, nums[expectedIndex]);
	}
	
	/** Tests binary search if correct target is in index */
	@Test
	public void testRandomBinarySearch() {
		setupRand();
		int expectedIndex = bin.binarySearch(nums, target);
        assertEquals(target, nums[expectedIndex]);
	}
	
}
