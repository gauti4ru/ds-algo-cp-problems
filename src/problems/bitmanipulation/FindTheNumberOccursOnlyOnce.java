package problems.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link :
 * https://leetcode.com/problems/single-number/
 * 
 * Solution link :
 * 
 * 
 */
public class FindTheNumberOccursOnlyOnce {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// as all the numbers appears twice
	// and we know that a^a =0
	// we can use this property
	private static void type2() {
		int[] nums = { 4, 1, 2, 1, 2 };
		int xor = 0;
		for (int num : nums) {
			xor = xor ^ num;
		}
		System.out.println(xor);
	}

	// brute force approach
	// time complexity O(n)
	// space complexity O(n)
	private static void type1() {
		int[] nums = { 4, 1, 2, 1, 2 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		int ans = -1;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				ans = entry.getKey();
				break;
			}
		}
		System.out.println(ans);
	}

}