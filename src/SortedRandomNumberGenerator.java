/**
 * @author Edward Yue Shung Wong
 */
public class SortedRandomNumberGenerator {

    public static final int MAXIMUM_SIZE = 100_000;
    public static final int MAXIMUM_NUMBER = 1_000_000_000;

    public static final int RANDOMNESS_CHECK_LIMIT = 10;
    public static final int WARM_UP_ITERATIONS = 1000;

    public static void main(String... ignored) {

        for (int i = 0; i <= WARM_UP_ITERATIONS; i++) {
            long zeroTime = System.currentTimeMillis();
            int[] initialArray = createInitialArray();

            populateArrayWithRandomNumbers(initialArray);
            long randomNumbersGeneratedTimepoint = System.currentTimeMillis();

            sortArray(initialArray);


            if (i == WARM_UP_ITERATIONS) {
                long afterTime = System.currentTimeMillis();

                long timeToGenerateRandomNumbers = randomNumbersGeneratedTimepoint - zeroTime;
                System.out.println("Time to generate random numbers: " + timeToGenerateRandomNumbers);

                long sortingTime = afterTime - randomNumbersGeneratedTimepoint;
                System.out.println("Time to sort random numbers: " + sortingTime);

                long timeToExecute = afterTime - zeroTime;
                System.out.println("Total time in nanos:" + timeToExecute);
            }
        }


    }

    public static int[] createInitialArray() {
        return new int[MAXIMUM_SIZE];
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * MAXIMUM_NUMBER);
    }

    public static void populateArrayWithRandomNumbers(int[] initialArray) {
        for (int i = 0; i < initialArray.length; i++) {
            initialArray[i] = generateRandomNumber();
        }
    }

    public static void sortArray(int[] arrayUnderSort) {
        quickSort(arrayUnderSort, 0, arrayUnderSort.length - 1);
    }

    private static void quickSort(int[] arrayUnderSort, int left, int right) {
        if (left < right) {
            int pivotNewIndex = partition(arrayUnderSort, left, right);
            quickSort(arrayUnderSort, left, pivotNewIndex - 1);
            quickSort(arrayUnderSort, pivotNewIndex + 1, right);
        }
    }

    private static int partition(int[] arrayUnderSort, int left, int right) {
        int pivotIndex = generateRandomIntegerBetween(left, right);
        int pivotElement = arrayUnderSort[pivotIndex];
        swapArrayElements(arrayUnderSort, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; ++i) {
            if (arrayUnderSort[i] <= pivotElement) {
                swapArrayElements(arrayUnderSort, storeIndex, i);
                ++storeIndex;
            }
        }

        swapArrayElements(arrayUnderSort, right, storeIndex);

        return storeIndex;
    }

    private static int generateRandomIntegerBetween(int lowerBound, int upperBound) {
        return lowerBound + (int) (Math.random() * (upperBound - lowerBound));
    }

    private static void swapArrayElements(int[] arrayUnderSort, int firstIndex, int secondIndex) {
        int swapValue = arrayUnderSort[secondIndex];
        arrayUnderSort[secondIndex] = arrayUnderSort[firstIndex];
        arrayUnderSort[firstIndex] = swapValue;
    }

}
