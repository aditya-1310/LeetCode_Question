class Solution {
    public boolean halvesAreAlike(String s) {
        int n  = s.length();
        int mid = n/2;
        int i=0;
        int j = mid;
        int counti=0;
        int countj=0;
        while( i<mid && j<n){
            if(isvovel(s.charAt(i)) ) {
                counti++;
            }
            if(isvovel(s.charAt(j)) ) {
                countj++;
            }
            i++;
            j++;
        }
        if(counti == countj) return true;

        return false;
    }
    public boolean isvovel(char ch){
        if(ch == 'a' || ch == 'e' || ch =='i' || ch== 'u'|| ch=='o'||
        ch == 'A' || ch == 'E' || ch =='I' || ch== 'O'|| ch=='U'){
            return true;
        }
        return false;
    }
}