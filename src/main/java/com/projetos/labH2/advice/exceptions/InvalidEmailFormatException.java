package com.projetos.labH2.advice.exceptions;

public class InvalidEmailFormatException extends RuntimeException{
    public InvalidEmailFormatException(String message){
        super(message);
    }
}
