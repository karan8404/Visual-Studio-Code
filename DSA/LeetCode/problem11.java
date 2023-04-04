public class problem11 {
    // maximize trapped rainwater
    public int maxArea(int[] height) {
        int front = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (front != end) {
            maxArea = Math.max(maxArea, (end - front) * Math.min(height[front], height[end]));

            if (height[front] < height[end])
                front++;
            else
                end--;
        }

        return maxArea;
    }
}
