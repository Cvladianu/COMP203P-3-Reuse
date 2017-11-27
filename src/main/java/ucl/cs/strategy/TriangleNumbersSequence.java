package ucl.cs.strategy;


import java.util.Iterator;

public class TriangleNumbersSequence extends ucl.cs.templatemethod.FibonacciSequence {

  public int term(int i) {
    if (i < 0) {
      throw new IllegalArgumentException("Not defined for indices < 0");
    }
    if (i < 1) {
      return 1;
    }
    return (i+1)*(i+2)/2;
  }
}
