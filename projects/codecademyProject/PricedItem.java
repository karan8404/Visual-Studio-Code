package codecademyProject;

// Create PricedItem interface here
public interface PricedItem<T>{
    public T getPrice();
  
    public void setPrice(T price);
  }
