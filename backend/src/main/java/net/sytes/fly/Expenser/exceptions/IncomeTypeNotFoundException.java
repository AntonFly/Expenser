package net.sytes.fly.Expenser.exceptions;

public class IncomeTypeNotFoundException extends Exception{
    private final String message;

    public IncomeTypeNotFoundException(String paramName, String param)
    { message = "Не найдено категории поступлений с " + paramName + " : " + param; }
}
