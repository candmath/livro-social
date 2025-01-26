package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Cliente;
import edu.ifsul.projeto.usuarios.Vendedor;

public class Pedido {

	// Atributos da classe
	
	public Livro livro;
	public Cliente comprador;
	public Vendedor vendedor;
	public Date dataRealizacao;
	public Date dataConfirmacao;
	public Boolean status;
	
	// Método para fazer um pedido
	
	public static Pedido pedir(Livro livroEscolhido, Biblioteca biblioteca) {
		
		Pedido novoPedido = new Pedido();
		
		novoPedido.dataRealizacao = new Date();
		novoPedido.status = false;
		novoPedido.livro = livroEscolhido;
		
		novoPedido.livro.disponibilidade = false;
		
		novoPedido.comprador = (Cliente) Biblioteca.usuarioLogado;
		
		novoPedido.vendedor = new Vendedor();
		
		biblioteca.pedidos.add(novoPedido);
		
		System.out.println("Pedido realizado com sucesso!");
		System.out.println("Obs.: sua compra será apenas efetivada quando um vendedor confirmar o pedido.");
		System.out.println("");
		
		return novoPedido;
		
	}
	
	// Método para confirmar um pedido
	
	public static void confirmar(Pedido pedidoEscolhido, ArrayList<Livro> livros) {
	
		if (pedidoEscolhido == null) {
			return;
		}
		
		pedidoEscolhido.dataConfirmacao = new Date();
		pedidoEscolhido.status = true;
		pedidoEscolhido.vendedor = (Vendedor) Biblioteca.usuarioLogado;
		
		livros.remove(pedidoEscolhido.livro);
		
		System.out.println("Pedido confirmado com sucesso!");
		System.out.println("");
		
		return;
	}
	
	// Método para cancelar um pedido
	
	public static void cancelar(ArrayList<Pedido> pedidos, Pedido pedidoEscolhido, Biblioteca biblioteca) {
		
		if (pedidoEscolhido == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE CANCELAMENTO DE PEDIDO -");
		System.out.println("Para confirmar o cancelamento do pedido do livro '', confirme sua senha abaixo.");
		System.out.println("AVISO! Não será possível recuperar as informações do pedido caso você excluá-lo.");
		System.out.println("");
		
		System.out.print("Confirme sua senha: ");
		String confirmarSenha = input.nextLine();
		
		if (confirmarSenha.equals(Biblioteca.usuarioLogado.getSenha())) {
			
			System.out.println("");
			System.out.println("Pedido cancelado com sucesso!");
			System.out.println("");
			
			pedidoEscolhido.livro.disponibilidade = true;
			
			biblioteca.pedidos.remove(pedidoEscolhido);
			
		} else {
			
			System.out.println("");
			System.out.println("ERRO! Confirmação de senha realizada sem sucesso.");
			System.out.println("");
			
		}
		
		return;
		
	}
	
	// Método para escolher um pedido
	
	public static Pedido escolher(ArrayList<Pedido> pedidos) {
		
		if (pedidos.isEmpty()) {
			System.out.println("Você não possui pedidos pendentes registrados no sistema.");
			System.out.println("");
			return null;
		}
		
		Scanner input = Biblioteca.input;
		Integer i = 0;
		
		System.out.println("- MENU DE ESCOLHA DE PEDIDO -");
		System.out.println("Todos os pedidos pendentes feitos pelo sistema:");
		
		for (Pedido vet : pedidos) {
			System.out.println(i + " - " + vet.livro.titulo + " - " + vet.livro.autoria + " - " + String.format("%.2f", vet.livro.preco) + " - "+ Biblioteca.formatacaoData.format(vet.dataRealizacao));
			i++;
		}
		
		System.out.println("");
		System.out.print("Digite o código do pedido que você deseja escolher: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0 ) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um código de pedido válido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return pedidos.get(auxCod);
		
	}
	
}
