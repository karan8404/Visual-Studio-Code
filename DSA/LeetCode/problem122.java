//Buy and sell stocks-2.
public class problem122 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0;
        int current=0;
        boolean buying=true;
        int i=0;
        
        try{
            for(i=0;i<n;i++){
                
                if(buying){
                    if(prices[i]<prices[i+1]){
                        current=prices[i];
                        buying=false;
                    }
                }
                
                else{
                    if(prices[i]>prices[i+1]){
                        profit+=prices[i]-current;
                        buying=true;
                    }
                }
            }
        }
        catch(Exception e){
            if(!buying)
                profit+=prices[i]-current;
        }
        
        return profit;
    }
}