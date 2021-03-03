package br.com.arquiteturasoftware.core.exception;

import br.com.arquiteturasoftware.core.exception.custom.CustomBadRequestException;
import br.com.arquiteturasoftware.core.exception.custom.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //lidar com as exceções globalmente.
public class CustomExceptionHandler {

    /* NOT FOUND - 404 */
    @ExceptionHandler({CustomNotFoundException.class}) //Fator proporciona o acesso a esse metodo
    public ResponseEntity<?> handlerNotFoundException(CustomNotFoundException e) {
        return new ResponseEntity<>(e.messageErrorObject(), HttpStatus.NOT_FOUND);
    }

    /* BAD REQUEST - 400 */
    @ExceptionHandler({CustomBadRequestException.class}) //Fator proporciona o acesso a esse metodo
    public ResponseEntity<?> handlerBadRequestException(CustomBadRequestException e) {
        return new ResponseEntity<>(e.messageErrorObject(), HttpStatus.BAD_REQUEST);
    }
}
