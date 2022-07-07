package com.api.projeto1;

import com.api.projeto1.model.Lista;
import com.api.projeto1.model.Nome;
import com.api.projeto1.repository.ListaRepository;
import com.api.projeto1.repository.NomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class Projeto1Application implements CommandLineRunner {
	@Autowired
	private ListaRepository listaRepository;

	@Autowired
	private NomeRepository nomeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Lista lista1 = new Lista(null,"lista 1");
		Nome nome1 = new Nome(null,"Charles",lista1);
		lista1.getNomes().addAll(Arrays.asList(nome1));

		listaRepository.save(lista1);
		nomeRepository.save(nome1);

	}
}
