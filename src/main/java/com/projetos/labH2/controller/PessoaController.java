package com.projetos.labH2.controller;

import com.projetos.labH2.labVO.PessoaVo;
import com.projetos.labH2.labVO.RequestCadastroVo;
import com.projetos.labH2.labVO.RequestPessoaVo;
import com.projetos.labH2.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Endpoint exibir uma lista com pessoas selecionada por nome
    @GetMapping("/buscarPorNome")
    @Operation(description = "Busca uma lista de pessoa por nome")
    public ResponseEntity<List<PessoaVo>> getPessoaByNome(@RequestParam String nome) {
        List<PessoaVo> pessoaByNome = pessoaService.getPessoaByNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaByNome);
    }

    // Endpoint exibir uma lista com pessoas selecionada por bairro
    @GetMapping("/buscarPorBairro")
    @Operation(description = "Busca uma lista de pessoa por bairro")
    public ResponseEntity<List<PessoaVo>> getPessoaByBairro(@RequestParam String bairro) {
        List<PessoaVo> pessoaByBairro = pessoaService.getPessoaByBairro(bairro);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaByBairro);
    }

    // Endpoint exibir uma lista com pessoas selecionada por cidade
    @GetMapping("/buscarPorCidade")
    @Operation(description = "Busca uma lista de pessoa por cidade")
    public ResponseEntity<List<PessoaVo>> getPessoaByCidade(@RequestParam String cidade) {
        List<PessoaVo> pessoaByCidade = pessoaService.getPessoaByCidade(cidade);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaByCidade);
    }

    // Endpoint para buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    @Operation(description = "Busca uma pessoa selecionada por id")
    public ResponseEntity<PessoaVo> getPessoaById(@PathVariable Long id) {
        PessoaVo pessoaById = pessoaService.getPessoaById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaById);
    }

    // Endpoint exibir uma lista com pessoas por intervalo de data de nascimento
    @GetMapping("/buscarPessoasPorDataNascimento")
    @Operation(description = "Lista pessoas por intervalo de data de nascimento")
    public ResponseEntity<List<PessoaVo>> getPessoaByDataNascimentoRange(@RequestParam String dataInicio, @RequestParam String dataFim) {
        List<PessoaVo> pessoaFound = pessoaService.getPessoaByDataNascimentoRange(dataInicio, dataFim);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaFound);
    }

    // Endpoint para cadastrar uma pessoa com endereço
    @PostMapping("/cadastrar")
    @Operation(description = "Cadastra uma pessoa")
    public ResponseEntity<String> cadastrarPessoaAndEndereco(@RequestBody @Valid RequestCadastroVo pessoa) {
        pessoaService.registrarPessoaAndEndereco(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa cadastrada com sucesso");
    }

    // Endpoint para cadastrar uma pessoa
    @PostMapping("/cadastrarPessoa")
    @Operation(description = "Cadastra uma pessoa")
    public ResponseEntity<String> cadastrarPessoa(@RequestBody @Valid RequestPessoaVo pessoa) {
        pessoaService.cadastrarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa cadastrada com sucesso");
    }

    // Endpoint para atualizar uma pessoa pelo ID
    @PutMapping("/{id}")
    @Operation(description = "Atualiza o resgistro da pessoa selecionada por id")
    public ResponseEntity<String> updatePessoa(@PathVariable Long id, @RequestBody @Valid RequestPessoaVo pessoa) {
        PessoaVo pessoaUpdatedById = pessoaService.updatePessoaById(id, pessoa);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa " + pessoaUpdatedById.getId() + " atualizada com sucesso!");
    }

    // Endpoint para apagar uma pessoa pelo ID
    @DeleteMapping("/{id}")
    @Operation(description = "Apaga o registro da pessoa selecionada por id")
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoaById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa com o id " + id + " apagada com sucesso!");
    }
}
