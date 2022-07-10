package ru.cryptoanaliser.khlopin.commands;

import ru.cryptoanaliser.khlopin.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
