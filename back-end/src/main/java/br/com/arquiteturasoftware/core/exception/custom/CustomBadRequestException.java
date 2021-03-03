package br.com.arquiteturasoftware.core.exception.custom;

import br.com.arquiteturasoftware.core.exception.MessageErrorObject;

public class CustomBadRequestException extends RuntimeException {

    private MessageErrorObject messageErrorObject;

    public CustomBadRequestException(String msg){
        this.messageErrorObject = new MessageErrorObject(msg);
    }

    public MessageErrorObject messageErrorObject() {
        return messageErrorObject;
    }

}
