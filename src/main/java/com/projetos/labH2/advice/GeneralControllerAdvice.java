package com.projetos.labH2.advice;

import com.projetos.labH2.advice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GeneralControllerAdvice {
    private final MessageSource messageSource;

    @Autowired
    public GeneralControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleNotFoundException(NotFoundException exception) {
        Problem problem = new Problem(
                HttpStatus.NOT_FOUND.value(),
                "Informação não encontrada",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        Problem problem = new Problem(
                HttpStatus.BAD_REQUEST.value(),
                "Não é possível desserializar o valor do tipo",
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problem> handleFieldNotFound(MethodArgumentNotValidException exception) {
        List<ErrorMessageRecord> problemList = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(e -> {
            String detail = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorMessageRecord messageDetail = new ErrorMessageRecord(
                    e.getField(),
                    detail
            );
            problemList.add(messageDetail);
        });

        Problem problem = new Problem(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Parameters",
                "Invalid Request Body",
                problemList
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }
}
