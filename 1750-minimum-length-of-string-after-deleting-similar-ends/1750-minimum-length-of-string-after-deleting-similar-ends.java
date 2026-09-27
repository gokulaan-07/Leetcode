class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) break;// if first layer is not cleared then cant get inside immediately return 

            if(s.charAt(i)==s.charAt(j)){

                char ch= s.charAt(i);// a

                while(i<=j && s.charAt(i)==ch){
                    i++;
                }
                while( j>=i && s.charAt(j)==ch){
                    j--;
                }
            }
        }
        return j-i+1;
    }
}
