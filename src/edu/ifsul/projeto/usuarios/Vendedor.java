package edu.ifsul.projeto.usuarios;

import java.util.ArrayList;
import java.util.Scanner;

import edu.ifsul.projeto.classes.Biblioteca;
import edu.ifsul.projeto.classes.Conversa;
import edu.ifsul.projeto.classes.Pedido;
import edu.ifsul.projeto.classes.Solicitacao;

public class Vendedor extends Usuario {
	
	// Método para escolher um administrador
	
	public static Administrador escolherAdministrador(ArrayList<Usuario> usuarios) {
		
		Integer contadorAdministradores = 0;
		
		for (Usuario vet : usuarios) {
			if (vet instanceof Administrador) {
				contadorAdministradores++;
			}
		}
		
		if (contadorAdministradores == 0) {
			System.out.println("Não há administradores registrados no sistema.");
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
		
		System.out.print("Digite o código do administrador que você quer utilizar: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um código de administrador válido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return auxiliar.get(auxCod);
		
	}
	
	// Método que retorna todas as conversas de um usuário
	
	public ArrayList<Conversa> getConversas(){
		
		ArrayList<Conversa> auxiliar = new ArrayList<>();
		
		for (Conversa vet : biblioteca.conversas) {
			if (vet.vendedor.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;
		
	}
	
	// Método que retorna todas as solicitações de compra de um usuário
	
	public ArrayList<Solicitacao> getSolicitacoes(){
		
		ArrayList<Solicitacao> auxiliar = new ArrayList<>();
		
		for (Solicitacao vet : biblioteca.solicitacoes) {
			if (vet.vendedor.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;	
		
	}
	
	// Método que retorna todos os pedidos de um usuário
	
	public ArrayList<Pedido> getPedidos(){
		
		ArrayList<Pedido> auxiliar = new ArrayList<>();
		
		for (Pedido vet : biblioteca.pedidos) {
			if (vet.vendedor.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;	
		
	}
	
	// Método que auxilia o cadastro de um novo vendedor

	public static Vendedor cadastrar(Biblioteca biblioteca) {
		
		Vendedor v = new Vendedor();
		Usuario.cadastrar(v, biblioteca);
		
		return v;
		
	}
	
}