package com.projetos.labH2.labDAO;

import com.projetos.labH2.labVO.EnderecoVo;
import com.projetos.labH2.labVO.RequestEnderecoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnderecoDao {
    void insertEndereco(EnderecoVo endereco);

    void registerOnlyEndereco(RequestEnderecoVo endereco);

    List<EnderecoVo> getAllEndereco();

    EnderecoVo getEnderecoById(@Param("id") Long id);

    void updateEnderecoById(EnderecoVo endereco);

    void deleteEnderecoById(@Param("id") Long id);

    boolean existById(@Param("id")Long id);
}
