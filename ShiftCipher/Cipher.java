package cs130.ShiftCypher;

/**
 * Cipher is a class with 3 methods
 * encode a message
 * decode a message
 * translate an integer into an array of ints for use as que
 */
public class Cipher{

    /**
     *
     * @param cipherKey the que of integers we need
     * @param message the message to be encoded
     * @return encoded message
     */
    public String encode(int cipherKey, String message){

        //turn int into an array of ints
        int[] key = intToIntArray(cipherKey);

        int que = key.length;
        String codedMessage = new String("");

        //temp is used to easily check between capital and lowercase letters
        char temp;

        //loop through each character only encodes Alphabetical characters upper and lowercase
        for(int i=0; i<message.length();i++){
            temp = message.charAt(i);
            if(temp>='a' & temp<='z'){
                //Uppercase letter calculation
                temp = (char) (temp - 'a');
                temp = (char) ((temp + key[i%que])%26 +'a');
                codedMessage += temp;
            }
            else if(temp>='A' && temp<='Z'){
                //Lowercase letter calculation
                temp = (char) (temp - 'A');
                temp = (char) ((temp + key[i%que])%26 +'A');
                codedMessage += temp;
            }
            else codedMessage += temp;

        }
        return codedMessage;
    }

    /**
     * method is nearly a copy of previous method but backwards in the actual encoding part
     * @param cipherKey needed the cipher key to reveal coded message
     * @param message the coded message to be decoded
     * @return returns the secret message
     */
    public String decode(int cipherKey, String message){
        int[] key = intToIntArray(cipherKey);
        int que = key.length;
        String codedMessage = new String("");

        char temp;

        for(int i=0; i<message.length();i++){
            temp = message.charAt(i);
            if(temp>='a' & temp<='z'){
                //Uppercase letter calculation
                temp = (char) (temp - 'a');
                temp = (char) ( ( (temp - key[ i%que ]) + 26) % 26 + 'a');
                codedMessage += temp;
            }
            else if(temp>='A' && temp<='Z'){
                //Lowercase letter calculation
                temp = (char) (temp - 'A');
                temp = (char) ( ( (temp - key[ i%que ]) + 26) % 26 + 'A');
                codedMessage += temp;
            }
            else codedMessage += temp;

        }
        return codedMessage;
    }

    /**
     * turns an integer into an array of ints
     * @param a the key to be used
     * @return the array of ints
     */
    private int[] intToIntArray(int a){
        String temp = Integer.toString(a);
        int[] array = new int[temp.length()];
        for (int i=0; i <array.length; i++){
            array[i] = temp.charAt(i) - '0';
        }
        return array;

    }

}