package com.projetos.labH2.advice;

import java.util.List;

public record Problem (
        int status,
        String message,
        String detail,
        List<ErrorMessageDto> erros
) {

}
