package com.projetos.labH2.labDAO;

import com.projetos.labH2.labVO.PessoaVo;
import com.projetos.labH2.labVO.RequestPessoaVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PessoaDao {
    void insertPessoa(RequestPessoaVo pessoa);

    List<PessoaVo> getAllPessoas();

    List<PessoaVo> getPessoaByNome(@Param("nome") String nome);

    List<PessoaVo> getPessoaByBairro(@Param("bairro")String bairro);

    List<PessoaVo> getPessoaByCidade(@Param("cidade") String cidade);

    List<PessoaVo> getPessoaByDataNascimentoRange(@Param("dataInicio")String dataInicio,@Param("dataFim") String dataFim);

    PessoaVo getPessoaById(@Param("id") Long id);

    PessoaVo getPessoaByEmail(String email);

    void updatePessoaById(PessoaVo pessoa);

    void deletePessoaById(@Param("id") Long id);
}
