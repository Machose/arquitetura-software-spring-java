package br.com.arquiteturasoftware.core.service;

import br.com.arquiteturasoftware.core.exception.custom.CustomBadRequestException;
import br.com.arquiteturasoftware.core.exception.custom.CustomNotFoundException;
import br.com.arquiteturasoftware.core.enums.CustomMessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.Errors;

import java.util.List;

public abstract class AbstractService<T> implements IService<T> {

    @Autowired
    protected JpaRepository<T, Long> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(long id) {
        try{
            return repository.findById(id).get(); /**findById retorna um optional por isso é necessário usar um get()*/
        }catch (Exception e){
            throw new CustomNotFoundException(CustomMessageError.NOT_FOUND.getDescricao());
        }
    }

    public T save(T object, Errors errors) {
        if(errors.hasErrors()){
            throw new CustomBadRequestException(CustomMessageError.BAD_REQUEST.getDescricao());
        }
        return repository.save(object);
    }

    public void deleteById(long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Erro ao deletar registro");
        }
    }
}
