package cs130.ShiftCypher;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Client {
    public static void main(String args[]){

        Cipher cypher = new Cipher();
        int key = 4321;
        String message = new String("Encode and decode a message using a key of values stored in in a queue");
        String a = new String(cypher.encode(key, message));
        String b = new String(cypher.decode(key, a));
        System.out.println(a);
        System.out.println(b);

    }
}