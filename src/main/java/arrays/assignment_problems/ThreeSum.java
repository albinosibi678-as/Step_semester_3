import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    public static void printResult(int[][] triplets) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < triplets.length; i++) {
            sb.append("[");
            for (int j = 0; j < triplets[i].length; j++) {
                sb.append(triplets[i][j]);
                if (j < triplets[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i < triplets.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        printResult(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        printResult(threeSum(new int[]{0, 0, 0}));
    }
}