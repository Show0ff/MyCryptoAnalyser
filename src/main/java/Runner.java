import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private static final Path cryptText = Path.of("C:\\JAVA\\CryptoAnaliser\\CryptoAnaliser\\src\\other\\crypt.txt");
    private static final Path originalText = Path.of("C:\\JAVA\\CryptoAnaliser\\CryptoAnaliser\\src\\other\\original.txt");
    public static final char[] ALPHABET_RU = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-'};

    public static void main(String[] args) {

        getTextForCrypt();
        getKey();
    }

    private static List<String> getTextForCrypt() {
        List<String> textString = new ArrayList<>();
        try {
            if (Files.exists(originalText)) {
                textString = Files.readAllLines(originalText);
                return textString;
            } else {
                System.out.print("Файла не существует");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    return textString;}

    private static int getKey() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите ключ: ");
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

    private static String encrypting() {
        List<String> textForCrypt = getTextForCrypt();
        System.out.println();


    return null;}



    private static String printCryptResult() {

        return null;
    };

}
