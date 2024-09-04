package com.projetos.labH2.labDAO;

import com.projetos.labH2.labVO.PessoaVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PessoaDao {
    void insertPessoa(PessoaVo pessoa);

    List<PessoaVo> getAllPessoas();

    List<PessoaVo> getPessoaByNome(@Param("nome") String nome);

    List<PessoaVo> getPessoaByDataNascimentoRange(@Param("dataInicio")String dataInicio,@Param("dataFim") String dataFim);

    PessoaVo getPessoaById(@Param("id") Long id);

    void updatePessoaById(PessoaVo pessoa);

    void deletePessoaById(@Param("id") Long id);
}
