package com.projetos.labH2.labDAO;

import com.projetos.labH2.labVO.PessoaVo;

import java.util.List;

public interface PessoaDao {
    void insertPessoa(PessoaVo pessoa);
    List<PessoaVo> getAllPessoas();
}
