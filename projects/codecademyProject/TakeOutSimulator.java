package codecademyProject;

import java.util.Scanner;

// Create TakeOutSimulator class here
public class TakeOutSimulator{
  private Customer customer;
  private FoodMenu foodMenu=new FoodMenu();
  private Scanner input;

  public TakeOutSimulator(Customer customer,Scanner input){
    this.customer=customer;
    this.input=input;
  }

  private <T> T getOutputOnIntInput(String userInputPrompt,IntUserInputRetriever<T> intUserInputRetriever){
    while(true){
      System.out.println(userInputPrompt);

      if(input.hasNextInt()){
        int received=input.nextInt();

        try{
          return (T)intUserInputRetriever.produceOutputOnIntUserInput(received);
        }
        catch(IllegalArgumentException i){
          System.out.println(i);
        }
      }
      else{
        System.out.println("Given input was not an 'int' type");
      }
    }
  }

  public boolean shouldSimulate() {
        String userPrompt = "Please, type 1 to PROCEED or 0 to STOP the simulation";
        
        IntUserInputRetriever<Boolean> intUserInputRetriever=(selection)->{
          if(selection==1&&customer.getMoney()>=foodMenu.getLowestCostFood().getPrice()){
            System.out.println("Conditions met, simulation started.");
            return true;
          }
          else if(selection==0){
            System.out.println("You don't want to coninue, simulation ended");
            return false;
          }
          else if(selection==1&&customer.getMoney()<foodMenu.getLowestCostFood().getPrice()){
            System.out.println("You dont have enough money, simulation ended");
            return false;
          }
          else{
            throw new IllegalArgumentException("Invalid selection");
          }
        };

        return getOutputOnIntInput(userPrompt,intUserInputRetriever);
    }

    public Food getMenuSelection(){
      String userPrompt="input the int index one of the food items displayed in the menu";
      int i=1;
      for(Food item:foodMenu.menu){
        System.out.println(i+"."+item);
        i++;
      }

      IntUserInputRetriever<Food> intUserInputRetriever=(selection)->{
        if((foodMenu.getFood(selection)==null)){
          throw new IllegalArgumentException("Invalid selection");
        }
        else{
          return foodMenu.getFood(selection);
        }
      };

      return getOutputOnIntInput(userPrompt,intUserInputRetriever);
    }

    public boolean isStillOrderingFood(){
      String userPrompt="input 1 to continue shopping or 0 to checkout";

      IntUserInputRetriever<Boolean> intUserInputRetreiver=(selection)->{
        if(selection==1){return true;}
        else if(selection==0){return false;}
        else{throw new IllegalArgumentException("Invalid input, enter 1 or 0.");}
      };

      return getOutputOnIntInput(userPrompt,intUserInputRetreiver);
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag){
      System.out.println("The payment is being processed");
      shoppingBag.display();
      
      int remainingMoney=customer.getMoney()-shoppingBag.getTotalPrice();
      customer.setMoney(remainingMoney);
      System.out.println("Amount of money remaining after payment:"+customer.getMoney());
      System.out.println("Enjoy your meal");

    }

    public void takeOutPrompt(){
      ShoppingBag<Food> shoppingBag=new ShoppingBag<>();
      int customerMoneyLeft=customer.getMoney();
      Food selectedFood;
      do{
        System.out.println("Amount of money left:"+customerMoneyLeft);
        selectedFood=this.getMenuSelection();
        if(customerMoneyLeft>=selectedFood.getPrice()){
          shoppingBag.addItem(selectedFood);
          customerMoneyLeft=customerMoneyLeft-selectedFood.getPrice();
        }
        else{
          System.out.println("Not enough money, select a different food item or checkout");
        }
      }
        while(isStillOrderingFood());
        this.checkoutCustomer(shoppingBag);
        System.out.println("Checked out successfully");
      }

    public void startTakeOutSimulator(){
      while(this.shouldSimulate()){
        System.out.println("Hello and welcome to my restaurant");
        System.out.println("Welcome "+customer.getName());
        this.takeOutPrompt();
      }
    }
  }