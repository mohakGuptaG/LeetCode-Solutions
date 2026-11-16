class Solution {
    public String frequencySort(String s) {
        
        // Step 1: Count the frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Set up the buckets
        // Array size is s.length() + 1 because max frequency can be s.length()
        List<Character>[] buckets = new List[s.length() + 1];
        
        // Step 3: Fill the buckets
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        // Step 4: Build the final string reading buckets backwards
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    // Append the character 'i' times (its frequency)
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}