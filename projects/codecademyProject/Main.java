package codecademyProject;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    System.out.println("Enter customer name.");
    String customerName=input.next();
    System.out.println("Enter amount of money owned by customer");
    int money=input.nextInt();
    Customer customer=new Customer(customerName,money);
    TakeOutSimulator takeOutSimulator=new TakeOutSimulator(customer,input);
    takeOutSimulator.startTakeOutSimulator();
    }    
}

