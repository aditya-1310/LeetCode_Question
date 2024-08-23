class Solution {
    public String fractionAddition(String expression) {
        int numinator = 0;
        int denominator =1;
        int index =0;
        int length = expression.length();
        while(index<length){
            int sign =1;
            if(expression.charAt(index)=='-' || expression.charAt(index)=='+'){
            sign = expression.charAt(index)=='-'?-1:1;
            index++;
            }
        int numst =index;
        while(index<length && Character.isDigit(expression.charAt(index))){
            index++;
        }
        int num = Integer.parseInt(expression.substring(numst,index))*sign;
        index++;

        int demonst =index;
        while(index<length &&  Character.isDigit(expression.charAt(index))){
            index++;
        }
        int demon = Integer.parseInt(expression.substring(demonst,index));
      
        
        numinator = demon * numinator + num *denominator;
        denominator *= demon;

        int gcd = gcd(Math.abs(numinator) , denominator);
        numinator /= gcd;
        denominator /= gcd;

        }
        return numinator + "/" + denominator; 
        
    }

    public int gcd(int a , int b) {
        while(b!=0){
            int temp =b;
             b = a%b;
             a = temp;
        }
        return a;
    }

}