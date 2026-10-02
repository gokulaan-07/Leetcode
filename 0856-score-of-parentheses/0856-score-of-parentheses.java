class Solution {
    public int scoreOfParentheses(String s) {
        int openCount = 0, count = 0; 
        char prev = ' ';  

        for(char c : s.toCharArray()){
            if(c == '(')
                openCount++;

            else{
                openCount--; 
                if(prev == '(')
                    count+=1 << openCount; 
            } 
            
            prev = c;   
        }

        return count; 
    }
}