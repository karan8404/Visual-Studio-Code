//Buy and sell stocks-1.
public class problem121 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minPrice=prices[0];
        int maxProfit=0;
        
        for(int i=1;i<n;i++){
            if(prices[i]<minPrice) minPrice=prices[i];
            if(prices[i]-minPrice > maxProfit)maxProfit=prices[i]-minPrice;
        }
        
        return maxProfit;
    }
}