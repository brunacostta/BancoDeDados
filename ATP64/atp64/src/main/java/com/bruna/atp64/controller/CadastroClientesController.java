package com.bruna.atp64.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bruna.atp64.model.CadastroClienteModel;
import com.bruna.atp64.repository.CadastroClienteRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroClientesController {
    private CadastroClienteRepository repository;

    public CadastroClientesController(CadastroClienteRepository repository){
        this.repository = repository;
    }
    
    @GetMapping("/cadastroCliente")
    public String CadastroClientes(HttpServletRequest req){
        List<CadastroClienteModel> lista = (List<CadastroClienteModel>)repository.findAll();
        
        req.setAttribute("cadastro", lista);
        return "cadastroClientes";
    }

    @GetMapping("/cadastroCliente/form")
    public String formulario(){
        return "cadastroCliente-form";
    }

    public String salvar(){
        return "redirect: /cadastroCliente";
    }
}
