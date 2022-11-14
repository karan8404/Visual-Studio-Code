package codecademyProject;

import java.util.ArrayList;
import java.util.List;

// Create FoodMenu class here
class FoodMenu{
  public List<Food> menu=new ArrayList<>();

  Food idli=new Food("Idli","delicious steamed Idli",10);
  Food dosa=new Food("Dosa","Steamy crunchy Dosa",50);
  Food chapati=new Food("Chapati","Yummy fluffy Chapati",5);
  Food fishCurry=new Food("Fish Curry","badbu aayega",70);
  Food friedRice=new Food("Fried Rice","Steamy fried rice,hot and sexy",60);
  Food paanchale=new Food("Paanchale Guha","sexy, cute, hot, big boobies, paanchale guha",Integer.MAX_VALUE);

  public FoodMenu(){
  menu.add(idli);
  menu.add(dosa);
  menu.add(chapati);
  menu.add(fishCurry);
  menu.add(friedRice);
  menu.add(paanchale);
  }

  public String toString(){
    String foodMenu="";
    int i=1;
    for(Food item: menu){
      foodMenu=foodMenu+i+". Enjoy "+item.getName()+": "+item.getDescription()+"    Cost: "+item.getPrice()+"/n";
      i++;
    }
    return foodMenu;
  }

  public Food getFood(int index){
    try{
      return menu.get(index-1);
    }
    catch(IndexOutOfBoundsException e){
      return null;
    }
  }

  public Food getLowestCostFood(){
    Food lowest=null;
    for(Food item: menu){
      if(lowest==null||item.getPrice()<lowest.getPrice()){
        lowest=item;
      }
    }
    return lowest;
  }
}
