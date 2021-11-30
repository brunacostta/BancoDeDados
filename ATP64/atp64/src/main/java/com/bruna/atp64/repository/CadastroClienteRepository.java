package com.bruna.atp64.repository;

import java.util.List;

import com.bruna.atp64.model.CadastroClienteModel;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CadastroClienteRepository extends PagingAndSortingRepository <CadastroClienteModel,Integer> {
    @Override
    default Iterable<CadastroClienteModel> findAll() {
        return findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    List<CadastroClienteModel> findByNome(String nome);
}
