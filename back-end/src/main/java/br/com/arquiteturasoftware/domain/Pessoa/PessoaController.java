package br.com.arquiteturasoftware.domain.Pessoa;

import br.com.arquiteturasoftware.core.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController extends AbstractController<Pessoa> {

    @Autowired
    PessoaMapper pessoaMapper;

    @Autowired
    PessoaService pessoaService;

    /**
     * Retorna uma lista com data formatada e sem ederenço embutido
     */
    @GetMapping("/dto")
    public ResponseEntity<?> findAllDTO() {
        return jsonResponse(service.findAll().stream()
                            .map(pessoa -> pessoaMapper.convertToDtoFind(pessoa))
                            .collect(Collectors.toList()));
    }

    /**
     * Salva um novo registro utilizando DTO e protegendo atributo admin
     */
    @PostMapping("dto")
    public ResponseEntity<?> saveDTO(@Validated @RequestBody Pessoa pessoa, Errors errors) {
        return jsonResponse(pessoaService.saveDTO(pessoa, errors));
    }


}
