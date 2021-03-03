package br.com.arquiteturasoftware.domain.Pessoa;

import br.com.arquiteturasoftware.core.enums.CustomMessageError;
import br.com.arquiteturasoftware.core.exception.custom.CustomBadRequestException;
import br.com.arquiteturasoftware.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PessoaService extends AbstractService<Pessoa> {

    @Autowired
    PessoaMapper pessoaMapper;

    /**
     * Salva um novo registro utilizando DTO
     */
    public Pessoa saveDTO(Pessoa pessoa, Errors errors) {
        if(errors.hasErrors()){
            throw new CustomBadRequestException(CustomMessageError.BAD_REQUEST.getDescricao());
        }

        PessoaSaveDTO pessoaSaveDTO = pessoaMapper.convertToDtoSave(pessoa);

        return repository.save(pessoaMapper.convertToEntity(pessoaSaveDTO));
    }
}
