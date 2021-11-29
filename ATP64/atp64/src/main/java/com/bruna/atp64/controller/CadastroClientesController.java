package com.bruna.atp64.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bruna.atp64.model.CadastroClienteModel;
import com.bruna.atp64.repository.CadastroClienteRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String formulario(HttpServletRequest req){
        CadastroClienteModel model = new CadastroClienteModel();
        req.setAttribute("cadastro", model);
        return "cadastroCliente-form";
    }

    @PostMapping("/cadastroCliente/salvar")
    public String salvar(CadastroClienteModel model){
        repository.save(model);
        return "redirect:/cadastroCliente";
    }

    @GetMapping("/cadastroCliente/deletar/{id}")
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "redirect:/cadastroCliente";
    }

    @GetMapping("/cadastroCliente/editar/{id}")
    public String editar(@PathVariable int id, HttpServletRequest req){
        CadastroClienteModel model = repository.findById(id).get();
        req.setAttribute("cadastro", model);
        return "cadastroCliente-form";
    }
}
