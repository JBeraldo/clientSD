package com.sd.client.app.exceptions;

public class ResponseErroException extends Exception{
    public ResponseErroException() {
        super("Erro na resposta do servidor");
    }

    public ResponseErroException(String message) {
        super(message);
    }

    public ResponseErroException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseErroException(Throwable cause) {
        super(cause);
    }

    public ResponseErroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
