public class SubArrayProblems {

    // array = [2,3,1,2,4,3]
    // target = 7
    // 1. 2,3,1 = 7, len - 3
    // 2. 1,2,4 = 7, len - 3
    // 3. 4,3   = 7, len - 2
    // [4,3]

    // [1]
    // target = 1
    // 1
    // O(N2)
    // O(1)
    public static int minSubArrayLen(int target, int[] nums) {
        int result = nums.length;
        boolean seen = false;
        for(int i = 0; i < nums.length; i++) { // O(N)
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == target) {
                    result = Math.min(result, j - i + 1);
                    seen = true;
                }
            }
        }

        return seen == true? result: 0;
    }

    // [2,3,1,2,4,3]
    // idx1 = 0
    // idx2 = 1, 2
    // 5 == 7?
    public static int minSubArrayLenFast(int target, int[] nums) {
        int result = nums.length;
        int idx1 = 0;
        int idx2 = 1;
        int sum = 0;
        if(nums[0] == target){
            return 1;
        }
        sum = nums[0];
        while(idx1 < nums.length && idx2 < nums.length) {
            sum += nums[idx2];
            if(sum < target) {
                idx2++;
            }else if(sum > target) {
                sum = sum - nums[idx1];
                sum = sum - nums[idx2];
                idx1++;
            }else { // sum == target
                result = Math.min(result, idx2 - idx1 + 1);
                sum = sum - nums[idx1];
                sum = sum - nums[idx2];
                idx1++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println("result : " + minSubArrayLenFast(target, nums));
    }
}
