package edu.ifsul.projeto.usuarios;

import java.util.ArrayList;
import java.util.Scanner;

import edu.ifsul.projeto.classes.Biblioteca;
import edu.ifsul.projeto.classes.Conversa;
import edu.ifsul.projeto.classes.Solicitacao;

public class Administrador extends Usuario {
	
	// M�todo para escolher um vendedor
	
	public static Vendedor escolherVendedor(ArrayList<Usuario> usuarios) {
		
		Integer contadorVendedores = 0;
		
		for (Usuario vet : usuarios) {
			if (vet instanceof Vendedor) {
				contadorVendedores++;
			}
		}
		
		if (contadorVendedores == 0) {
			System.out.println("N�o h� vendedores registrados no sistema.");
			System.out.println("");
			return null;
		}
		
		Scanner input = Biblioteca.input;
		ArrayList<Vendedor> auxiliar = new ArrayList<>();
		Integer i = 0;
		
		System.out.println("- MENU DE ESCOLHA DE VENDEDOR -");
		System.out.println("Todos os vendedores cadastrados no sistema:");
		
		for (Usuario vet : usuarios) {
			if (vet instanceof Vendedor) {
				auxiliar.add((Vendedor) vet);
			}
		}
		
		for (Vendedor vet : auxiliar) {
			System.out.println(i + " - " + vet.getNomeCompleto());
			i++;
		}
		
		System.out.println("");
		
		System.out.print("Digite o c�digo do vendedor que voc� quer utilizar: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um c�digo de vendedor v�lido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return auxiliar.get(auxCod);
		
	}
	
	// M�todo que retorna todas as conversas de um usu�rio
	
	public ArrayList<Conversa> getConversas(){
		
		ArrayList<Conversa> auxiliar = new ArrayList<>();
		
		for (Conversa vet : biblioteca.conversas) {
			if (vet.administrador.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;
		
	}
	
	// M�todo que retorna todas as solicita��es de compra de um usu�rio
	
	public ArrayList<Solicitacao> getSolicitacoes(){
		
		ArrayList<Solicitacao> auxiliar = new ArrayList<>();
		
		for (Solicitacao vet : biblioteca.solicitacoes) {
			if (vet.administrador.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;	
		
	}
	
	// M�todo que auxilia o cadastro de um novo adminsitrador
	
	public static Administrador cadastrar(Biblioteca biblioteca) {	
		
		Administrador admin = new Administrador();	
		Usuario.cadastrar(admin, biblioteca);	
		
		return admin;	
		
	}
	
}