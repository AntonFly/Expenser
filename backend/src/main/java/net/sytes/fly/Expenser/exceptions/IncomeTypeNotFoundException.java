package net.sytes.fly.Expenser.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class IncomeTypeNotFoundException extends ChangeSetPersister.NotFoundException {
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public IncomeTypeNotFoundException(String paramName, String param)
    { message = "Не найдено категории поступлений с " + paramName + " : " + param; }
}
