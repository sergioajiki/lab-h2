package com.projetos.labH2.controller;

import com.projetos.labH2.labVO.PessoaVo;
import com.projetos.labH2.service.PessoaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Pessoas" )
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaVo> getAllPessoas() {
        return pessoaService.getAllPessoas();
    }

    @GetMapping("/pessoa/{id}")
    public PessoaVo getPessoaById(@PathVariable int id) {
        return pessoaService.getPessoaById(id);
    }

    @PostMapping("/cadastrar")
    public String cadastrarPessoa(@RequestBody PessoaVo pessoa) {
        try {
            pessoaService.cadastrarPessoa(pessoa);
            return "Pessoa cadastrada com sucesso!";
        } catch (Exception ex) {
            return "Erro ao cadastrar pessoa" + ex.getMessage();
        }
    }

    // Endpoint para deletar uma pessoa pelo ID
    @GetMapping("/apagar/{id}")
    public void deletarPessoa(@PathVariable int id) {
         pessoaService.deletarPessoaById(id);
    }
}
