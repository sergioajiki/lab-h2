package com.projetos.labH2.labVO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EnderecoVo {
    private Long id;
    @NotEmpty(message = "O campo logradouro é obrigatório")
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @NotEmpty(message = "O campo cep é obrigatório")
    @Size(min = 8, max = 8, message = "Cep inválido, deve conter exatamente 8 caracteres")
    private String cep;
    @NotEmpty(message = "O campo cidade é obrigatório")
    private String cidade;
    @NotEmpty(message = "O campo estado é obrigatório")
    @Size(min = 2, max=2, message = "Deve conter a sigla do estado com 02 caracteres")
    private String estado;
}
