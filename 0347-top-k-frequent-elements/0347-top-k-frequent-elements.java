class Solution {
    public class Pair implements Comparable<Pair> {
        int key, value;
        
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public int compareTo(Pair p) {
            return this.value - p.value;
        }
    }
    
    public int[] topKFrequent(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> h = new HashMap<>();
        
        // Count frequencies
        for (int i = 0; i < n; i++) {
            h.put(arr[i], h.getOrDefault(arr[i], 0) + 1);
        }
        
        // Use max heap (reverse order) to get top k frequent elements
        Queue<Pair> q = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            q.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        int[] freq = new int[k];
        for (int i = 0; i < k; i++) {
            freq[i] = q.poll().key;  // Extract the key (element), not the Pair object
        }
        
        return freq;
    }
}