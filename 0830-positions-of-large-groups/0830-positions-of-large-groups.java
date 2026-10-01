class Solution {

    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> result = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while(p2 < s.length()){

            while(p2 < s.length() &&
                  s.charAt(p1) == s.charAt(p2)){

                p2++;
            }

            int length = p2 - p1;

            if(length >= 3){

                List<Integer> temp = new ArrayList<>();

                temp.add(p1);
                temp.add(p2 - 1);

                result.add(temp);
            }

            p1 = p2;
        }

        return result;
    }
}