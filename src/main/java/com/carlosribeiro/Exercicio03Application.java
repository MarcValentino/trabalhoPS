package com.carlosribeiro;

import com.carlosribeiro.modelo.Autor;
import com.carlosribeiro.servico.AutorService;
import com.carlosribeiro.util.Util;
import corejava.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Exercicio03Application implements CommandLineRunner {

	@Autowired
	private AutorService autorService;

	public static void main(String[] args) {

		SpringApplication.run(Exercicio03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String nome;
		String lanceMinimo;
		Autor umAutor;

		boolean continua = true;
		while (continua) {
			System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um autor");
			System.out.println("2. Alterar um autor");
			System.out.println("3. Remover um autor");
			System.out.println("4. Listar todos os autores");
			System.out.println("5. Sair");

			int opcao = Console.readInt('\n' +
					"Digite um número entre 1 e 5:");

			switch (opcao) {
				case 1 -> {
					nome = Console.readLine('\n' +
							"Informe o nome do autor: ");
					lanceMinimo = Console.readLine(
							"Informe o nome da instituição: ");

					umAutor = new Autor(nome, lanceMinimo);

					autorService.inclui(umAutor);

					System.out.println('\n' + "Autor número " +
							umAutor.getId() + " incluído com sucesso!");

				}
				case 2 -> {
					int resposta = Console.readInt('\n' +
							"Digite o número do autor que você deseja alterar: ");
					try{
						autorService.alterarAutor(resposta);
					}
					catch (Exception e){
						System.out.println(e.getMessage());
					}
				}
				case 3 -> {
					int resposta = Console.readInt('\n' +
							"Digite o número do autor que você deseja remover: ");
					autorService.removerAutor(resposta);
				}
				case 4 -> {
					List<Autor> autores = autorService.recuperaAutores();

					for (Autor autor : autores) {
						System.out.println('\n' +
								"Id = " + autor.getId() +
								"  Nome = " + autor.getNome() +
								"  Instituição = " + autor.getInstituicao());
					}

				}
				case 5 -> {
					continua = false;
				}
				default -> System.out.println('\n' + "Opção inválida!");
			}
		}

	}
}
