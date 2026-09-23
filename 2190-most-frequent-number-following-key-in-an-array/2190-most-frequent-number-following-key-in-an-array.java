class Solution {
    public int mostFrequent(int[] nums, int key) {
       // Map<Integer,Integer> map=new HashMap<>();
        
       /* for(int i=0;i<nums.length;i++){
            if(num==key && !map.contains(num)){
                map.put(nums[i+1],)
            }
        }*/
        int[] a=new int[1001];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                a[nums[i+1]]++;
            }
        }
        int max=Integer.MIN_VALUE;int idx=0;
        for(int i=0;i<1001;i++){
            if(a[i]>max){
                max=a[i];
                idx=i;
            }
        }
        return idx;
    }
}