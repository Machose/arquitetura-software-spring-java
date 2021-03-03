package br.com.arquiteturasoftware.domain.Pessoa;

import br.com.arquiteturasoftware.domain.Endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class PessoaSaveDTO {
    private long id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String rg;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    private Endereco endereco;
}
