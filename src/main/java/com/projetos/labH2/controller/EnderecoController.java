package com.projetos.labH2.controller;

import com.projetos.labH2.labVO.EnderecoVo;
import com.projetos.labH2.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Endereços")
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    @Operation(description = "Exibe a lista de todos os endereços cadastrados")
    public ResponseEntity<List<EnderecoVo>> getAllEndereco() {
        List<EnderecoVo> allEndereco = enderecoService.getAllEndereco();
        return ResponseEntity.status(HttpStatus.OK).body(allEndereco);
    }

    @GetMapping("/{id}")
    @Operation(description = "Busca um endereço selecionado por id")
    public ResponseEntity<EnderecoVo> getEnderecoById(@PathVariable Long id) {
        EnderecoVo enderecoById = enderecoService.getEnderecoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoById);
    }

    @PostMapping("/cadastrar")
    @Operation(description = "Cadastra as informações de um endereço")
    public ResponseEntity<String> cadastrarEndereco(@Valid @RequestBody EnderecoVo endereco) {
        enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço Cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    @Operation(description = "Atualiza as informações de um endereço selecionado por Id")
    public ResponseEntity<String> updateEndereco(@PathVariable Long id, @Valid @RequestBody EnderecoVo endereco) {
        EnderecoVo enderecoById = enderecoService.updateEnderecoById(id, endereco);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço com a id " + enderecoById.getId() + " foi atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Apaga o registro de um endereço selecionado por Id")
    public ResponseEntity<String> deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço com a id " + id + " apagado com sucesso!");
    }
}
