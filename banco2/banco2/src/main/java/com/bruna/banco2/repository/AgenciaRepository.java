package com.bruna.banco2.repository;

import com.bruna.banco2.model.Agencia;

import org.springframework.data.repository.CrudRepository;

//Teste as operações de CRUD da repository na classe principal da aplicação.
public interface AgenciaRepository extends CrudRepository <Agencia, Integer> {
    
}
