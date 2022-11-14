package codecademyProject;

// Create IntUserInputRetriever interface here
public interface IntUserInputRetriever<T>{

    public T produceOutputOnIntUserInput(int selection)throws IllegalArgumentException;
  }
