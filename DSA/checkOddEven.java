import java.util.*;

class checkOddEven {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to be checked for being odd or even");
        int num = sc.nextInt();

        if ((num & 1) == 1) {
            System.out.println("Odd number");
        } else {
            System.out.println("even number");
        }
        sc.close();
    }
}