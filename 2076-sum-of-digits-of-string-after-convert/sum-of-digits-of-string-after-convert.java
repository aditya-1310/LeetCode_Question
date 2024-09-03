class Solution {
    public int getLucky(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 'a' + 1;  
            result.append(value);
        }

        
        String valStr = result.toString();
        int temp = 0;

        for (int i = 0; i < valStr.length(); i++) {
            temp += valStr.charAt(i) - '0';
        }

        
        while (k > 1) {  
            int sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            temp = sum;
            k--;
        }

        return temp;
    }
}
