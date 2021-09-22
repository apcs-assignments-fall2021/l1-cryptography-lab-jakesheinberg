import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String encrypted = "";
        int lenStr = message.length();
        for(int x=0; x<lenStr; x++){
            char a = message.charAt(x);
            if(a>=65 && a<=87){
            int b= a +3;
            char c = (char) b;
            encrypted = encrypted + c;
        }else if(a>=88&&a<=90){
                int b= a -23;
                char c = (char) b;
                encrypted = encrypted + c;
            }else if(a>=97&&a<=119){
                int b= a +3;
                char c = (char) b;
                encrypted = encrypted + c;
            }else if(a>=120&&a<=122){
                int b= a -23;
                char c = (char) b;
                encrypted = encrypted + c;
            }else{
                encrypted = encrypted + a;
            }

            }
        return encrypted;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String decrypted = "";
        int lenStr = message.length();
        for(int x=0; x<lenStr; x++){
            char a = message.charAt(x);
            if(a>=68 && a<=90){
                int b= a -3;
                char c = (char) b;
                decrypted = decrypted + c;
            }else if(a>=65&&a<=67){
                int b= a +23;
                char c = (char) b;
                decrypted = decrypted + c;
            }else if(a>=100&&a<=122){
                int b= a -3;
                char c = (char) b;
                decrypted = decrypted + c;
            }else if(a>=97&&a<=99){
                int b= a +23;
                char c = (char) b;
                decrypted = decrypted + c;
            }else{
                decrypted = decrypted + a;
            }

        }
        return decrypted;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        key = key%26;
        String encrypted = "";
        int lenStr = message.length();
        for(int x=0; x<lenStr; x++){
            char a = message.charAt(x);
            if(a>=65 && a<=90-key){
                int b= a +key;
                char c = (char) b;
                encrypted = encrypted + c;
            }else if(a>=90-(key-1)&&a<=90){
                int b= a -(26-key);
                char c = (char) b;
                encrypted = encrypted + c;
            }else if(a>=97&&a<=(122-key)){
                int b= a +key;
                char c = (char) b;
                encrypted = encrypted + c;
            }else if(a>=122-(key-1)&&a<=122){
                int b= a -(26-key);
                char c = (char) b;
                encrypted = encrypted + c;
            }else{
                encrypted = encrypted + a;
            }

        }
        return encrypted;
    }


    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key){
        key = key%26;
        String decrypt = "";
        int lenStr = message.length();
        for(int x=0; x<lenStr; x++){
            char a = message.charAt(x);
            if(a>=65+key && a<=90){
                int b= a -key;
                char c = (char) b;
                decrypt = decrypt + c;
            }else if(a>=65&&a<=65+(key-1)){
                int b= a +(26-key);
                char c = (char) b;
                decrypt = decrypt + c;
            }else if(a>=97+key &&a<=122){
                int b= a -key;
                char c = (char) b;
                decrypt = decrypt + c;
            }else if(a>=122&&a<=122+(key-1)){
                int b= a +(26-key);
                char c = (char) b;
                decrypt = decrypt + c;
            }else{
                decrypt = decrypt + a;}}
        return decrypt;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        System.out.println(encryptCaesarKey("hello", 50));



        Scanner scan = new Scanner(System.in);
        System.out.println(decryptCaesarKey("l", 17));

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
