package edu.ifsul.projeto.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ifsul.projeto.usuarios.Administrador;
import edu.ifsul.projeto.usuarios.Cliente;
import edu.ifsul.projeto.usuarios.Usuario;
import edu.ifsul.projeto.usuarios.Vendedor;

public class Biblioteca {
	
	// Atributos da classe
	
	public ArrayList<Usuario> usuarios = new ArrayList<>();
	public ArrayList<Pedido> pedidos = new ArrayList<>();
	public ArrayList<EspacoLeitura> espacos = new ArrayList<>();
	public ArrayList<Livro> livros = new ArrayList<>();
	public ArrayList<Solicitacao> solicitacoes = new ArrayList<>();
	public ArrayList<Conversa> conversas = new ArrayList<>();
	
	public static Usuario usuarioLogado;
	
	public static Scanner input = new Scanner(System.in);
	
	public static SimpleDateFormat formatacaoData = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss"); 
	
	// Método principal de execução da aplicação
	
	public static void main(String[] args) {
		
		Integer opMenuEditarEl, opMenuConfConversas, opMenuConfEspacos, opMenuConfConta, opMenuTipoCadastro, opMenuPrincipal, opMenuAdministrador, opMenuCliente, opMenuVendedor, opMenuConfGeneros, opMenuConfLivros;
		
		Biblioteca bibliotecaAtual = new Biblioteca();
		
		do {
			
			opMenuPrincipal = Menu.principal();
			
			switch (opMenuPrincipal) {
			case 1:
				
				usuarioLogado = Menu.acesso(bibliotecaAtual.usuarios);
				
				if (usuarioLogado == null) {
					
					System.out.println("ERRO! Nenhum usuário foi encontrado com essas credenciais, ou alguma informação foi digitada incorretamente.");
					System.out.println("");
					
				} else {
					if (usuarioLogado.getTipo() == Administrador.class) {
						
						Administrador administradorLogado = (Administrador) usuarioLogado;

						do {
							
							opMenuAdministrador = Menu.administrador();
							
							switch (opMenuAdministrador) {
							case 1:
								Menu.mostrarUsuarios(bibliotecaAtual.usuarios);
								break;
							case 2:
								Menu.mostrarLivros(bibliotecaAtual.livros);
								break;
							case 3:
								Menu.mostrarEspacos(bibliotecaAtual.espacos);
								break;
							case 4:
								Menu.mostrarPedidos(bibliotecaAtual.pedidos);
								break;
							case 5:
								Menu.mostrarSolicitacoes(bibliotecaAtual.solicitacoes);
								break;
							case 6:
								Menu.mostrarGeneros(Genero.lista);
								break;
							case 7:
								Menu.mostrarConversas(bibliotecaAtual);
								break;
							case 8:
								Menu.mostrarConversas(administradorLogado.getConversas());
								break;
							case 9:
								Solicitacao.confirmar(Solicitacao.escolher(bibliotecaAtual.solicitacoes), bibliotecaAtual);
								break;
							case 10:
								opMenuConfConversas = Menu.configuracoesConversas();
								switch (opMenuConfConversas) {
								case 1:
									Conversa.iniciar(Administrador.escolherVendedor(bibliotecaAtual.usuarios), bibliotecaAtual.conversas);
									break;
								case 2:
									Conversa.visualizarMensagens(Conversa.escolher(administradorLogado.getConversas()));
									break;
								case 3:
									Mensagem.enviar(Conversa.escolher(bibliotecaAtual.conversas));
									break;
								case 4:
									Conversa.excluir(Conversa.escolher(administradorLogado.getConversas()), bibliotecaAtual);
									break;
								case 5:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");									
									break;
								}
								break;
							case 11:
								opMenuConfGeneros = Menu.configuracoesGeneros();
								switch (opMenuConfGeneros) {
								case 1:
									Genero.criar();
									break;
								case 2:
									Genero.editar(Genero.escolher(Genero.lista));
									break;
								case 3:
									Genero.excluir(bibliotecaAtual.livros, Genero.escolher(Genero.lista));
									break;
								case 4:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");									
									break;
								}
								break;
							case 12:
								opMenuConfLivros = Menu.configuracoesLivros();
								switch (opMenuConfLivros) {
								case 1:
									Livro.cadastrar(bibliotecaAtual.livros);
									break;
								case 2:
									Livro.editar(bibliotecaAtual.livros, Livro.escolher(bibliotecaAtual.livros));
									break;
								case 3:
									Livro.excluir(bibliotecaAtual.livros, Livro.escolher(bibliotecaAtual.livros));
									break;
								case 4:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");
									break;
								}
								break;
							case 13:
								opMenuTipoCadastro = Menu.escolherTipoCadastro();
								switch (opMenuTipoCadastro) {
								case 1:
									Administrador.cadastrar(bibliotecaAtual);
									break;
								case 2:
									Vendedor.cadastrar(bibliotecaAtual);
									break;
								case 3:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");									
									break;
								}
								break;
							case 14:
								opMenuConfConta = Menu.configuracoesConta();
								switch (opMenuConfConta) {
								case 1:
									usuarioLogado.alterarEmail();
									break;
								case 2:
									usuarioLogado.alterarSenha();									
									break;
								case 3:
									if (usuarioLogado.excluirConta(bibliotecaAtual)) {
										opMenuAdministrador = 15;
									}									
									break;
								case 4:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");													
									break;
								}
								break;
							case 15:
								System.out.println("Saindo do sistema...");
								System.out.println("");
								break;
							
							}
							
						} while (opMenuAdministrador != 15);
						
					} else if (usuarioLogado.getTipo() == Vendedor.class) {
						
						Vendedor vendedorLogado = (Vendedor) usuarioLogado;
						
						do {
					
							opMenuVendedor = Menu.vendedor();
							
							switch (opMenuVendedor) {
							case 1:
								Pedido.confirmar(Pedido.escolher(bibliotecaAtual.pedidos), bibliotecaAtual.livros);
								break;
							case 2:
								Menu.mostrarPedidosConluidos(vendedorLogado);
								break;
							case 3:
								Menu.mostrarSolicitacoes(vendedorLogado.getSolicitacoes());
								break;
							case 4:
								Menu.mostrarConversas(vendedorLogado.getConversas());
								break;
							case 5:
								opMenuConfConversas = Menu.configuracoesConversas();
								switch (opMenuConfConversas) {
								case 1:
									Conversa.iniciar(Vendedor.escolherAdministrador(bibliotecaAtual.usuarios), bibliotecaAtual.conversas);
									break;
								case 2:
									Conversa.visualizarMensagens(Conversa.escolher(bibliotecaAtual.conversas));
									break;
								case 3:
									Mensagem.enviar(Conversa.escolher(bibliotecaAtual.conversas));
									break;
								case 4:
									Conversa.excluir(Conversa.escolher(vendedorLogado.getConversas()), bibliotecaAtual);
									break;
								case 5:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");									
									break;
								}
								break;
							case 6:
								Solicitacao.solicitar(bibliotecaAtual);
								break;
							case 7:
								Solicitacao.editar(Solicitacao.escolher(vendedorLogado.getSolicitacoes()));
								break;
							case 8:
								opMenuConfConta = Menu.configuracoesConta();
								switch (opMenuConfConta) {
								case 1:
									usuarioLogado.alterarEmail();
									break;
								case 2:
									usuarioLogado.alterarSenha();								
									break;
								case 3:
									if (usuarioLogado.excluirConta(bibliotecaAtual)) {
										opMenuVendedor = 9;
									}
									break;
								case 4:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");													
									break;
								}								
								break;
							case 9:
								System.out.println("Saindo do sistema...");
								System.out.println("");
								break;
							
							}
							
						} while (opMenuVendedor != 9);
						
					} else {
						
						Cliente clienteLogado = (Cliente) usuarioLogado;
						
						do {
							
							opMenuCliente = Menu.cliente();
							
							switch (opMenuCliente) {
							case 1:
								Livro.comprar(bibliotecaAtual);
								break;
							case 2:
								Pedido.cancelar(clienteLogado.getPedidos(), Pedido.escolher(clienteLogado.getPedidos()), bibliotecaAtual);
								break;
							case 3:
								Menu.mostrarPedidosConluidos(clienteLogado);
								break;
							case 4:
								Menu.mostrarPedidosPendentes(clienteLogado);
								break;
							case 5:
								Menu.mostrarEspacos(clienteLogado.getEspacos());
								break;
							case 6:
								Menu.mostrarComentarios(clienteLogado);
								break;
							case 7:
								opMenuConfEspacos = Menu.configuracoesEspacos();
								switch (opMenuConfEspacos) {
								case 1:
									EspacoLeitura.criar(bibliotecaAtual.espacos);
									break;
								case 2:
									
									EspacoLeitura elSelecionado = EspacoLeitura.escolherParaAdministrador(clienteLogado.getEspacos());
									
									if (elSelecionado == null) {
										break;
									}
									
									opMenuEditarEl = Menu.editarEspacos(elSelecionado);
									
									switch (opMenuEditarEl) {
									case 1:
										
										elSelecionado.alterarNome();
										
										break;
									case 2:
										
										Integer opMenuConfCargos = Menu.configuracoesCargos();
										
										switch (opMenuConfCargos) {
										case 1:
											
											elSelecionado.promoverParticipante(elSelecionado.escolherParticipante());
											
											break;
										case 2:
											
											elSelecionado.despromoverParticipante(elSelecionado.escolherParticipante());									
											
											break;
										case 3:
											
											System.out.println("Voltando para o menu anterior...");
											System.out.println("");
											
											return;
										}
										
										break;
									case 3:
										
										elSelecionado.removerParticipante(elSelecionado.escolherParticipante());
										
										break;
									case 4:
										System.out.println("Voltando para o menu anterior...");
										System.out.println("");
										break;
									}
									break;
								case 3:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");		
									break;
								}
								break;
							case 8:
								Comentario.publicar(EspacoLeitura.escolherParaAdministrador(clienteLogado.getEspacos()));
								break;
							case 9:
								EspacoLeitura.sair(bibliotecaAtual.espacos, clienteLogado.getEspacos(), EspacoLeitura.escolherParaUsuarioComum(clienteLogado.getEspacos()));
								break;
							case 10:
								EspacoLeitura.ingressar(bibliotecaAtual.espacos);
								break;
							case 11:
								EspacoLeitura.excluir(EspacoLeitura.escolherParaAdministrador(clienteLogado.getEspacos()), bibliotecaAtual.espacos);
								break;
							case 12:
								opMenuConfConta = Menu.configuracoesConta();
								switch (opMenuConfConta) {
								case 1:
									usuarioLogado.alterarEmail();									
									break;
								case 2:
									usuarioLogado.alterarSenha();
									break;
								case 3:
									if (usuarioLogado.excluirConta(bibliotecaAtual)) {
										opMenuCliente = 13;										
									}
									break;
								case 4:
									System.out.println("Voltando para o menu anterior...");
									System.out.println("");													
									break;
								}
								break;
							case 13:
								System.out.println("Saindo do sistema...");
								System.out.println("");
								break;
							
							}			
						} while (opMenuCliente != 13);
					}					
				}
				break;
			case 2:
				Cliente.cadastrar(bibliotecaAtual);
				break;
			case 3:
				Administrador.cadastrar(bibliotecaAtual);
				break;
			case 4:
				Menu.sobre();
				break;
			case 5:
				System.out.println("Fechando sistema...");
				break;
			}
			
		} while (opMenuPrincipal != 5);
		
		
	}


}
