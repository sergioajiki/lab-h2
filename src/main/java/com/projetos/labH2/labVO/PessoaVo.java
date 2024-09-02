package com.projetos.labH2.labVO;

import jakarta.validation.constraints.NotEmpty;

public class PessoaVo {
    private int id;
    @NotEmpty(message = "O campo nome é obrigatório")
    private String nome;
    @NotEmpty(message = "O campo idade é obrigatório")
    private int idade;
    @NotEmpty(message = "O campo email é obrigatório")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
