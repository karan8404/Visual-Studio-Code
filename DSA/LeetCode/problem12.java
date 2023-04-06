public class problem12 {
    public String intToRoman(int num) {
        String roman = "";
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i=0;i<nums.length;i++){
            while(num>=nums[i]){
                roman+=chars[i];
                num-=nums[i];
            }
        }
        return roman;
    }
}