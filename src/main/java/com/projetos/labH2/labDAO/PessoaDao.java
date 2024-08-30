package com.projetos.labH2.labDAO;

import com.projetos.labH2.labVO.PessoaVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PessoaDao {
    void insertPessoa(PessoaVo pessoa);
    List<PessoaVo> getAllPessoas();
}
