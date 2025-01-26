package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Administrador;
import edu.ifsul.projeto.usuarios.Cliente;
import edu.ifsul.projeto.usuarios.Usuario;
import edu.ifsul.projeto.usuarios.Vendedor;

public class Menu {
	
	// Método do menu principal
	
	public static Integer principal() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU PRINCIPAL -");
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Acessar sistema;");
		System.out.println("2 - Cadastrar cliente;");
		System.out.println("3 - Cadastrar administrador;");
		System.out.println("4 - Sobre;");
		System.out.println("5 - Encerrar programa.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 5)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
		
	}
	
	// Método do menu para administradores
	
	public static Integer administrador() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DO ADMINISTRADOR -");
		System.out.println("Usuário acessando o sistema no momento: '" + Biblioteca.usuarioLogado.getNomeCompleto() + "'.");
		
		System.out.println("Operações disponíveis:");		
		System.out.println("1 - Visualizar todos os usuários cadastrados no sistema;");
		System.out.println("2 - Visualizar todos os livros cadastrados no sistema;");
		System.out.println("3 - Visualizar todos os espaços públicos de leitura cadastrados no sistema;");
		System.out.println("4 - Visualizar todos os pedidos cadastrados no sistema;");
		System.out.println("5 - Visualizar todas as solicitações de compra feitas no sistema;");
		System.out.println("6 - Visualizar todos os gêneros literários cadastrados no sistema;");
		System.out.println("7 - Visualizar todas as conversas feitas no sistema;");
		System.out.println("8 - Visualizar suas conversas;");
		System.out.println("9 - Concluir solicitação de compra;");
		System.out.println("10 - Começar ou excluir uma conversa ou enviar uma mensagem em uma conversa;");
		System.out.println("11 - Cadastrar, editar ou excluir gêneros literários do sistema;");
		System.out.println("12 - Cadastrar, editar ou excluir livros do sistema;");
		System.out.println("13 - Cadastrar novo vendedor ou novo administrador no sistema;");
		System.out.println("14 - Alterar dados de sua conta ou deletar sua conta;");
		System.out.println("15 - Sair.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 15)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
	}
	
	// Método do menu para clientes
	
	public static Integer cliente() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DO CLIENTE -");
		System.out.println("Usuário acessando o sistema no momento: '" + Biblioteca.usuarioLogado.getNomeCompleto() + "'.");
		
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Comprar livro;");
		System.out.println("2 - Cancelar pedido pendente;");
		System.out.println("3 - Visualizar seus livros comprados;");
		System.out.println("4 - Visualizar seus pedidos pendentes;");
		System.out.println("5 - Visualizar os espaços públicos de leitura que você participa;");
		System.out.println("6 - Visualizar seus comentários;");
		System.out.println("7 - Criar ou editar espaços públicos de leitura;");
		System.out.println("8 - Publicar um comentário em um espaço público de leitura;");
		System.out.println("9 - Sair de um espaço público de leitura;");
		System.out.println("10 - Ingressar em um espaço público de leitura;");
		System.out.println("11 - Excluir um espaço público de leitura;");
		System.out.println("12 - Alterar dados de sua conta ou deletar sua conta;");
		System.out.println("13 - Sair.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 13)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
	}
	
	// Método do menu sobre
	
	public static void sobre() {
		
		System.out.println("- SOBRE O SISTEMA -");
		System.out.println("O sistema 'LivroSocial' foi desenvolvido tendo em mente os amantes de livros e as bibliotecas.");
		System.out.println("Os principais objetivos da aplicação são:");
		System.out.println("- Promover uma maior interação entre usuários com espaços públicos de leitura;");
		System.out.println("- Unir a melhor interação entre os próprios usuários com um sistema de compras fácil.");
		System.out.println("Além dos objetivos citados acima, busca-se desenvolver uma aplicação de alta qualidade.");
		System.out.println("");
		System.out.println("- SOBRE O AUTOR -");
		System.out.println("Aplicação desenvolvida por Matheus Candiotto © 2021");
		System.out.println("Sou um estudante de informática e também amante de livros, música e tecnologia. :)");
		System.out.println("'Eu sou Matheus, e Matheus quer dizer eu!' ~ Uma frase adaptada de um mago bem conhecido.");
		System.out.println("");
		
		return;
		
	}
	
	// Método do menu para vendedores
	
	public static Integer vendedor() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DO VENDEDOR -");
		System.out.println("Usuário acessando o sistema no momento: '" + Biblioteca.usuarioLogado.getNomeCompleto() + "'.");
		
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Vender livro;");
		System.out.println("2 - Visualizar seus livros vendidos;");
		System.out.println("3 - Visualizar suas solicitações de compra;");
		System.out.println("4 - Visualizar suas conversas;");
		System.out.println("5 - Começar ou excluir uma conversa ou enviar uma mensagem em uma conversa;");
		System.out.println("6 - Solicitar compra de livro para um administrador;");
	  	System.out.println("7 - Editar solicitação de compra existente;");
		System.out.println("8 - Alterar dados de sua conta ou deletar sua conta;");
		System.out.println("9 - Sair.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 9)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
	}
	
	// Método do menu de acesso
	
	public static Usuario acesso(ArrayList<Usuario> usuarios) {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ACESSO AO SISTEMA -");
		System.out.println("Digite suas informações abaixo para poder acessar o sistema.");
		
		System.out.print("Digite seu e-mail: ");
		String emailDigitado = input.nextLine();
		
		System.out.print("Digite sua senha: ");
		String senhaDigitada = input.nextLine();
		
		Usuario usuario = Usuario.login(emailDigitado, senhaDigitada, usuarios);
		
		System.out.println("");
		
		return usuario;
	}
	
	// Método do menu de configurações de conta
	
	public static Integer configuracoesConta() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURAÇÕES DE CONTA -");
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Alterar seu e-mail;");
		System.out.println("2 - Alterar sua senha;");
		System.out.println("3 - Excluir sua conta;");
		System.out.println("4 - Voltar para o menu anterior.");
		System.out.println("");
		
		System.out.print("Digite o código da operação desejada: ");	
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
				
		while ((opSelecionada < 1) || (opSelecionada > 4)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}	
		
		return opSelecionada;
	}
	
	// Método do menu de configurações de livros
	
	public static Integer configuracoesLivros() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURAÇÕES DE LIVROS -");
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Cadastrar novo livro;");
		System.out.println("2 - Editar livro existente;");
		System.out.println("3 - Excluir livro;");
		System.out.println("4 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");	
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 4)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
		
	}
	
	// Método do menu para configurações de gêneros
	
	public static Integer configuracoesGeneros() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURAÇÕES DOS GÊNEROS LITERÁRIOS -");
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Cadastrar novo gênero literário;");
		System.out.println("2 - Editar gênero literário existente;");
		System.out.println("3 - Excluir gênero literário;");
		System.out.println("4 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());

		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 4)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
	}
	
	// Método do menu para configurações de conversas
	
	public static Integer configuracoesConversas() {
		
		Scanner input = Biblioteca.input;
	
		System.out.println("- MENU DE CONFIGURAÇÕES DE CONVERSAS -");
		System.out.println("Operações disponíveis:");			
		System.out.println("1 - Iniciar conversa;");
		System.out.println("2 - Visualizar mensagens de uma conversa;");
		System.out.println("3 - Enviar mensagem;");
		System.out.println("4 - Excluir conversa;");
		System.out.println("5 - Voltar para o menu anterior.");
			
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());	
			
		System.out.println("");
			
		while ((opSelecionada < 1) || (opSelecionada > 5)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());	
			System.out.println("");
		}
			
		return opSelecionada;
		
	}
	
	// Método do menu para escolher um tipo de usuário para cadastro
	
	public static Integer escolherTipoCadastro() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE SELEÇÃO DE TIPO DE USUÁRIO PARA CADASTRO -");
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Cadastrar novo administrador;");
		System.out.println("2 - Cadastrar novo vendedor;");
		System.out.println("3 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");	
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 3)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;		
		
	}
	
	// Método para mostrar todas as solicitações de compra
	
	public static void mostrarSolicitacoes(ArrayList<Solicitacao> solicitacoes) {
		
		if (solicitacoes.isEmpty()) {
			System.out.println("Você não possui solicitações de compra registradas no sistema.");
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
			System.out.println("Não há solicitações de compra concluídas registradas no sistema.");
		} else {
			System.out.println("- MENU DE VISUALIZAÇÃO DE SOLICITAÇÕES DE COMPRA -");
			System.out.println("Todas as solicitações de compra concluídas registradas no sistema:");
			
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
			System.out.println("Não há solicitações de compra pendentes registradas no sistema.");
		} else {
			System.out.println("");
			System.out.println("Todas as solicitações de compra pendentes registradas no sistema:");
			
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
	
	// Método para mostrar todos os livros
	
	public static void mostrarLivros(ArrayList<Livro> livros) {
			
		Scanner input = Biblioteca.input;		
		String auxOp;
		Integer i = 0; 
		
		if (livros.isEmpty()) {
			System.out.println("Não há livros registrados no sistema.");
			System.out.println("");
			return;
		}
	
		do {	
			
			i = 0;
			
			System.out.println("- MENU DE VISUALIZAÇÃO DE LIVROS -");
			System.out.println("Todos os livros cadastrados no sistema:");
			
			for (Livro vet: livros) {
				System.out.println(i + " - " + vet.titulo + ", escrito por " + vet.autoria);
				i++;				
			}
			
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informações de um livro? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
				
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada válida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
				
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o código do livro que você deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());		
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um código de livro válido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				Livro livroEscolhido = livros.get(auxPos);
				
				System.out.println("Mostrando informações do livro '" + livroEscolhido.titulo + "' escrito por '" + livroEscolhido.autoria + "':");
				System.out.println("Ano de publicação: " + livroEscolhido.ano);
				System.out.println("Quantidade de páginas: " + livroEscolhido.totalPaginas);
				System.out.println("Editora: " + livroEscolhido.editora);
				System.out.println("Preço: R$" + String.format("%.2f", livroEscolhido.preco));
				System.out.println("Descrição: " + livroEscolhido.descricao);
				
				if (livroEscolhido.disponibilidade) {
					System.out.println("Disponibilidade: disponível para compra");
				} else {
					System.out.println("Disponibilidade: indisponível");
				}
					
				System.out.print("Gênero(s) literário(s): ");
				if (livroEscolhido.generos.isEmpty()) {
					System.out.print("não informado(s) ou inexistente(s)");
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
	
	// Método para mostrar todos os pedidos
	
	public static void mostrarPedidos(ArrayList<Pedido> pedidos) {
		
		if (pedidos.isEmpty()) {
			System.out.println("Não há pedidos registrados no sistema.");
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
			System.out.println("Não há pedidos concluídos registrados no sistema.");
		} else {
			System.out.println("- MENU DE VISUALIZAÇÃO DE PEDIDOS -");
			System.out.println("Todos os pedidos concluídos registrados no sistema:");
			
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
			System.out.println("Não há pedidos pendentes registrados no sistema.");
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
	
	// Método para mostrar todos os pedidos pendentes de um cliente
	
	public static void mostrarPedidosPendentes(Cliente cliente) {
		
		Integer contadorPedidosPendentes = 0;
		
		for (Pedido vet : cliente.getPedidos()) {
			if (!vet.status) {
				contadorPedidosPendentes++;
			}
		}
		
		if (contadorPedidosPendentes == 0) {
			System.out.println("Você não possui compras de livros registradas no sistema.");
			System.out.println("");		
			return;
		}
		
		if (cliente.getPedidos().isEmpty()) {
			System.out.println("Você não possui pedidos pendentes registrados no sistema.");
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
	
	// Método para mostrar todos os pedidos pendentes de um vendedor
	
	public static void mostrarPedidosPendentes(Vendedor vendedor) {
		
		Integer contadorPedidosPendentes = 0;
		
		for (Pedido vet : vendedor.getPedidos()) {
			if (!vet.status) {
				contadorPedidosPendentes++;
			}
		}
		
		if (contadorPedidosPendentes == 0) {
			System.out.println("Você não possui compras de livros registradas no sistema.");
			System.out.println("");		
			return;
		}
		
		if (vendedor.getPedidos().isEmpty()) {
			System.out.println("Você não possui pedidos pendentes registrados no sistema.");
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

	// Método para mostrar todos os pedidos concluídos de um cliente
	
	public static void mostrarPedidosConluidos(Cliente cliente) {
		
		Integer contadorPedidosConcluidos = 0;
		
		for (Pedido vet : cliente.getPedidos()) {
			if (vet.status) {
				contadorPedidosConcluidos++;
			}
		}
		
		if (contadorPedidosConcluidos == 0) {
			System.out.println("Você não possui compras de livros registradas no sistema.");
			System.out.println("");		
			return;
		}
		
		if (cliente.getPedidos().isEmpty()) {
			System.out.println("Você não possui compras de livros registradas no sistema.");
			System.out.println("");
			return;
		}
		
		System.out.println("Mostrando todos os pedidos concluídos do cliente '" + cliente.getNomeCompleto() + "':");

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
	
	// Método para mostrar todos os pedidos concluídos de um vendedor
	
	public static void mostrarPedidosConluidos(Vendedor vendedor) {
		
		Integer contadorPedidosConcluidos = 0;
		
		for (Pedido vet : vendedor.getPedidos()) {
			if (vet.status) {
				contadorPedidosConcluidos++;
			}
		}
		
		if (contadorPedidosConcluidos == 0) {
			System.out.println("Você não possui vendas de livros registradas no sistema.");
			System.out.println("");		
			return;
		}
		
		if (vendedor.getPedidos().isEmpty()) {
			System.out.println("Você não possui vendas de livros registradas no sistema.");
			System.out.println("");
			return;
		}
		
		System.out.println("Mostrando todos os pedidos concluídos do vendedor '" + vendedor.getNomeCompleto() + "':");

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
	
	// Método para mostrar todas as conversas de um usuário
	
	public static void mostrarConversas(ArrayList<Conversa> conversas) {
		
		String auxOp;
		Scanner input = Biblioteca.input;
		
		if (conversas.isEmpty()) {
			System.out.println("Você não possui conversas registradas no sistema.");
			System.out.println("");
			return;
		}
		
		do {

			System.out.println("- MENU DE VISUALIZAÇÃO DE CONVERSAS -");
			System.out.println("Todas as conversas registradas no sistema:");
			
			Integer i = 0;
			
			for (Conversa vet : conversas) {
				System.out.println(i + " - " + vet.assunto + " - " + vet.vendedor.getNomeCompleto() + " - " + vet.administrador.getNomeCompleto());
				i++;
			}
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informações de uma conversa? [S/N] ");
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
			
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o código da conversa que você deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um código de conversa válido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				Conversa conversaSelecionada = conversas.get(auxPos);
				
				System.out.println("Mostrando as informações da conversa selecionada:");
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
	
	// Método para mostrar todas as conversas do sistema
	
	public static void mostrarConversas(Biblioteca biblioteca) {
		
		String auxOp;
		Scanner input = Biblioteca.input;
		
		if (biblioteca.conversas.isEmpty()) {
			System.out.println("Não há conversas registradas no sistema.");
			System.out.println("");
			return;
		}
		
		do {

			System.out.println("- MENU DE VISUALIZAÇÃO DE CONVERSAS -");
			System.out.println("Todas as conversas registradas no sistema:");
			
			Integer i = 0;
			
			for (Conversa vet : biblioteca.conversas) {
				System.out.println(i + " - " + vet.assunto + " - " + vet.vendedor.getNomeCompleto() + " - " + vet.administrador.getNomeCompleto());
				i++;
			}
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informações de uma conversa? [S/N] ");
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
			
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o código da conversa que você deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um código de conversa válido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				Conversa conversaSelecionada = biblioteca.conversas.get(auxPos);
				
				System.out.println("Mostrando as informações da conversa selecionada:");
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
	
	// Método do menu de configurações de cargos
	
	public static Integer configuracoesCargos() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURAÇÕES DE CARGOS -");
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Promover um participante para o cargo de Administrador;");
		System.out.println("2 - Despromover um participante do cargo de Administrador;");
		System.out.println("3 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 3)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;
		
	}
	
	// Menu para mostrar todos os espaços públicos de leitura
	
	public static void mostrarEspacos(ArrayList<EspacoLeitura> espacos) {
		
		Scanner input = Biblioteca.input;
		String auxOp;
		
		if ((espacos.isEmpty()) && (Biblioteca.usuarioLogado instanceof Cliente)) {
			System.out.println("Você não está participando de um espaço público de leitura.");
			System.out.println("");
			return;
		}
		
		if (espacos.isEmpty()) {
			System.out.println("Não há espaços de leitura registrados no sistema.");
			System.out.println("");
			return;
		}
		
		do {
			System.out.println("- MENU DE VISUALIZAÇÃO DE ESPAÇOS PÚBLICOS DE LEITURA -");
			System.out.println("Todos os espaços públicos de leitura cadastrados no sistema:");
		
			Integer i = 0;
			
			for (EspacoLeitura vet : espacos) {
				System.out.println(i + " - " + vet.nome + " - " + vet.criador.getNomeCompleto());
				i++;
			}
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informações de um espaço público de leitura? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada válida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o código do espaço público de leitura que você deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um código de espaço público de leitura válido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				EspacoLeitura elEscolhido = espacos.get(auxPos);
				
				System.out.println("Mostrando informações do espaço público de leitura '" + elEscolhido.nome + "' criado por '" + elEscolhido.criador.getNomeCompleto() + "':");
				
				System.out.println("");
				System.out.println("Todos os administradores:");
				i = 0;
				for (Usuario vet : elEscolhido.administradores) {
					System.out.println(i + " - " + vet.getNomeCompleto());
					i++;
				}

				System.out.println("");
				System.out.println("Todos os usuários comuns:");
				
				if (elEscolhido.usuariosNormais.isEmpty()) {
					System.out.println("Nenhum usuário está participando deste espaço público de leitura.");
				}
				
				i = 0;
				for (Usuario vet : elEscolhido.usuariosNormais) {
					System.out.println(i + " - " + vet.getNomeCompleto());
				}
				
				System.out.println("");
				System.out.println("Todos os comentários enviados:");
				
				if (elEscolhido.comentarios.isEmpty()) {
					System.out.println("Nenhum comentário foi postado neste espaço público de leitura.");
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
	
	// Método do menu para mostrar todos os comentários
	
	public static void mostrarComentarios(Cliente cliente) {
		
		if (cliente.comentarios.isEmpty()) {
			System.out.println("Você não comentou ainda.");
			System.out.println("");
			return;
		}
		
		Integer i = 0;
		
		System.out.println("- MENU DE VISUALIZAÇÃO DE COMENTÁRIOS -");
		System.out.println("Todos os comentários feitos por '" + cliente.getNomeCompleto() + "':");
		for (Comentario vet : cliente.comentarios) {
			System.out.println(i + " - " + vet.texto + " - " + Biblioteca.formatacaoData.format(vet.dataPostagem) + " - " + vet.espacoLeitura.nome);
			i++;
		}
		
		System.out.println("");
		
		return;
		
	}
	
	// Método para mostrar todos os usuários
	
	public static void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		
		Scanner input = Biblioteca.input;
		String auxOp;

		do {
			System.out.println("- MENU DE VISUALIZAÇÃO DE USUÁRIOS -");
			System.out.println("Todos os usuários cadastrados no sistema:");
			
			Integer i = 0;

			for (Usuario vet : usuarios) {
				System.out.println(i + " - " + vet.getNomeCompleto() + " - " + vet.getEmail());
				i++;
			}
			
			System.out.println("");
			System.out.print("Gostaria de detalhar as informações de um usuário? [S/N] ");
			auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada válida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if ((auxOp.equals("S")) || auxOp.equals("s")) {
				System.out.print("Digite o código do usuário que você deseja detalhar: ");
				Integer auxPos = Integer.valueOf(input.nextLine());
				
				System.out.println("");
				
				while ((auxPos < 0) || (auxPos >= i)) {
					System.out.print("ERRO! Digite um código válido: ");
					auxPos = Integer.valueOf(input.nextLine());
					System.out.println("");
				}
				
				Usuario usuarioEscolhido = usuarios.get(auxPos);
			
				System.out.println("Mostrando mais informações sobre o usuário selecionado:");
				System.out.println("Nome completo: " + usuarioEscolhido.getNomeCompleto());
				System.out.println("E-mail: " + usuarioEscolhido.getEmail());
				System.out.println("Data do cadastro: " + Biblioteca.formatacaoData.format(usuarioEscolhido.dataCadastro));
				
				System.out.print("Tipo de usuário: ");
				
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
	
	// Método para mostrar todos os gêneros literários
	
	public static void mostrarGeneros(ArrayList<Genero> generos) {
		
		if (generos.isEmpty()) {
			System.out.println("Não há gêneros literários cadastrados no sistema.");
			System.out.println("");
			return;
		}
		
		Integer i = 0;
		
		System.out.println("- MENU DE VISUALIZAÇÃO DE GÊNEROS LITERÁRIOS -");
		System.out.println("Todos os gêneros literários cadastrados no sistema: ");
		for (Genero vet : generos) {
			System.out.println(i + " - " + vet.nome);
			i++;
		}
		
		System.out.println("");
			
		return;	
		
	}
	
	// Método de menu para editar um espaço público de leitura
	
	public static Integer editarEspacos(EspacoLeitura elEscolhido) {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE EDIÇÃO DE ESPAÇO PÚBLICO DE LEITURA -");
		System.out.println("Operações disponíveis para a edição do espaço público de leitura '" + elEscolhido.nome + "':");
		System.out.println("1 - Editar nome do espaço público de leitura;");
		System.out.println("2 - Promover ou despromover um usuário;");
		System.out.println("3 - Remover um participante do espaço público de leitura;");
		System.out.println("4 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o código da operação que você deseja realizar: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 4)) {
			System.out.println("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;		
		
	}
	
	// Método de menu de configurações dos espaços públicos de leitura
	
	public static Integer configuracoesEspacos() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIGURAÇÕES DOS ESPAÇOS PÚBLICOS DE LEITURA -");
		System.out.println("Operações disponíveis:");
		System.out.println("1 - Criar novo espaço público de leitura;");
		System.out.println("2 - Editar espaço público de leitura existente;");
		System.out.println("3 - Voltar para o menu anterior.");
		
		System.out.println("");
		System.out.print("Digite o código da operação desejada: ");
		Integer opSelecionada = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((opSelecionada < 1) || (opSelecionada > 3)) {
			System.out.print("ERRO! Digite um código válido: ");
			opSelecionada = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return opSelecionada;		
		
	}
	
}
