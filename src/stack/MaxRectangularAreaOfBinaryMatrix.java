package stack;

import java.util.Arrays;
import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/maximal-rectangle
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8
 * 
 * */
public class MaxRectangularAreaOfBinaryMatrix {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// TODO study later
	private static void type4() {
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int row = matrix.length;
		int col = matrix[0].length;
		int[] left = new int[col];
		int[] right = new int[col];
		int[] height = new int[col];
		Arrays.fill(right, col);

		int max = 0;
		for (int i = 0; i < row; i++) {
			max = Math.max(max, dp(i, col, left, right, height, matrix));
		}
		System.out.println(max);
	}

	private static int dp(int r, int col, int[] left, int[] right, int height[], int[][] matrix) {
		int currentLeft = 0;
		int currentRight = col;

		// update height cache
		for (int i = 0; i < col; i++) {
			if (matrix[r][i] == 1)
				height[i]++;
			else
				height[i] = 0;
		}
		// update left cache
		for (int i = 0; i < col; i++) {
			if (matrix[r][i] == 1)
				left[i] = Math.max(left[i], currentLeft);
			else {
				left[i] = 0;
				currentLeft = i + 1;
			}
		}
		// update right cache
		for (int i = col - 1; i >= 0; i--) {
			if (matrix[r][i] == 1)
				right[i] = Math.min(right[i], currentRight);
			else {
				right[i] = col;
				currentRight = i;
			}
		}
		// update area
		int max = 0;
		for (int i = 0; i < col; i++) {
			max = Math.max(max, (right[i] - left[i]) * height[i]);
		}
		return max;
	}

	private static void type3() {
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int m = matrix.length, n = matrix[0].length;
		int[] histogram = new int[n];
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			// we will update the histogram on each iteration
			// and add the current row to the histogram
			for (int j = 0; j < n; j++) {
				// if the cell is zero then it has no point of adding previous
				// so we set it to 0
				// else we will add 1 to the height
				histogram[j] = matrix[i][j] == 0 ? 0 : histogram[j] + 1;
			}
			maxArea = Math.max(maxArea, maxAreaOfHistogramOptimized(histogram, n));
		}
		System.out.println(maxArea);
	}

	private static int maxAreaOfHistogramOptimized(int[] histogram, int n) {
		int max = 0;
		int[] stack = new int[n + 1];
		int top = -1, height, width;
		for (int i = 0; i <= n; i++) {
			while (top != -1 && (i == n || histogram[stack[top]] > histogram[i])) {
				height = histogram[stack[top--]];
				width = (top == -1) ? i : i - stack[top] - 1;
				max = Math.max(max, height * width);
			}
			stack[++top] = i;
		}
		return max;
	}

	private static void type2() {
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int m = matrix.length, n = matrix[0].length;
		int[] histogram = new int[n];
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			// we will update the histogram on each iteration
			// and add the current row to the histogram
			for (int j = 0; j < n; j++) {
				// if the cell is zero then it has no point of adding previous
				// so we set it to 0
				// else we will add 1 to the height
				histogram[j] = matrix[i][j] == 0 ? 0 : histogram[j] + 1;
			}
			maxArea = Math.max(maxArea, maxAreaOfHistogram(histogram, n));
		}
		System.out.println(maxArea);
	}

	private static int maxAreaOfHistogram(int[] histogram, int n) {
		int max = 0, area, right;
		int[] left = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i])
				stack.pop();
			if (stack.isEmpty()) left[i] = -1;
			else left[i] = stack.peek();
			stack.add(i);
		}
		stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i])
				stack.pop();
			if (stack.isEmpty()) right = n;
			else right = stack.peek();
			stack.add(i);
			area = (right - left[i] - 1) * histogram[i];
			max = Math.max(max, area);
		}
		return max;
	}

	// brute force approach
	private static void type1() {

	}

}
