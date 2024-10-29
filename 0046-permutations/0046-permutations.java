class Solution {
    public static void swap(int s, int l, int[] nums) {
        int temp = nums[s];
        nums[s] = nums[l];
        nums[l] = temp;
    }

    public static void p(int[] nums, int s, int l, List<List<Integer>> res) {
        if (s == l) {
            List<Integer> a = new ArrayList<>();
            for (int num : nums) {
                a.add(num);
            }
            res.add(a);
            return;
        }
        for (int i = s; i <= l; i++) {
            swap(s, i, nums);
            p(nums, s + 1, l, res);
            swap(s, i, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        p(nums, 0, nums.length - 1, res);
        return res;
    }
}