package br.com.arquiteturasoftware.core.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageErrorObject {
    private String message;

    public MessageErrorObject(String msg){
        this.message = msg;
    }
}
