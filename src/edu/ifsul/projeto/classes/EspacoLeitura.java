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
	
	// Método para criar um novo espaço público de leitura
	
	public static EspacoLeitura criar(ArrayList<EspacoLeitura> espacos) {
		
		Scanner input = Biblioteca.input;
		
		EspacoLeitura novoEl = new EspacoLeitura();
		
		System.out.println("- MENU DE CRIAÇÃO DE ESPAÇO PÚBLICO DE LEITURA -");
		System.out.print("Digite o nome do espaço público de leitura: ");
		novoEl.nome = input.nextLine();
		
		novoEl.criador = (Cliente) Biblioteca.usuarioLogado;
		novoEl.administradores.add((Cliente) Biblioteca.usuarioLogado);
		
		espacos.add(novoEl);
		
		System.out.println("");
		System.out.println("Espaço público de leitura '" + novoEl.nome + "' criado com sucesso!");
		System.out.println("");
		
		return novoEl;
		
	}
	
	// Método para ingressar em um espaço público de leitura
	
	public static void ingressar(ArrayList<EspacoLeitura> espacos) {
		
		if (espacos.isEmpty()) {
			System.out.println("Não há espaços públicos de leitura registrados no sistema.");
			System.out.println("");
			return;
		}
		
		Scanner input = Biblioteca.input;
		Integer i = 0;
		
		System.out.println("- MENU DE ACESSO DE ESPAÇO PÚBLICO DE LEITURA -");
		System.out.println("Espaços de leitura públicos disponíveis para entrar:");
		
		for (EspacoLeitura vet : espacos) {
			System.out.println(i + " - " + vet.nome);
			i++;
		}
	
		System.out.println("");
		System.out.print("Digite o código do espaço público de leitura que você deseja entrar: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um código válido: ");
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
			System.out.println("Você já está participando deste espaço público de leitura.");
			System.out.println("");
			return;
		}

		
		elEscolhido.usuariosNormais.add((Cliente) Biblioteca.usuarioLogado);
		
		System.out.println("Você entrou com sucesso no espaço de leitura '" + elEscolhido.nome + "'!");
		System.out.println("");
		
		return;
	}
	
	// Método para escolher um espaço público de leitura (onde o usuário seja apenas administrador)
	
	public static EspacoLeitura escolherParaAdministrador(ArrayList<EspacoLeitura> espacos) {
		
		Scanner input = Biblioteca.input;
		Integer i = 0, contadorAuxiliar = 0;
		ArrayList<EspacoLeitura> auxiliar = new ArrayList<>();
		
		if (espacos.isEmpty()) {
			System.out.println("Você não está participando de um espaço público de leitura.");
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
			System.out.println("Você não é administrador de um espaço público de leitura.");
			System.out.println("");
			return null;
		}
		
		System.out.println("- MENU DE ESCOLHA DE ESPAÇO PÚBLICO DE LEITURA -");
		System.out.println("Todos os espaços públicos de leitura cadastrados no sistema:");
		
		for (EspacoLeitura vet : auxiliar) {
			System.out.println(i + " - " + vet.nome);
			i++;				
		}
		
		System.out.println("");
		System.out.print("Digite o código do espaço de leitura que você deseja selecionar: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		System.out.println("");
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um código válido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return espacos.get(auxCod);
		
	}
	
	// Método para escolher um participante de um espaço público de leitura
	
	public Cliente escolherParticipante() {
		
		if (this.usuariosNormais.isEmpty()) {
			System.out.println("Não há participantes comuns no espaço público de leitura.");
			System.out.println("");
			return null;
		}
		
		Integer i = 0;
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ESCOLHA DE PARTICIPANTE DE ESPAÇO PÚBLICO DE LEITURA -");
		System.out.println("Todos os participantes que participam desse espaço público de leitura:");
		for (Cliente vet : this.usuariosNormais) {
			System.out.println(i + " - " + vet.getNomeCompleto());
			i++;
		}
		
		System.out.print("Digite um código de um participante: ");
		Integer auxCod = Integer.valueOf(input.nextLine());
		
		while ((auxCod < 0) || (auxCod >= i)) {
			System.out.print("ERRO! Digite um código válido: ");
			auxCod = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		return this.usuariosNormais.get(auxCod);
		
	}
	
	// Método para remover um participante de um espaço público de leitura
	
	public void removerParticipante(Cliente participanteEscolhido) {
		
		if (participanteEscolhido == null) {
			return;
		}
		
		this.usuariosNormais.remove(participanteEscolhido);
		
		System.out.println("");
		System.out.println("Usuário '" + participanteEscolhido.getNomeCompleto() + "' removido com sucesso do espaço público de leitura '" + this.nome + "'.");
		System.out.println("");
		
		return;
		
	}
	
	// Método para promover um participante de um espaço público de leitura
	
	public void promoverParticipante(Cliente participanteEscolhido) {
		
		if (participanteEscolhido == null) {
			return;
		}
		
		this.administradores.add(participanteEscolhido);
		
		System.out.println("");
		System.out.println("Usuário '" + participanteEscolhido.getNomeCompleto() + "' promovido para o cargo de Administrador com sucesso.");
		System.out.println("");
		
		return;
		
	}
	
	// Método para despromover um participante de um espaço público de leitura
	
	public void despromoverParticipante(Cliente participanteEscolhido) {
		
		if (participanteEscolhido == null) {
			return;
		}
		
		this.administradores.remove(participanteEscolhido);
		
		System.out.println("");
		System.out.println("Usuário '" + participanteEscolhido.getNomeCompleto() + "' despromovido para o cargo de Vendedor com sucesso.");
		System.out.println("");
		
		return;
		
	}
	
	// Método para alterar o nome de um espaço público de leitura
	
	public void alterarNome() {
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE ALTERAÇÃO DE NOME DE ESPAÇO PÚBLICO DE LEITURA -");
		System.out.print("Digite um novo valor para o campo 'Nome': ");
		this.nome = input.nextLine();
		
		System.out.println("");
		System.out.println("Nome do espaço público de leitura alterado com sucesso!");
		System.out.println("");
		
		return;
		
	}
	
	// Método para excluir um espaço público de leitura
	
	public static void excluir(EspacoLeitura elEscolhido, ArrayList<EspacoLeitura> espacos) {
		
		if (elEscolhido == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		
		System.out.println("- MENU DE EXCLUSÃO DE ESPAÇO PÚBLICO DE LEITURA -");
		System.out.println("Para excluir este espaço público de leitura e todas as suas mensagens, confirme sua senha abaixo.");
		System.out.println("AVISO! Após o processo de exclusão, NENHUMA informação do espaço de leitura poderá ser recuperada.");
		System.out.println("");
		
		System.out.print("Digite sua senha: ");
		String confirmarSenha = input.nextLine();
		
		if (Biblioteca.usuarioLogado.getSenha().equals(confirmarSenha)) {
			
			espacos.remove(elEscolhido);
			 
			System.out.println("");
			System.out.println("Espaço público de leitura '" + elEscolhido.nome + "' excluído com sucesso!");
			System.out.println("");
			
		} else {
			
			System.out.println("");
			System.out.println("Operação cancelada! A senha digitada está incorreta.");
			System.out.println("");
			
		}
	}
	
	// Método para escolher um espaço público de leitura (sem restrições de tipo de usuário)
	
	public static EspacoLeitura escolherParaUsuarioComum(ArrayList<EspacoLeitura> espacos) {
		
		Scanner input = Biblioteca.input;
		Integer i = 0;
		
		if (espacos.isEmpty()) {
			System.out.println("Você não está participando de um espaço público de leitura.");
			System.out.println("");
			return null;
		}
		
		System.out.println("- MENU DE ESCOLHA DE ESPAÇO PÚBLICO DE LEITURA -");
		System.out.println("Todos os espaços públicos de leitura cadastrados no sistema:");
		
		for (EspacoLeitura vet : espacos) {
			System.out.println(i + " - " + vet.nome);
			i++;				
		}
		
		System.out.println("");
		System.out.print("Digite o código do espaço de leitura que você deseja selecionar: ");
		Integer auxPos = Integer.valueOf(input.nextLine());
		
		while ((auxPos < 0) || (auxPos >= i)) {
			System.out.print("ERRO! Digite um código válido: ");
			auxPos = Integer.valueOf(input.nextLine());
			System.out.println("");
		}
		
		System.out.println("");
		
		return espacos.get(auxPos);
		
	}
	
	// Método para sair de um espaço público de leitura
	
	public static void sair(ArrayList<EspacoLeitura> espacosBiblioteca, ArrayList<EspacoLeitura> espacosCliente, EspacoLeitura elEscolhido) {
		
		if (elEscolhido == null) {
			return;
		}
		
		Scanner input = Biblioteca.input;
		Integer contadorAuxiliar = elEscolhido.administradores.size() + elEscolhido.usuariosNormais.size();
		
		if ((contadorAuxiliar - 1) == 0) {

			System.out.println("AVISO! Caso você saia desse espaço público de leitura, o mesmo será excluído, já que não haverá outros usuários participando desse espaço.");
			System.out.println("Caso você opte por não excluir o espaço público de leitura, a operação de exclusão será cancelada.");
			
			System.out.print("Deseja continuar a operação? [S/N] ");
			String auxOp = input.nextLine();
			
			System.out.println("");
			
			while ((!auxOp.equals("N")) && (!auxOp.equals("S")) && (!auxOp.equals("n")) && (!auxOp.equals("s"))){
				System.out.print("ERRO! Digite uma entrada válida: ");
				auxOp = input.nextLine();
				System.out.println("");
			}
			
			if ((auxOp.equals("s") || (auxOp.equals("S")))) {
				
				espacosBiblioteca.remove(elEscolhido);
				
				System.out.println("");
				System.out.println("O espaço público de leitura '" + elEscolhido.nome + "' foi excluído com sucesso!");
				System.out.println("");
				
				return;
				
			} else {
				
				System.out.println("");
				System.out.println("Saída/exclusão do espaço público de leitura cancelada com sucesso.");
				System.out.println("");
				
				return;
				
			}
		
		} else {
			
			espacosCliente.remove(elEscolhido);
			
			System.out.println("Você saiu do espaço público de leitura '" + elEscolhido.nome + "'.");
			System.out.println("");
			
		}
		
		return;
	}

}
