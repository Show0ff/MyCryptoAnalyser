package ru.cryptoanaliser.khlopin.controller;

import ru.cryptoanaliser.khlopin.commands.BruteForce;
import ru.cryptoanaliser.khlopin.commands.Decrypt;
import ru.cryptoanaliser.khlopin.commands.Encrypt;
import ru.cryptoanaliser.khlopin.constants.Resources;
import ru.cryptoanaliser.khlopin.exception.ApplicationException;

import java.util.Scanner;

public class Controller {
    public Controller() {
        System.out.println("**************************************************");
        System.out.println("Добро пожаловать в КриптоАнализатор!");
        System.out.println("**************************************************");
    }
    public static void run() {
        System.out.println("--------------------------------------------------");
        System.out.println("Выберите функцию: ");
        System.out.println("1. Зашифровать текст.");
        System.out.println("2. Расшифровать текст.");
        System.out.println("3. BruteForce");
        System.out.println("--------------------------------------------------");
        System.out.println("4. Посмотреть последний зашифрованный текст");
        System.out.println("5. Посмотреть последний расшифрованный текст");
        System.out.println("6. Посмотреть последний введённый текст");
        System.out.println("--------------------------------------------------");
        System.out.println("7. Закрыть программу");
        System.out.println("--------------------------------------------------");

        Scanner console = new Scanner(System.in);
        System.out.print("Введите цифру: ");
        int activator = console.nextInt();
        if (activator == 1) {
            Encrypt.crypt(Resources.getTextFromConsole(),Resources.getKey());
            System.out.println("Результат шифровки: " + Resources.getTextCrypt());
        } else if (activator == 2) {
            Decrypt.decrypt(Resources.getTextCrypt(),Resources.getKey());
            System.out.println("Результат дешифровки: " + Resources.getTextDecrypt());
        } else if (activator == 3) {
            BruteForce.bruteForce(Resources.getTextCrypt());
            System.out.println("Результат взлома: " + Resources.getTextDecrypt());
        } else if (activator == 4){
            System.out.println("Последний зашифрованный текст: " + Resources.getTextCrypt());
        } else if (activator == 5){
            System.out.println("Последний расшифрованный текст: " + Resources.getTextDecrypt());
        } else if (activator == 6){
            System.out.println("Последний введённый текст: " + Resources.getTextFromFile());
        } else if (activator == 7){
            System.out.println("Всё. Я ухожу.");
            System.exit(0);
        } else {
            System.out.println("Введено неправильно значение");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new ApplicationException(e.getMessage());
            }
            run();
        }

        System.out.println("1 - Меню");
        System.out.println("Для закрытия программы - любой текст или нажмите enter");
        activator = console.nextInt();
        System.out.print("Введите: ");
        if (activator == 1) {
            run();
        } else {
            System.out.println("Всё. Я ухожу.");
            System.exit(0);
        }
    }
}
