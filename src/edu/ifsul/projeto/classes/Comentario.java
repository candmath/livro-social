package edu.ifsul.projeto.classes;

import java.util.Date;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Cliente;

public class Comentario {
	
	// Atributos da classe
	
	public String texto;
	public Cliente autor;
	public Date dataPostagem;
	public EspacoLeitura espacoLeitura;
	
	// Método para publicar um novo comentário
		
	public static Comentario publicar(EspacoLeitura elEscolhido) {
		
		if (elEscolhido == null) {
			return null;
		}
		
		Scanner input = Biblioteca.input;		
		Comentario novoComentario = new Comentario();
		
		System.out.println("- MENU DE POSTAGEM DE COMENTÁRIO -");
		System.out.println("Informe no campo abaixo o comentário que você quer postar no espaço de leitura '" + elEscolhido.nome + "'.");
		System.out.println("");
		
		System.out.print("Digite o seu comentário: ");
		novoComentario.texto = input.nextLine();
		
		novoComentario.dataPostagem = new Date();
		novoComentario.espacoLeitura = elEscolhido;
		novoComentario.autor = (Cliente) Biblioteca.usuarioLogado;
		
		elEscolhido.comentarios.add(novoComentario);
		
		Cliente usuarioConvertido = (Cliente) Biblioteca.usuarioLogado;
		usuarioConvertido.comentarios.add(novoComentario);

		System.out.println("");
		System.out.println("Comentário postado com sucesso no espaço público de leitura '" + elEscolhido.nome + "'!");
		System.out.println("");
		
		return novoComentario;
		
	}

}
