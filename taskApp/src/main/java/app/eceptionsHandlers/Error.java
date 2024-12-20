package app.eceptionsHandlers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private String message;
    private int number;

    public Error(String message, int number) {
        this.message = message;
        this.number = number;
    }
}
