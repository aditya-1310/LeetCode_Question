class Solution {
    private static final int INF = (int) 2e9;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int end, int target) {
        long currdis = rundis(edges,n,source,end);
        if(currdis<target) return new int [0][0];
            boolean matcht = (currdis == target);
            for(int []edge: edges){
                if(edge[2]>0) continue;
                edge[2] = matcht?INF:1;

                if(!matcht) {
                    long newdis = rundis(edges,n ,source,end);
                    if(newdis <= target){
                        matcht = true;
                        edge[2] += target - newdis;
                    }
                }
            }
            return matcht ? edges:new int[0][0];
    }
    private long rundis( int[][] edges,int n, int source, int end){
        long adj [][] = new long[n][n];
        long mindis [] = new long[n];
        boolean vis[] = new boolean[n];
        Arrays.fill(mindis,INF);
        for(long []row : adj){
            Arrays.fill(row,INF);
        }

        mindis[source] =0;
        for(int []edge:edges){
            if(edge[2] != -1){
                adj[edge[0]][edge[1]] = edge[2];
                adj[edge[1]][edge[0]] = edge[2];
            }
        }
        for(int i=0;i<n;i++){
            int nesvis = -1;
            for(int j=0;j<n;j++){
                if(!vis[j] &&( nesvis ==-1 || mindis[j]< mindis[nesvis])){
                    nesvis =j;
                }
            }
            vis[nesvis] = true;
            for(int v =0;v<n;v++){
                mindis[v] = Math.min(mindis[v],(mindis[nesvis]+ adj[nesvis][v]));
            }
        }
        return mindis[end];


    }
}