package cs130.ShiftCypher;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Client {
    public static void main(String args[]){

        upperCase("ENCODE AND DECODE A MESSAGE USING A KEY OF VALUES STORED IN A QUEUE");
        lowerCase("encode and decode a message using a key of values stored in a queue");
        noSpaces("encodeanddecodeamessageusingakeyofvaluesstoredinaqueENCODEANDDECODEAMESSAGEUSINGAKEYOFVALUESSTOREDINAQUE");

    }

    public static void upperCase(String message){
        Cipher cypher = new Cipher();
        int key = 619423;
        String a = new String(cypher.encode(key, message));
        String b = new String(cypher.decode(key, a));

        System.out.println(message);
        System.out.println(a);
        System.out.println(b);
    }

    public static void lowerCase(String message){
        Cipher cypher = new Cipher();
        int key = 567542;
        String a = new String(cypher.encode(key, message));
        String b = new String(cypher.decode(key, a));

        System.out.println(message);
        System.out.println(a);
        System.out.println(b);
    }

    public static void noSpaces(String message){
        Cipher cypher = new Cipher();
        int key = 567542;
        String a = new String(cypher.encode(key, message));
        String b = new String(cypher.decode(key, a));

        System.out.println(message);
        System.out.println(a);
        System.out.println(b);
    }
}