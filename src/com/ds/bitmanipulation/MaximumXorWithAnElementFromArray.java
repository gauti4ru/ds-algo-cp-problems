package com.ds.bitmanipulation;

/*
 * Problem link :
 * https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
 * 
 * Solution link :
 * 
 * 
 */
public class MaximumXorWithAnElementFromArray {

	// You are given an array nums consisting of non-negative integers. You are also
	// given a queries array, where queries[i] = [xi, mi].
	// The answer to the ith query is the maximum bitwise XOR value of xi and any
	// element of nums that does not exceed mi. In other words, the answer is
	// max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in
	// nums are larger than mi, then the answer is -1.
	// Return an integer array answer where answer.length == queries.length and
	// answer[i] is the answer to the ith query.

	// Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
	// Output: [3,3,7]
	// Explanation:
	// 1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1
	// XOR 3 = 2. The larger of the two is 3.
	// 2) 1 XOR 2 = 3.
	// 3) 5 XOR 2 = 7.

	// Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
	// Output: [15,-1,5]

	// 1 <= nums.length, queries.length <= 105
	// queries[i].length == 2
	// 0 <= nums[j], xi, mi <= 109
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] nums = { 0, 1, 2, 3, 4 };
		int[][] queries = { { 3, 1 }, { 1, 3 }, { 5, 6 } };
	}

}
