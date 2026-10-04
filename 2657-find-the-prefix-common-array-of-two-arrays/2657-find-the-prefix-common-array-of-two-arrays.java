class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c = new int[A.length];
        int cnt = 0;
        Set<Integer> a = new HashSet();
        Set<Integer> b = new HashSet();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i])
                cnt++;
            else {
                if (a.contains(B[i]))
                    cnt++;
                if (b.contains(A[i]))
                    cnt++;
            }
            a.add(A[i]);
            b.add(B[i]);
            c[i] = cnt;
        }
        return c;
    }
}