package Tatul;

public class Main {

    public static void main(String[] args) {
        String input = "AAAABBBCCCC";
        boolean encode = true;
        int shift = 3;
        String encoded = Algorithms.rle2CaesarCipher(input, encode, shift);
        String decoded = Algorithms.rle2CaesarCipher(encoded, !encode, -shift);

        System.out.println("Input: " + input);
        System.out.println("Encode: " + encode);
        System.out.println("Shift: " + shift);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);
    }
}