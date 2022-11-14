package home;

import java.io.*;
class random {
   double rand(int lb,int ub){
       ub++;
       double size=ub-lb;
       return Math.floor(Math.random()*size)+lb;
   }
   
   public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the lower bound and upper bound");
        random ob=new random();
        int lb=Integer.parseInt(br.readLine());
        int ub=Integer.parseInt(br.readLine());
        System.out.println("press enter to generate next number or any character to terminate");
        double r;
        do{
            r=ob.rand(lb,ub);
            System.out.print(r);
        }
        while(br.readLine().isEmpty());
    }
}