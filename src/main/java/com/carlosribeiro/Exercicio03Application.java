package com.carlosribeiro;

import com.carlosribeiro.modelo.Produto;
import com.carlosribeiro.servico.ProdutoService;
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
	private ProdutoService produtoService;

	public static void main(String[] args) {

		SpringApplication.run(Exercicio03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String nome;
		double lanceMinimo;
		String dataCadastro;
		Produto umProduto;

		boolean continua = true;
		while (continua) {
			System.out.println('\n' + "O que você deseja fazer?");
			System.out.println('\n' + "1. Cadastrar um produto");
			System.out.println("2. Alterar um produto");
			System.out.println("3. Remover um produto");
			System.out.println("4. Listar todos os produtos");
			System.out.println("5. Sair");

			int opcao = Console.readInt('\n' +
					"Digite um número entre 1 e 5:");

			switch (opcao) {
				case 1 -> {
					nome = Console.readLine('\n' +
							"Informe o nome do produto: ");
					lanceMinimo = Console.readDouble(
							"Informe o valor do lance mínimo: ");
					dataCadastro = Console.readLine(
							"Informe a data de cadastramento do produto: ");

					umProduto = new Produto(nome, lanceMinimo, Util.strToLocalDate(dataCadastro));

					produtoService.inclui(umProduto);

					System.out.println('\n' + "Produto número " +
							umProduto.getId() + " incluído com sucesso!");

				}
				case 2 -> {

				}
				case 3 -> {

				}
				case 4 -> {
					List<Produto> produtos = produtoService.recuperaProdutos();

					for (Produto produto : produtos) {
						System.out.println('\n' +
								"Id = " + produto.getId() +
								"  Nome = " + produto.getNome() +
								"  Lance mínimo = " + Util.doubleToStr(produto.getLanceMinimo()) +
								"  Data Cadastro = " + Util.dateToStr(produto.getDataCadastro()));
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
