package com.projetos.labH2.service;

import com.projetos.labH2.labDAO.EnderecoDao;
import com.projetos.labH2.labVO.EnderecoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoDao enderecoDao;

    public void cadastrarEndereco(EnderecoVo endereco) {
        enderecoDao.insertEndereco(endereco);
    }

    public List<EnderecoVo> getAllEndereco() {
        return enderecoDao.getAllEndereco();
    }

    public EnderecoVo getEnderecoById(Long id){
        return enderecoDao.getEnderecoById(id);
    }
    public EnderecoVo updateEnderecoById(Long id, EnderecoVo endereco){
        enderecoDao.updateEnderecoById(id, endereco);
        return endereco;
    }

    public void deleteEndereco(Long id){
        enderecoDao.deleteEnderecoById(id);
    }
}
