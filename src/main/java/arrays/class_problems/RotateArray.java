public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        k = k % nums.length;
        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        return newArray;
    }

    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        printArray(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        printArray(rotateArray(new int[]{1, 2}, 3));
    }
}