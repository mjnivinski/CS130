package cs130.NLargest;


//placeholder class for organization
public class NLargest {
    private int[] array1;
    private int[] array2;

    public NLargest(int[] array1, int[] array2){
        this.array1 = array1;
        this.array2 = array2;
    }

    public int findLargestN(int n){

        NFinder finder = new NFinder(array1, array2);

        return finder.findNLargest(n);
    }
}
