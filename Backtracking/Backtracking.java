package Backtracking;

import java.util.List;


// can we make from 9 3 7 = target
// using + -


public class Backtracking {
    static boolean calc(List<Integer> nums, int target, int sum, int idx) {
        System.out.println(sum + " " + idx);
        if (idx == nums.size()) return target == sum;

        return calc(nums, target, sum + nums.get(idx), idx + 1) ||     // false || true
                calc(nums, target, sum - nums.get(idx), idx + 1);
    }

    static boolean solve(List<Integer> nums, int target) {
        if (nums == null || nums.isEmpty()) return false;
        return calc(nums, target, nums.get(0), 1);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(9, 3, 7);
        int target = 13;

        System.out.println(solve(nums, target) ? "Solution exists" : "No solution");
    }
}
