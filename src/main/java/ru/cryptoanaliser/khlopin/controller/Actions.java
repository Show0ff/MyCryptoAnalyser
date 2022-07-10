package ru.cryptoanaliser.khlopin.controller;

import ru.cryptoanaliser.khlopin.commands.Action;
import ru.cryptoanaliser.khlopin.commands.Decrypt;
import ru.cryptoanaliser.khlopin.commands.Encrypt;

public enum Actions {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
    }
}
