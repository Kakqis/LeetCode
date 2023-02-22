package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(new LinkedList<Integer>(), nums);
        return res;
    }

    private void backtrack(LinkedList<Integer> element, int[] nums) {
        // 某排列和数组长度一致时结束
        if (element.size() == nums.length) {
            res.add((List) element.clone());
            return;
        }

        for (int num : nums) {
            if (element.contains(num)) {
                continue;
            }

            element.addLast(num);
            // 回溯
            backtrack(element, nums);
            // 移除添加的结果
            element.removeLast();
        }
    }
}