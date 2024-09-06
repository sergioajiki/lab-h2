package com.projetos.labH2.service;

import com.projetos.labH2.advice.exceptions.InvalidCepException;
import com.projetos.labH2.advice.exceptions.NotFoundException;
import com.projetos.labH2.labDAO.EnderecoDao;
import com.projetos.labH2.labVO.EnderecoVo;
import com.projetos.labH2.labVO.RequestEnderecoVo;
import com.projetos.labH2.util.CepValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoDao enderecoDao;

    public void cadastrarEndereco(RequestEnderecoVo endereco) {
        validarCep(endereco.getCep());

        endereco.setLogradouro(endereco.getLogradouro().toLowerCase());
        endereco.setComplemento(endereco.getComplemento().toLowerCase());
        endereco.setBairro(endereco.getBairro().toLowerCase());
        endereco.setCep(CepValidator.formatCep(endereco.getCep()));
        endereco.setCidade(endereco.getCidade().toLowerCase());
        endereco.setEstado(endereco.getEstado().toUpperCase());

        enderecoDao.registerOnlyEndereco(endereco);
    }

    public List<EnderecoVo> getAllEndereco() {
        return enderecoDao.getAllEndereco();
    }

    public EnderecoVo getEnderecoById(Long id){
        Optional<EnderecoVo> enderecoOptional = Optional.ofNullable(enderecoDao.getEnderecoById(id));
        if(enderecoOptional.isEmpty()){
            throw new NotFoundException("Endereço com id " + id + " não foi encontrado");
        }
        return enderecoDao.getEnderecoById(id);
    }

    public EnderecoVo updateEnderecoById(Long id, RequestEnderecoVo endereco){
        validarCep(endereco.getCep());

        Optional<EnderecoVo> enderecoOptional = Optional.ofNullable(enderecoDao.getEnderecoById(id));
        if(enderecoOptional.isEmpty()){
            throw new NotFoundException("Endereço com id " + id + " não foi encontrado");
        }
        EnderecoVo enderecoToUpdate = enderecoOptional.get();

        enderecoToUpdate.setLogradouro(endereco.getLogradouro().toLowerCase());
        enderecoToUpdate.setComplemento(endereco.getComplemento().toLowerCase());
        enderecoToUpdate.setBairro(endereco.getBairro().toLowerCase());
        enderecoToUpdate.setCep(CepValidator.formatCep(endereco.getCep()));
        enderecoToUpdate.setCidade(endereco.getCidade().toLowerCase());
        enderecoToUpdate.setEstado(endereco.getEstado().toUpperCase());

        enderecoDao.updateEnderecoById(enderecoToUpdate);

        return enderecoToUpdate;
    }

    public void deleteEndereco(Long id){
        Optional<EnderecoVo> enderecoOptional = Optional.ofNullable(enderecoDao.getEnderecoById(id));
        if(enderecoOptional.isEmpty()){
            throw new NotFoundException("Endereço com id " + id + " não foi encontrado");
        }

        enderecoDao.deleteEnderecoById(id);
    }

    // Método para validar o formato do CEP
    private void validarCep(String cep){
        if(!CepValidator.isValidCep(cep)){
            throw new InvalidCepException("Formato do Cep é inválido");
        }
    }

    private String formatCep(String cep){
        if(cep == null || cep.length() != 8) {
            throw new InvalidCepException("Formato do Cep é inválido. O CEP deve conter exatamente 8 caracteres.");
        }
        return cep.substring(0,5) + "-" + cep.substring(5);
    }
}
