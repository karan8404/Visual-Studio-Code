package codecademyProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// Create ShoppingBag class here
public class ShoppingBag<T extends PricedItem<Integer>>{
  private Map<T,Integer> shoppingBag=new HashMap<>();

  void addItem(T item){
    Integer quantity=shoppingBag.get(item);
    if(quantity==null){
      shoppingBag.put(item,1);
    }
    else{
      shoppingBag.put(item,quantity+1);
    }
  }

  int getTotalPrice(){
    int total=0;
    for(Entry<T,Integer> pair: shoppingBag.entrySet()){
      total=total+pair.getKey().getPrice()*pair.getValue();
    }
    return total;
  }

  public void display(){
    System.out.println("Food purchased: ");
    int i=1;

    for (Map.Entry<T,Integer> pair : shoppingBag.entrySet()) {
      System.out.printf("%d. %s(s)-%d\n",i,((Food)pair.getKey()).getName(),pair.getValue());
    }
  }
}
