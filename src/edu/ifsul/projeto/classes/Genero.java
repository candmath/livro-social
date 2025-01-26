package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Genero {
	
	// Atributos da classe

	public String nome;
	
	public static ArrayList<Genero> lista = new ArrayList<>();
	
	// M�todo para associar um g�nero liter�rio � um livro
	
	public static void associar(Livro livroEscolhido) {
		
		if (lista.isEmpty()) {
			System.out.println("N�o h� g�neros liter�rios cadastrados no sistema.");
			return;
		}
		
		Scanner input = Biblioteca.input;
		String auxOp;
		Integer auxPos, i = 0;
		
		do {
			
			System.out.println("- MENU DE ASSOCIA��O DE G�NERO LITER�RIO EM LIVRO -");	
			System.out.println("Todos os g�neros liter�rios dispon�veis para associa��o:");
			i = 0;
			for (Genero vet : lista) {
				System.out.println(i + " - " + vet.nome);
				i++;					
			}
			
			System.out.println("");
			System.out.print("Digite o c�digo do g�nero liter�rio que voc� quer associar ao livro '" + livroEscolhido.titulo + "': ");
			auxPos = Integer.valueOf(input.nextLine());	
			
			System.out.println("");
			
			while ((auxPos < 0) || (auxPos >= i)) {
				System.out.print("ERRO! Digite um c�digo de g�nero liter�rio v�lido: ");
				auxPos = Integer.valueOf(input.nextLine());
				System.out.println("");
			}
			
			Genero generoEscolhido = lista.get(auxPos);

			livroEscolhido.generos.add(generoEscolhido);

			System.out.println("G�nero liter�rio '" + generoEscolhido.nome + "' associado com sucesso ao livro '" + livroEscolhido.titulo + "'!");
			System.out.println("");
			
			System.out.print("Deseja associar outro g�nero liter�rio ao livro '" + livroEscolhido.titulo + "'? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada v�lida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if (auxOp.equals("n")) {
				auxOp = "N";
			}
			
		
			
		} while (!auxOp.equals("N"));
	
			
	}
	
	// M�todo para criar um novo g�nero liter�rio
	
	public static ArrayList<Genero> criar() {

		Scanner input = Biblioteca.input;
		String auxOp;
		
		do {	
			Genero novoGenero = new Genero();
			
			System.out.println("- MENU DE CADASTRO DE G�NERO LITER�RIO -");
			System.out.print("Digite o nome do g�nero liter�rio que voc� quer cadastrar no sistema: ");
			novoGenero.nome = input.nextLine();
	
			lista.add(novoGenero);
	
			System.out.println("");
			System.out.println("G�nero liter�rio '" + novoGenero.nome + "' cadastrado com sucesso!");
			System.out.println("");
			
			System.out.print("Deseja cadastrar algum outro g�nero liter�rio? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada v�lida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if (auxOp.equals("n")) {
				return null;
			}
			
		} while ((!auxOp.equals("N")));
			
		return lista;
	
	}
	
	// M�todo para editar um g�nero liter�rio
	
	public static void editar(Genero generoEscolhido) {
		
		if (generoEscolhido == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE EDI��O DE G�NERO LITER�RIO -");
		System.out.print("Digite o novo nome do g�nero liter�rio: ");
		String novoNome = input.nextLine();
		
		generoEscolhido.nome = novoNome;
		
		System.out.println("");
		System.out.println("G�nero liter�rio alterado com sucesso!");
		System.out.println("");
		
		return;
	}
	
	// M�todo para excluir um g�nero liter�rio
	
	public static void excluir(ArrayList<Livro> livros, Genero generoEscolhido) {
		
		if (generoEscolhido == null) {
			return;
		}
		
		for (Livro vet : livros) {
			vet.generos.remove(generoEscolhido);
		}
	
		lista.remove(generoEscolhido);
		
		System.out.println("G�nero liter�rio '" + generoEscolhido.nome + "' exclu�do com sucesso!");
		System.out.println("");
		
		return;
	}
	
	// M�todo para escolher um g�nero liter�rio
	
	public static Genero escolher(ArrayList<Genero> generos) {
		
		if (generos.isEmpty()) {
			System.out.println("N�o h� g�neros liter�rios registrados no sistema.");
			System.out.println("");
			return null;
		}
		
		Scanner input = Biblioteca.input;
		Integer i = 0;
		
		System.out.println("- MENU DE SELE��O DE G�NERO LITER�RIO - ");
		System.out.println("G�neros liter�rios cadastrados no sistema:");
		
		for (Genero vet : generos) {
			System.out.println(i + " - " + vet.nome);
			i++;
		}
		
		System.out.println("");
		System.out.print("Digite o c�digo do g�nero liter�rio: ");
		Integer auxPos = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxPos < 0) || (auxPos >= i)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			auxPos = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return generos.get(auxPos);
	}
	
}
