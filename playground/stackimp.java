package playground;
import java.util.*;

public class stackimp{

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Integer> st=new Stack<Integer>();
        System.out.println("Enter push, peek, pop, print or stop.");
        String c="";
        label:
        while(true){
            c=sc.next();
            switch (c) {
                case "push":
                    System.out.println("Enter the number to be pushed into the stack");
                    st.push(sc.nextInt());
                    break;
                case "peek":
                    System.out.println(st.peek());
                    break;
                case "pop":
                    System.out.println("popped element "+st.pop());
                    break;
                case "print":
                    System.out.println(st.toString());
                    break;
                case "stop":
                    System.out.println("exited successfully");
                    break label;
                default:
                    System.out.println("Invalid input,Enter push, peek, pop, print or stop.");
                    break;
            }
        }
        sc.close();
        
    }
}
