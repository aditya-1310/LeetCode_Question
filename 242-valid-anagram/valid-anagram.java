class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // Early exit if lengths differ
        }

        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}