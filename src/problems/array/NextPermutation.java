package problems.array;

/*
 * Problem link
 * https://www.codingninjas.com/codestudio/problems/893046?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/next-permutation/
 * 
 * solution link
 * https://www.youtube.com/watch?v=LuLCLgMElus&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=9
 * */
public class NextPermutation {

	// a number is linearly increasing from the back to a certain point and we have
	// to find that point
	// In 13542 -> break point is 3 that mean we can divide the number by 13 - 542.
	// now we have to change this prefix such a way it will be the minimum biggest
	// number like for 13 the choices are 14 and 15
	// So we will choose 14
	// as from the right side it is increasing so the right most element for
	// which a[index]<a[i] will satisfy this
	// then we will swap the numbers a[index] and a[i]
	// so now the prefix is greater
	// so my number is now 14 - 532
	// as we have now increased the prefix so the for the remaining part will be as
	// minimum as possible for the next element
	// so previously it was increasing from the back that's it was highest so if we
	// reverse the number then it will be become the lowest
	// so the number will become 14 - 235
	public static void main(String[] args) {
		int[] nums = { 5, 4, 3, 2, 1 };
		print(nums);
		int length = nums.length;
		// first traverse from the right and find the first element where a[i]<a[i+1]
		int index = length - 2;
		while (index >= 0) {
			if (nums[index] < nums[index + 1]) {
				break;
			}
			index--;
		}
		if (index == -1) {// the number is a decreasing number like 54321
			reverse(nums, 0);
		} else {
			// first traverse from the right and find the first element where a[index]<a[i]
			int swapingIndex = length - 1;
			while (swapingIndex > index) {
				if (nums[index] < nums[swapingIndex]) {
					break;
				}
				swapingIndex--;
			}
			swap(nums, index, swapingIndex);
			reverse(nums, index + 1);
		}
		print(nums);
	}

	private static void print(int[] nums) {
		for (int item : nums) {
			System.out.print(item);
		}
		System.out.println();
	}

	private static void reverse(int[] nums, int i) {
		int start = i;
		int last = nums.length - 1;
		while (start < last) {
			swap(nums, start, last);
			start++;
			last--;
		}
	}

	private static void swap(int[] nums, int index, int swapingIndex) {
		int temp = nums[index];
		nums[index] = nums[swapingIndex];
		nums[swapingIndex] = temp;
	}

}
