'''Given an integer array nums of unique elements, return all possible

(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

 

Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.'''

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> ans){
        ans.add(new ArrayList<>(current));

        for(int i = start; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(i+1, nums, current, ans);
            current.remove(current.size() - 1);
        }
    }
}