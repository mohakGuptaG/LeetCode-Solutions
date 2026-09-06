

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> mt = new HashMap<>();
        List<Integer> freqs = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            if (!mt.containsKey(count)) {
                mt.put(count, new ArrayList<>());
                freqs.add(count); 
            }
            mt.get(count).add(val);
        }

        Collections.sort(freqs);

        int[] ans = new int[k];
        int idx = 0;

        for (int i = freqs.size() - 1; i >= 0 && idx < k; i--) {
            int freq = freqs.get(i);
            for (int num : mt.get(freq)) {
                ans[idx++] = num;
                if (idx == k) break;
            }
        }

        return ans;
    }
}