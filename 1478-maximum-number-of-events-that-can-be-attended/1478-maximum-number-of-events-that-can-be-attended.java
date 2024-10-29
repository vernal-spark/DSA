class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(event -> event[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxEvents = 0;
        int day = 1; // Starting day

        for (int i = 0; i < events.length || !minHeap.isEmpty(); day++) {
            while (i < events.length && events[i][0] == day) {
                minHeap.offer(events[i][1]); // Store the end day of the event
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll(); // Remove events that have already ended
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll(); // Attend the event that ends earliest on the current day
                maxEvents++;
            }
        }

        return maxEvents;
    }
}