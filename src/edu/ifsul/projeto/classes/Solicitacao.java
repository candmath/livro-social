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
	
	// M�todo para realizar uma solicita��o de compra
		
	public static Solicitacao solicitar(Biblioteca biblioteca) {
		
		Scanner input = Biblioteca.input;
		Solicitacao novaSolicitacao = new Solicitacao();
		novaSolicitacao.livro = new Livro();
		
		System.out.println("- MENU DE REALIZA��O DE SOLICITA��O DE COMPRA -");
		System.out.print("Digite o nome do livro que voc� deseja solicitar: ");
		novaSolicitacao.livro.titulo = input.nextLine();
		
		System.out.print("Digite a autoria do livro que voc� deseja solicitar: ");
		novaSolicitacao.livro.autoria = input.nextLine();
		
		novaSolicitacao.dataRealizacao = new Date();
		novaSolicitacao.vendedor = (Vendedor) Biblioteca.usuarioLogado;
		novaSolicitacao.status = false;
		
		biblioteca.solicitacoes.add(novaSolicitacao);
		
		System.out.println("");
		System.out.println("Solicita��o feita com sucesso!");
		System.out.println("AVISO! Um administrador precisa verificar e confirmar sua solicita��o de compra para que ela seja efetivada.");
		System.out.println("");
		
		return novaSolicitacao;
		
	}
	
	// M�todo para confirmar uma solicita��o de compra
	
	public static void confirmar(Solicitacao solicitacaoEscolhida, Biblioteca biblioteca) {
		
		if (solicitacaoEscolhida == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CONFIRMA��O DE SOLICITA��O DE COMPRA -");
		System.out.println("Informa��es da solicita��o escolhida:");
		System.out.println("T�tulo do livro: " + solicitacaoEscolhida.livro.titulo);
		System.out.println("Autoria do livro: " + solicitacaoEscolhida.livro.autoria);
		System.out.println("Data da solicita��o: " + solicitacaoEscolhida.dataRealizacao);
		System.out.println("Feita por: " + solicitacaoEscolhida.vendedor.getNomeCompleto());
		
		System.out.println("");
		System.out.println("AVISO! Caso voc� n�o confirme a solicita��o, ela ser� exclu�da e n�o poder� ser recuperada posteriormente.");
		System.out.println("");
		
		System.out.print("Deseja confirmar esta solicita��o? [S/N] ");
		String auxOp = input.nextLine();
		
		System.out.println("");
		
		while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
			System.out.print("ERRO! Digite uma entrada v�lida: ");
			auxOp = input.nextLine();
			System.out.println("");
		}
		
		if ((auxOp.equals("S")) || (auxOp.equals("s"))) {
			
			solicitacaoEscolhida.status = true;
			
			solicitacaoEscolhida.administrador = (Administrador) Biblioteca.usuarioLogado;
			
			solicitacaoEscolhida.dataConfirmacao = new Date();
			
			Livro.cadastrar(solicitacaoEscolhida.livro, biblioteca);
		
			System.out.println("Solicita��o confirmada com sucesso!");
			System.out.println("");	
			
		} else {
			
			biblioteca.solicitacoes.remove(solicitacaoEscolhida);
			
			System.out.println("Solicita��o rejeitada com sucesso!");
			System.out.println("");
			
		}
		
		return;
		
	}
	
	// M�todo para excluir uma solicita��o de compra
	
	public static void excluir(Solicitacao solicitacaoEscolhida, Biblioteca biblioteca) {
		
		biblioteca.solicitacoes.remove(solicitacaoEscolhida);
		
		System.out.println("");
		System.out.println("Solicita��o exclu�da com sucesso!");
		System.out.println("");	
		
		return;
		
	}
	
	// M�todo para editar uma solicita��o de compra
	
	public static void editar(Solicitacao solicitacaoEscolhida) {
		
		if (solicitacaoEscolhida == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		Integer contadorAlteracoes = 0;
		String auxOp;
		
		do {

			System.out.println("- MENU DE EDI��O DE SOLICITA��O DE COMPRA -");
			System.out.println("Op��es dispon�veis para edi��o para essa solicita��o:");
			System.out.println("1 - T�tulo do livro;");
			System.out.println("2 - Autoria do livro;");
			System.out.println("3 - Voltar para o menu anterior.");
			
			System.out.println("");
			System.out.print("Digite o c�digo da informa��o da solicita��o que voc� deseja alterar: ");
			Integer auxCod = Integer.valueOf(input.nextLine());
			
			System.out.println("");
			
			while ((auxCod < 1) || (auxCod > 3)) {
				System.out.print("ERRO! Digite um c�digo v�lido: ");
				auxCod = Integer.valueOf(input.nextLine());
				System.out.println("");
			}
			
			switch (auxCod) {
				case 1:
					System.out.print("Digite o novo valor para o campo 'T�tulo': ");
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
			System.out.print("Deseja alterar mais alguma informa��o dessa solicita��o? [S/N] ");
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
		
		if (contadorAlteracoes == 0) {
			System.out.println("Nenhuma altera��o realizada.");
			System.out.println("");			
		} else if (contadorAlteracoes == 1) {
			System.out.println("Altera��o realizada com sucesso!");
			System.out.println("");
		} else {
			System.out.println("Altera��es realizadas com sucesso!");
			System.out.println("");
		}
		
	}
	
	// M�todo para escolher uma solicita��o de compra
	
	public static Solicitacao escolher(ArrayList<Solicitacao> solicitacoes) {
		
		if (solicitacoes.isEmpty()) {
			System.out.println("N�o h� solicita��es de compra registradas no sistema.");
			System.out.println("");
			return null;
		}
		
		Integer i = 0;
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ESCOLHA DE SOLICITA��O DE COMPRA -");
		System.out.println("Todas as solicita��es de compra cadastradas no sistema:");
		
		for (Solicitacao vet : solicitacoes) {
			System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + vet.vendedor.getNomeCompleto() + " - " + Biblioteca.formatacaoData.format(vet.dataRealizacao));
			i++;
		}
		
		System.out.println("");
		System.out.print("Digite o c�digo da solicita��o de compra que voc� deseja escolher: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || ((auxCod >= i))) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return solicitacoes.get(auxCod);
	}
	
}
