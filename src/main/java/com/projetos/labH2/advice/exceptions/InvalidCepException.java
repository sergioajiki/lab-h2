package com.projetos.labH2.advice.exceptions;

import org.springframework.data.relational.core.sql.In;

public class InvalidCepException extends RuntimeException{
    public InvalidCepException(String message){
        super(message);
    }
}
