package com.atendimento.exceptionsApp;

import lombok.Getter;

@Getter
public class AtendimentoPsicologicoException extends RuntimeException{
    private final String message;
    private String description;
    private final Integer statusCode;

    public AtendimentoPsicologicoException(String message, Integer statusCode){
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }
    public AtendimentoPsicologicoException(String message, String description, Integer statusCode){
        super(message);
        this.message = message;
        this.description = description;
        this.statusCode = statusCode;
    }


}