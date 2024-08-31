class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer,ArrayList<Pair<Integer,Double>>> map  = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            map.putIfAbsent(u,new ArrayList<>());
            map.get(u).add(new Pair<>(v,w));
            map.putIfAbsent(v,new ArrayList<>());
            map.get(v).add(new Pair<>(u,w));
        }

        double maxpro[] = new double[n];
        maxpro[start] =1d;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(Pair<Integer,Double> p : map.getOrDefault(curr,new ArrayList<>())){
                int next = p.getKey();
                double currpro = p.getValue();
                if(maxpro[curr]*currpro > maxpro[next]){
                    maxpro[next] = maxpro[curr]*currpro;
                    q.offer(next);
                }
            }
        } 
        return maxpro[end];
    }
}
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}