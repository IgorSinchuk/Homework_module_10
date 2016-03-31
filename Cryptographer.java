public class Cryptographer {
    public static final int ALPHABET_COUNT = 26;
    public static final int ASCII_CODE_A = 65;
    public static final int ASCII_CODE_a = 97;
    public static StringBuilder alphabet = new StringBuilder().append("abcdefghijklmnopqrstuvwxyz");

    public static String crypt(String stringForEncrypt, int cryptPower, boolean forCrypt) {
        String resultString = "";
        int charNumberInAlphabet;
        int charASCIIForEncrypt;
        for (int i = 0; i < stringForEncrypt.length(); i++) {
            charNumberInAlphabet = getCharNumberInAlphabet(stringForEncrypt.charAt(i), cryptPower, forCrypt);
            charASCIIForEncrypt = (int) stringForEncrypt.charAt(i);
            if (isLetter(charASCIIForEncrypt) & (charASCIIForEncrypt >= ASCII_CODE_a)) {
                resultString += (char) (ASCII_CODE_a + charNumberInAlphabet);
            } else if (isLetter(charASCIIForEncrypt) & (charASCIIForEncrypt >= ASCII_CODE_A)){
                resultString += (char) (ASCII_CODE_A + charNumberInAlphabet);
            } else {
                resultString += stringForEncrypt.charAt(i);
            }
        }
        return resultString;
    }

    public static boolean isLetter(int charASCIICode) {
        boolean isCharASCIICodeMorea;
        boolean isCharASCIICodeLessa;
        boolean isCharASCIICodeMoreA;
        boolean isCharASCIICodeLessA;
        isCharASCIICodeMorea = charASCIICode >= ASCII_CODE_a;
        isCharASCIICodeLessa = charASCIICode <= ASCII_CODE_a + ALPHABET_COUNT;
        isCharASCIICodeMoreA = charASCIICode >= ASCII_CODE_A;
        isCharASCIICodeLessA = charASCIICode <= ASCII_CODE_A + ALPHABET_COUNT;
        return isCharASCIICodeMorea & isCharASCIICodeLessa || isCharASCIICodeMoreA & isCharASCIICodeLessA;
    }

    private static int getCharNumberInAlphabet(char charForEncrypt, int cryptPower, boolean forCrypt) {
        charForEncrypt = Character.toLowerCase(charForEncrypt);
        String charInAlphabet = String.valueOf(charForEncrypt);
        int charNumberInAlphabet = alphabet.indexOf(charInAlphabet);
        if (forCrypt) {
            return (charNumberInAlphabet + cryptPower) % ALPHABET_COUNT;
        } else {
            return (charNumberInAlphabet - cryptPower + ALPHABET_COUNT * (1 + cryptPower/ALPHABET_COUNT)) % ALPHABET_COUNT;
        }
    }
}