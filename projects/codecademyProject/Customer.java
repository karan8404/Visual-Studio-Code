package codecademyProject;
// Create Customer class here
public class Customer{
    private String name;
    private int money;
  
    public Customer(String name,int money){
      this.name=name;
      this.money=money;
    }
  
  //setters and getters for name
    public void setName(String name){
      this.name=name;
    }
    public String getName(){
      return this.name;
    }
  
  //setters and getters for money
    public void setMoney(int money){
      this.money=money;
    }
    public int getMoney(){
      return this.money;
    }
  }
