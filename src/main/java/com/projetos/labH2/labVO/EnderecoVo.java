package com.projetos.labH2.labVO;

import lombok.Data;

@Data
public class EnderecoVo {
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
}
