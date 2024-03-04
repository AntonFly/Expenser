package net.sytes.fly.Expenser.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class TransactionNotFoundException extends ChangeSetPersister.NotFoundException {
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public TransactionNotFoundException(String paramName, String param)
    { message = "Не найдено поступления с " + paramName + " : " + param; }
}
