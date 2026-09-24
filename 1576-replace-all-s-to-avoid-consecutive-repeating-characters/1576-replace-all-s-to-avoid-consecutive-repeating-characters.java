class Solution {
    public String modifyString(String s) {
        char arr[]=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            char ch1=arr[i];
            if(ch1=='?'){
                for(char ch='a';ch<='z';ch++){
                  char prev=(i>0)?arr[i-1]:0;
                  char next=(i<arr.length-1)?arr[i+1]:0;
                    if(ch!=prev && ch!=next){
                        arr[i]=ch;
                        break;
                    }
               }
            }
        }
        return new String(arr);
    }
}