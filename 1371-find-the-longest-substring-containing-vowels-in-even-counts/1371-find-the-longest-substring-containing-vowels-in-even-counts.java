class Solution {
    HashMap<Character, Integer> vowlToBitIndex = new HashMap<Character, Integer>() {
        {
            put('a', 1);
            put('e', 2);
            put('i', 4);
            put('o', 8);
            put('u', 16);
        }
    };
    
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> stateToIndex = new HashMap<>();
        stateToIndex.put(0, -1);
        int state = 0, maxLen = 0;
        for(int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if(vowlToBitIndex.containsKey(cur)) {
                // flap the digits of the state. 1-> 0 or 0 -> 1
                int bitToFlip = vowlToBitIndex.get(cur); 
                state ^= bitToFlip; 
            }
            
            stateToIndex.putIfAbsent(state, i);
            maxLen = Math.max(maxLen, i - stateToIndex.get(state));
        }
        
        return maxLen;    
    }
}