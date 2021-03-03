package br.com.arquiteturasoftware.domain.Endereco;

import br.com.arquiteturasoftware.core.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends AbstractController<Endereco> {
}
