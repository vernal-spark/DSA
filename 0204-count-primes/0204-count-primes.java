class Solution {
    public int countPrimes(int n) {
        if(n<=1){
            return 0;
        }
        boolean prime[] = new boolean[n];
        for(int i=0;i<n;i++){
            prime[i]=true;
        }
        for(int i=2;i*i<=n;i++){
            if(prime[i]==true){
                for(int j=i*i;j<n;j+=i){
                    prime[j]=false;
                }
            }
        }
        int count = 0;
        for(int i=2;i<prime.length;i++){
            if(prime[i]==true){
                count++;
            }
        }
        return count;
    }
}