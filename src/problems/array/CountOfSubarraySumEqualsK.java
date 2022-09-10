package problems.array;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://leetcode.com/problems/subarray-sum-equals-k/submissions/
 * 
 * Solution:
 * https://www.youtube.com/watch?v=fFVZt-6sgyo
 * */
public class CountOfSubarraySumEqualsK {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// prefix sum approach
	// time complexity O(n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 1, 2, 3 };
		int k = 3;
		int n = nums.length, sum = 0, reminder, count = 0;
		Map<Integer, Integer> prefixSumMap = new HashMap<>();
		prefixSumMap.put(0, 1);// zero prefix sum for empty sub array
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			reminder = sum - k;
			// if reminder exists that mean k also exists
			// the number of prefix sum of reminder is equals the number prefix sum of k
			if (prefixSumMap.containsKey(reminder)) {
				count = count + prefixSumMap.get(reminder);
			}
			// on every index we are updating the prefix sum count
			if (!prefixSumMap.containsKey(sum)) {
				prefixSumMap.put(sum, 1);
			} else {
				prefixSumMap.put(sum, 1 + prefixSumMap.get(sum));
			}
		}
		System.out.println("Count of subarry is " + count);
	}

	// brute force approach using two loops
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 1, 2, 3 };
		int k = 3;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == k) {
					count++;
				}
			}
		}
		System.out.println("Count of subarry is " + count);
	}
}