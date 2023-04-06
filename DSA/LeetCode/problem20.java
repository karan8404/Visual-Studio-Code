public class problem20 {
    public boolean isValid(String s) {
        String working="";

        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr==')' && working.length()!=0){
                
                if(working.charAt(working.length()-1)=='(')
                    working=working.substring(0,working.length()-1);
                else 
                    return false;
            }
            else if(curr=='}' && working.length()!=0){
                if(working.charAt(working.length()-1)=='{')
                    working=working.substring(0,working.length()-1);
                else 
                    return false;
            }
            else if(curr==']' && working.length()!=0){
                if(working.charAt(working.length()-1)=='[')
                    working=working.substring(0,working.length()-1);
                else 
                    return false;
            }
            else
                working+=curr;
        }
        return working.length()==0;
    }
}