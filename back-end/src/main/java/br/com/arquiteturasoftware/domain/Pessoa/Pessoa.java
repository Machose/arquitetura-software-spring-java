package br.com.arquiteturasoftware.domain.Pessoa;

import br.com.arquiteturasoftware.domain.Endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @NotEmpty
    @NotBlank
    @Size(max = 120)
    @Column(name = "nome")
    private String nome;

    @NotEmpty
    @NotBlank
    @Size(max = 120)
    @Column(name = "sobrenome")
    private String sobrenome;

    @NotEmpty
    @NotBlank
    @Size(max = 11)
    @Column(name = "cpf")
    private String cpf;

    @NotEmpty
    @NotBlank
    @Column(name = "rg")
    private String rg;

    @NotNull
    @Column(name = "admin")
    private Boolean admin = false;

    @Column(name = "data_nascimento")
    @Temporal(value = TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento = new Date();

    @NotNull
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Endereco endereco;
}
