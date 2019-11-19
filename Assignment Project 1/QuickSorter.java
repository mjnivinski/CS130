package cs130.NLargest;


public class QuickSorter {
    public QuickSorter(){

    }

    public void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int min, int max){
        if (min < max){
            int indexOfPartition = partition(array, min, max);

            quickSort(array, min, indexOfPartition - 1);

            quickSort(array, indexOfPartition + 1, max);
        }
    }

    private int partition(int[] array, int min, int max){
        int partitionElement;
        int left, right;
        int middle = (min + max)/2;

        partitionElement = array[middle];

        int temp = array[middle];
        array[middle] = array[min];
        array[min] = temp;

        left = min;
        right = max;

        while(left < right) {
            while (left < right && array[left] <= partitionElement) {
                left++;

            }

            while (array[right] > partitionElement) {
                right--;
            }

            if (left < right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        temp = array[min];
        array[min] = array[right];
        array[right] = temp;

        return right;

    }
}
