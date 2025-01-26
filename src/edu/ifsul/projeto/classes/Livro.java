package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Livro {
	
	// Atributos da classe

	public String titulo;
	public String autoria;
	public Integer ano;
	public Integer totalPaginas;
	public String descricao;
	public String editora;
	public Double preco;
	public Boolean disponibilidade;
	public ArrayList<Genero> generos = new ArrayList<>();
	
	// M�todo para cadastrar um novo livro

	public static Livro cadastrar(ArrayList<Livro> livros) {
		
		Livro novoLivro = new Livro();
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CADASTRO DE LIVRO -");
		System.out.println("Informe nos campos abaixo as informa��es do livro que voc� deseja adicionar no sistema.");
		
		System.out.print("Digite o t�tulo: ");
		novoLivro.titulo = input.nextLine();
		
		System.out.print("Digite a autoria: ");
		novoLivro.autoria = input.nextLine();

		System.out.print("Digite o ano de publica��o: ");
		novoLivro.ano = Integer.valueOf(input.nextLine());
		
		System.out.print("Digite a quantidade de p�ginas: ");
		novoLivro.totalPaginas = Integer.valueOf(input.nextLine());

		System.out.print("Digite a descri��o: ");
		novoLivro.descricao = input.nextLine();
		
		System.out.print("Digite a editora: ");
		novoLivro.editora = input.nextLine();

		System.out.print("Digite o pre�o: ");
		novoLivro.preco = Double.valueOf(input.nextLine());
		
		System.out.println("");
		
		novoLivro.disponibilidade = true;
		
		Genero.associar(novoLivro);
		
		System.out.println("");
		System.out.println("Novo livro cadastrado com sucesso!");
		System.out.println("");
		
		livros.add(novoLivro);
		
		return novoLivro;
		
	}
	
	// M�todo para cadastrar um novo livro (a partir de uma solicita��o de compra)
	
	public static Livro cadastrar(Livro novoLivro, Biblioteca biblioteca) {

		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CADASTRO DE LIVRO -");
		System.out.println("Informe nos campos abaixo as informa��es do livro que voc� deseja adicionar no sistema.");
		
		System.out.print("Digite o ano de publica��o: ");
		novoLivro.ano = Integer.valueOf(input.nextLine());
		
		System.out.print("Digite a quantidade de p�ginas: ");
		novoLivro.totalPaginas = Integer.valueOf(input.nextLine());

		System.out.print("Digite a descri��o do livro: ");
		novoLivro.descricao = input.nextLine();
		
		System.out.print("Digite a editora: ");
		novoLivro.editora = input.nextLine();

		System.out.print("Digite o pre�o: ");
		novoLivro.preco = Double.valueOf(input.nextLine());
		
		System.out.println("");
		
		novoLivro.disponibilidade = true;
		
		Genero.associar(novoLivro);
		
		System.out.println("");
		System.out.println("Novo livro cadastrado com sucesso!");
		System.out.println("");
		
		biblioteca.livros.add(novoLivro);
		
		return novoLivro;
		
	}
	
	// M�todo para remover um livro do sistema
	
	public static void excluir(ArrayList<Livro> livros, Livro livroEscolhido) {
		
		if (livroEscolhido == null) {
			return;
		}
		
		System.out.println("Livro '" + livroEscolhido.titulo + "' exclu�do com sucesso!");
		System.out.println("");
		
		livros.remove(livroEscolhido);
	
		return;
		
	}
	
	// M�todo para editar as informa��es de um livro
	
	public static void editar(ArrayList<Livro> livros, Livro livroEscolhido) {
		
		if (livros.isEmpty()) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		Integer auxCod, contadorAlteracoes = 0;
		String auxOp;
		
		do {
			System.out.println("- MENU DE EDI��O DE LIVRO -");
			System.out.println("Op��es dispon�veis para edi��o do livro '" + livroEscolhido.titulo + "':");
			System.out.println("1 - T�tulo;");
			System.out.println("2 - Autoria;");
			System.out.println("3 - Ano de publica��o;");
			System.out.println("4 - Quantidade de p�ginas;");
			System.out.println("5 - Descri��o;");
			System.out.println("6 - Editora;");
			System.out.println("7 - G�nero(s) liter�rio(s);");
			System.out.println("8 - Pre�o.");
			
			System.out.println("");
			System.out.print("Digite o c�digo da informa��o do livro que voc� deseja alterar: ");
			auxCod = Integer.valueOf(input.nextLine());

			System.out.println("");
			
			while ((auxCod < 1) || (auxCod > 8)) {
				System.out.print("ERRO! Digite um c�digo de informa��o do livro v�lido: ");
				auxCod = Integer.valueOf(input.nextLine());
				System.out.println("");
			}	
			
			switch(auxCod) {
			case 1:
				System.out.print("Digite o novo valor para o campo 'T�tulo': ");
				livroEscolhido.titulo = input.nextLine();
				contadorAlteracoes++;
				break;
			case 2:
				System.out.print("Digite o novo valor para o campo 'Autoria': ");
				livroEscolhido.autoria = input.nextLine();
				contadorAlteracoes++;
				break;
			case 3:
				System.out.print("Digite o novo valor para o campo 'Ano de publica��o': ");
				livroEscolhido.ano = Integer.valueOf(input.nextLine());
				contadorAlteracoes++;
				break;
			case 4:
				System.out.print("Digite o novo valor para o campo 'Quantidade de p�ginas': ");
				livroEscolhido.totalPaginas = Integer.valueOf(input.nextLine());
				contadorAlteracoes++;
				break;
			case 5:
				System.out.print("Digite o novo valor para o campo 'Descri��o': ");
				livroEscolhido.descricao = input.nextLine();
				contadorAlteracoes++;
				break;
			case 6:
				System.out.print("Digite o novo valor para o campo 'Editora': ");
				livroEscolhido.editora = input.nextLine();
				contadorAlteracoes++;
				break;	
			case 7:
				System.out.println("Opera��es dispon�veis para edi��o de g�neros liter�rios:");
				System.out.println("1 - Associar novo g�nero liter�rio;");
				System.out.println("2 - Desassociar g�nero liter�rio.");
				System.out.println("");
				
				System.out.print("Digite o c�digo da opera��o desejada: ");
				Integer opSelecionada = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((opSelecionada < 1) || (opSelecionada > 2)) {
					System.out.print("ERRO! Digite um c�digo v�lido: ");
					opSelecionada = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				switch (opSelecionada) {		
				case 1:
					
					Genero generoEscolhido = Genero.escolher(Genero.lista);
					
					if (generoEscolhido != null) {
						livroEscolhido.generos.add(generoEscolhido);
						System.out.println("");
						System.out.println("G�nero liter�rio associado com sucesso!");
						contadorAlteracoes++;
					}
				
					break;
					
				case 2:
					
					if (livroEscolhido.generos.remove(Genero.escolher(livroEscolhido.generos))) {
						System.out.println("");
						System.out.println("G�nero liter�rio desassociado com sucesso! ");			
						contadorAlteracoes++;	
					}
						
					break;
				
				}
				
				break;
			case 8:
				System.out.print("Digite o novo valor para o campo 'Pre�o': ");
				livroEscolhido.preco = Double.valueOf(input.nextLine());
				contadorAlteracoes++;
				break;
			}
						
			if (auxCod != 7) {
				System.out.println("");
			}
			
			System.out.print("Voc� deseja alterar mais algum campo deste livro? [S/N] ");
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
		
		if (contadorAlteracoes == 1) {
			System.out.println("Altera��o realizada com sucesso!");
			System.out.println("");			 
		} else if (contadorAlteracoes > 1) {
			System.out.println("Altera��es realizadas com sucesso!");
			System.out.println("");				
		} else {
			System.out.println("Nenhuma altera��o foi realizada.");
			System.out.println("");
		}
		
		return;
		
	}
	
	// M�todo para escolher um livro
	
	public static Livro escolher(ArrayList<Livro> livros) {
		
		Scanner input = Biblioteca.input;
		Integer auxCod, i = 0;
		
		if (livros.isEmpty()) {
			System.out.println("N�o h� livros cadastrados no sistema.");
			System.out.println("");
			return null;
		}
		
		System.out.println("- MENU DE ESCOLHA DE LIVRO -");
		System.out.println("Todos os livros cadastrados no sistema:");
		for (Livro vet : livros) {
			System.out.println(i + " - " + vet.titulo + ", escrito por " + vet.autoria);
			i++;
		}
		
		System.out.println("");
		System.out.print("Digite o c�digo do livro que voc� quer escolher: ");
		auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return livros.get(auxCod);
		
	}
	
	// M�todo para comprar um livro
	
	public static Livro comprar(Biblioteca biblioteca) {
		
		Integer contadorLivrosDisponiveis = 0;
		
		for (Livro vet : biblioteca.livros) {
			if (vet.disponibilidade) {
				contadorLivrosDisponiveis++;
			}
		}
		
		if (contadorLivrosDisponiveis == 0) {
			System.out.println("N�o h� livros dispon�veis para venda.");
			System.out.println("");
			return null;			
		}
		
		if (biblioteca.livros.isEmpty()) {
			System.out.println("N�o h� livros dispon�veis para venda.");
			System.out.println("");
			return null;
		}
		
		Integer i = 0, auxPos;
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE COMPRA DE LIVRO -");
		System.out.println("Todos os livros dispon�veis para compra:");
		for (Livro vet : biblioteca.livros) {
			if (vet.disponibilidade) {
				System.out.println(i + " - " + vet.titulo + " - " + vet.autoria);
				i++;
			}
		}

		System.out.println("");
		System.out.print("Digite o c�digo do livro que voc� quer comprar: ");
		auxPos = Integer.valueOf(input.nextLine());
		
		System.out.println("");
			
		while ((auxPos < 0) || (auxPos >= i)) {
			System.out.print("ERRO! Digite um c�digo de livro v�lido: ");
			auxPos = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
			
		Livro livroEscolhido = biblioteca.livros.get(auxPos);
		
		System.out.println("Informa��es detalhadas do livro que voc� quer comprar:");
		System.out.println("T�tulo: " + livroEscolhido.titulo);
		System.out.println("Autoria: " + livroEscolhido.autoria);
		System.out.println("Ano de publica��o: " + livroEscolhido.ano);
		System.out.println("Quantidade de p�ginas: " + livroEscolhido.totalPaginas);
		System.out.println("Descri��o: " + livroEscolhido.descricao);
		System.out.println("Editora: " + livroEscolhido.editora);
		System.out.println("Pre�o: R$" + String.format("%.2f", livroEscolhido.preco));
		
		System.out.print("G�nero(s) liter�rio(s): ");
		if (livroEscolhido.generos.isEmpty()) {
			System.out.println("n�o informado(s) ou inexistente(s)");
		} else {
			for (Genero vet : livroEscolhido.generos) {
				System.out.print(vet.nome + " ");
			}					
		}

		System.out.println("");
		System.out.print("Deseja continuar a compra? [S/N] ");
		String auxOp = input.nextLine();
		
		System.out.println("");
		
		while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
			System.out.print("ERRO! Digite uma entrada v�lida: ");
			auxOp = input.nextLine();
			System.out.println("");
		}
		
		if ((auxOp.equals("N")) || auxOp.equals("n")) {
			
			System.out.println("");
			System.out.println("Compra cancelada com sucesso!");
			System.out.println("");

			return null;
			
		} else {	
			
			Pedido.pedir(livroEscolhido, biblioteca);
			
			return livroEscolhido;
			
		}	
		
	}
	
}
