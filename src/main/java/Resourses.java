import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.util.Locale;
import java.util.Scanner;

public class Resourses {
    public String getTextForCrypt() { // получить текст для шифровки
        String textString = null;
        try {
            if (Files.exists(Constants.getOriginalText())) {
                textString = String.valueOf(Files.readAllLines(Constants.getOriginalText()));
                if (!textString.isEmpty()) {
                    return textString.substring(1, textString.length() - 1).toLowerCase();
                } else {
                    System.out.println("Текст отсутствует в файле"); }
            } else {
                System.out.println("Файла не существует");
                throw new FileSystemNotFoundException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textString;
    }

    public String getTextForDecrypt() { // получить текст для Дешифровки
        String textString = null;
        try {
            if (Files.exists(Constants.getCryptText())) {
                textString = String.valueOf(Files.readAllLines(Constants.getCryptText()));
                if (!textString.isEmpty()) {
                    return textString.substring(1, textString.length() - 1);
                } else {
                    System.out.println("Текст отсутствует в файле"); }
            } else {
                System.out.println("Файла не существует");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return textString;
    }

    public int getKey() { // установить значение смещения
        Scanner console = new Scanner(System.in);
        System.out.println("Введите число на которое хотите сделать смещение: ");
        while (true) {
            int key = console.nextInt();
            if (key <= Constants.getALPHABET().size() - 1 && key >= 0) {
                return key;
            } else {
                System.out.println("Введите ключ в пределах длинны алфавита: ");
                key = console.nextInt();
            }
        }
    }

    /* public String getWay() { //метод получения направления смещения
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
    } */
}
