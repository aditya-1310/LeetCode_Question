class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
      return solve(expression);
    }
    public ArrayList<Integer> solve(String expression){
          ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
        if(expression.charAt(i)=='+'||expression.charAt(i) =='-'||expression.charAt(i)=='*'){

            ArrayList<Integer> left = solve(expression.substring(0,i));
            ArrayList<Integer> right = solve(expression.substring(i+1));
            
            for(int x:left){
                for(int y:right){
                    if(expression.charAt(i)=='+'){
                        arr.add(x+y);
                    }
                    else if(expression.charAt(i)=='-'){
                        arr.add(x-y);
                    }
                    else{
                        arr.add(x*y);
                    }
                }
            }
            }
        }
            if(arr.isEmpty()){
                arr.add(Integer.parseInt(expression));
            }

        return arr;
    }
}