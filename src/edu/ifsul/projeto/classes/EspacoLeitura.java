package edu.ifsul.projeto.classes;

import java.util.ArrayList;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Cliente;

public class EspacoLeitura {
	
	// Atributos da classe

	public String nome;
	public Cliente criador;
	public ArrayList<Comentario> comentarios = new ArrayList<>();
	public ArrayList<Cliente> usuariosNormais = new ArrayList<>();
	public ArrayList<Cliente> administradores = new ArrayList<>();
	
	// M�todo para criar um novo espa�o p�blico de leitura
	
	public static EspacoLeitura criar(ArrayList<EspacoLeitura> espacos) {
		
		Scanner input = Biblioteca.input;
		
		EspacoLeitura novoEl = new EspacoLeitura();
		
		System.out.println("- MENU DE CRIA��O DE ESPA�O P�BLICO DE LEITURA -");
		System.out.print("Digite o nome do espa�o p�blico de leitura: ");
		novoEl.nome = input.nextLine();
		
		novoEl.criador = (Cliente) Biblioteca.usuarioLogado;
		novoEl.administradores.add((Cliente) Biblioteca.usuarioLogado);
		
		espacos.add(novoEl);
		
		System.out.println("");
		System.out.println("Espa�o p�blico de leitura '" + novoEl.nome + "' criado com sucesso!");
		System.out.println("");
		
		return novoEl;
		
	}
	
	// M�todo para ingressar em um espa�o p�blico de leitura
	
	public static void ingressar(ArrayList<EspacoLeitura> espacos) {
		
		if (espacos.isEmpty()) {
			System.out.println("N�o h� espa�os p�blicos de leitura registrados no sistema.");
			System.out.println("");
			return;
		}
		
		Scanner input = Biblioteca.input;
		Integer i = 0;
		
		System.out.println("- MENU DE ACESSO DE ESPA�O P�BLICO DE LEITURA -");
		System.out.println("Espa�os de leitura p�blicos dispon�veis para entrar:");
		
		for (EspacoLeitura vet : espacos) {
			System.out.println(i + " - " + vet.nome);
			i++;
		}
	
		System.out.println("");
		System.out.print("Digite o c�digo do espa�o p�blico de leitura que voc� deseja entrar: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		EspacoLeitura elEscolhido = espacos.get(auxCod);
		
		Integer contadorUsuariosNormais = 0, contadorAdministradores = 0;
		
		for (Cliente vet : elEscolhido.usuariosNormais) {
			if (vet.equals((Cliente) Biblioteca.usuarioLogado)) {
				contadorUsuariosNormais++;
			}
		}
		
		for (Cliente vet : elEscolhido.administradores) {
			if (vet.equals((Cliente) Biblioteca.usuarioLogado)){
				contadorAdministradores++;
			}
		}
		
		if ((contadorUsuariosNormais != 0) || (contadorAdministradores != 0)) {
			System.out.println("Voc� j� est� participando deste espa�o p�blico de leitura.");
			System.out.println("");
			return;
		}

		
		elEscolhido.usuariosNormais.add((Cliente) Biblioteca.usuarioLogado);
		
		System.out.println("Voc� entrou com sucesso no espa�o de leitura '" + elEscolhido.nome + "'!");
		System.out.println("");
		
		return;
	}
	
	// M�todo para escolher um espa�o p�blico de leitura (onde o usu�rio seja apenas administrador)
	
	public static EspacoLeitura escolherParaAdministrador(ArrayList<EspacoLeitura> espacos) {
		
		Scanner input = Biblioteca.input;
		Integer i = 0, contadorAuxiliar = 0;
		ArrayList<EspacoLeitura> auxiliar = new ArrayList<>();
		
		if (espacos.isEmpty()) {
			System.out.println("Voc� n�o est� participando de um espa�o p�blico de leitura.");
			System.out.println("");
			return null;
		}
		
		for (EspacoLeitura vet : espacos) {
			if (vet.administradores.contains((Cliente) Biblioteca.usuarioLogado)){
				auxiliar.add(vet);
				contadorAuxiliar++;
			}
		}
		
		if (contadorAuxiliar == 0) {
			System.out.println("Voc� n�o � administrador de um espa�o p�blico de leitura.");
			System.out.println("");
			return null;
		}
		
		System.out.println("- MENU DE ESCOLHA DE ESPA�O P�BLICO DE LEITURA -");
		System.out.println("Todos os espa�os p�blicos de leitura cadastrados no sistema:");
		
		for (EspacoLeitura vet : auxiliar) {
			System.out.println(i + " - " + vet.nome);
			i++;				
		}
		
		System.out.println("");
		System.out.print("Digite o c�digo do espa�o de leitura que voc� deseja selecionar: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return espacos.get(auxCod);
		
	}
	
	// M�todo para escolher um participante de um espa�o p�blico de leitura
	
	public Cliente escolherParticipante() {
		
		if (this.usuariosNormais.isEmpty()) {
			System.out.println("N�o h� participantes comuns no espa�o p�blico de leitura.");
			System.out.println("");
			return null;
		}
		
		Integer i = 0;
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ESCOLHA DE PARTICIPANTE DE ESPA�O P�BLICO DE LEITURA -");
		System.out.println("Todos os participantes que participam desse espa�o p�blico de leitura:");
		for (Cliente vet : this.usuariosNormais) {
			System.out.println(i + " - " + vet.getNomeCompleto());
			i++;
		}
		
		System.out.print("Digite um c�digo de um participante: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return this.usuariosNormais.get(auxCod);
		
	}
	
	// M�todo para remover um participante de um espa�o p�blico de leitura
	
	public void removerParticipante(Cliente participanteEscolhido) {
		
		if (participanteEscolhido == null) {
			return;
		}
		
		this.usuariosNormais.remove(participanteEscolhido);
		
		System.out.println("");
		System.out.println("Usu�rio '" + participanteEscolhido.getNomeCompleto() + "' removido com sucesso do espa�o p�blico de leitura '" + this.nome + "'.");
		System.out.println("");
		
		return;
		
	}
	
	// M�todo para promover um participante de um espa�o p�blico de leitura
	
	public void promoverParticipante(Cliente participanteEscolhido) {
		
		if (participanteEscolhido == null) {
			return;
		}
		
		this.administradores.add(participanteEscolhido);
		
		System.out.println("");
		System.out.println("Usu�rio '" + participanteEscolhido.getNomeCompleto() + "' promovido para o cargo de Administrador com sucesso.");
		System.out.println("");
		
		return;
		
	}
	
	// M�todo para despromover um participante de um espa�o p�blico de leitura
	
	public void despromoverParticipante(Cliente participanteEscolhido) {
		
		if (participanteEscolhido == null) {
			return;
		}
		
		this.administradores.remove(participanteEscolhido);
		
		System.out.println("");
		System.out.println("Usu�rio '" + participanteEscolhido.getNomeCompleto() + "' despromovido para o cargo de Vendedor com sucesso.");
		System.out.println("");
		
		return;
		
	}
	
	// M�todo para alterar o nome de um espa�o p�blico de leitura
	
	public void alterarNome() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ALTERA��O DE NOME DE ESPA�O P�BLICO DE LEITURA -");
		System.out.print("Digite um novo valor para o campo 'Nome': ");
		this.nome = input.nextLine();
		
		System.out.println("");
		System.out.println("Nome do espa�o p�blico de leitura alterado com sucesso!");
		System.out.println("");
		
		return;
		
	}
	
	// M�todo para excluir um espa�o p�blico de leitura
	
	public static void excluir(EspacoLeitura elEscolhido, ArrayList<EspacoLeitura> espacos) {
		
		if (elEscolhido == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE EXCLUS�O DE ESPA�O P�BLICO DE LEITURA -");
		System.out.println("Para excluir este espa�o p�blico de leitura e todas as suas mensagens, confirme sua senha abaixo.");
		System.out.println("AVISO! Ap�s o processo de exclus�o, NENHUMA informa��o do espa�o de leitura poder� ser recuperada.");
		System.out.println("");
		
		System.out.print("Digite sua senha: ");
		String confirmarSenha = input.nextLine();
		
		if (Biblioteca.usuarioLogado.getSenha().equals(confirmarSenha)) {
			
			espacos.remove(elEscolhido);
			 
			System.out.println("");
			System.out.println("Espa�o p�blico de leitura '" + elEscolhido.nome + "' exclu�do com sucesso!");
			System.out.println("");
			
		} else {
			
			System.out.println("");
			System.out.println("Opera��o cancelada! A senha digitada est� incorreta.");
			System.out.println("");
			
		}
	}
	
	// M�todo para escolher um espa�o p�blico de leitura (sem restri��es de tipo de usu�rio)
	
	public static EspacoLeitura escolherParaUsuarioComum(ArrayList<EspacoLeitura> espacos) {
		
		Scanner input = Biblioteca.input;
		Integer i = 0;
		
		if (espacos.isEmpty()) {
			System.out.println("Voc� n�o est� participando de um espa�o p�blico de leitura.");
			System.out.println("");
			return null;
		}
		
		System.out.println("- MENU DE ESCOLHA DE ESPA�O P�BLICO DE LEITURA -");
		System.out.println("Todos os espa�os p�blicos de leitura cadastrados no sistema:");
		
		for (EspacoLeitura vet : espacos) {
			System.out.println(i + " - " + vet.nome);
			i++;				
		}
		
		System.out.println("");
		System.out.print("Digite o c�digo do espa�o de leitura que voc� deseja selecionar: ");
		Integer auxPos = Integer.valueOf(input.nextLine());
		
		while ((auxPos < 0) || (auxPos >= i)) {
			System.out.print("ERRO! Digite um c�digo v�lido: ");
			auxPos = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		System.out.println("");
		
		return espacos.get(auxPos);
		
	}
	
	// M�todo para sair de um espa�o p�blico de leitura
	
	public static void sair(ArrayList<EspacoLeitura> espacosBiblioteca, ArrayList<EspacoLeitura> espacosCliente, EspacoLeitura elEscolhido) {
		
		if (elEscolhido == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		Integer contadorAuxiliar = elEscolhido.administradores.size() + elEscolhido.usuariosNormais.size();
		
		if ((contadorAuxiliar - 1) == 0) {

			System.out.println("AVISO! Caso voc� saia desse espa�o p�blico de leitura, o mesmo ser� exclu�do, j� que n�o haver� outros usu�rios participando desse espa�o.");
			System.out.println("Caso voc� opte por n�o excluir o espa�o p�blico de leitura, a opera��o de exclus�o ser� cancelada.");
			
			System.out.print("Deseja continuar a opera��o? [S/N] ");
			String auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada v�lida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if ((auxOp.equals("s") || (auxOp.equals("S")))) {
				
				espacosBiblioteca.remove(elEscolhido);
				
				System.out.println("");
				System.out.println("O espa�o p�blico de leitura '" + elEscolhido.nome + "' foi exclu�do com sucesso!");
				System.out.println("");
				
				return;
				
			} else {
				
				System.out.println("");
				System.out.println("Sa�da/exclus�o do espa�o p�blico de leitura cancelada com sucesso.");
				System.out.println("");
				
				return;
				
			}
		
		} else {
			
			espacosCliente.remove(elEscolhido);
			
			System.out.println("Voc� saiu do espa�o p�blico de leitura '" + elEscolhido.nome + "'.");
			System.out.println("");
			
		}
		
		return;
	}

}
