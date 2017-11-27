package ucl.cs.Context;

import org.junit.Test;
import ucl.cs.matchers.IterableBeginsWith;
import ucl.cs.strategy.FibonacciStrategy;
import ucl.cs.strategy.SequenceStrategy;
import ucl.cs.strategy.TriangleNumberStrategy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

/**
 * Created by cosmi_owugxv5 on 11/27/2017.
 */
public class SequenceContextTest {

    FibonacciStrategy strategyf= new FibonacciStrategy();
    TriangleNumberStrategy strategyt = new TriangleNumberStrategy();
    SequenceContext contextf = new SequenceContext(strategyf);
    SequenceContext contextt = new SequenceContext(strategyt);

    @Test
    public void definesFirstTwoTermsToBeOneFAndFirstTermToBeOneT() {

        assertThat(contextf.term(0), is(1));
        assertThat(contextf.term(1), is(1));

        assertThat(contextt.term(0), is(1));
        assertThat(contextt.term(1), not(1));
    }

    @Test
    public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {

        assertThat(contextf.term(2), is(2));
        assertThat(contextf.term(3), is(3));
        assertThat(contextf.term(4), is(5));
    }

    public void definesTermsTriangle() {
        assertThat(contextt.term(1), is(3));
        assertThat(contextt.term(2), is(6));
        assertThat(contextt.term(3), is(10));
        assertThat(contextt.term(4), is(15));
    }

    @Test
    public void isUndefinedForNegativeIndices() {

        try {
            contextt.term(-1);
            fail("should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
        }
        try {
            contextf.term(-1);
            fail("should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
        }
    }

    @Test
    public void canBeIteratedThroughF() {
        assertThat(contextf, IterableBeginsWith.beginsWith(1, 1, 2, 3, 5));
    }

    @Test
    public void canBeIteratedThroughT() {
        assertThat(contextt, IterableBeginsWith.beginsWith(1, 3, 6, 10, 15));
    }
}
