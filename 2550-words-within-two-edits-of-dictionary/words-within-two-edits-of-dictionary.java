class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        ArrayList<String> arr = new ArrayList<>();
        for(String str:queries){
            for(String check : dictionary){
                if(str.length() !=check.length()) continue;
               int diff =0;
               boolean twoedit = true;
                    for(int i=0;i<str.length();i++){
                        if(str.charAt(i) != check.charAt(i)) diff++;
                    }
                    if(diff >2) twoedit = false;
            if(twoedit && diff<=2) {
                arr.add(str);
                break;
            }
          
            }
        }
        

        return arr;

    }

}