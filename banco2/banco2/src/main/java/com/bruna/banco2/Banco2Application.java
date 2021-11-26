package com.bruna.banco2;

import com.bruna.banco2.model.Agencia;
import com.bruna.banco2.model.Cliente;
import com.bruna.banco2.repository.AgenciaRepository;
import com.bruna.banco2.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Banco2Application implements CommandLineRunner{
	private ClienteRepository repository;
	private AgenciaRepository repository2;

	public Banco2Application(ClienteRepository repository, AgenciaRepository repository2){
		this.repository = repository;
		this.repository2 = repository2;
	}

	public static void main(String[] args) {
		SpringApplication.run(Banco2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Teste CRUD cliente
		Cliente model = new Cliente();
		//model.setId(4);
		model.setNome("Ines");
		model.setSobrenome("Brasil");

		repository.save(model);
		
		//repository.deleteById(1);
		
		repository.findAll().forEach(cliente -> System.out.printf("\nId: %d || Nome: %s || Sobrenome: %s ", cliente.getId(), cliente.getNome(), cliente.getSobrenome()));
		System.out.println("\n");

		// Teste CRUD agencia

		Agencia model2 = new Agencia();
		model2.setNome("Blush");
		model2.setRamo("Modelo");
		
		repository2.save(model2);

		repository2.findAll().forEach(agencia -> System.out.printf("\nId: %d || Nome: %s || Ramo: %s ", agencia.getId(), agencia.getNome(), agencia.getRamo()));
		System.out.println("\n");
	}
}
