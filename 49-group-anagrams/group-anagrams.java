class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);   
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}