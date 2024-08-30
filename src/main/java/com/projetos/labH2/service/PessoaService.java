package com.projetos.labH2.service;

import com.projetos.labH2.labDAO.PessoaDao;
import com.projetos.labH2.labVO.PessoaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    private PessoaDao pessoaDao;

    public PessoaVo getPessoaById(Integer id) {
        return pessoaDao.getPessoaById(id);
    }
}
