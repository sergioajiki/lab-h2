package com.projetos.labH2.controller;

import com.projetos.labH2.labVO.PessoaVo;
import com.projetos.labH2.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PessoaVo>> getAllPessoas() {
        List<PessoaVo> allPessoa = pessoaService.getAllPessoas();
        return ResponseEntity.status(HttpStatus.OK).body(allPessoa);
    }

    // Endpoint para buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    @Operation(description = "Busca uma pessoa selecionada por id")
    public ResponseEntity<PessoaVo> getPessoaById(@PathVariable Long id) {
        PessoaVo pessoaById = pessoaService.getPessoaById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaById);
    }

    // Endpoint para cadastrar uma pessoa
    @PostMapping("/cadastrar")
    @Operation(description = "Cadastra uma pessoa")
    public ResponseEntity<String> cadastrarPessoa(@RequestBody @Valid PessoaVo pessoa) {
        pessoaService.cadastrarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa cadastrada com sucesso");
    }

    // Endpoint para apagar uma pessoa pelo ID
    @DeleteMapping("/{id}")
    @Operation(description = "Apaga o registro da pessoa selecionada por id")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa com o id " + id + " apagada com sucesso!");
    }

    // Endpoint para atualizar uma pessoa pelo ID
    @PutMapping("/{id}")
    @Operation(description = "Atualiza o resgistro da pessoa selecionada por id")
    public ResponseEntity<String> updatePessoa(@PathVariable Long id, @RequestBody @Valid PessoaVo pessoa) {
        PessoaVo pessoaUpdatedById = pessoaService.updatePessoaById(id, pessoa);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa " + pessoa.getNome() + " atualizada com sucesso!");
    }
}
