package com.projetos.labH2.labDAO;

import com.projetos.labH2.labVO.EnderecoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnderecoDao {
    void insertEndereco(EnderecoVo endereco);

    List<EnderecoVo> getAllEndereco();

    EnderecoVo getEnderecoById(@Param("id") Long id);

    void updateEnderecoById(EnderecoVo endereco);

    void deleteEnderecoById(@Param("id") Long id);
}
