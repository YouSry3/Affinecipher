package Main;

import java.util.Scanner;

public class Main {
     // Main method to demonstrate the Affine cipher
    public static void main(String[] args) {
        AffineCipher Aff = new AffineCipher();
        String originalText = "HelloWorld";
        System.out.println("Original Text: " + originalText);

        String encryptedText = Aff.encrypt(originalText);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = Aff.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }

}
