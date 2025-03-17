package Main;

public class AffineCipher {

    // Key parts for the Affine cipher
    private static final int A = 5;  // Must be coprime with 26
    private static final int B = 8;  // Can be any integer

    // Function to encrypt the text
    public static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                int x = ch - base;
                int encryptedChar = (A * x + B) % 26;
                ciphertext.append((char) (encryptedChar + base));
            } else {
                ciphertext.append(ch);
            }
        }
        return ciphertext.toString();
    }

    // Function to decrypt the text
    public static String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        int aInverse = modInverse(A, 26);  // Modular inverse of A
        for (char ch : ciphertext.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                int y = ch - base;
                int decryptedChar = (aInverse * (y - B + 26)) % 26;
                plaintext.append((char) (decryptedChar + base));
            } else {
                plaintext.append(ch);
            }
        }
        return plaintext.toString();
    }

    // Function to find the modular inverse of A
    private static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }


}
