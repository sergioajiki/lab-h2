package com.projetos.labH2.controller;

import com.projetos.labH2.labVO.PessoaVo;
import com.projetos.labH2.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa/{id}")
    public PessoaVo getPessoaById(@PathVariable int id) {
        return pessoaService.getPessoaById(id);
    }
}
