class Solution {
    public int findSpecialInteger(int[] arr) {
        int count=1,x=arr[0];
        for(int i=1;i<arr.length;i++){
           if(arr[i]==x){
               count++;
           } 
           else{
               count=1;
           }
           if(count>arr.length/4){
               return arr[i];
           }
           x=arr[i];
        }
        return x;
    }
}