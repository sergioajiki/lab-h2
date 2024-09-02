package com.projetos.labH2.labVO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PessoaVo {
    private Long id;

    @NotEmpty(message = "O campo nome é obrigatório")
    private String nome;

    @NotNull(message = "O campo idade é obrigatório")
    private Integer idade;

    @NotEmpty(message = "O campo email é obrigatório")
    private String email;
}

