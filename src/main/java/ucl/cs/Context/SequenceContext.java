package ucl.cs.Context;

import ucl.cs.strategy.SequenceStrategy;
import ucl.cs.templatemethod.FibonacciSequence;

import java.util.Iterator;

/**
 * Created by cosmi_owugxv5 on 11/27/2017.
 */
public class SequenceContext implements Iterable<Integer> {
    private SequenceStrategy strategy;

    public SequenceContext(SequenceStrategy strategy) {
        this.strategy = strategy;
    }

    public int term(int i)
    {
        return strategy.term(i);
    }

    public Iterator<Integer> iterator() {
        return new SequenceIterator();
    }

    private class SequenceIterator implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return strategy.term(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }
}
