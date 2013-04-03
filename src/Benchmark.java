import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Edward Yue Shung Wong
 */
public class Benchmark {

    public static final int WARM_UP_ITERATIONS = 1000;
    public static final int NUMBER_OF_RANDOM_NUMBERS = 100_000;
    public static final int MAX_RANDOM_NUMBER = 1_000_000_000;

    public static void main(String[] args) {
        Integer[] sortedIntegers = new Integer[0];

        for (int j = 0; j <= WARM_UP_ITERATIONS; j++) {
            long zeroTime = System.currentTimeMillis();

            int[] randomIntegers = createRandomNumberList();

            long randomTime = System.currentTimeMillis();

            sortedIntegers = sortRandomIntegerListIntoOrderedArray(randomIntegers);

            if (WARM_UP_ITERATIONS <= j) {
                long completionTime = System.currentTimeMillis();

                long randomGenerationTime = randomTime - zeroTime;
                System.out.println("Random Generation Time: " + randomGenerationTime);

                long sortTime = completionTime - randomTime;
                System.out.println("Sort time: " + sortTime);

                long executionTime = completionTime - zeroTime;
                System.out.println("Duration: " + executionTime);
            }
        }

        for (int i = 1; i < sortedIntegers.length; i++) {
            Integer sortedInteger = sortedIntegers[i - 1];
            assert sortedInteger <= sortedIntegers[i];
        }
    }

    private static int[] createRandomNumberList() {
        int[] randomIntegers = new int[NUMBER_OF_RANDOM_NUMBERS];

        for (int i = 0; i < NUMBER_OF_RANDOM_NUMBERS; i++) {
            randomIntegers[i] = getRandomIntegerBetweenZeroAndMax();
        }
        return randomIntegers;
    }

    private static Integer[] sortRandomIntegerListIntoOrderedArray(int[] randomIntegers) {
        Collection<Integer> randomIntegersList = new ArrayList<>(randomIntegers.length);
        for (Integer randomInteger : randomIntegers) {
            randomIntegersList.add(randomInteger);
        }
        Integer[] randomSortedIntegersArray = randomIntegersList
                .parallelStream()
                .sorted()
                .toArray(_ -> new Integer[NUMBER_OF_RANDOM_NUMBERS]);
        return randomSortedIntegersArray;
    }

    private static int getRandomIntegerBetweenZeroAndMax() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER);
    }

}
