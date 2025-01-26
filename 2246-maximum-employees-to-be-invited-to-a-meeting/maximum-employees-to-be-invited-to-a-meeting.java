class Solution {


    public int Bfs(int start,Map<Integer,List<Integer>> adj,boolean vis[]){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});
        int maxdis =0;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currNode = current[0];
            int dis = current[1];

            for(int neigh :adj.getOrDefault(currNode,new ArrayList<>())){
                if(!vis[neigh]){
                    vis[neigh] = true;
                    queue.add(new int[]{neigh,dis+1});
                    maxdis = Math.max(maxdis,dis+1);
                }
            }
        }
        return maxdis;
    }
    public int maximumInvitations(int[] favorite) {
       int n = favorite.length;
       Map<Integer,List<Integer>> arr = new HashMap<>();
       for(int i=0;i<n;i++){
        int u = i;
        int v= favorite[i];
        arr.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
       }

       int longestcyccount = 0;
       int happylen = 0;
       boolean vis[] = new boolean[n];

       for(int i=0;i<n;i++){
        if(!vis[i]){
       Map<Integer,Integer> nam = new HashMap<>();
            int currnode = i;
            int currnextcnt = 0;
            while(!vis[currnode]){
                vis[currnode] = true;
                nam.put(currnode, currnextcnt);

                int nextnode = favorite[currnode];
                currnextcnt++;
                if(nam.containsKey(nextnode)){
                    int cyclelength = currnextcnt - nam.get(nextnode);
                    longestcyccount  = Math.max(longestcyccount,cyclelength);
                

                if(cyclelength ==2){
                    boolean visited [] = new boolean[n];
                     visited[currnode] =  true;
                     visited[nextnode ] = true;

                     happylen += 2 + Bfs(currnode,arr,visited) + Bfs(nextnode,arr,visited);

                }
                break;
                }
                
            currnode = nextnode;
            }
        }

       }


        return Math.max(happylen,longestcyccount);
    }

}