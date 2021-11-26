package com.bruna.banco2;

import java.util.List;

import com.bruna.banco2.model.Cliente;
import com.bruna.banco2.repository.ClienteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Banco2Application implements CommandLineRunner{
	private ClienteRepository repository;

	public Banco2Application(ClienteRepository repository){
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Banco2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente model = new Cliente();
		model.setId(4);
		model.setNome("Adriana");
		model.setSobrenome("Costa");

		repository.save(model);
		
		repository.deleteById(1);
		
		repository.findAll().forEach(cliente -> System.out.printf("\nId: %d || Nome: %s || Sobrenome: %s ", cliente.getId(), cliente.getNome(), cliente.getSobrenome()));
		System.out.println("\n");
	}
}
