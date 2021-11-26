package com.bruna.banco2.repository;

import com.bruna.banco2.model.Cliente;

import org.springframework.data.repository.CrudRepository;

//Crie uma camada repository e adicione a interface ClienteRepository que herda de CrudRepository.
public interface ClienteRepository extends CrudRepository <Cliente,Integer> {
    
}
