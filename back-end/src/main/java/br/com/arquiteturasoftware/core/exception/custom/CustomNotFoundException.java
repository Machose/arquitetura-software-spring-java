package br.com.arquiteturasoftware.core.exception.custom;

import br.com.arquiteturasoftware.core.exception.MessageErrorObject;

public class CustomNotFoundException extends RuntimeException {

    private MessageErrorObject messageErrorObject;

    public CustomNotFoundException(String msg){
        this.messageErrorObject = new MessageErrorObject(msg);
    }

    public MessageErrorObject messageErrorObject() {
        return messageErrorObject;
    }
}
