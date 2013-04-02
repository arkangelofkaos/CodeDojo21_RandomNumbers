import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Edward Yue Shung Wong
 */
public class SortedRandomNumberGeneratorTest {

    private SortedRandomNumberGenerator sortedRandomNumberGenerator;

    @Before
    public void setUp() {
        sortedRandomNumberGenerator = new SortedRandomNumberGenerator();
    }

    private void assertArrayIsSorted(int[] initialArray) {
        for (int i = 1; i < initialArray.length; ++i) {
            int currentNumber = initialArray[i - 1];
            int nextNumber = initialArray[i];
            assertTrue(currentNumber <= nextNumber);
        }
    }

    @Test
    public void shouldCreateArrayOfSize100k() {
        int[] initialArray = sortedRandomNumberGenerator.createInitialArray();
        assertNotNull(initialArray);
    }

    @Test
    public void shouldGenerateARandomNumberInRange() {
        int number = sortedRandomNumberGenerator.generateRandomNumber();
        assertTrue(number >= 0);
        assertTrue(number < sortedRandomNumberGenerator.MAXIMUM_NUMBER);
    }

    @Test
    public void shouldPopulateArrayWithRandomNumbers() {
        int[] initialArray = sortedRandomNumberGenerator.createInitialArray();
        sortedRandomNumberGenerator.populateArrayWithRandomNumbers(initialArray);

        for (int i = 0; i < sortedRandomNumberGenerator.RANDOMNESS_CHECK_LIMIT; i++) {
            int currentNumber = initialArray[i];
            int nextNumber = initialArray[i + 1];

            assertTrue(currentNumber != nextNumber);
        }
    }

    @Test
    public void shouldGenerateSortedArray() {
        int[] initialArray = sortedRandomNumberGenerator.createInitialArray();
        sortedRandomNumberGenerator.populateArrayWithRandomNumbers(initialArray);
        sortedRandomNumberGenerator.sortArray(initialArray);

        assertArrayIsSorted(initialArray);
    }

    @Test
    public void shouldQuickSortArrayOfSize5() {
        int[] simpleArray = new int[] {3, 2, 5, 1, 4};
        sortedRandomNumberGenerator.sortArray(simpleArray);
        assertArrayIsSorted(simpleArray);
    }

}
