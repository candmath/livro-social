package edu.ifsul.projeto.classes;

import java.util.Date;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Usuario;

public class Mensagem {
	
	// Atributos da classe
	
	public String texto;
	public Date dataEnvio;
	public Usuario autor;
	public Conversa conversa;
	
	// Método para enviar uma mensagem
	
	public static Mensagem enviar(Conversa conversaEscolhida) {
		
		if (conversaEscolhida == null) {
			return null;
		}
		
		Mensagem novaMensagem = new Mensagem();
		Scanner input = Biblioteca.input;
		
		System.out.print("Digite sua mensagem: ");
		novaMensagem.texto = input.nextLine();
		
		novaMensagem.dataEnvio = new Date();
		novaMensagem.autor = Biblioteca.usuarioLogado;
		novaMensagem.conversa = conversaEscolhida;
		
		System.out.println("");
		System.out.println("Mensagem enviada com sucesso!");
		System.out.println("");
		
		conversaEscolhida.mensagens.add(novaMensagem);
		
		return novaMensagem;
		
	}

}
