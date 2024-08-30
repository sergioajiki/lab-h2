package com.projetos.labH2.labDAO;

import com.projetos.labH2.labVO.PessoaVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PessoaDao {
    void insertPessoa(PessoaVo pessoa);

    List<PessoaVo> getAllPessoas();

    PessoaVo getPessoaById(@Param("id") int id);

    void deletePessoaById(@Param("id") int id);
}
