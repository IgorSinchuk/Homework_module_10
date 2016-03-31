import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWorker {
    public static void writeToFile(String fileName, String text) {
        FileWriter outputStream = null;
        try {
            outputStream = new FileWriter(fileName);
            for (int i = 0; i < text.length(); i++) {
                outputStream.append(text.charAt(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден:" + e);
        } catch (IOException e){
            System.out.println("Ошибка: " + e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println("Ошибка: " + e);
                }
            }
        }
    }

    public static String readFromFile(String fileName) {
        FileReader inputStream = null;
        String result = "";
        try {
            inputStream = new FileReader(fileName);
            int c;
            while ((c = inputStream.read()) != -1) {
                result += (char) c;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден:" + e);
        } catch (IOException e){
            System.out.println("Ошибка: " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Ошибка: " + e);
                }
            }
        }
        return result;
    }
}