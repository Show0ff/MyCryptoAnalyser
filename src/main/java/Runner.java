import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private static final Path cryptText = Path.of("C:\\JAVA\\MyProjects\\MyCryptoAnalyser\\src\\other\\cryptText.txt");
    private static final Path originalText = Path.of("C:\\JAVA\\MyProjects\\MyCryptoAnalyser\\src\\other\\originalText.txt");
    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    public static void main(String[] args) {
        String result = encrypting(getTextForCrypt(), setKey(), getWay());
        System.out.println(result);
    }

    private static String getTextForCrypt() { // получить текст для шифровки
        String textString = null;
        try {
            if (Files.exists(originalText)) {
                textString = String.valueOf(Files.readAllLines(originalText));
                return textString.substring(1,textString.length() - 1);
            } else {
                System.out.println("Файла не существует");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return textString;
    }

    private static int setKey() { // установить значение смещения
        Scanner console = new Scanner(System.in);
        System.out.println("Введите число на которое хотите сделать смещение: ");
        while (true) {
            int key = console.nextInt();
            if (key <= 32 && key > 0) {
                return key;
            } else {
                System.out.println("Введите ключ в пределах длинны алфавита: ");
                key = console.nextInt();
            }
        }
    }

    private static String getWay() { //метод получения направления смещения
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сторону смещения L или R");
        while (true) {
            String result = scanner.nextLine();
            if (result.equalsIgnoreCase("r")) {
                return "R";
            } else if (result.equalsIgnoreCase("l")) {
                return "L";
            } else {
                System.out.println("Неверное направление");
            }
        }
    }


    private static String encrypting(String text, int key, String way) { //метод шифрования
        // сделать проверку на пустоту
        char[] charArray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            int temp = ALPHABET.indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
            charArray[i] = ALPHABET.get(temp + key);
        }
        return String.valueOf(charArray);
    }
}
//[АБВГДЕЁЖЗИЙКЛМН]
