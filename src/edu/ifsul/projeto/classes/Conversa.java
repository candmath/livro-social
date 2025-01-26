package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Administrador;
import edu.ifsul.projeto.usuarios.Vendedor;

public class Conversa {
	
	// Atributos da classe

	public String assunto;
	public Vendedor vendedor; 
	public Administrador administrador;
	public ArrayList<Mensagem> mensagens = new ArrayList<>();
	
	// Método para iniciar uma nova conversa (com um vendedor)
		
	public static Conversa iniciar(Vendedor vendedorEscolhido, ArrayList<Conversa> conversas) {
		
		if (vendedorEscolhido == null) {
			return null;
		}
		
		Conversa novaConversa = new Conversa();
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CRIAÇÃO DE CONVERSA -");
		
		System.out.print("Digite o assunto da conversa: ");
		novaConversa.assunto = input.nextLine();
		
		novaConversa.vendedor = vendedorEscolhido;
		novaConversa.administrador = (Administrador) Biblioteca.usuarioLogado;
		
		System.out.println("");
		System.out.println("Conversa com o assunto '" + novaConversa.assunto + "' iniciada com o vendedor '" + novaConversa.administrador.getNomeCompleto() + "'!");
		System.out.println("");
	
		conversas.add(novaConversa);
		
		return novaConversa;
		
	}
	
	// Método para iniciar uma nova conversa (com um administrador)
	
	public static Conversa iniciar(Administrador administradorEscolhido, ArrayList<Conversa> conversas) {
		
		if (administradorEscolhido == null) {
			return null;
		}
		
		Conversa conversa = new Conversa();
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CRIAÇÃO DE CONVERSA -");
		
		System.out.print("Digite o assunto da conversa: ");
		conversa.assunto = input.nextLine();
		
		conversa.administrador = administradorEscolhido;
		conversa.vendedor = (Vendedor) Biblioteca.usuarioLogado;
		
		System.out.println("");
		System.out.println("Conversa com o assunto '" + conversa.assunto + "' iniciada com o administrador '" + conversa.administrador.getNomeCompleto() + "'!");
		System.out.println("");
	
		conversas.add(conversa);
		
		return conversa;
		
	}
	
	// Método para excluir uma conversa
	
	public static void excluir(Conversa conversaEscolhida, Biblioteca biblioteca) {
		
		if (conversaEscolhida == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		
		if (Biblioteca.usuarioLogado instanceof Administrador) {
			System.out.println("Você está prestes a excluir a conversa com o assunto '" + conversaEscolhida.assunto + "' com o vendedor '" + conversaEscolhida.vendedor.getNomeCompleto() + "'.");
			System.out.println("AVISO! Caso você exclua esta conversa, o vendedor não poderá mais visualizá-la.");		
		} else {
			System.out.println("Você está prestes a excluir a conversa com o assunto '" + conversaEscolhida.assunto + "' com o administrador '" + conversaEscolhida.administrador.getNomeCompleto() + "'.");
			System.out.println("AVISO! Caso você exclua esta conversa, o administrador não poderá mais visualizá-la.");		
		}		
		
		System.out.println("");
		System.out.print("Deseja continuar a operação? [S/N] ");
		String auxOp = input.nextLine();
		
		System.out.println("");
		
		while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
			System.out.print("ERRO! Digite uma entrada válida: ");
			auxOp = input.nextLine();
			System.out.println("");

		}
		
		if ((auxOp.equals("S")) || (auxOp.equals("s"))) {
			
			biblioteca.conversas.remove(conversaEscolhida);
			
			System.out.println("Operação realizada com sucesso!");
			System.out.println("");	
			
		} else {
			
			System.out.println("Operação cancelada com sucesso!");
			System.out.println("");
			
		}
		
		return;
		
	}
	
	// Método para visualizar as mensagens de uma conversa
	
	public static void visualizarMensagens(Conversa conversaEscolhida) {

		if (conversaEscolhida == null) {
			return;
		}
		
		System.out.println("- MENU DE VISUALIZAÇÃO DE MENSAGENS DE CONVERSA -");
		System.out.println("Assunto: '" + conversaEscolhida.assunto + "'.");
		
		if (conversaEscolhida.mensagens.isEmpty()) {
			System.out.println("Não há mensagens enviadas nessa conversa.");
		} else {
			for (Mensagem vet : conversaEscolhida.mensagens) {
				System.out.println(vet.autor.getNomeCompleto() + " enviou uma mensagem em " + Biblioteca.formatacaoData.format(vet.dataEnvio) + ": " + vet.texto);
			}			
		}
		
		System.out.println("");
		
		return;
		
	}
	
	// Método para escolher uma conversa
	
	public static Conversa escolher(ArrayList<Conversa> conversas) {
		
		if (conversas.isEmpty()) {
			System.out.println("Não há conversas registradas no sistema.");
			System.out.println("");
			return null;
		}
		
		Scanner input = Biblioteca.input;
		Integer i = 0;		
		
		System.out.println("- MENU DE SELEÇÃO DE CONVERSA -");
		System.out.println("Todas as conversas registradas no sistema:");
		
		for (Conversa vet : conversas) {
			System.out.println(i + " - " + vet.assunto + " - " + vet.vendedor.getNomeCompleto() + " - " + vet.administrador.getNomeCompleto());
			i++;
		}
		
		System.out.println("");
		System.out.print("Digite o código da conversa que você quer escolher: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um código válido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return conversas.get(auxCod);
	}
	
}
