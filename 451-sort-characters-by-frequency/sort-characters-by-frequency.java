class Solution {
    public String frequencySort(String s) {
       HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int freq = map.get(ch);
                map.put(ch, freq + 1);
            } else {
                map.put(ch, 1);
            }
        }   
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char ch : map.keySet()) {
            pq.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.remove();
            int freq = map.get(ch);
            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }   
        return sb.toString(); 
    }
}