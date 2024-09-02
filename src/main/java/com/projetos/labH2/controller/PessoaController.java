package com.projetos.labH2.controller;

import com.projetos.labH2.labVO.PessoaVo;
import com.projetos.labH2.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Pessoas")
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    // Endpoint exibir uma lista com todas as pessoas
    @GetMapping
    @Operation(description = "Lista todas as pessoas")
    public List<PessoaVo> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

    // Endpoint para buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    @Operation(description = "Busca uma pessoa selecionada por id")
    public PessoaVo getPessoaById(@PathVariable int id) {
        return pessoaService.getPessoaById(id);
    }

    // Endpoint para cadastrar uma pessoa
    @PostMapping("/cadastrar")
    @Operation(description = "Cadastra uma pessoa")
    public String cadastrarPessoa(@RequestBody PessoaVo pessoa) {
        try {
            pessoaService.cadastrarPessoa(pessoa);
            return "Pessoa cadastrada com sucesso!";
        } catch (Exception ex) {
            return "Erro ao cadastrar pessoa" + ex.getMessage();
        }
    }

    // Endpoint para apagar uma pessoa pelo ID
    @DeleteMapping("/{id}")
    @Operation(description = "Apaga o registro da pessoa selecionada por id")
    public void deletarPessoa(@PathVariable int id) {
        pessoaService.deletarPessoaById(id);
    }
}
