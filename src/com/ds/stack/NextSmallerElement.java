package com.ds.stack;

import java.util.Stack;

import static com.util.ArrayUtil.print;

/*
 * Problem link :
 * https://www.interviewbit.com/problems/nearest-smaller-element/
 * https://www.codingninjas.com/studio/problems/immediate-smaller-element-_1062597
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=nc1AYFyvOR4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=5
 * 
 * */
public class NextSmallerElement {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// same as the previous type2
	// just a little compact,
	// we have reduced the unnecessary if checks
	private static void type3() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
			answer[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.add(arr[i]);
		}
		print(arr);
		print(answer);
		
	}

	// same as the next greater element
	private static void type2() {
		int[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				answer[i] = -1;
			} else {
				if (stack.peek() < arr[i]) {
					answer[i] = stack.peek();
				} else {
					while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
					if (stack.isEmpty()) answer[i] = -1;
					else answer[i] = stack.peek();
				}
			}
			stack.add(arr[i]);
		}
		print(arr);
		print(answer);
	}

	// brute force
	private static void type1() {

	}
}
