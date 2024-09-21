class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<String> arr = new ArrayList<>();
        for(int i=1;i<=n;i++){
        arr.add(String.valueOf(i));
        }
        Collections.sort(arr);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            result.add(Integer.valueOf(arr.get(i)));
        }

        return result;
    }
}