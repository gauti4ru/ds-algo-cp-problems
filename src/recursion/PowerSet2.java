package recursion;

import java.util.*;

/*
 * Problem links:
 * https://leetcode.com/problems/subsets-ii/
 * https://www.codingninjas.com/studio/problems/subsequences-of-string_985087
 *
 * Solution link
 * https://www.youtube.com/watch?v=b7AYbpM5YrE
 * https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=54
 *
 * https://www.youtube.com/watch?v=Yg5a2FxU4Fo&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=12
 * https://www.youtube.com/watch?v=lfFqW1DTsqM&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=13
 *
 *
 * https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/
 * */
public class PowerSet2 {

    // the algorithms used for no unique elements wil also work on the unique elements
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // Given array has duplicate characters
    // With computation
    // here, our intuition is that we will pick one unique item a time
    // from the remaining list
    // first we will make 0 item lists then 1 item then 2 then n items
    private static void type3() {
        int[] nums = {1, 2, 1, 3, 2, 4};
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> bucket = new ArrayList<>();
        powerSet(nums, 0, bucket, answer);
        System.out.println(answer);
    }

    private static void powerSet(int[] arr, int currentIndex, List<Integer> bucket, List<List<Integer>> answer) {
        // deep copy of the bucket
        answer.add(new ArrayList<>(bucket));
        for (int i = currentIndex; i < arr.length; i++) {
            // loop will not execute for the duplicate values
            if (i != currentIndex && arr[i] == arr[i - 1]) continue;
            // we are choosing arr[i] to be part of the bucket
            bucket.add(arr[i]);
            // computing the remaining
            powerSet(arr, i + 1, bucket, answer);
            // after computing again removing it
            bucket.remove(bucket.size() - 1);
        }
    }

    // it will contain duplicate sets also
    private static void type2() {
        int[] nums = {1, 2, 1, 3, 2, 4};
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(answer, new ArrayList<>(), nums, 0);
        System.out.println(answer);
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
        if (nums.length == start) {
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[start]);
        backtrack(list, temp, nums, start + 1);
        temp.remove(temp.size() - 1);
        backtrack(list, temp, nums, start + 1);
    }

    // duplicate elements with set
    // extra computation needed
    private static void type1() {
        String str = "aaa";
        Set<String> answer = new HashSet<>();
        powerSetWithSet(new StringBuilder(), 0, str, answer);
        System.out.println(answer);
    }

    private static void powerSetWithSet(StringBuilder previous, int current, String actualString, Set<String> answer) {
        if (current == actualString.length()) {
            answer.add(previous.toString());
            return;
        }
        // here we are not choosing it to be a part of the answer
        powerSetWithSet(previous, current + 1, actualString, answer);
        // here we are choosing the element to a part of the answer
        powerSetWithSet(previous.append(actualString.charAt(current)), current + 1, actualString, answer);
        // as previous is a StringBuilder so we are changing the actual object so we
        // need to delete the last character which we have added previously
        previous.deleteCharAt(previous.length() - 1);
    }
}
