import java.util.HashMap;

//count distinct elements in a window of size k of an arra.
//video 29.
public class CountDistinctElements{
    public static void countDistinctElements(int nums[],int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>(n);
        for(int i=0;i<k;i++){//putting initial elements in the map.
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        System.out.println(map.size());
        System.out.println(map);

        for(int i=1;i<n-k+1;i++){
            map.put(nums[i-1], map.get(nums[i-1])-1);//reducing count of last element by 1.
            if(map.get(nums[i-1])==0){//removing element if count is 0.
                map.remove(nums[i-1]);
            }

            if(map.containsKey(nums[i+k-1])){
                map.put(nums[i+k-1], map.get(nums[i+k-1])+1);
            }
            else{
                map.put(nums[i+k-1], 1);
            }
            System.out.println(map.size());
            System.out.println(map);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,2,1,3,1,1,3};
        int k=4;
        countDistinctElements(nums, k);
    }
}