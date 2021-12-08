package com.bruna.atp64.repository;

import com.bruna.atp64.model.TipoClienteModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TipoClienteRepository extends PagingAndSortingRepository <TipoClienteModel,Integer> {
    
}
