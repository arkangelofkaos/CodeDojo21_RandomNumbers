package random.generator;

/**
 * @author Edward Yue Shung Wong
 */
public class RandomNumberArrayGenerator implements IRandomNumberArrayGenerator {

    @Override
    public int[] create(int arraySize, int maxRandomValue) {
        int[] randomIntegers = createEmptyArray(arraySize);
        for (int i = 0; i < arraySize; i++) {
            randomIntegers[i] = generateRandomNumber(maxRandomValue);
        }
        return randomIntegers;
    }

    private static int[] createEmptyArray(int arraySize) {
        return new int[arraySize];
    }

    private static int generateRandomNumber(int maxRandomValue) {
        return (int) (Math.random() * maxRandomValue);
    }

}
