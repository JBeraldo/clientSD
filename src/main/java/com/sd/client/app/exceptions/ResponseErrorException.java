package com.sd.client.app.exceptions;

public class ResponseErrorException extends Exception{
    public ResponseErrorException() {
        super("Erro na resposta do servidor");
    }

    public ResponseErrorException(String message) {
        super(message);
    }

    public ResponseErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseErrorException(Throwable cause) {
        super(cause);
    }

    public ResponseErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
