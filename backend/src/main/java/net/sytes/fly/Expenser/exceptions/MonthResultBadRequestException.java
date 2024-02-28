package net.sytes.fly.Expenser.exceptions;

import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;

public class MonthResultBadRequestException extends BadRequestException{
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public MonthResultBadRequestException(String paramName, String param)
    { message = "Параметр '" + paramName + "' не может быть со значением: " + param; }
}
