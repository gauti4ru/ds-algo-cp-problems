package problems.string;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * https://www.codingninjas.com/codestudio/problems/1112621?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=__Cu92rei1s -> pepcoding
 * 
 * https://www.youtube.com/watch?v=JoF0Z7nVSrA -> neetcode
 * 
 */
public class KMPAlgorithm {

	// 28. Find the Index of the First Occurrence in a String
	public static void main(String[] args) {
		type1();
		type2();
	}

	// thought process is little different
	// here we are thinking in terms of longest prefix suffix array
	// check pepcoding for explanation
	private static void type2() {
		String str = "aaxaabcaaaaxaabcaa";
		String ptrn = "aabcaa";

		char[] st = (ptrn + "&" + str).toCharArray();
		int[] lps = new int[st.length];

		int i = 1, j = 0;
		while (i < st.length) {
			if (st[i] == st[j]) {
				lps[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = lps[j - 1];
			} else {
				i++;
			}
		}
		int count = 0;
		for (int num : lps) {
			count += num == ptrn.length() ? 1 : 0;
		}
		System.out.println(count);
	}

	// check algoexpert for explanation
	private static void type1() {
		String str = "aaxaabcaaaax";
		String ptrn = "aabcaa";
		char[] s1 = str.toCharArray();
		char[] s2 = ptrn.toCharArray();

		int answer = -1;

		int[] pattern = new int[s2.length];
		Arrays.fill(pattern, -1);

		// finding pattern array
		int i = 1, j = 0;
		while (i < s2.length) {
			if (s2[i] == s2[j]) {
				pattern[i] = j;
				i++;
				j++;
			} else if (j > 0) {
				j = pattern[j - 1] + 1;
			} else {
				i++;
			}
		}

		// operating on actual string
		i = j = 0;
		while (i < s1.length) {
			if (s1[i] == s2[j]) {
				if (j == s2.length - 1) {
					answer = i - s2.length + 1;
					break;
				}
				i++;
				j++;
			} else if (j > 0) {
				j = pattern[j - 1] + 1;
			} else {
				i++;
			}
		}
		System.out.println(answer);
	}

}
