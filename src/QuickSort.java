public class QuickSort {
    public void quickSort(int[] array, int lowArrayValueIndex, int highArrayValueIndex){
        if (lowArrayValueIndex<highArrayValueIndex){
            int pivot = partition(array,lowArrayValueIndex,highArrayValueIndex);

            quickSort(array, lowArrayValueIndex, pivot - 1);
            quickSort(array, pivot + 1, highArrayValueIndex);
        }
    }

    private int partition(int[] array, int lowArrayValueIndex, int highArrayValueIndex) {
        int pivot = array[highArrayValueIndex];
        int lowerThanLowArrayValueIndex = lowArrayValueIndex - 1;
        for (int currentArrayValueIndex = lowArrayValueIndex; currentArrayValueIndex < highArrayValueIndex; currentArrayValueIndex++){
            if (array[currentArrayValueIndex] < pivot){
                lowerThanLowArrayValueIndex++;
                int temporaryVariable = array[lowerThanLowArrayValueIndex];
                array[lowerThanLowArrayValueIndex] = array[currentArrayValueIndex];
                array[currentArrayValueIndex] = temporaryVariable;
            }
        }
        int temporaryVariable = array[lowerThanLowArrayValueIndex + 1];
        array[lowerThanLowArrayValueIndex + 1] = array[highArrayValueIndex];
        array[highArrayValueIndex] = temporaryVariable;

        return lowerThanLowArrayValueIndex + 1;
    }
}
