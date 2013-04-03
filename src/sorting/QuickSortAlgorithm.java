package sorting;

/**
 * @author Edward Yue Shung Wong
 */
public class QuickSortAlgorithm implements SortAlgorithm {

    @Override
    public int[] sortArray(int[] arrayUnderSort) {
        quickSort(arrayUnderSort, 0, arrayUnderSort.length - 1);
        return arrayUnderSort;
    }

    private void quickSort(int[] arrayUnderSort, int left, int right) {
        if (left < right) {
            int pivotNewIndex = partition(arrayUnderSort, left, right);
            quickSort(arrayUnderSort, left, pivotNewIndex - 1);
            quickSort(arrayUnderSort, pivotNewIndex + 1, right);
        }
    }

    private int partition(int[] arrayUnderSort, int left, int right) {
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

    private int generateRandomIntegerBetween(int lowerBound, int upperBound) {
        return lowerBound + (int) (Math.random() * (upperBound - lowerBound));
    }

    private void swapArrayElements(int[] arrayUnderSort, int firstIndex, int secondIndex) {
        int swapValue = arrayUnderSort[secondIndex];
        arrayUnderSort[secondIndex] = arrayUnderSort[firstIndex];
        arrayUnderSort[firstIndex] = swapValue;
    }
}
