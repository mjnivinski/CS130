package cs130.compressor;

// Write a program that stores an array nxm  in less space than nxm  given that the numbers in the area are repeated a lot


import java.util.Arrays;

public class Compressor {
    int[][] picture;
    int[][] compressed;



    //constructor
    public Compressor(int[][] picture){
        this.picture = picture;
    }



    //compresses the array of integers that was the argument in the constructor
    public int[][] compress(){
        compressed = new int[picture.length][];

        for(int i=0; i<compressed.length; i++){
            compressRow(i, picture[i]);
        }

        return compressed;
    }

    //function called to decompress an array returns an array of integer arrays decompressed
    public int[][] decompress(int[][] compressed){
        int[][] decompressed = new int[compressed.length][];
        for(int i=0; i<compressed.length; i++){
            decompressed[i] = decompressArray(compressed[i]);
        }

        return decompressed;
    }

    //takes a row from the picture and finds the best pattern to compress with. and then compresses the array with that pattern
    public void compressRow(int rowN, int[] row){

        int n = 2;

        int[] winner = new int[]{-1,-1};
        int best = 0;
        int[][] checked;
        int[] checking;
        int checkCount = 0;
        int score;

        while(n<(int)(row.length/2)){
            checked = new int[row.length-n][];
            for(int i=0; i<checked.length; i++){
                checked[i]=null;
            }

            for(int i=0; i<row.length-n; i++){
                checking = new int[n];
                for(int j=0; j<n; j++){
                    checking[j] = row[i+j];
                }
                if(checkForArray(checking, checked)) {
                    score = patternSearch(checking, row, i, best);
                    checked[checkCount] = checking;
                    if(score > best){
                        best = score;
                        winner = checking;
                    }
                }
            }
            n++;
        }

        //at this point I have found the pattern which will offer the best compression by this procedures standards.

        for(int i=0; i<winner.length; i++){
        }

        if(best==0){
            int[] newRow = new int[row.length];
            for(int i=0; i<newRow.length; i++){
                newRow[i] = row[i];
            }
            compressed[rowN] = newRow;
        } else{
            compressed[rowN] = compressArray(row, winner, best);
        }
    }


    //Takes the row to compress. the pattern to replace and the previously calculated reduction amount and creates the new compressed array
    public int[] compressArray(int[] row, int[] pattern, int reduction){

        int[] temp = new int[row.length-reduction];

        for(int i=0; i<pattern.length; i++) {
            temp[i] = pattern[i];
        }

        temp[pattern.length] = -1;

        int i=0;
        int n=pattern.length+1;

        while(i<row.length){
            temp[n] = row[i];
            if(pattern[0] == row[i] && row.length - i > pattern.length) {
                for(int j=1; j<pattern.length; j++){
                    if(pattern[j] != row[i+j]) break;
                    if(j == pattern.length-1) {
                        temp[n] = -1;
                        i+=pattern.length-1;
                    }
                }
            }
            i++;
            n++;
        }

        return temp;
    }


    //takes any compressed array and scans the first portion to get the pattern
    //and then creates a new array adding the pattern wherever a -1 is found but then copying the rest.
    public int[] decompressArray(int[] row){

        int i=0;
        int sCount=0;

        while(row[i]!= -1){
            sCount++;
            i++;
        }

        int[] pattern = new int[sCount];
        for(int j=0; j<pattern.length; j++){
            pattern[j] = row[j];
        }

        i++;

        int pCount=-1;

        for(int j=0; j<row.length; j++){
            if(row[j] == -1) pCount++;
        }


        int[] temp = new int[row.length-pCount-1-pattern.length + (pCount * pattern.length)];

        for(int j=0; j<temp.length; j++){
            if(row[i] == -1){
                for(int k=0; k<pattern.length; k++){
                    temp[j] = pattern[k];
                    j++;
                }
                j--;
            } else {
                temp[j] = row[i];
            }
            i++;
        }

        return temp;
    }

    //give pattern search a pattern[in the form of an array of int's] and an array to search within. and it will tell you how many of it are within
    //since we are taking the pattern from the array to be searched within, there will always be one pattern and the first pattern will always start where we have selected the pattern.
    //no need to search the entire array every time
    public int patternSearch(int[] pattern, int[] row, int start, int best){
        //n == number of found
        //k == size of pattern
        //n(k-1) - (k+1)

        int length = pattern.length;
        int found = 0;
        int maxLeft;

        for(int i=start; i<row.length-length; i++){
            for(int j=0; j<length; j++){
                if(pattern[j] != row[i+j]) break;
                if(j==length-1){
                    found++;
                    i+=pattern.length-1;
                }
            }
            maxLeft = ((row.length-i)/length + found)*(length-1) - length - 1;
            if(maxLeft < best) return 0;
        }

        int score = (found * (length - 1)) - length - 1;

        return score;
    }




    //this is used in the compressRow method, it checks to see if the method has already tested a given pattern
    private boolean checkForArray(int[] array, int[][] checked){
        for(int i=0; i<checked.length; i++){
            if(Arrays.equals(array, checked[i])) return false;
            if(checked[i] == null) return true;
        }
        return true;
    }

    //outputs the compressed information to string
    public String toString(){
        String layout ="";
        for(int i=0;i<compressed.length;i++){
            for(int j=0;j<compressed[i].length;j++){
                layout+=compressed[i][j] + " ";
            }
            layout +="\n";
        }
        return layout;
    }

    //outputs any array of integer arrays to string format for presentation
    public String toString(int[][] array){
        String layout ="";
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                layout+=array[i][j] + " ";
            }
            layout +="\n";
        }
        return layout;
    }
}
