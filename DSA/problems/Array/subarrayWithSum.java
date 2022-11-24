package Array;
import java.util.HashMap;

//find subarray with given sum k, video-28.
public class subarrayWithSum {
    public int subarraySum(int nums[], int target) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {// putting the sum of numbers in the hashmap.
            sum += nums[i];
            map.put(sum, i);
        }
        if (map.containsKey(target)) {// checking if the map already contains reqd target
            // System.out.println(0+","+map.get(target));
            res++;
        }

        if (n == 1)
            return res;

        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if (map.containsKey(currSum + target) && (i + 1) <= map.get(currSum + target)) {
                // System.out.println(i+1+","+map.get(currSum+target));
                res++;
            }
        }
        return res;
    }
}
