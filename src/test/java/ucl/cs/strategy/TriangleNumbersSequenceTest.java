package ucl.cs.strategy;

import org.junit.Test;
import ucl.cs.matchers.IterableBeginsWith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Created by cosmi_owugxv5 on 11/27/2017.
 */
public class TriangleNumbersSequenceTest {
    final TriangleNumbersSequence sequence = new TriangleNumbersSequence();

    @Test
    public void definesFirstTermToBeOne() {

        assertThat(sequence.term(0), is(1));
        assertThat(sequence.term(1), not(1));
    }

    @Test
    public void definesTermsEqualToFormula() {

        assertThat(sequence.term(1), is(3));
        assertThat(sequence.term(2), is(6));
        assertThat(sequence.term(3), is(10));
        assertThat(sequence.term(4), is(15));
    }

    @Test
    public void isUndefinedForNegativeIndices() {

        try {
            sequence.term(-1);
            fail("should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
        }
    }

    @Test
    public void canBeIteratedThrough() {
        assertThat(sequence, IterableBeginsWith.beginsWith(1, 3, 6, 10, 15));
    }
}
