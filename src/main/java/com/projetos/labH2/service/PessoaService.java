package com.projetos.labH2.service;

import com.projetos.labH2.advice.exceptions.DuplicateEntryException;
import com.projetos.labH2.advice.exceptions.InvalidEmailFormatException;
import com.projetos.labH2.advice.exceptions.NotFoundException;
import com.projetos.labH2.labDAO.EnderecoDao;
import com.projetos.labH2.labDAO.PessoaDao;
import com.projetos.labH2.labVO.*;
import com.projetos.labH2.util.CepValidator;
import com.projetos.labH2.util.EmailValidator;
import com.projetos.labH2.util.FormatDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaDao pessoaDao;
    @Autowired
    private EnderecoDao enderecoDao;

    // Método para obter uma lista com todas as pessoas
    public List<PessoaVo> getAllPessoas() {
        return pessoaDao.getAllPessoas();
    }

    // Método para buscar pessoa por nome
    public List<PessoaVo> getPessoaByNome(String nome) {
        return pessoaDao.getPessoaByNome(nome.toLowerCase());
    }

    // Método para uma lista de pessoas selecionada por bairro
    public List<PessoaVo> getPessoaByBairro(String bairro) {
        return pessoaDao.getPessoaByBairro(bairro.toLowerCase());
    }

    // Método para uma lista de pessoas selecionada por cidade
    public List<PessoaVo> getPessoaByCidade(String cidade) {
        return pessoaDao.getPessoaByCidade(cidade.toLowerCase());
    }

    // Método para obter uma pessoa pelo ID
    public PessoaVo getPessoaById(Long id) {
        var pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaById(id));
        if (pessoaOptional.isEmpty()) {
            throw new NotFoundException(String.format("Pessoa com id %d não encontrado", id));
        }

        return pessoaOptional.get();
    }

    //Método para obter uma lista com pessoas por intervalo de data de nascimento
    public List<PessoaVo> getPessoaByDataNascimentoRange(String dataInicio, String dataFim) {
        // Converte as datas para o formato yyyy-MM-dd
        String dataInicioConvertida = FormatDateUtil.converterParaFormatoYYYYMMDD(dataInicio);
        String dataFimConvertida = FormatDateUtil.converterParaFormatoYYYYMMDD(dataFim);

        return pessoaDao.getPessoaByDataNascimentoRange(dataInicioConvertida, dataFimConvertida);
    }

    // Método para obter uma pessoa pelo email
    public PessoaVo getPessoaByEmail(String email) {
        var pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaByEmail(email.toLowerCase()));
        if (pessoaOptional.isEmpty()) {
            throw new NotFoundException(String.format("Pessoa com email %s não encontrado", email));
        }

        return pessoaOptional.get();
    }

    // Método para cadastrar uma pessoa com o endereço
    public void registrarPessoaAndEndereco(RequestCadastroVo infoForRegister) {
        CepValidator.validarCep(infoForRegister.getCep());
        validarEmail(infoForRegister.getEmail());

        EnderecoVo endereco = new EnderecoVo();
        endereco.setLogradouro(infoForRegister.getLogradouro().toLowerCase());
        endereco.setNumero(infoForRegister.getNumero().toLowerCase());
        endereco.setComplemento(infoForRegister.getComplemento().toLowerCase());
        endereco.setBairro(infoForRegister.getBairro().toLowerCase());
        endereco.setCep(CepValidator.formatCep(infoForRegister.getCep().toLowerCase()));
        endereco.setCidade(infoForRegister.getCidade().toLowerCase());
        endereco.setEstado(infoForRegister.getEstado().toUpperCase());

        enderecoDao.insertEndereco(endereco);

        RequestPessoaVo pessoa = new RequestPessoaVo();
        pessoa.setNome(infoForRegister.getNome());
        pessoa.setIdade(infoForRegister.getIdade());
        pessoa.setEmail(infoForRegister.getEmail().toLowerCase());
        pessoa.setData_nascimento(dataNascimentoFormatoBanco(infoForRegister.getData_nascimento()));
        pessoa.setEndereco(endereco);

        pessoaDao.insertPessoa(pessoa);
    }

    // Método para cadastrar uma pessoa
    public void cadastrarPessoa(RequestPessoaVo pessoa) {
        validarEmail(pessoa.getEmail());
        Optional<PessoaVo> pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaByEmail(pessoa.getEmail().toLowerCase()));
        if (pessoaOptional.isPresent()) {
            throw new DuplicateEntryException(String.format("Email %s já está registrado", pessoa.getEmail()));
        }
        if (pessoa.getEndereco() != null && pessoa.getEndereco().getId() != null) {
            if (!enderecoDao.existById(pessoa.getEndereco().getId())) {
                throw new NotFoundException(String.format("Endereço com id %d não foi encontrado", pessoa.getEndereco().getId()));
            }
        }
        pessoa.setNome(pessoa.getNome().toLowerCase());
        pessoa.setEmail(pessoa.getEmail().toLowerCase());
        pessoa.setData_nascimento(dataNascimentoFormatoBanco(pessoa.getData_nascimento()));

        pessoaDao.insertPessoa(pessoa);
    }

    // Método para atualizar uma pessoa
    public PessoaVo updatePessoaById(Long id, RequestPessoaVo pessoa) {
        validarEmail(pessoa.getEmail());

        Optional<PessoaVo> pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaById(id));
        if (pessoaOptional.isEmpty()) {
            throw new NotFoundException(String.format("Pessoa com id %d não encontrado", id));
        }

        Optional<PessoaVo> pessoaOptionalByEmail = Optional.ofNullable(pessoaDao.getPessoaByEmail(pessoa.getEmail().toLowerCase()));
        if (pessoaOptionalByEmail.isPresent() && !pessoaOptionalByEmail.get().getId().equals(id)) {
            throw new DuplicateEntryException(String.format("Email %s já está registrado", pessoa.getEmail()));
        }

        if (pessoa.getEndereco() != null && pessoa.getEndereco().getId() != null) {
            if (!enderecoDao.existById(pessoa.getEndereco().getId())) {
                throw new NotFoundException(String.format("Endereço com id %d não foi encontrado", pessoa.getEndereco().getId()));
            }
        }

        PessoaVo pessoaToUpdate = pessoaOptional.get();
        pessoaToUpdate.setNome(pessoa.getNome().toLowerCase());
        pessoaToUpdate.setEmail(pessoa.getEmail().toLowerCase());
        pessoaToUpdate.setEndereco(pessoa.getEndereco());
        pessoaToUpdate.setData_nascimento(dataNascimentoFormatoBanco(pessoa.getData_nascimento()));

        pessoaDao.updatePessoaById(pessoaToUpdate);

        return pessoaToUpdate;
    }

    // Método para deletar uma pessoa pelo ID
    public void deletarPessoaById(Long id) {
        Optional<PessoaVo> pessoaOptional = Optional.ofNullable(pessoaDao.getPessoaById(id));
        if (pessoaOptional.isEmpty()) {
            throw new NotFoundException(String.format("Pessoa com id %d não encontrado", id));
        }

        pessoaDao.deletePessoaById(id);
    }

    // Método para validar o formato do Email
    private void validarEmail(String email) {
        if (!EmailValidator.isValidEmail(email)) {
            throw new InvalidEmailFormatException("Formato de email inválido");
        }
    }

    // Método para converter para minúsculas
    private void normalizarDados(PessoaVo pessoa) {
        pessoa.setNome(pessoa.getNome().toLowerCase());
        pessoa.setEmail(pessoa.getEmail().toLowerCase());
    }

    // Método para converter data_nascimento para o formato yyyy-MM-dd para o registro no banco'
    private String dataNascimentoFormatoBanco(String data) {
        String dataFormatada = FormatDateUtil.converterParaFormatoYYYYMMDD(data);

        return dataFormatada;
    }
}
