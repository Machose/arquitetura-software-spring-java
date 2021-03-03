package br.com.arquiteturasoftware.domain.Pessoa;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PessoaFindDTO convertToDtoFind(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaFindDTO.class);
    }

    public PessoaSaveDTO convertToDtoSave(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaSaveDTO.class);
    }

    public Pessoa convertToEntity(PessoaSaveDTO pessoaDTO) {
        return modelMapper.map(pessoaDTO, Pessoa.class);
    }
}
