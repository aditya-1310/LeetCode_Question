class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        int index = 0;
        int length = expression.length();
        
        while (index < length) {
            int sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }

            int numStart = index;
            while (index < length && Character.isDigit(expression.charAt(index))) {
                index++;
            }
            int num = Integer.parseInt(expression.substring(numStart, index)) * sign;
            index++; // Skip '/'

            int denomStart = index;
            while (index < length && Character.isDigit(expression.charAt(index))) {
                index++;
            }
            int denom = Integer.parseInt(expression.substring(denomStart, index));
            
            numerator = numerator * denom + num * denominator;
            denominator *= denom;

            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
