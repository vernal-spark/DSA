class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ngsum = 0, sum = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += customers[i];
            if (grumpy[i] == 0) {
                ngsum += customers[i];
            }
        }
        if (minutes >= customers.length) {
            return sum;
        }
        int ans = ngsum;
        int maxExtraSatisfied = 0;
        int currentExtraSatisfied = 0;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentExtraSatisfied += customers[i];
            }
        }
        maxExtraSatisfied = currentExtraSatisfied;

        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                currentExtraSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                currentExtraSatisfied -= customers[i - minutes];
            }
            maxExtraSatisfied = Math.max(maxExtraSatisfied, currentExtraSatisfied);
        }

        // Final result
        ans += maxExtraSatisfied;
        return ans;
    }
}