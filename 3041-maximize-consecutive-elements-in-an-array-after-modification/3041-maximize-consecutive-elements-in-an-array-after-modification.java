class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0;

        for (int x : nums) {
           
            int inc = dp.getOrDefault(x, 0) + 1;
            dp.put(x + 1, inc);

            
            int keep = dp.getOrDefault(x - 1, 0) + 1;
            dp.put(x, keep);

            max = Math.max(max, Math.max(inc, keep));
        }

        return max;
    }
}