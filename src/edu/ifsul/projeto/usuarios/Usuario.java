package edu.ifsul.projeto.usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import edu.ifsul.projeto.classes.Biblioteca;

public abstract class Usuario {
	
	// Atributos da classe
	
	public String nome;
	public String sobrenome;
	private String email;
	private String senha;
	public Date dataCadastro;
	public Biblioteca biblioteca;
	
	public static ArrayList<Usuario> lista = new ArrayList<>();
	
	// M�todo para o cadastro de um novo usu�rio
	
	public static Usuario cadastrar(Usuario novoUsuario, Biblioteca biblioteca) {
		
		Scanner input = Biblioteca.input;
		
		System.out.print("- MENU DE CADASTRO DE NOVO "); 
		
		if (novoUsuario instanceof Cliente) {
			
			System.out.println("CLIENTE -");
			
		} else if (novoUsuario instanceof Vendedor) {
			
			System.out.println("VENDEDOR -");
			
		} else {
			
			System.out.println("ADMINISTRADOR -");
			
		}
		
		System.out.println("Informe nos campos abaixo suas informa��es para o cadastro.");
		
		System.out.print("Digite seu nome: ");
		novoUsuario.nome = input.nextLine();

		System.out.print("Digite seu sobrenome: ");
		novoUsuario.sobrenome = input.nextLine();
		
		System.out.print("Digite seu e-mail: ");
		novoUsuario.email = input.nextLine();

		System.out.print("Digite sua senha: ");
		novoUsuario.senha = input.nextLine();	
		
		System.out.print("Confirme sua senha: ");
		String confirmarSenha = input.nextLine();
		
		while (!novoUsuario.senha.equals(confirmarSenha)) {
			System.out.print("ERRO! Confirma��o de senha realizada sem sucesso. Digite novamente sua senha: ");
			confirmarSenha = input.nextLine();
		}
		
		novoUsuario.dataCadastro = new Date();
		
		novoUsuario.biblioteca = biblioteca;
		
		for (Usuario vet : biblioteca.usuarios) {
			if (novoUsuario.email.equals(vet.email)) {
				System.out.println("");
				System.out.println("Este e-mail j� est� sendo utilizado. Por gentileza, informe um e-mail diferente!");
				System.out.println("");
				return null;
			}
		}
		
		System.out.println("");
		System.out.print("Novo ");
		if (novoUsuario instanceof Cliente) {
			System.out.print("cliente");
		} else if (novoUsuario instanceof Administrador) {
			System.out.print("administrador");
		} else {
			System.out.print("vendedor");
		}
		System.out.println(" cadastrado com sucesso!");
		System.out.println("");
			
		biblioteca.usuarios.add(novoUsuario);
	
		return novoUsuario;
		
	}
	
	// M�todo para a verifica��o de informa��es para acesso (login)
	
	public static Usuario login(String emailDigitado, String senhaDigitada, ArrayList<Usuario> usuarios) {
		
		for (Usuario vet : usuarios) {
			if ((vet.email.equals(emailDigitado)) && (vet.senha.equals(senhaDigitada))) {
				return vet;
			}
		}
		
		return null;
		
	}
	
	// M�todo que retorna o tipo do usu�rio que est� acessando o sistema
	
	public Class<?> getTipo() {
		
		if (this instanceof Administrador) {
			
			return Administrador.class;
			
		} else if (this instanceof Cliente) {
			
			return Cliente.class;
			
		} else {
			
			return Vendedor.class;
			
		}
		
	}
	
	// M�todo que retorna o nome completo do usu�rio que est� acessando o sistema
	
	public String getNomeCompleto() {
		
		return this.nome + " " + this.sobrenome;
		
	}
	
	// M�todo que altera a senha de um usu�rio
	
	public void alterarSenha() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ALTERA��O DE SENHA -");
		System.out.println("Para trocar de senha, confirme sua senha abaixo e informe sua nova senha ap�s a confirma��o.");
		
		System.out.print("Confirme sua senha: ");
		String confirmarSenha = input.nextLine();
		
		if (confirmarSenha.equals(this.senha)) {

			System.out.println("");
			System.out.print("Digite a sua nova senha: ");
			String novaSenha = input.nextLine();
			
			System.out.println("");
			System.out.print("Digite novamente a sua nova senha: ");
			String confirmarNovaSenha = input.nextLine();
			
			while (!novaSenha.equals(confirmarNovaSenha)) {
				
				System.out.print("ERRO! Confirme novamente sua senha: ");
				confirmarNovaSenha = input.nextLine();
				
			}
			
			System.out.println("");
			System.out.println("Sua senha foi alterada com sucesso.");
			System.out.println("");
				
			this.senha = novaSenha;				
			
		} else {
			
			System.out.println("");
			System.out.println("ERRO! A opera��o foi cancelada, pois a senha digitada est� incorreta.");
			System.out.println("");
			
		}
		
		return;
		
	}
	
	// M�todo que altera o e-mail de um usu�rio
	
	public void alterarEmail() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ALTERA��O DE E-MAIL -");
		System.out.println("Para trocar de e-mail, confirme sua senha abaixo e informe seu novo e-mail ap�s a confirma��o.");

		System.out.print("Confirme sua senha: ");
		String confirmarSenha = input.nextLine();
		
		if (confirmarSenha.equals(this.senha)) {
			
			System.out.println("");
			System.out.print("Digite o seu novo e-mail: ");

			this.email = input.nextLine();
			
			System.out.println("");
			System.out.println("Seu e-mail foi alterado com sucesso!");
			System.out.println("");	

			
		} else {
			
			System.out.println("");
			System.out.println("ERRO! Opera��o cancelada. A senha digitada est� incorreta.");
			System.out.println("");		
			
		}
		
		return;
		
	}
	
	// M�todo que exclui uma conta de um usu�rio do sistema
	
	public Boolean excluirConta(Biblioteca biblioteca) {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE EXCLUS�O DE CONTA -");
		System.out.println("AVISO! Caso voc� exclua sua conta, n�o ser� poss�vel recuperar os seus dados.");
		System.out.print("Confirme sua senha: ");
		String confirmarSenha = input.nextLine();
		
		if (confirmarSenha.equals(this.senha)) {
			
			System.out.println("");
			System.out.println("Sua conta foi exclu�da com sucesso!");
			System.out.println("");
			
			biblioteca.usuarios.remove(this);
			Biblioteca.usuarioLogado = null;
			
			return true;
			
		} else {
			
			System.out.println("");
			System.out.println("ERRO! Opera��o de exclus�o de conta realizada sem sucesso. A senha digitada est� incorreta.");
			System.out.println("");
			
			return false;
			
		}
	
	}
	
	// M�todo que retorna o e-mail de um usu�rio
	
	public String getEmail() {
		return this.email;
	}
	
	// M�todo que retorna a senha de um usu�rio
	
	public String getSenha() {
		return this.senha;
	}
	
}
