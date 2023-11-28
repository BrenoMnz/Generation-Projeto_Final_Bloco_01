package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.model.Conta;
import ecommerce.model.PlacaDeVideo;
import ecommerce.model.Processador;


public class Menu {

	public static void main(String[] args) {
		
		EcommerceController ProdutoConta = new EcommerceController();
		
		ProdutoConta.criarAdmin();
		
		ProdutoConta.cadastroProduto(new Processador(0, "Ryzen 5", "AMD", 1, 50.00f, 0, "x64", 6, 12, 5.5f));
		ProdutoConta.cadastroProduto(new PlacaDeVideo(1, "GTX 750 TI", "Nvidia", 2, 1000.00f, 0, "x64", 5, 5.5f));
		
		Scanner ler = new Scanner(System.in);
		
		int opcao;
		
		int logon = 0, perms = 0, tempInt;
		boolean continua = true;
		String usuario, senha;
		
		int numero = 2, tipo = 0, quantidadeEstoque, qtdNucleos, qtdThreads, vram;
		String nome, marca, arquitetura;
		float preco, frequenciaClock;
		
		while(continua) {
			
			ler.nextLine();
			if (logon == 0) {
				System.out.println("====================================================");
				System.out.println("                                                    ");
				System.out.println("           HARDWERE PEÇAS PARA COMPUTADOR           ");
				System.out.println("                                                    ");
				System.out.println("====================================================");
				System.out.println("                                                    ");
				System.out.println("1 - Login                                           ");
				System.out.println("2 - Sair                                            ");
				System.out.println("                                                    ");
				System.out.println("====================================================");
				System.out.print("Entre com a opção desejada: ");
				try {
					opcao = ler.nextInt();
					
					switch(opcao) {
						case 1 -> {
							ler.nextLine();
							System.out.println("                                                    ");
							System.out.print("Insira o usuário: ");
							usuario = ler.nextLine();
							System.out.println("                                                    ");
							System.out.print("Insira a senha: ");
							senha = ler.nextLine();
							
							if (ProdutoConta.checkLogin(usuario, senha)) {
								perms = ProdutoConta.buscarContas(usuario).getPermissao();
								logon = 1;
							}

						}
						case 2 -> {
							continua = false;
						}
					}
				} catch (InputMismatchException e) {
					System.out.println("\nInsira um número como opção!");
				}
			} else {
				switch(perms) {
					case 1 -> {
						System.out.println("====================================================");
						System.out.println("                                                    ");
						System.out.println("           HARDWERE PEÇAS PARA COMPUTADOR           ");
						System.out.println("                                                    ");
						System.out.println("====================================================");
						System.out.println("Bem vindo administrador!                            ");
						System.out.println("                                                    ");
						System.out.println("1 - Cadastrar produto                               ");
						System.out.println("2 - Deletar produto                                 ");
						System.out.println("3 - Listar produtos                                 ");
						System.out.println("4 - Buscar produto por código                       ");
						System.out.println("5 - Atualizar produto                               ");
						System.out.println("6 - Estocar produto                                 ");
						System.out.println("7 - Remover produto                                 ");
						System.out.println("8 - Cadastrar usuário                               ");
						System.out.println("9 - Deletar usuário                                 ");
						System.out.println("10 - Logout                                         ");
						System.out.println("                                                    ");
						System.out.println("====================================================");
						System.out.print("Entre com a opção desejada: ");
						try {
							opcao = ler.nextInt();
							
							switch(opcao) {
								case 1 -> {
									ler.nextLine();
									System.out.println("\nCadastrar produto\n\n");
									
									System.out.print("Insira o nome: ");
									nome = ler.nextLine();
									System.out.print("Insira a marca: ");
									marca = ler.nextLine();
									System.out.print("Insira o tipo: ");
									tipo = ler.nextInt();
									switch(tipo) {
									case 1 -> {
										ler.nextLine();
										System.out.print("Insira a arquitetura: ");
										arquitetura = ler.nextLine();
										System.out.print("Insira a quantidade de núcleos: ");
										qtdNucleos = ler.nextInt();
										System.out.print("Insira a quantidade de threads: ");
										qtdThreads = ler.nextInt();
										System.out.print("Insira a frequência do clock: ");
										frequenciaClock = ler.nextFloat();
										ler.nextLine();
										System.out.print("Insira o preço: R$");
										preco = ler.nextFloat();
										
										ProdutoConta.cadastroProduto(new Processador(numero, nome, marca, tipo, preco, 0, arquitetura, qtdNucleos, qtdThreads, frequenciaClock));
									}
									case 2 -> {
										ler.nextLine();
										System.out.print("Insira a arquitetura: ");
										arquitetura = ler.nextLine();
										System.out.print("Insira a VRAM(em GBs): ");
										vram = ler.nextInt();
										System.out.print("Insira a frequência do clock: ");
										frequenciaClock = ler.nextFloat();
										ler.nextLine();
										System.out.print("Insira o preço: R$");
										preco = ler.nextFloat();
										
										ProdutoConta.cadastroProduto(new PlacaDeVideo(numero, nome, marca, tipo, preco, 0, arquitetura, vram, frequenciaClock));
									}
									}
									
								}
								case 2 -> {
									System.out.println("\nDeletar produto\n\n");
									
									System.out.print("Insira o número do produto a ser deletado: ");
									tempInt = ler.nextInt();
									
									ProdutoConta.deletaProduto(tempInt);
									
								}
								case 3 -> {
									System.out.println("\nListar produtos\n\n");
									
									ProdutoConta.listaProdutos();
								}
								case 4 -> {
									System.out.println("\nBuscar produto por código\n\n");
									
									System.out.print("Insira o número do produto: ");
									tempInt = ler.nextInt();
									ProdutoConta.buscarPorNumero(tempInt);
								}
								case 5 -> {
									System.out.println("\nAtualizar produto\n\n");
									
									System.out.print("Insira o número do produto: ");
									tempInt = ler.nextInt();
									ler.nextLine();
									
									var buscaProduto = ProdutoConta.buscarProdutos(tempInt);
									
									if (buscaProduto != null) {
										tipo = buscaProduto.getTipo();
										
										System.out.print("Insira o nome: ");
										nome = ler.nextLine();
										System.out.print("Insira a marca: ");
										marca = ler.nextLine();

										switch(tipo) {
										case 1 -> {
											System.out.print("Insira a arquitetura: ");
											arquitetura = ler.nextLine();
											System.out.print("Insira a quantidade de núcleos: ");
											qtdNucleos = ler.nextInt();
											System.out.print("Insira a quantidade de threads: ");
											qtdThreads = ler.nextInt();
											System.out.print("Insira a frequência do clock: ");
											frequenciaClock = ler.nextFloat();
											ler.nextLine();
											System.out.print("Insira o preço: R$");
											preco = ler.nextFloat();
											
											ProdutoConta.cadastroProduto(new Processador(numero, nome, marca, tipo, preco, 0, arquitetura, qtdNucleos, qtdThreads, frequenciaClock));
										}
										case 2 -> {
											System.out.print("Insira a arquitetura: ");
											arquitetura = ler.nextLine();
											System.out.print("Insira a VRAM(em GBs): ");
											vram = ler.nextInt();
											System.out.print("Insira a frequência do clock: ");
											frequenciaClock = ler.nextFloat();
											ler.nextLine();
											System.out.print("Insira o preço: R$");
											preco = ler.nextFloat();
											
											ProdutoConta.cadastroProduto(new PlacaDeVideo(numero, nome, marca, tipo, preco, 0, arquitetura, vram, frequenciaClock));
										}
										}
									}
								}
								case 6 -> {
									System.out.println("\nEstocar produto\n\n");
									
									System.out.print("Insira o número do produto: ");
									tempInt = ler.nextInt();
									System.out.print("Insira a quantidade de estoque: ");
									quantidadeEstoque = ler.nextInt();
									
									ProdutoConta.estocaProduto(tempInt, quantidadeEstoque);
								}
								case 7 -> {
									System.out.println("\nRemover produto\n\n");
									
									System.out.print("Insira o número do produto: ");
									tempInt = ler.nextInt();
									System.out.print("Insira a quantidade de remoção: ");
									quantidadeEstoque = ler.nextInt();
									
									ProdutoConta.removeProduto(tempInt, quantidadeEstoque);
								}
								case 8 -> {
									ler.nextLine();
									System.out.println("                                                    ");
									System.out.print("Insira o nome do usuário: ");
									usuario = ler.nextLine();
									System.out.println("                                                    ");
									System.out.print("Insira a senha do usuário: ");
									senha = ler.nextLine();
									System.out.println("                                                    ");
									System.out.print("Insira o nível de permissão: ");
									tempInt = ler.nextInt();
									
									ProdutoConta.cadastraUsuario(new Conta(usuario, senha, tempInt));
								}
								case 9 -> {
									System.out.println("                                                    ");
									System.out.print("Insira o nome do usuário a ser removido: ");
									ler.nextLine();
									nome = ler.nextLine();
									
									ProdutoConta.deletaUsuario(nome);
								}
								case 10 -> {
									logon = 0;
									perms = 0;
									usuario = "0";
									senha = "0";
								}
							}
						} catch (InputMismatchException e) {
							System.out.println("Insira um número como opção!");
						}
					}
					case 2 -> {
						System.out.println("====================================================");
						System.out.println("                                                    ");
						System.out.println("           HARDWERE PEÇAS PARA COMPUTADOR           ");
						System.out.println("                                                    ");
						System.out.println("====================================================");
						System.out.println("Bem vindo comprador!                                ");
						System.out.println("                                                    ");
						System.out.println("1 - Listar produtos                                 ");
						System.out.println("2 - Buscar produto por código                       ");
						System.out.println("3 - Comprar produtos                                ");
						System.out.println("4 - Logout                                         ");
						System.out.println("                                                    ");
						System.out.println("====================================================");
						System.out.print("Entre com a opção desejada: ");
						try {
							opcao = ler.nextInt();
							
							switch(opcao) {
								case 1 -> {
									System.out.println("\nListar produtos\n\n");
									
									ProdutoConta.listaProdutos();
								}
								case 2 -> {
									System.out.println("\nBuscar produto por código\n\n");
									
									System.out.print("Insira o número do produto: ");
									tempInt = ler.nextInt();
									ProdutoConta.buscarPorNumero(tempInt);
								}
								case 3 -> {
									System.out.println("\nComprar produtos\n\n");
									
									System.out.print("Insira o número do produto: ");
									tempInt = ler.nextInt();
									System.out.print("Insira a quantidade de compra: ");
									quantidadeEstoque = ler.nextInt();
									
									ProdutoConta.removeProduto(tempInt, quantidadeEstoque);
								}
								case 4 -> {
									logon = 0;
									perms = 0;
									usuario = "0";
									senha = "0";
								}
								
							}
						} catch (InputMismatchException e) {
							System.out.println("Insira um número como opção!");
						}
					}
				}
			}

		}
		
		System.out.println("OBRIGADO POR COMPRAR NA HARDWERE");

	}
}
