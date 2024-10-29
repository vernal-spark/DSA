class Solution {
    public static int find(int i,int[] parent){
        if(parent[i]==i)return i;
        return parent[i]=find(parent[i],parent);
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int parent[] = new int[n];
        HashMap<String,Integer> owner = new HashMap<String,Integer>();
        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(owner.containsKey(mail)){
                    int index = owner.get(mail);
                    int p1 = find(i,parent);
                    int p2 = find(index,parent);
                    parent[p1]=p2;
                }
                else{
                    owner.put(mail,i);
                }
            }
        }

        HashMap<Integer,TreeSet<String>> ans = new HashMap<Integer,TreeSet<String>>();
        for(int i=0;i<n;i++){
            int root = find(i,parent);
            List<String> mailList = accounts.get(i);
            if(!ans.containsKey(root)){
                ans.put(root,new TreeSet());
            }
            ans.get(root).addAll(mailList.subList(1,mailList.size()));
        }

        List<List<String>> res = new ArrayList<>();
        for (int root : ans.keySet()) {
            String name = accounts.get(root).get(0);
            ArrayList<String> emails = new ArrayList<>(ans.get(root));
            emails.add(0, name);
            res.add(emails);
        }
        return res;
    }
}