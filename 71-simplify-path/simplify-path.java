class Solution {
    public String simplifyPath(String path) {
        String arr [] = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("..")){
             if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(!arr[i].equals(".")  && !arr[i].equals("")){
                stack.push(arr[i]);
            }
        }
            if(stack.isEmpty()){
                return "/";
            }

        StringBuilder str  = new StringBuilder();
        for(int i=0;i<stack.size();i++){
            str.append("/").append(stack.get(i));
        }

        return str.toString();
    }
}