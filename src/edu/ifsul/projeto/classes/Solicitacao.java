package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Administrador;
import edu.ifsul.projeto.usuarios.Vendedor;

public class Solicitacao {
	
	// Atributos da classe
	
	public Livro livro;
	public Date dataRealizacao;
	public Date dataConfirmacao;
	public Vendedor vendedor;
	public Administrador administrador;
	public Boolean status; 
	
	// Método para realizar uma solicitação de compra
		
	public static Solicitacao solicitar(Biblioteca biblioteca) {
		
		Scanner input = Biblioteca.input;
		Solicitacao novaSolicitacao = new Solicitacao();
		novaSolicitacao.livro = new Livro();
		
		System.out.println("- MENU DE REALIZAÇÃO DE SOLICITAÇÃO DE COMPRA -");
		System.out.print("Digite o nome do livro que você deseja solicitar: ");
		novaSolicitacao.livro.titulo = input.nextLine();
		
		System.out.print("Digite a autoria do livro que você deseja solicitar: ");
		novaSolicitacao.livro.autoria = input.nextLine();
		
		novaSolicitacao.dataRealizacao = new Date();
		novaSolicitacao.vendedor = (Vendedor) Biblioteca.usuarioLogado;
		novaSolicitacao.status = false;
		
		biblioteca.solicitacoes.add(novaSolicitacao);
		
		System.out.println("");
		System.out.println("Solicitação feita com sucesso!");
		System.out.println("AVISO! Um administrador precisa verificar e confirmar sua solicitação de compra para que ela seja efetivada.");
		System.out.println("");
		
		return novaSolicitacao;
		
	}
	
	// Método para confirmar uma solicitação de compra
	
	public static void confirmar(Solicitacao solicitacaoEscolhida, Biblioteca biblioteca) {
		
		if (solicitacaoEscolhida == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIRMAÇÃO DE SOLICITAÇÃO DE COMPRA -");
		System.out.println("Informações da solicitação escolhida:");
		System.out.println("Título do livro: " + solicitacaoEscolhida.livro.titulo);
		System.out.println("Autoria do livro: " + solicitacaoEscolhida.livro.autoria);
		System.out.println("Data da solicitação: " + solicitacaoEscolhida.dataRealizacao);
		System.out.println("Feita por: " + solicitacaoEscolhida.vendedor.getNomeCompleto());
		
		System.out.println("");
		System.out.println("AVISO! Caso você não confirme a solicitação, ela será excluída e não poderá ser recuperada posteriormente.");
		System.out.println("");
		
		System.out.print("Deseja confirmar esta solicitação? [S/N] ");
		String auxOp = input.nextLine();
		
		System.out.println("");
		
		while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
			System.out.print("ERRO! Digite uma entrada válida: ");
			auxOp = input.nextLine();
			System.out.println("");
		}
		
		if ((auxOp.equals("S")) || (auxOp.equals("s"))) {
			
			solicitacaoEscolhida.status = true;
			
			solicitacaoEscolhida.administrador = (Administrador) Biblioteca.usuarioLogado;
			
			solicitacaoEscolhida.dataConfirmacao = new Date();
			
			Livro.cadastrar(solicitacaoEscolhida.livro, biblioteca);
		
			System.out.println("Solicitação confirmada com sucesso!");
			System.out.println("");	
			
		} else {
			
			biblioteca.solicitacoes.remove(solicitacaoEscolhida);
			
			System.out.println("Solicitação rejeitada com sucesso!");
			System.out.println("");
			
		}
		
		return;
		
	}
	
	// Método para excluir uma solicitação de compra
	
	public static void excluir(Solicitacao solicitacaoEscolhida, Biblioteca biblioteca) {
		
		biblioteca.solicitacoes.remove(solicitacaoEscolhida);
		
		System.out.println("");
		System.out.println("Solicitação excluída com sucesso!");
		System.out.println("");	
		
		return;
		
	}
	
	// Método para editar uma solicitação de compra
	
	public static void editar(Solicitacao solicitacaoEscolhida) {
		
		if (solicitacaoEscolhida == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		Integer contadorAlteracoes = 0;
		String auxOp;
		
		do {

			System.out.println("- MENU DE EDIÇÃO DE SOLICITAÇÃO DE COMPRA -");
			System.out.println("Opções disponíveis para edição para essa solicitação:");
			System.out.println("1 - Título do livro;");
			System.out.println("2 - Autoria do livro;");
			System.out.println("3 - Voltar para o menu anterior.");
			
			System.out.println("");
			System.out.print("Digite o código da informação da solicitação que você deseja alterar: ");
			Integer auxCod = Integer.valueOf(input.nextLine());
			
			System.out.println("");
			
			while ((auxCod < 1) || (auxCod > 3)) {
				System.out.print("ERRO! Digite um código válido: ");
				auxCod = Integer.valueOf(input.nextLine());
				System.out.println("");
			}
			
			switch (auxCod) {
				case 1:
					System.out.print("Digite o novo valor para o campo 'Título': ");
					solicitacaoEscolhida.livro.titulo = input.nextLine();
					contadorAlteracoes++;
					break;
				case 2:
					System.out.print("Digite o novo valor para o campo 'Autoria': ");
					solicitacaoEscolhida.livro.autoria = input.nextLine();
					contadorAlteracoes++;
					break;
				case 3:
					System.out.println("Voltando para o menu anterior...");
					System.out.println("");
					return;
			}
			
			System.out.println("");
			System.out.print("Deseja alterar mais alguma informação dessa solicitação? [S/N] ");
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
		
		if (contadorAlteracoes == 0) {
			System.out.println("Nenhuma alteração realizada.");
			System.out.println("");			
		} else if (contadorAlteracoes == 1) {
			System.out.println("Alteração realizada com sucesso!");
			System.out.println("");
		} else {
			System.out.println("Alterações realizadas com sucesso!");
			System.out.println("");
		}
		
	}
	
	// Método para escolher uma solicitação de compra
	
	public static Solicitacao escolher(ArrayList<Solicitacao> solicitacoes) {
		
		if (solicitacoes.isEmpty()) {
			System.out.println("Não há solicitações de compra registradas no sistema.");
			System.out.println("");
			return null;
		}
		
		Integer i = 0;
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ESCOLHA DE SOLICITAÇÃO DE COMPRA -");
		System.out.println("Todas as solicitações de compra cadastradas no sistema:");
		
		for (Solicitacao vet : solicitacoes) {
			System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + vet.vendedor.getNomeCompleto() + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao));
			i++;
		}
		
		System.out.println("");
		System.out.print("Digite o código da solicitação de compra que você deseja escolher: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || ((auxCod >= i))) {
			System.out.print("ERRO! Digite um código válido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return solicitacoes.get(auxCod);
	}
	
}
