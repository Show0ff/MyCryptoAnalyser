package ru.cryptoanaliser.khlopin;

import ru.cryptoanaliser.khlopin.commands.BruteForce;
import ru.cryptoanaliser.khlopin.commands.Decrypt;
import ru.cryptoanaliser.khlopin.commands.Encrypt;
import ru.cryptoanaliser.khlopin.constants.Resources;
import ru.cryptoanaliser.khlopin.controller.Controller;


public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Controller.run();
    }
}
