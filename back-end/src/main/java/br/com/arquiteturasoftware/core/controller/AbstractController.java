package br.com.arquiteturasoftware.core.controller;

import br.com.arquiteturasoftware.core.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public abstract class AbstractController<T> extends ResponseAbstractController implements IController<T> {

    @Autowired
    protected IService<T> service;

    /**
     * Retorna uma lista
     */
    @GetMapping
    public ResponseEntity<?> findAll() {
        return jsonResponse(service.findAll());
    }

    /**
     * Retorna um registro pelo ID
     */
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return jsonResponse(service.findById(id));
    }

    /**
     * Salva um novo registro
     */
    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody T object, Errors errors) {
        return jsonResponse(service.save(object, errors));
    }

    /**
     * Atualiza um registro que já existe
     */

    @PutMapping
    public ResponseEntity<?> update(@Validated @RequestBody T object, Errors errors) {
        return jsonResponse(service.save(object, errors));
    }

    /**
     * Método para deletar um registro pelo ID
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        service.deleteById(id);
        return jsonResponse();
    }
}
