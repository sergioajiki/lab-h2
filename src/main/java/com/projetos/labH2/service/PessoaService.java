package com.projetos.labH2.service;

import com.projetos.labH2.labDAO.PessoaDao;
import com.projetos.labH2.labVO.PessoaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void deletarPessoaById(int id) {
        pessoaDao.deletePessoaById(id);
    }

    // Método para atualizar uma pessoa
    public void updatePessoaById(int id, PessoaVo pessoa) {
        Optional<PessoaVo> pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaById(id));
        if (pessoaOptional.isEmpty()) {
            throw new RuntimeException("Pessoa não encontrada");
        }
        pessoa.setId(id);
        pessoaDao.updatePessoaById(pessoa);
    }
}
