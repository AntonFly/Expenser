package net.sytes.fly.Expenser.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class ExpenseTypeNotFoundException extends ChangeSetPersister.NotFoundException {
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ExpenseTypeNotFoundException(String paramName, String param)
    { message = "Не найдено категории расходов с " + paramName + " : " + param; }
}
