class Solution {
    public String generateTheString(int n) {
        String a="";
    if(n%2!=0){
        for(int i=0;i<n;i++){
            a+="a";
        }
    }
    else{
       for(int i=0;i<n-1;i++){
        a+="a";
       }
       a+="b";
    }
    return a;
    }
}