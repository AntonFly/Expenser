package net.sytes.fly.Expenser.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class MonthResultNotFoundException extends ChangeSetPersister.NotFoundException {
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public MonthResultNotFoundException(String paramName, String param)
    { message = "Не найдено результатов месяца с " + paramName + " : " + param; }
}
