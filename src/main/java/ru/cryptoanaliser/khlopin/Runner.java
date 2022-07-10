package ru.cryptoanaliser.khlopin;

import ru.cryptoanaliser.khlopin.toplevel.Application;
import ru.cryptoanaliser.khlopin.commands.Decrypt;
import ru.cryptoanaliser.khlopin.commands.Encrypt;
import ru.cryptoanaliser.khlopin.constants.Resourses;
import ru.cryptoanaliser.khlopin.controller.MainController;
import ru.cryptoanaliser.khlopin.entity.Result;

public class Runner {
    public static void main(String[] args) {
        doDecrypt();
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);
    }

    public static void doCrypt() {
        Encrypt encrypt = new Encrypt();
        Resourses resourses = new Resourses();
        String text1 = resourses.getTextForCrypt(); // original TEXT
        int key = resourses.getKey();
        encrypt.crypt(text1,key);
    }

    public static void doDecrypt() {
        Decrypt decrypt = new Decrypt();
        Resourses resourses = new Resourses();
        String text2 = resourses.getTextForDecrypt(); // crypt TEXT
        int key = resourses.getKey();
        decrypt.decrypt(text2,key);
    }
}
