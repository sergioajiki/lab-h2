package com.projetos.labH2;

import com.projetos.labH2.labDAO.PessoaDao;
import com.projetos.labH2.labVO.PessoaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseVerifier implements CommandLineRunner {
    @Autowired
    private PessoaDao pessoaDao;

    @Override
    public void run(String... args) throws Exception {
        try {
            // Tenta buscar todas as pessoas para verificar se a tabela existe
            List<PessoaVo> pessoas = pessoaDao.getAllPessoas();
            System.out.println("Banco de dados criado com sucesso! Tabela 'pessoa' contém " + pessoas.size() + " registros.");
        } catch (Exception e) {
            // Em caso de erro, exibe uma mensagem de falha
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }
}
