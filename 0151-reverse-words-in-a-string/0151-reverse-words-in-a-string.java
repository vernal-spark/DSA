class Solution {
    public String reverseWords(String s) {
        String s1 = s.trim();
        String[] a = s.split("\\s+");
        int low=0,high=a.length-1;
        while(low<high){
            String temp = a[low];
            a[low]=a[high];
            a[high]=temp;
            low++;
            high--;
        }
        String ans = String.join(" ",a);
        return ans.trim();
    }
}