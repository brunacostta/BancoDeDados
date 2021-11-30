package com.bruna.atp64.api;

import java.util.List;

import com.bruna.atp64.model.CadastroClienteModel;
import com.bruna.atp64.repository.CadastroClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Crie os 4 métodos para tratar todas as operações de CRUD. Os métodos devem responder a uma única url, que deve ser precedida por/api.
@RestController
@RequestMapping("/api/cadastroCliente")
public class CadastroApi {

    @Autowired
    private CadastroClienteRepository repository;

    @GetMapping
    public List<CadastroClienteModel> CadastroClientes(String nome){
        if (nome != null) {
            return (List<CadastroClienteModel>)repository.findByNome(nome);
        }
        return (List<CadastroClienteModel>)repository.findAll();
    }
    
    @PostMapping
    public String salvar(@RequestBody CadastroClienteModel model){
        repository.save(model);
        return "Salvo com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "Deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody CadastroClienteModel model, @PathVariable int id){
        if (model.getId() == id) {
            repository.save(model);
            return "Alterado com sucesso!"; 
        }
        return "Id da url diferente do body";
    }
}
