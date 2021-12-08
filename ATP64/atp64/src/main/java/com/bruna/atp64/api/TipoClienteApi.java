package com.bruna.atp64.api;

import java.util.List;

import com.bruna.atp64.model.TipoClienteModel;
import com.bruna.atp64.repository.TipoClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipoCliente")
public class TipoClienteApi {
    
    @Autowired
    private TipoClienteRepository rep;

    public List<TipoClienteModel>list(){
        return (List<TipoClienteModel>)rep.findAll();
    }
}
