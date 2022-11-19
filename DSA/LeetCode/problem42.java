//Trapping rainwater.
public class problem42 {
    public int trap(int[] height) {
        // initializing left and right arrays
        int n = height.length;
        if (n < 3)
            return 0;

        int left[] = new int[n];
        left[0] = height[0];
        int right[] = new int[n];
        right[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
            right[n - 1 - i] = Math.max(right[n - i], height[n - 1 - i]);
        }
        // calculating the ans
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }
}