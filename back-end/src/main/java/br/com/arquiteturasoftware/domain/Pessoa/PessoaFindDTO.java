package br.com.arquiteturasoftware.domain.Pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PessoaFindDTO {

    private long id;

    private String nome;

    private String sobrenome;

    private Boolean admin;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
}
