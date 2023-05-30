package com.rogerhagerbaum.parkerning.exceptionHandling;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
@Getter
@Setter
public class EntityException extends RuntimeException {
    private HttpStatus status;
    List<String> problems;

    public EntityException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}