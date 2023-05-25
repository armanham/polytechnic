package Arman;

import java.math.BigInteger;

import static Arman.AES.decrypt;
import static Arman.AES.encrypt;
import static Arman.DiffieHellman.*;

public class DiffieHellmanAES {

    public static void main(String[] args) throws Exception {

        BigInteger modulus = new BigInteger("23");
        BigInteger generator = new BigInteger("5");

        // Alice's key pair
        BigInteger alicePrivateKey = generatePrivateKey(10);
        BigInteger alicePublicKey = generatePublicKey(alicePrivateKey, generator, modulus);
        // Bob's key pair
        BigInteger bobPrivateKey = generatePrivateKey(10);
        BigInteger bobPublicKey = generatePublicKey(bobPrivateKey, generator, modulus);

        // Alice and Bob exchange public keys
        BigInteger aliceSharedSecret = generateSharedSecret(alicePrivateKey, bobPublicKey, modulus);
        BigInteger bobSharedSecret = generateSharedSecret(bobPrivateKey, alicePublicKey, modulus);

        // Verify that the shared secrets are the same
        if (aliceSharedSecret.equals(bobSharedSecret)) {
            System.out.println("Shared secret: " + aliceSharedSecret);

            // Use the shared secret as the AES key
            String aesKey = aliceSharedSecret.toString();
            String originalValue = "my secret ";
            String encryptedValue = encrypt(originalValue, aesKey);
            String decryptedValue = decrypt(encryptedValue, aesKey);

            System.out.println("Original value: " + originalValue);
            System.out.println("Encrypted value: " + encryptedValue);
            System.out.println("Decrypted value: " + decryptedValue);
        } else {
            System.out.println("Error: shared secrets do not match!");
        }
    }
}