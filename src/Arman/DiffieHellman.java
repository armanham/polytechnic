package Arman;

import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {

    public static BigInteger generatePrivateKey(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger privateKey = new BigInteger(bitLength, random);
        return privateKey;
    }

    public static BigInteger generatePublicKey(BigInteger privateKey, BigInteger generator, BigInteger modulus) {
        BigInteger publicKey = generator.modPow(privateKey, modulus);
        return publicKey;
    }

    public static BigInteger generateSharedSecret(BigInteger privateKey, BigInteger publicKey, BigInteger modulus) {
        BigInteger sharedSecret = publicKey.modPow(privateKey, modulus);
        return sharedSecret;
    }
}