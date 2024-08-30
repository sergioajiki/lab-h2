package com.projetos.labH2.service;

import com.projetos.labH2.labDAO.PessoaDao;
import com.projetos.labH2.labVO.PessoaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaDao pessoaDao;

    // Método para obter uma lista com todas as pessoas
    public List<PessoaVo> getAllPessoas() {
        return pessoaDao.getAllPessoas();
    }

    // Método para obter uma pessoa pelo ID
    public PessoaVo getPessoaById(Integer id) {
        return pessoaDao.getPessoaById(id);
    }

    // Método para cadastrar uma pessoa
    public void cadastrarPessoa(PessoaVo pessoa) {
        pessoaDao.insertPessoa(pessoa);
    }

    // Método para deletar uma pessoa pelo ID
    public boolean deletarPessoaById(int id) {
        return pessoaDao.deletePessoaById(id);
    }
}
