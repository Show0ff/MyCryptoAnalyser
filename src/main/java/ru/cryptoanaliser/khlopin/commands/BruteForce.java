package ru.cryptoanaliser.khlopin.commands;

import ru.cryptoanaliser.khlopin.constants.Constants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.random.RandomGenerator;

public class BruteForce {

    public static void bruteForce(String text) {

        char[] charArray = tryToDecrypt(text);


        boolean successful = false;
        while (!successful) {
            String text1 = new String(charArray);
            StringTokenizer tokenizer = new StringTokenizer(text1, " ");
            List<String> textTokenInList = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                textTokenInList.add(tokenizer.nextToken()); // делит стринг на токены по пробелам и добавляет их в список
            }
            for (int i = 0; i < textTokenInList.size(); i++) {
                if (i > 0 && textTokenInList.get(i).equals("но") && textTokenInList.get(i - 1).endsWith(",")) {
                    successful = true;
                    break;
                }
            }
            if (!successful) {
                charArray = tryToDecrypt(text);
            }
        }

        // Разделить слова по пробелам в отдельные токены и добавить в список, после сравнить элементы списка с условием и
        //Условия правильно шифрования:
        //1. Если charArray содержит в себе пробелы' ' И
        //2. запятые перед союзами НО и А


        writeResultInFile(charArray);

    }


    private static char[] tryToDecrypt(String text) {
         Random random = new Random();
        int key = random.nextInt(Constants.getALPHABET().size());
        System.out.println(key);
//        int key = 15;
        char[] charArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            int temp = Constants.getALPHABET().indexOf(text.charAt(i)); // Получаем индекс символа в алфавите из входящего текста
            if (temp - key < 0) {
                int test = temp - key;
                charArray[i] = Constants.getALPHABET().get(Constants.getALPHABET().size() + test);
            } else {
                charArray[i] = Constants.getALPHABET().get((temp - key) % (Constants.getALPHABET().size()));
            }
        }
        return charArray;
    }

    private static void writeResultInFile(char[] charArray) {
        final ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(CharBuffer.wrap(charArray));
        byte[] result = Arrays.copyOf(byteBuffer.array(), byteBuffer.limit());

        try {
            Files.write(Constants.getOriginalText(), result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}