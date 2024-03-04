package net.sytes.fly.Expenser.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class TransactionTypeNotFoundException extends ChangeSetPersister.NotFoundException {
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public TransactionTypeNotFoundException(String paramName, String param)
    { message = "Не найдено категории поступлений с " + paramName + " : " + param; }
}
