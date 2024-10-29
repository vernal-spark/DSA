class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1<len2){
            return "";
        }
        HashMap<Character,Integer> hs = new HashMap<>();
        HashMap<Character,Integer> ht = new HashMap<>();

        for(int i=0;i<len2;i++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
        }
        int start = 0,start_idx=-1,count = 0,min_len=Integer.MAX_VALUE;
        for(int j=0;j<len1;j++){
            Character c = s.charAt(j);
            hs.put(c,hs.getOrDefault(c,0)+1);
            if(ht.containsKey(c) && hs.getOrDefault(c,0)<= ht.getOrDefault(c,0)){
                count++;
            }
            if(count==len2){
                while(hs.getOrDefault(s.charAt(start),0)>ht.getOrDefault(s.charAt(start),0) || !hs.containsKey(s.charAt(start))){
                    if(hs.getOrDefault(s.charAt(start),0)>ht.getOrDefault(s.charAt(start),0)){
                        hs.put(s.charAt(start),hs.get(s.charAt(start))-1);
                    }
                    start++;
                }
                int curr_len= j-start+1;
                System.out.println(curr_len+" "+j);
                if(curr_len<min_len){
                    min_len=curr_len;
                    start_idx=start;
                }
            }
        }
        if(start_idx==-1){
            return "";
        }
        return s.substring(start_idx,start_idx+min_len);
    }
}