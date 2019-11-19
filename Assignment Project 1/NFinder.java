package cs130.NLargest;

public class NFinder {

    private int[] array1;
    private int[] array2;

    private int firstMin, firstMax;
    private int secondMin, secondMax;

    //constructor class, acquires default mins and maxes for recursive entrance.
    public NFinder(int[] array1, int[] array2){
        this.array1 = array1;
        this.array2 = array2;
        firstMin = secondMin = 0;
        firstMax = array1.length-1;
        secondMax = array2.length-1;
    }

    //checking for valid lists (does not check to see if list is ordered)
    public int findNLargest(int n){
        if(n > array1.length + array2.length){
            System.out.println("N too large for these arrays");
            return 0;
        } else if(n <= 0) {
            System.out.println("N is too small");
            return 0;
        }

        //if it just so happens to have an array that is empty we answer that question with O(1)
        if(array1.length == 0) return array2[array2.length - n];
        else if(array2.length == 0) return array1[array1.length - n];

        //enter recursive algorithm
        return findLargest(n, firstMin, firstMax, secondMin, secondMax);
    }

    //Recursive algorithm that divides the arrays and determines which division has answer then called again on remaining numbers
    //The larger array is split in half by a midpoint.
    //Then perform a binary search into the second array using the larger arrays midpoint.
    //Because this is the location where an answer could be to our problem there is a relative N value to those two numbers
    //If this respective N is larger than the actual N value, then we know the actual answer must be to the right of each bisection.
    //If it is lower then the opposite is true, it must be to the left.
    //So we call the method again with the bisections as either new mins or new maxes to have a much smaller section.
    //when both mins are neighbors or both pairs equal we call a final checker to make sure we get the right value.
    //Because the binary searcher does not find the exact relative position we need to do a safety check at the very end.
    private int findLargest(int n, int min1, int max1, int min2, int max2) {

        //final check at beginning to see if we have collected 4 or fewer possible answers
        if(min1+1>=max1 && min2+1>=max2){
            return finalCheck(n, max1, max2);
        }

        int bisector1, bisector2;

        //this section determines which array will be cut in half and which will be searched for the respective bisector
        if(max1 - min1 >= max2 - min2){
            bisector1 = (max1 + min1) /2;
            bisector2 = binarySearch(array2, min2, max2, array1[bisector1]);
        }
        else {
            bisector2 = (max2 + min2) /2;
            bisector1 = binarySearch(array1, min1, max1, array2[bisector2]);
        }

        //the distance to the right hand end of the array is calculated here for both arrays
        //then checked against n to see if the answer is to the left of the bisections, or to the right
        //if it is above the number, the right hand remaining section must be where the answer is
        if(array1.length + array2.length - bisector1 - bisector2 > n){
            if(max1 - min1 >= max2 - min2){
                return findLargest(n, bisector1, max1, bisector2, max2);
            } else return findLargest(n, bisector1, max1, bisector2, max2);
        } else {
            if(max1 - min1 >= max2 - min2) {
                return findLargest(n, min1, bisector1, min2, bisector2);
            } else return findLargest(n, min1, bisector1, min2, bisector2);
        }
    }

    //the previous algorithm finds pairs of numbers that could be the answer. possible a pair and a single, or two pairs.
    //this does a very rudimentary check to find the correct answer
    //it takes the possible numbers, sorts them. and then based on a calculated n value returns the correct value.
    private int finalCheck(int n, int max1, int max2){

        //this represents all the numbers that are guaranteed not to be the answer.
        //the distance to the end of the array for each array from max is all the right hand numbers the answer cannot be

        n = n - (array1.length + array2.length - max1 - max2 - 2);

        int x0, x1, x2, x3;
        x0 = x1 = x2 = x3 = 0;

        //assigning all the values into 4 variables
        x0 = array1[max1];
        x1 = array2[max2];
        //sometimes the pairs are both assigned to the end of the list, so the lower hand value is checked for vailidity
        if(max1 > 0){
            x2 = array1[max1-1];
        }
        if(max2 > 0){
            x3 = array2[max2-1];
        }

        //put into an array, sorted and returned based on previous n calculation
        int[] array = new int[]{x0, x1, x2,x3};

        sorter(array);

        if(n==3){
            return array[1];
        } else if(n==2){
            return array[2];
        } else return array[3];
    }

    //binary style searched for where a respective element would be placed in the other array
    private int binarySearch(int[] array, int min, int max, int target){

        //because there is often not an answer that is equal to our target,
        //this algorithm is deisgned to find the element that it would go after in the array
        //because sometimes that is smaller than anything in the list it could bisect at a value that is not ideal.
        //however the final check handles 4 possible answers so this is not really an issue.
        if(target >= array[max]) return max;
        else if(target < array[min]) return min;
        if(min + 1 == max) return min;

        int midPoint = (min + max) / 2;

        if(target > array[midPoint]){
            return binarySearch(array, midPoint, max, target);
        }else return binarySearch(array, min, midPoint, target);
    }

    //bubble sort algorithm for final check
    private void sorter(int[] array){

        for (int i = 0; i < array.length-1; i++)
            for (int j = 0; j < array.length-i-1; j++)
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
    }
}