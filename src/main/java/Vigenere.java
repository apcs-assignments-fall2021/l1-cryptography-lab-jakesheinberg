import java.util.Scanner;


public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        return ch;
    }


    public static char decryptCaesarLetter(char ch, int key) {
        // YOUR CODE HERE
        return ch;
    }


    public static String encryptVigenere(String message, String key) {
        String encrypted = "";
        int lenKey = key.length();
        int keyIndex = 0;
        int lenStr = message.length();
        for(int x=0;x<lenStr; x++){
            char a = key.charAt(keyIndex);
            char u = message.charAt(x);
            if (u>=65 && u<=90 ||u>=97 && u<=122 ){
            int b = a - 'A';
            String letta = "";
            letta = letta + message.charAt(x);
            String encryptedletta = Caesar.encryptCaesarKey(letta, b);
            encrypted = encrypted + encryptedletta;
            if(keyIndex<lenKey-1) {
                keyIndex +=1;
            }else{
                keyIndex=0;
            }}

            else {
                encrypted = encrypted + u;
            }}
         return encrypted;}

    public static String decryptVigenere(String message, String key) {
        String decrypted = "";
        int lenKey = key.length();
        int keyIndex = 0;
        int lenStr = message.length();
        for(int x=0;x<lenStr; x++){
            char a = key.charAt(keyIndex);
            char u = message.charAt(x);
            if (u>=65 && u<=90 ||u>=97 && u<=122 ){
                int b = a - 'A';
                String letta = "";
                letta = letta + message.charAt(x);
                String decryptedletta = Caesar.decryptCaesarKey(letta, b);
                decrypted = decrypted + decryptedletta;
                if(keyIndex<lenKey-1) {
                    keyIndex +=1;
                }else{
                    keyIndex=0;
                }}

            else {
                decrypted = decrypted + u;
            }}
        return decrypted;}



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
