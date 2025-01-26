package edu.ifsul.projeto.usuarios;

import java.util.ArrayList;

import edu.ifsul.projeto.classes.Biblioteca;
import edu.ifsul.projeto.classes.Comentario;
import edu.ifsul.projeto.classes.EspacoLeitura;
import edu.ifsul.projeto.classes.Pedido;

public class Cliente extends Usuario {
	
	// Atributos da classe
	
	public ArrayList<Comentario> comentarios = new ArrayList<>();
	
	// Método que retorna todos os pedidos de um usuário
	
	public ArrayList<Pedido> getPedidos(){
		
		ArrayList<Pedido> auxiliar = new ArrayList<>();
		
		for (Pedido vet : biblioteca.pedidos) {
			if (vet.comprador.equals(this)) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;	
		
	}
	
	// Método que retorna todos os espaços públicos de leitura de um usuário
	
	public ArrayList<EspacoLeitura> getEspacos(){
		
		ArrayList<EspacoLeitura> auxiliar = new ArrayList<>();
		
		for (EspacoLeitura vet : biblioteca.espacos) {
			if ((vet.usuariosNormais.contains(this)) || (vet.administradores.contains(this))) {
				auxiliar.add(vet);
			}
		}
		
		return auxiliar;
		
	}
	
	// Método que auxilia o cadastro de um novo cliente
	
	public static Cliente cadastrar(Biblioteca biblioteca) {
		
		Cliente c = new Cliente();
		Usuario.cadastrar(c, biblioteca);
		
		return c;
		
	}
	
}