class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> arr = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder(i + "/");
            for (int j = i + 1; j <= n; j++)
                if (gcd(i, j) == 1)
                    arr.add(new StringBuilder(sb).append(j).toString());

        }
        return arr;
    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}