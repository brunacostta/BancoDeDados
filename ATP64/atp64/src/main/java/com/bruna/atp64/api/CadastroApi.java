package com.bruna.atp64.api;

import java.util.List;

import com.bruna.atp64.model.CadastroClienteModel;
import com.bruna.atp64.repository.CadastroClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Crie os 4 métodos para tratar todas as operações de CRUD. Os métodos devem responder a uma única url, que deve ser precedida por/api.
@RestController
public class CadastroApi {

    @Autowired
    private CadastroClienteRepository repository;

    @GetMapping("/api/cadastroCliente")
    public List<CadastroClienteModel> CadastroClientes(){
        List<CadastroClienteModel> lista = (List<CadastroClienteModel>)repository.findAll();
        return lista;
    }
    
    @PostMapping("/api/cadastroCliente")
    public String salvar(@RequestBody CadastroClienteModel model){
        repository.save(model);
        return "Salvo com sucesso!";
    }

    @DeleteMapping("/api/cadastroCliente/{id}")
    public String deletar(@PathVariable int id){
        repository.deleteById(id);
        return "Deletado com sucesso!";
    }

    @PutMapping("/api/cadastroCliente/{id}")
    public String update(@RequestBody CadastroClienteModel model, @PathVariable int id){
        if (model.getId() == id) {
            repository.save(model);
            return "Alterado com sucesso!"; 
        }
        return "Id da url diferente do body";
    }
}
