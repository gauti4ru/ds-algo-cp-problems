package problems.string;

public class MinimumInsertionAtBeginingToMakePalindromeString {

	public static void main(String[] args) {
		type1();
	}

	// brute force
	// time complexity O(n^2)
	// space complexity O(1)
	// from the right most we are checking that the string is palindrome or not , we
	// will check decrease the end index until the string became palindrome
	// if there is there is no palindrome then it will stop at start=0 end=0
	// as one character itself is always palindrome
	private static void type1() {
		String str = "abcd";
		char[] arr = str.toCharArray();
		int start = 0, end = str.length();
		while (!isPalindrome(arr, start, end - 1)) {
			end--;
		}
		int count = str.length() - end;
		System.out.println(count);
	}

	private static boolean isPalindrome(char[] arr, int left, int right) {
		while (left < right) {
			if (arr[left] != arr[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}