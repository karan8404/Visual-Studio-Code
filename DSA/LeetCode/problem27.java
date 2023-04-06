class Solution {
    public int removeElement(int[] nums, int val) {
        int index=nums.length-1;

        for(int i=0;i<=index;i++)
            if(nums[i]==val)
                nums[i--]=nums[index--];
                
        return index+1;
    }
}