package ru.cryptoanaliser.khlopin.controller;

import ru.cryptoanaliser.khlopin.commands.Action;
import ru.cryptoanaliser.khlopin.entity.Result;

public class MainController {
    public Result execute (String command, String[] parameters) {
        Action action = Actions.find(command);
        Result result = action.execute(parameters);
        return  result;
    }
}
