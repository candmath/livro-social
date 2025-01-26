package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Administrador;
import edu.ifsul.projeto.usuarios.Cliente;
import edu.ifsul.projeto.usuarios.Usuario;
import edu.ifsul.projeto.usuarios.Vendedor;

public class Menu {
	
	// M�todo do menu principal
	
	public static Integer principal() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU PRINCIPAL -");
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Acessar sistema;");
		System.out.println("2 - Cadastrar cliente;");
		System.out.println("3 - Cadastrar administrador;");
		System.out.println("4 - Sobre;");
		System.out.println("5 - Encerrar programa.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 5)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
		
	}
	
	// M�todo do menu para administradores
	
	public static Integer administrador() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DO ADMINISTRADOR -");
		System.out.println("Usu�rio acessando o sistema no momento: '" + Biblioteca.usuarioLogado.getNomeCompleto() + "'.");
		
		System.out.println("Opera��es dispon�veis:");		
		System.out.println("1 - Visualizar todos os usu�rios cadastrados no sistema;");
		System.out.println("2 - Visualizar todos os livros cadastrados no sistema;");
		System.out.println("3 - Visualizar todos os espa�os p�blicos de leitura cadastrados no sistema;");
		System.out.println("4 - Visualizar todos os pedidos cadastrados no sistema;");
		System.out.println("5 - Visualizar todas as solicita��es de compra feitas no sistema;");
		System.out.println("6 - Visualizar todos os g�neros liter�rios cadastrados no sistema;");
		System.out.println("7 - Visualizar todas as conversas feitas no sistema;");
		System.out.println("8 - Visualizar suas conversas;");
		System.out.println("9 - Concluir solicita��o de compra;");
		System.out.println("10 - Come�ar ou excluir uma conversa ou enviar uma mensagem em uma conversa;");
		System.out.println("11 - Cadastrar, editar ou excluir g�neros liter�rios do sistema;");
		System.out.println("12 - Cadastrar, editar ou excluir livros do sistema;");
		System.out.println("13 - Cadastrar novo vendedor ou novo administrador no sistema;");
		System.out.println("14 - Alterar dados de sua conta ou deletar sua conta;");
		System.out.println("15 - Sair.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 15)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
	}
	
	// M�todo do menu para clientes
	
	public static Integer cliente() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DO CLIENTE -");
		System.out.println("Usu�rio acessando o sistema no momento: '" + Biblioteca.usuarioLogado.getNomeCompleto() + "'.");
		
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Comprar livro;");
		System.out.println("2 - Cancelar pedido pendente;");
		System.out.println("3 - Visualizar seus livros comprados;");
		System.out.println("4 - Visualizar seus pedidos pendentes;");
		System.out.println("5 - Visualizar os espa�os p�blicos de leitura que voc� participa;");
		System.out.println("6 - Visualizar seus coment�rios;");
		System.out.println("7 - Criar ou editar espa�os p�blicos de leitura;");
		System.out.println("8 - Publicar um coment�rio em um espa�o p�blico de leitura;");
		System.out.println("9 - Sair de um espa�o p�blico de leitura;");
		System.out.println("10 - Ingressar em um espa�o p�blico de leitura;");
		System.out.println("11 - Excluir um espa�o p�blico de leitura;");
		System.out.println("12 - Alterar dados de sua conta ou deletar sua conta;");
		System.out.println("13 - Sair.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 13)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
	}
	
	// M�todo do menu sobre
	
	public static void sobre() {
		
		System.out.println("- SOBRE O SISTEMA -");
		System.out.println("O sistema 'LivroSocial' foi desenvolvido tendo em mente os amantes de livros e as bibliotecas.");
		System.out.println("Os principais objetivos da aplica��o s�o:");
		System.out.println("- Promover uma maior intera��o entre usu�rios com espa�os p�blicos de leitura;");
		System.out.println("- Unir a melhor intera��o entre os pr�prios usu�rios com um sistema de compras f�cil.");
		System.out.println("Al�m dos objetivos citados acima, busca-se desenvolver uma aplica��o de alta qualidade.");
		System.out.println("");
		System.out.println("- SOBRE O AUTOR -");
		System.out.println("Aplica��o desenvolvida por Matheus Candiotto � 2021");
		System.out.println("Sou um estudante de inform�tica e tamb�m amante de livros, m�sica e tecnologia. :)");
		System.out.println("'Eu sou Matheus, e Matheus quer dizer eu!' ~ Uma frase adaptada de um mago bem conhecido.");
		System.out.println("");
		
		return;
		
	}
	
	// M�todo do menu para vendedores
	
	public static Integer vendedor() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DO VENDEDOR -");
		System.out.println("Usu�rio acessando o sistema no momento: '" + Biblioteca.usuarioLogado.getNomeCompleto() + "'.");
		
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Vender livro;");
		System.out.println("2 - Visualizar seus livros vendidos;");
		System.out.println("3 - Visualizar suas solicita��es de compra;");
		System.out.println("4 - Visualizar suas conversas;");
		System.out.println("5 - Come�ar ou excluir uma conversa ou enviar uma mensagem em uma conversa;");
		System.out.println("6 - Solicitar compra de livro para um administrador;");
	  	System.out.println("7 - Editar solicita��o de compra existente;");
		System.out.println("8 - Alterar dados de sua conta ou deletar sua conta;");
		System.out.println("9 - Sair.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 9)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
	}
	
	// M�todo do menu de acesso
	
	public static Usuario acesso(ArrayList<Usuario> usuarios) {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ACESSO AO SISTEMA -");
		System.out.println("Digite suas informa��es abaixo para poder acessar o sistema.");
		
		System.out.print("Digite seu e-mail: ");
		String emailDigitado = input.nextLine();
		
		System.out.print("Digite sua senha: ");
		String senhaDigitada = input.nextLine();
		
		Usuario usuario = Usuario.login(emailDigitado, senhaDigitada, usuarios);
		
		System.out.println("");
		
		return usuario;
	}
	
	// M�todo do menu de configura��es de conta
	
	public static Integer configuracoesConta() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURA��ES DE CONTA -");
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Alterar seu e-mail;");
		System.out.println("2 - Alterar sua senha;");
		System.out.println("3 - Excluir sua conta;");
		System.out.println("4 - Voltar para o menu anterior.");
		System.out.println("");
		
		System.out.print("Digite o c�digo da opera��o desejada: ");	
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
				
		while ((opSelecionada < 1) || (opSelecionada > 4)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}	
		
		return opSelecionada;
	}
	
	// M�todo do menu de configura��es de livros
	
	public static Integer configuracoesLivros() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURA��ES DE LIVROS -");
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Cadastrar novo livro;");
		System.out.println("2 - Editar livro existente;");
		System.out.println("3 - Excluir livro;");
		System.out.println("4 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");	
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 4)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
		
	}
	
	// M�todo do menu para configura��es de g�neros
	
	public static Integer configuracoesGeneros() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURA��ES DOS G�NEROS LITER�RIOS -");
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Cadastrar novo g�nero liter�rio;");
		System.out.println("2 - Editar g�nero liter�rio existente;");
		System.out.println("3 - Excluir g�nero liter�rio;");
		System.out.println("4 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());

		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 4)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
	}
	
	// M�todo do menu para configura��es de conversas
	
	public static Integer configuracoesConversas() {
		
		Scanner input = Biblioteca.input;
	
		System.out.println("- MENU DE CONFIGURA��ES DE CONVERSAS -");
		System.out.println("Opera��es dispon�veis:");			
		System.out.println("1 - Iniciar conversa;");
		System.out.println("2 - Visualizar mensagens de uma conversa;");
		System.out.println("3 - Enviar mensagem;");
		System.out.println("4 - Excluir conversa;");
		System.out.println("5 - Voltar para o menu anterior.");
			
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());	
			
		System.out.println("");
			
		while ((opSelecionada < 1) || (opSelecionada > 5)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());	
			System.out.println("");
		}
			
		return opSelecionada;
		
	}
	
	// M�todo do menu para escolher um tipo de usu�rio para cadastro
	
	public static Integer escolherTipoCadastro() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE SELE��O DE TIPO DE USU�RIO PARA CADASTRO -");
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Cadastrar novo administrador;");
		System.out.println("2 - Cadastrar novo vendedor;");
		System.out.println("3 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");	
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 3)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;		
		
	}
	
	// M�todo para mostrar todas as solicita��es de compra
	
	public static void mostrarSolicitacoes(ArrayList<Solicitacao> solicitacoes) {
		
		if (solicitacoes.isEmpty()) {
			System.out.println("Voc� n�o possui solicita��es de compra registradas no sistema.");
			System.out.println("");
			return;
		}
		
		Integer contadorPendentes = 0, contadorConcluidas = 0, i = 0;
		
		for (Solicitacao vet : solicitacoes) {
			if (vet.status) {
				contadorConcluidas++;
			} else {
				contadorPendentes++;
			}
		}
		
		if (contadorConcluidas == 0) {
			System.out.println("N�o h� solicita��es de compra conclu�das registradas no sistema.");
		} else {
			System.out.println("- MENU DE VISUALIZA��O DE SOLICITA��ES DE COMPRA -");
			System.out.println("Todas as solicita��es de compra conclu�das registradas no sistema:");
			
			i = 0;
			
			for (Solicitacao vet : solicitacoes) {
				if (vet.status) {
					System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + vet.vendedor.getNomeCompleto() +  " - " + vet.administrador.getNomeCompleto() + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao)  + " - " + Biblioteca.formatacaoData.format(vet.dataConfirmacao));
					i++;					
				}
			}			
		}

		if (contadorPendentes == 0) {
			System.out.println("");
			System.out.println("N�o h� solicita��es de compra pendentes registradas no sistema.");
		} else {
			System.out.println("");
			System.out.println("Todas as solicita��es de compra pendentes registradas no sistema:");
			
			i = 0;
			
			for (Solicitacao vet : solicitacoes) {
				if (!vet.status) {
					System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + vet.vendedor.getNomeCompleto() + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao));
					i++;					
				}
			}
			
			System.out.println("");
			
		}
		
	}
	
	// M�todo para mostrar todos os livros
	
	public static void mostrarLivros(ArrayList<Livro> livros) {
			
		Scanner input = Biblioteca.input;		
		String auxOp;
		Integer i = 0; 
		
		if (livros.isEmpty()) {
			System.out.println("N�o h� livros registrados no sistema.");
			System.out.println("");
			return;
		}
	
		do {	
			
			i = 0;
			
			System.out.println("- MENU DE VISUALIZA��O DE LIVROS -");
			System.out.println("Todos os livros cadastrados no sistema:");
			
			for (Livro vet: livros) {
				System.out.println(i + " - " + vet.titulo + ", escrito por " + vet.autoria);
				i++;				
			}
			
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informa��es de um livro? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
				
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada v�lida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
				
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o c�digo do livro que voc� deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());		
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um c�digo de livro v�lido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				Livro livroEscolhido = livros.get(auxPos);
				
				System.out.println("Mostrando informa��es do livro '" + livroEscolhido.titulo + "' escrito por '" + livroEscolhido.autoria + "':");
				System.out.println("Ano de publica��o: " + livroEscolhido.ano);
				System.out.println("Quantidade de p�ginas: " + livroEscolhido.totalPaginas);
				System.out.println("Editora: " + livroEscolhido.editora);
				System.out.println("Pre�o: R$" + String.format("%.2f", livroEscolhido.preco));
				System.out.println("Descri��o: " + livroEscolhido.descricao);
				
				if (livroEscolhido.disponibilidade) {
					System.out.println("Disponibilidade: dispon�vel para compra");
				} else {
					System.out.println("Disponibilidade: indispon�vel");
				}
					
				System.out.print("G�nero(s) liter�rio(s): ");
				if (livroEscolhido.generos.isEmpty()) {
					System.out.print("n�o informado(s) ou inexistente(s)");
				} else {
					for (Genero generos : livroEscolhido.generos) {
						System.out.print(generos.nome + " ");
					}					
				}
		
				System.out.println("");
				System.out.println("");

			} else {
				break;
			}

		} while ((!auxOp.equals("N") || !auxOp.equals("n")));
		
		return;
	}	
	
	// M�todo para mostrar todos os pedidos
	
	public static void mostrarPedidos(ArrayList<Pedido> pedidos) {
		
		if (pedidos.isEmpty()) {
			System.out.println("N�o h� pedidos registrados no sistema.");
			System.out.println("");
			return;
		}
		
		Integer contadorConcluidos = 0, contadorPendentes = 0, i = 0;
		
		for (Pedido vet : pedidos) {
			if (vet.status) {
				contadorConcluidos++;
			} else {
				contadorPendentes++;
			}
		}
		
		if (contadorConcluidos == 0) {
			System.out.println("N�o h� pedidos conclu�dos registrados no sistema.");
		} else {
			System.out.println("- MENU DE VISUALIZA��O DE PEDIDOS -");
			System.out.println("Todos os pedidos conclu�dos registrados no sistema:");
			
			i = 0;

			for (Pedido vet : pedidos) {
				if (vet.status) {
					System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + vet.comprador.getNomeCompleto() + " - " + vet.vendedor.getNomeCompleto() + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao) + " - "  + Biblioteca.formatacaoData.format(vet.dataConfirmacao));
					i++;
				}
			}
			
		}
		
		if (contadorPendentes == 0) {
			System.out.println("");
			System.out.println("N�o h� pedidos pendentes registrados no sistema.");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("Todos os pedidos pendentes registrados no sistema:");
			
			i = 0;
			
			for (Pedido vet : pedidos) {
				if (!vet.status) {
					System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + vet.comprador.getNomeCompleto() + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao));
					i++;
				}
			}
			
			System.out.println("");
			
		}
		
		return;
		
	}
	
	// M�todo para mostrar todos os pedidos pendentes de um cliente
	
	public static void mostrarPedidosPendentes(Cliente cliente) {
		
		Integer contadorPedidosPendentes = 0;
		
		for (Pedido vet : cliente.getPedidos()) {
			if (!vet.status) {
				contadorPedidosPendentes++;
			}
		}
		
		if (contadorPedidosPendentes == 0) {
			System.out.println("Voc� n�o possui compras de livros registradas no sistema.");
			System.out.println("");		
			return;
		}
		
		if (cliente.getPedidos().isEmpty()) {
			System.out.println("Voc� n�o possui pedidos pendentes registrados no sistema.");
			System.out.println("");
			return;
		}
		
		System.out.println("Mostrando todos os pedidos pendentes do cliente '" + cliente.getNomeCompleto() + "':");
		Integer i = 0;
		for (Pedido vet : cliente.getPedidos()) {
			if (!vet.status) {
				System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + String.format("%.2f", vet.livro.preco) + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao));	
				i++;
			}
		}
		
		System.out.println("");
		
		return;
		
	}
	
	// M�todo para mostrar todos os pedidos pendentes de um vendedor
	
	public static void mostrarPedidosPendentes(Vendedor vendedor) {
		
		Integer contadorPedidosPendentes = 0;
		
		for (Pedido vet : vendedor.getPedidos()) {
			if (!vet.status) {
				contadorPedidosPendentes++;
			}
		}
		
		if (contadorPedidosPendentes == 0) {
			System.out.println("Voc� n�o possui compras de livros registradas no sistema.");
			System.out.println("");		
			return;
		}
		
		if (vendedor.getPedidos().isEmpty()) {
			System.out.println("Voc� n�o possui pedidos pendentes registrados no sistema.");
			System.out.println("");
			return;
		}
		
		System.out.println("Mostrando todos os pedidos pendentes do vendedor '" + vendedor.getNomeCompleto() + "':");
		Integer i = 0;
		for (Pedido vet : vendedor.getPedidos()) {	
			if (!vet.status) {
				System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + String.format("%.2f", vet.livro.preco) + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao));	
				i++;
			}
		}
		
		System.out.println("");
		
		return;
		
	}

	// M�todo para mostrar todos os pedidos conclu�dos de um cliente
	
	public static void mostrarPedidosConluidos(Cliente cliente) {
		
		Integer contadorPedidosConcluidos = 0;
		
		for (Pedido vet : cliente.getPedidos()) {
			if (vet.status) {
				contadorPedidosConcluidos++;
			}
		}
		
		if (contadorPedidosConcluidos == 0) {
			System.out.println("Voc� n�o possui compras de livros registradas no sistema.");
			System.out.println("");		
			return;
		}
		
		if (cliente.getPedidos().isEmpty()) {
			System.out.println("Voc� n�o possui compras de livros registradas no sistema.");
			System.out.println("");
			return;
		}
		
		System.out.println("Mostrando todos os pedidos conclu�dos do cliente '" + cliente.getNomeCompleto() + "':");

		Integer i = 0;
		for (Pedido vet : cliente.getPedidos()) {	
			if (vet.status) {
				System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + String.format("%.2f", vet.livro.preco) + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao) + " - " + Biblioteca.formatacaoData.format(vet.dataConfirmacao));	
				i++;
			}
		}
		
		System.out.println("");
		
		return;
		
	}
	
	// M�todo para mostrar todos os pedidos conclu�dos de um vendedor
	
	public static void mostrarPedidosConluidos(Vendedor vendedor) {
		
		Integer contadorPedidosConcluidos = 0;
		
		for (Pedido vet : vendedor.getPedidos()) {
			if (vet.status) {
				contadorPedidosConcluidos++;
			}
		}
		
		if (contadorPedidosConcluidos == 0) {
			System.out.println("Voc� n�o possui vendas de livros registradas no sistema.");
			System.out.println("");		
			return;
		}
		
		if (vendedor.getPedidos().isEmpty()) {
			System.out.println("Voc� n�o possui vendas de livros registradas no sistema.");
			System.out.println("");
			return;
		}
		
		System.out.println("Mostrando todos os pedidos conclu�dos do vendedor '" + vendedor.getNomeCompleto() + "':");

		Integer i = 0;
		for (Pedido vet : vendedor.getPedidos()) {	
			if (vet.status) {
				System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + String.format("%.2f", vet.livro.preco) + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao) + " - " + Biblioteca.formatacaoData.format(vet.dataConfirmacao));	
				i++;
			}
		}
		
		System.out.println("");
		
		return;
		
	}
	
	// M�todo para mostrar todas as conversas de um usu�rio
	
	public static void mostrarConversas(ArrayList<Conversa> conversas) {
		
		String auxOp;
		Scanner input = Biblioteca.input;
		
		if (conversas.isEmpty()) {
			System.out.println("Voc� n�o possui conversas registradas no sistema.");
			System.out.println("");
			return;
		}
		
		do {

			System.out.println("- MENU DE VISUALIZA��O DE CONVERSAS -");
			System.out.println("Todas as conversas registradas no sistema:");
			
			Integer i = 0;
			
			for (Conversa vet : conversas) {
				System.out.println(i + " - " + vet.assunto + " - " + vet.vendedor.getNomeCompleto() + " - " + vet.administrador.getNomeCompleto());
				i++;
			}
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informa��es de uma conversa? [S/N] ");
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
			
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o c�digo da conversa que voc� deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um c�digo de conversa v�lido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				Conversa conversaSelecionada = conversas.get(auxPos);
				
				System.out.println("Mostrando as informa��es da conversa selecionada:");
				System.out.println("Assunto: " + conversaSelecionada.assunto);
				System.out.println("Vendedor: " + conversaSelecionada.vendedor.getNomeCompleto());
				System.out.println("Administrador: " + conversaSelecionada.administrador.getNomeCompleto());
				System.out.println("");
				
				if (conversaSelecionada.mensagens.isEmpty()) {
					System.out.println("Nenhuma mensagem foi enviada nesta conversa.");
				} else {
					System.out.println("Quantidade total de mensagens enviadas: " + conversaSelecionada.mensagens.size());					
					System.out.println("Todas as mensagens enviadas:");
					
					for (Mensagem vet : conversaSelecionada.mensagens) {
						System.out.println(vet.autor.getNomeCompleto() + " enviou uma mensagem em " + Biblioteca.formatacaoData.format(vet.dataEnvio) + ": " + vet.texto);
					}
					
				}
				
				System.out.println("");
				
			}
			
		} while (!auxOp.equals("N"));
		
		return;
	}
	
	// M�todo para mostrar todas as conversas do sistema
	
	public static void mostrarConversas(Biblioteca biblioteca) {
		
		String auxOp;
		Scanner input = Biblioteca.input;
		
		if (biblioteca.conversas.isEmpty()) {
			System.out.println("N�o h� conversas registradas no sistema.");
			System.out.println("");
			return;
		}
		
		do {

			System.out.println("- MENU DE VISUALIZA��O DE CONVERSAS -");
			System.out.println("Todas as conversas registradas no sistema:");
			
			Integer i = 0;
			
			for (Conversa vet : biblioteca.conversas) {
				System.out.println(i + " - " + vet.assunto + " - " + vet.vendedor.getNomeCompleto() + " - " + vet.administrador.getNomeCompleto());
				i++;
			}
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informa��es de uma conversa? [S/N] ");
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
			
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o c�digo da conversa que voc� deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um c�digo de conversa v�lido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				Conversa conversaSelecionada = biblioteca.conversas.get(auxPos);
				
				System.out.println("Mostrando as informa��es da conversa selecionada:");
				System.out.println("Assunto: " + conversaSelecionada.assunto);
				System.out.println("Vendedor: " + conversaSelecionada.vendedor.getNomeCompleto());
				System.out.println("Administrador: " + conversaSelecionada.administrador.getNomeCompleto());
				System.out.println("");
				
				if (conversaSelecionada.mensagens.isEmpty()) {
					System.out.println("Nenhuma mensagem foi enviada nesta conversa.");
				} else {
					System.out.println("Total de mensagens enviadas: " + conversaSelecionada.mensagens.size());					
					System.out.println("Mensagens enviadas:");
					
					for (Mensagem vet : conversaSelecionada.mensagens) {
						System.out.println(vet.texto + " - " + vet.autor.getNomeCompleto() + " - " + Biblioteca.formatacaoData.format(vet.dataEnvio));
					}
					
				}
				
				System.out.println("");
				
			}
			
		} while (!auxOp.equals("N"));
		
		return;
	}
	
	// M�todo do menu de configura��es de cargos
	
	public static Integer configuracoesCargos() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURA��ES DE CARGOS -");
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Promover um participante para o cargo de Administrador;");
		System.out.println("2 - Despromover um participante do cargo de Administrador;");
		System.out.println("3 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 3)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
		
	}
	
	// Menu para mostrar todos os espa�os p�blicos de leitura
	
	public static void mostrarEspacos(ArrayList<EspacoLeitura> espacos) {
		
		Scanner input = Biblioteca.input;
		String auxOp;
		
		if ((espacos.isEmpty()) && (Biblioteca.usuarioLogado instanceof Cliente)) {
			System.out.println("Voc� n�o est� participando de um espa�o p�blico de leitura.");
			System.out.println("");
			return;
		}
		
		if (espacos.isEmpty()) {
			System.out.println("N�o h� espa�os de leitura registrados no sistema.");
			System.out.println("");
			return;
		}
		
		do {
			System.out.println("- MENU DE VISUALIZA��O DE ESPA�OS P�BLICOS DE LEITURA -");
			System.out.println("Todos os espa�os p�blicos de leitura cadastrados no sistema:");
		
			Integer i = 0;
			
			for (EspacoLeitura vet : espacos) {
				System.out.println(i + " - " + vet.nome + " - " + vet.criador.getNomeCompleto());
				i++;
			}
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informa��es de um espa�o p�blico de leitura? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada v�lida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o c�digo do espa�o p�blico de leitura que voc� deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um c�digo de espa�o p�blico de leitura v�lido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				EspacoLeitura elEscolhido = espacos.get(auxPos);
				
				System.out.println("Mostrando informa��es do espa�o p�blico de leitura '" + elEscolhido.nome + "' criado por '" + elEscolhido.criador.getNomeCompleto() + "':");
				
				System.out.println("");
				System.out.println("Todos os administradores:");
				i = 0;
				for (Usuario vet : elEscolhido.administradores) {
					System.out.println(i + " - " + vet.getNomeCompleto());
					i++;
				}

				System.out.println("");
				System.out.println("Todos os usu�rios comuns:");
				
				if (elEscolhido.usuariosNormais.isEmpty()) {
					System.out.println("Nenhum usu�rio est� participando deste espa�o p�blico de leitura.");
				}
				
				i = 0;
				for (Usuario vet : elEscolhido.usuariosNormais) {
					System.out.println(i + " - " + vet.getNomeCompleto());
				}
				
				System.out.println("");
				System.out.println("Todos os coment�rios enviados:");
				
				if (elEscolhido.comentarios.isEmpty()) {
					System.out.println("Nenhum coment�rio foi postado neste espa�o p�blico de leitura.");
				}
				
				i = 0;
				for (Comentario vet : elEscolhido.comentarios) {
					System.out.println(i + " - " + vet.autor.getNomeCompleto() + " - " + vet.texto + " - " + Biblioteca.formatacaoData.format(vet.dataPostagem));
				}
				
				System.out.println("");

			} else {
				break;
			}
			
		} while (!auxOp.equals("N"));	
		
	}
	
	// M�todo do menu para mostrar todos os coment�rios
	
	public static void mostrarComentarios(Cliente cliente) {
		
		if (cliente.comentarios.isEmpty()) {
			System.out.println("Voc� n�o comentou ainda.");
			System.out.println("");
			return;
		}
		
		Integer i = 0;
		
		System.out.println("- MENU DE VISUALIZA��O DE COMENT�RIOS -");
		System.out.println("Todos os coment�rios feitos por '" + cliente.getNomeCompleto() + "':");
		for (Comentario vet : cliente.comentarios) {
			System.out.println(i + " - " + vet.texto + " - " + Biblioteca.formatacaoData.format(vet.dataPostagem) + " - " + vet.espacoLeitura.nome);
			i++;
		}
		
		System.out.println("");
		
		return;
		
	}
	
	// M�todo para mostrar todos os usu�rios
	
	public static void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		
		Scanner input = Biblioteca.input;
		String auxOp;

		do {
			System.out.println("- MENU DE VISUALIZA��O DE USU�RIOS -");
			System.out.println("Todos os usu�rios cadastrados no sistema:");
			
			Integer i = 0;

			for (Usuario vet : usuarios) {
				System.out.println(i + " - " + vet.getNomeCompleto() + " - " + vet.getEmail());
				i++;
			}
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informa��es de um usu�rio? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada v�lida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o c�digo do usu�rio que voc� deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um c�digo v�lido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				Usuario usuarioEscolhido = usuarios.get(auxPos);
			
				System.out.println("Mostrando mais informa��es sobre o usu�rio selecionado:");
				System.out.println("Nome completo: " + usuarioEscolhido.getNomeCompleto());
				System.out.println("E-mail: " + usuarioEscolhido.getEmail());
				System.out.println("Data do cadastro: " + Biblioteca.formatacaoData.format(usuarioEscolhido.dataCadastro));
				
				System.out.print("Tipo de usu�rio: ");
				
				if (usuarioEscolhido instanceof Cliente) {
					System.out.println("cliente");
				} else if (usuarioEscolhido instanceof Administrador) {
					System.out.println("administrador");
				} else {
					System.out.println("vendedor");
				}
				
				System.out.println("");
				
				
			}
			
			if (auxOp.equals("n")) {
				auxOp = "N";
			}

		} while (!auxOp.equals("N"));
	
		return;
		
	}
	
	// M�todo para mostrar todos os g�neros liter�rios
	
	public static void mostrarGeneros(ArrayList<Genero> generos) {
		
		if (generos.isEmpty()) {
			System.out.println("N�o h� g�neros liter�rios cadastrados no sistema.");
			System.out.println("");
			return;
		}
		
		Integer i = 0;
		
		System.out.println("- MENU DE VISUALIZA��O DE G�NEROS LITER�RIOS -");
		System.out.println("Todos os g�neros liter�rios cadastrados no sistema: ");
		for (Genero vet : generos) {
			System.out.println(i + " - " + vet.nome);
			i++;
		}
		
		System.out.println("");
			
		return;	
		
	}
	
	// M�todo de menu para editar um espa�o p�blico de leitura
	
	public static Integer editarEspacos(EspacoLeitura elEscolhido) {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE EDI��O DE ESPA�O P�BLICO DE LEITURA -");
		System.out.println("Opera��es dispon�veis para a edi��o do espa�o p�blico de leitura '" + elEscolhido.nome + "':");
		System.out.println("1 - Editar nome do espa�o p�blico de leitura;");
		System.out.println("2 - Promover ou despromover um usu�rio;");
		System.out.println("3 - Remover um participante do espa�o p�blico de leitura;");
		System.out.println("4 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o que voc� deseja realizar: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 4)) {
			System.out.println("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;		
		
	}
	
	// M�todo de menu de configura��es dos espa�os p�blicos de leitura
	
	public static Integer configuracoesEspacos() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURA��ES DOS ESPA�OS P�BLICOS DE LEITURA -");
		System.out.println("Opera��es dispon�veis:");
		System.out.println("1 - Criar novo espa�o p�blico de leitura;");
		System.out.println("2 - Editar espa�o p�blico de leitura existente;");
		System.out.println("3 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o c�digo da opera��o desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 3)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;		
		
	}
	
}
