package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Genero {
	
	// Atributos da classe

	public String nome;
	
	public static ArrayList<Genero> lista = new ArrayList<>();
	
	// Método para associar um gênero literário à um livro
	
	public static void associar(Livro livroEscolhido) {
		
		if (lista.isEmpty()) {
			System.out.println("Não há gêneros literários cadastrados no sistema.");
			return;
		}
		
		Scanner input = Biblioteca.input;
		String auxOp;
		Integer auxPos, i = 0;
		
		do {
			
			System.out.println("- MENU DE ASSOCIAÇÃO DE GÊNERO LITERÁRIO EM LIVRO -");	
			System.out.println("Todos os gêneros literários disponíveis para associação:");
			i = 0;
			for (Genero vet : lista) {
				System.out.println(i + " - " + vet.nome);
				i++;					
			}
			
			System.out.println("");
			System.out.print("Digite o código do gênero literário que você quer associar ao livro '" + livroEscolhido.titulo + "': ");
			auxPos = Integer.valueOf(input.nextLine());	
			
			System.out.println("");
			
			while ((auxPos < 0) || (auxPos >= i)) {
				System.out.print("ERRO! Digite um código de gênero literário válido: ");
				auxPos = Integer.valueOf(input.nextLine());
				System.out.println("");
			}
			
			Genero generoEscolhido = lista.get(auxPos);

			livroEscolhido.generos.add(generoEscolhido);

			System.out.println("Gênero literário '" + generoEscolhido.nome + "' associado com sucesso ao livro '" + livroEscolhido.titulo + "'!");
			System.out.println("");
			
			System.out.print("Deseja associar outro gênero literário ao livro '" + livroEscolhido.titulo + "'? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada válida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if (auxOp.equals("n")) {
				auxOp = "N";
			}
			
		
			
		} while (!auxOp.equals("N"));
	
			
	}
	
	// Método para criar um novo gênero literário
	
	public static ArrayList<Genero> criar() {

		Scanner input = Biblioteca.input;
		String auxOp;
		
		do {	
			Genero novoGenero = new Genero();
			
			System.out.println("- MENU DE CADASTRO DE GÊNERO LITERÁRIO -");
			System.out.print("Digite o nome do gênero literário que você quer cadastrar no sistema: ");
			novoGenero.nome = input.nextLine();
	
			lista.add(novoGenero);
	
			System.out.println("");
			System.out.println("Gênero literário '" + novoGenero.nome + "' cadastrado com sucesso!");
			System.out.println("");
			
			System.out.print("Deseja cadastrar algum outro gênero literário? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada válida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if (auxOp.equals("n")) {
				return null;
			}
			
		} while ((!auxOp.equals("N")));
			
		return lista;
	
	}
	
	// Método para editar um gênero literário
	
	public static void editar(Genero generoEscolhido) {
		
		if (generoEscolhido == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE EDIÇÃO DE GÊNERO LITERÁRIO -");
		System.out.print("Digite o novo nome do gênero literário: ");
		String novoNome = input.nextLine();
		
		generoEscolhido.nome = novoNome;
		
		System.out.println("");
		System.out.println("Gênero literário alterado com sucesso!");
		System.out.println("");
		
		return;
	}
	
	// Método para excluir um gênero literário
	
	public static void excluir(ArrayList<Livro> livros, Genero generoEscolhido) {
		
		if (generoEscolhido == null) {
			return;
		}
		
		for (Livro vet : livros) {
			vet.generos.remove(generoEscolhido);
		}
	
		lista.remove(generoEscolhido);
		
		System.out.println("Gênero literário '" + generoEscolhido.nome + "' excluído com sucesso!");
		System.out.println("");
		
		return;
	}
	
	// Método para escolher um gênero literário
	
	public static Genero escolher(ArrayList<Genero> generos) {
		
		if (generos.isEmpty()) {
			System.out.println("Não há gêneros literários registrados no sistema.");
			System.out.println("");
			return null;
		}
		
		Scanner input = Biblioteca.input;
		Integer i = 0;
		
		System.out.println("- MENU DE SELEÇÃO DE GÊNERO LITERÁRIO - ");
		System.out.println("Gêneros literários cadastrados no sistema:");
		
		for (Genero vet : generos) {
			System.out.println(i + " - " + vet.nome);
			i++;
		}
		
		System.out.println("");
		System.out.print("Digite o código do gênero literário: ");
		Integer auxPos = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxPos < 0) || (auxPos >= i)) {
			System.out.print("ERRO! Digite um código válido: ");
			auxPos = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return generos.get(auxPos);
	}
	
}
