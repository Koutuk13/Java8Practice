package com.example.codility;


import java.util.Arrays;

public class PracticeExample1 {

    public static void main(String[] args) {
      //  int[] arr = {1, 3, 6, 4, 1, 2};
        /*116432
       112643
        112364
        112346

        -3,-4,5*/

        int arr[] = {1, 3, 6, 4, 1, 2};
        int n = arr.length;
        int ans = firstMissingPositive(arr, n);
        System.out.println(ans);

    }
    public static int firstMissingPositive(int[] nums,
                                           int n)
    {
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ans)
                ans++;
        }
        return ans;
    }
}
