package ru.cryptoanaliser.khlopin;

import ru.cryptoanaliser.khlopin.commands.BruteForce;
import ru.cryptoanaliser.khlopin.commands.Decrypt;
import ru.cryptoanaliser.khlopin.commands.Encrypt;
import ru.cryptoanaliser.khlopin.constants.Resources;



public class Runner {
    public static void main(String[] args) {
        doCrypt();
    }

    public static void doCrypt() {
        String text1 = Resources.getText(); // Result in crypt TEXT
        int key = Resources.getKey();
        Encrypt.crypt(text1,key);
    }

    public static void doDecrypt() {
        String text2 = Resources.getTextCrypt(); // Result in ordinal TEXT
        int key = Resources.getKey();
        Decrypt.decrypt(text2,key);
    }

    public static void doBruteForce() {
        System.out.println("Старт");
        String text = Resources.getTextCrypt(); // Result in ordinal TEXT
        System.out.println("Старт2");
        BruteForce.bruteForce(text);
        System.out.println("Старт3");
    }
}
