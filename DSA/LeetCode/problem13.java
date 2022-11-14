import java.util.*;
//Roman numerals to integers.
public class problem13 {
    
    public int romanToInt(String s) {
        Map<Character,Integer> romanNumerals=new HashMap<>();
        romanNumerals.put('I',1);
        romanNumerals.put('V',5);
        romanNumerals.put('X',10);
        romanNumerals.put('L',50);
        romanNumerals.put('C',100);
        romanNumerals.put('D',500);
        romanNumerals.put('M',1000);
        
        int number=0;
        
        for(int i=0;i<s.length()-1;i++){
            char roman=s.charAt(i);
            char nextRoman=s.charAt(i+1);
            
            if(romanNumerals.get(nextRoman) <= romanNumerals.get(roman)){
                number+=romanNumerals.get(roman);
            }
            else{
                number-=romanNumerals.get(roman);
            }
        }
        number+=romanNumerals.get(s.charAt(s.length()-1));
        
        return number;
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println(new problem13().romanToInt(sc.next()));
        sc.close();
    }
}