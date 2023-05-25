package Tatul;

public class Algorithms {

    public static String rle2(String input, boolean encode) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        char currentChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == currentChar) {
                count++;
            } else {
                if (encode) {
                    output.append(count);
                    output.append(currentChar);
                } else {
                    for (int j = 0; j < count; j++) {
                        output.append(currentChar);
                    }
                }
                count = 1;  currentChar = c;
            }
        }
        if (encode) {
            output.append(count);  output.append(currentChar);
        } else {
            for (int j = 0; j < count; j++) {
                output.append(currentChar);
            }
        }
        return output.toString();
    }


    public static String caesarCipher(String input, int shift) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (((c - base + shift) % 26) + base);
            }
            output.append(c);
        }
        return output.toString();
    }


    public static String rle2CaesarCipher(String input, boolean encode, int shift) {
        StringBuilder output = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        int count = 1;
        char currentChar = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == currentChar) {
                count++;
            } else {
                if (encode) {
                    buffer.append(count);
                    buffer.append(currentChar);
                } else {
                    for (int j = 0; j < count; j++) {
                        buffer.append(currentChar);
                    }
                }
                count = 1;
                currentChar = c;
            }
        }

        if (encode) {
            buffer.append(count);
            buffer.append(currentChar);
        } else {
            for (int j = 0; j < count; j++) {
                buffer.append(currentChar);
            }
        }

        String encodedDecoded = buffer.toString();
        for (int i = 0; i < encodedDecoded.length(); i++) {
            char c = encodedDecoded.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) (((c - base + shift) % 26) + base);
            }
            output.append(c);
        }
        return output.toString();
    }
}