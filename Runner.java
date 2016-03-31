public class Runner {
    public static final int CRYPT_POWER = 114;
    public static final String FILE_NAME = "File.txt";
    public static boolean ENCRYPT = true;
    public static boolean DECRYPT = false;

    public static void main(String[] args) {
        String text = " If you don’t make mistakes, you’re not working on hard enough problems. And that’s a big mistake. ";
        System.out.println("Незашифрованная строка записанная в текстоввый файл: " + text);

        text = Cryptographer.crypt(text, CRYPT_POWER, ENCRYPT);
        System.out.println("Зашифрованная строка записанная в текстввый файл: " + text);
        FileWorker.writeToFile(FILE_NAME, text);

        text = FileWorker.readFromFile(FILE_NAME);
        System.out.println("Зашифрованная строка считанная из текстового файла: " + text);

        text = Cryptographer.crypt(text, CRYPT_POWER, DECRYPT);
        System.out.println("Расшифровання строка считанная из текстового файла: " + text);

        System.out.println();
    }
}