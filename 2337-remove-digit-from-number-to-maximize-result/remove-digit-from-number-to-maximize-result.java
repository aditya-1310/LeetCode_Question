class Solution {
    public String removeDigit(String number, char digit) {
        int d=0;
       for(int i =0;i<number.length();i++){
        if(number.charAt(i) == digit){

        d =i;
        if(i+1<number.length() && number.charAt(i)< number.charAt(i+1)){
            break;
        }
    }
        }
        return number.substring(0,d) + number.substring(d+1,number.length());
    }
}