package net.sytes.fly.Expenser.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class UserNotFoundException extends ChangeSetPersister.NotFoundException {
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public UserNotFoundException(String paramName, String param)
    { message = "Не найдено пользователя с " + paramName + " : " + param; }
}
