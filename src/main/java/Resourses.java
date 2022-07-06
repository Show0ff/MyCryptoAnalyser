import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Resourses {
    public String getTextForCrypt() { // получить текст для шифровки
        String textString = null;
        try {
            if (Files.exists(Constants.getOriginalText())) {
                textString = String.valueOf(Files.readAllLines(Constants.getOriginalText()));
                return textString.substring(1,textString.length() - 1);
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
            if (key <= 32 && key > 0) {
                return key;
            } else {
                System.out.println("Введите ключ в пределах длинны алфавита: ");
                key = console.nextInt();
            }
        }
    }

    public String getWay() { //метод получения направления смещения
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
}
