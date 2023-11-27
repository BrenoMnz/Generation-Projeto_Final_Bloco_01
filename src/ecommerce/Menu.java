package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		int opcao;
		
		int logon = 0, perms = 0, tempInt;
		boolean continua = true;
		String usuario, senha, temp;
		
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
							//ler.nextLine();
							System.out.print("Insira a senha: ");
							senha = ler.nextLine();
							
							if(usuario.equals("1") && senha.equals("1")) {
								//FUNÇÃO PARA CHECAR O NOME E SE É ADMINISTRADOR
								perms = 1;
								logon = 1;
							} else if (usuario.equals("2") && senha.equals("2")) {
								//FUNÇÃO PARA CHECAR O NOME E SE É COMPRADOR
								perms = 2;
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
									System.out.println("CADASTRA");
								}
								case 2 -> {
									System.out.println("DELETA");
								}
								case 3 -> {
									System.out.println("LISTA");
								}
								case 4 -> {
									System.out.println("BUSCA");
								}
								case 5 -> {
									System.out.println("ATUALIZA");
								}
								case 6 -> {
									System.out.println("ESTOCA");
								}
								case 7 -> {
									System.out.println("REMOVE");
								}
								case 8 -> {
									ler.nextLine();
									System.out.println("                                                    ");
									System.out.print("Insira o nome do usuário: ");
									temp = ler.nextLine();
									System.out.println("                                                    ");
									System.out.print("Insira a senha do usuário: ");
									temp = ler.nextLine();
									System.out.println("                                                    ");
									System.out.print("Insira o nível de permissão: ");
									tempInt = ler.nextInt();
										//CADASTRAR OS DADOS NO OBJETO
								}
								case 9 -> {
									System.out.println("                                                    ");
									System.out.print("Insira o nome do usuário a ser removido: ");
									temp = ler.nextLine();
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
									System.out.println("LISTA");
								}
								case 2 -> {
									System.out.println("BUSCA");
								}
								case 3 -> {
									System.out.println("COMPRA");
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
