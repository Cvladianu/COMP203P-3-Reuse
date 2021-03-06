package ucl.cs.strategy;

import java.util.Iterator;

public class FibonacciSequence extends ucl.cs.templatemethod.FibonacciSequence {

  public int term(int i) {
    if (i < 0) {
      throw new IllegalArgumentException("Not defined for indices < 0");
    }
    if (i < 2) {
      return 1;
    }
    return term(i - 1) + term(i - 2);
  }
}
