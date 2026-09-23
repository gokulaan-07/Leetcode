public class Solution {
    public int getMappedValue(int[] mapping, int num) {
        int mappedValue = 0;
        int place = 1;
        if (num == 0) {
            return mapping[0];
        }
        while (num > 0) {
            int digit = num % 10;
            mappedValue += place * mapping[digit];
            num /= 10;
            place *= 10;
        }
        return mappedValue;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> mappedValuesWithIndex = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int mappedValue = getMappedValue(mapping, nums[i]);
            mappedValuesWithIndex.add(new int[]{mappedValue, i});
        }

        Collections.sort(mappedValuesWithIndex, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[nums.length];
        for (int i = 0; i < mappedValuesWithIndex.size(); i++) {
            result[i] = nums[mappedValuesWithIndex.get(i)[1]];
        }
        return result;
    }
}