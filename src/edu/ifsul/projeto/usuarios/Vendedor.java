package edu.ifsul.projeto.usuarios;

import java.util.ArrayList;
import java.util.Scanner;

import edu.ifsul.projeto.classes.Biblioteca;
import edu.ifsul.projeto.classes.Conversa;
import edu.ifsul.projeto.classes.Pedido;
import edu.ifsul.projeto.classes.Solicitacao;

public class Vendedor extends Usuario {
	
	// M�todo para escolher um administrador
	
	public static Administrador escolherAdministrador(ArrayList<Usuario> usuarios) {
		
		Integer contadorAdministradores = 0;
		
		for (Usuario vet : usuarios) {
			if (vet instanceof Administrador) {
				contadorAdministradores++;
			}
		}
		
		if (contadorAdministradores == 0) {
			System.out.println("N�o h� administradores registrados no sistema.");
			System.out.println("");
			return null;
		}
		
		Scanner input = Biblioteca.input;
		ArrayList<Administrador> auxiliar = new ArrayList<>();
		Integer i = 0;
		
		System.out.println("- MENU DE ESCOLHA DE ADMINISTRADOR -");
		System.out.println("Todos os administradores cadastrados no sistema:");
		
		for (Usuario vet : usuarios) {
			if (vet instanceof Administrador) {
				auxiliar.add((Administrador) vet);
			}
		}
		
		for (Administrador vet : auxiliar) {
			System.out.println(i + " - " + vet.getNomeCompleto());
			i++;
		}
		
		System.out.println("");
		
		System.out.print("Digite o c�digo do administrador que voc� quer utilizar: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um c�digo de administrador v�lido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return auxiliar.get(auxCod);
		
	}
	
	// M�todo que retorna todas as conversas de um usu�rio
	
	public ArrayList<Conversa> getConversas(){
		
		ArrayList<Conversa> auxiliar = new ArrayList<>();
		
		for (Conversa vet : biblioteca.conversas) {
			if (vet.vendedor.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;
		
	}
	
	// M�todo que retorna todas as solicita��es de compra de um usu�rio
	
	public ArrayList<Solicitacao> getSolicitacoes(){
		
		ArrayList<Solicitacao> auxiliar = new ArrayList<>();
		
		for (Solicitacao vet : biblioteca.solicitacoes) {
			if (vet.vendedor.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;	
		
	}
	
	// M�todo que retorna todos os pedidos de um usu�rio
	
	public ArrayList<Pedido> getPedidos(){
		
		ArrayList<Pedido> auxiliar = new ArrayList<>();
		
		for (Pedido vet : biblioteca.pedidos) {
			if (vet.vendedor.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;	
		
	}
	
	// M�todo que auxilia o cadastro de um novo vendedor

	public static Vendedor cadastrar(Biblioteca biblioteca) {
		
		Vendedor v = new Vendedor();
		Usuario.cadastrar(v, biblioteca);
		
		return v;
		
	}
	
}