package br.com.arquiteturasoftware.domain.Endereco;

import br.com.arquiteturasoftware.domain.Pessoa.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "endereco")
@Getter
@Setter
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @NotEmpty
    @NotBlank
    @Size(max = 256)
    @Column(name = "logradouro")
    private String logradouro;

    @NotEmpty
    @NotBlank
    @Size(max = 120)
    @Column(name = "bairro")
    private String bairro;

    @NotEmpty
    @NotBlank
    @Size(max = 120)
    @Column(name = "complemento")
    private String complemento;

    @NotEmpty
    @NotBlank
    @Size(max = 9)
    @Column(name = "cep")
    private String cep;

    @JsonIgnore
    @OneToMany(mappedBy = "endereco")
    private List<Pessoa> pessoas;
}
