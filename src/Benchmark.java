import random.generator.IRandomNumberArrayGenerator;
import random.generator.RandomNumberArrayGenerator;
import sorting.QuickSortAlgorithm;
import sorting.SortAlgorithm;

/**
 * @author Edward Yue Shung Wong
 */
public class Benchmark {

    public static final int WARM_UP_ITERATIONS = 1000;
    public static final int NUMBER_OF_RANDOM_NUMBERS = 100_000;
    public static final int MAX_RANDOM_NUMBER = 1_000_000_000;
    public static final int NUMBER_OF_SAMPLE_ITERATIONS = 5;

    private static IRandomNumberArrayGenerator randomNumberArrayGenerator = new RandomNumberArrayGenerator();
    private static SortAlgorithm sortAlgorithm
//            = new LambdaSortAlgorithm();
            = new QuickSortAlgorithm();

    public static void main(String[] args) {
        int[] sortedIntegers = new int[0];

        for (int j = 0; j <= WARM_UP_ITERATIONS + NUMBER_OF_SAMPLE_ITERATIONS; j++) {
            long zeroTime = System.currentTimeMillis();

            int[] randomIntegers = randomNumberArrayGenerator.create(NUMBER_OF_RANDOM_NUMBERS, MAX_RANDOM_NUMBER);

            long randomTime = System.currentTimeMillis();

            sortedIntegers = sortAlgorithm.sortArray(randomIntegers);

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
            int sortedInteger = sortedIntegers[i - 1];
            assert sortedInteger <= sortedIntegers[i];
        }
    }

}
