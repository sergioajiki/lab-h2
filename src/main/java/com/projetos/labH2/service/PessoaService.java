package com.projetos.labH2.service;

import com.projetos.labH2.advice.exceptions.InvalidEmailFormatException;
import com.projetos.labH2.advice.exceptions.NotFoundException;
import com.projetos.labH2.labDAO.PessoaDao;
import com.projetos.labH2.labVO.PessoaVo;
import com.projetos.labH2.util.EmailValidator;
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

    // Método para buscar pessoa por nome
    public List<PessoaVo> getPessoaByNome(String nome) {
        return pessoaDao.getPessoaByNome(nome);
    }

    // Método para obter uma pessoa pelo ID
    public PessoaVo getPessoaById(Long id) {
        var pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaById(id));
        if (pessoaOptional.isEmpty()) {
            throw new NotFoundException(String.format("Pessoa com id %d não encontrado", id));
        }
        return pessoaOptional.get();
    }

    // Método para cadastrar uma pessoa
    public void cadastrarPessoa(PessoaVo pessoa) {
        boolean isEmail = EmailValidator.isValidEmail(pessoa.getEmail());
        if (!isEmail) {
            throw new InvalidEmailFormatException("Formato de email inválido");
        }
        pessoaDao.insertPessoa(pessoa);
    }

    // Método para atualizar uma pessoa
    public PessoaVo updatePessoaById(Long id, PessoaVo pessoa) {
        boolean isEmail = EmailValidator.isValidEmail(pessoa.getEmail());
        if (!isEmail) {
            throw new InvalidEmailFormatException("Formato de email inválido");
        }
        Optional<PessoaVo> pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaById(id));
        if (pessoaOptional.isEmpty()) {
            throw new NotFoundException(String.format("Pessoa com id %d não encontrado", id));
        }
        pessoa.setId(id); // Confirma que o id seja atualizado corretamente
        pessoaDao.updatePessoaById(pessoa);
        return pessoa;
    }

    // Método para deletar uma pessoa pelo ID
    public void deletarPessoaById(Long id) {
        Optional<PessoaVo> pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaById(id));
        if (pessoaOptional.isEmpty()) {
            throw new NotFoundException(String.format("Pessoa com id %d não encontrado", id));
        }
        pessoaDao.deletePessoaById(id);
    }
}
