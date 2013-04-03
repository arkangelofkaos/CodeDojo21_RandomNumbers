package sorting;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Edward Yue Shung Wong
 */
public class LambdaSortAlgorithm implements SortAlgorithm {

    public int[] sortArray(int[] unsortedArray) {
        int length = unsortedArray.length;

        Collection<Integer> randomIntegersList = new ArrayList<>(length);
        for (Integer integer : unsortedArray) {
            randomIntegersList.add(integer);
        }

        Integer[] sortedBoxedArray = randomIntegersList
                .parallelStream()
                .sorted()
                .toArray(i -> new Integer[length]);

        int[] sortedArray = new int[length];
        for (int i = 0; i < length; i++) {
            sortedArray[i] = sortedBoxedArray[i];
        }

        return sortedArray;
    }
}
