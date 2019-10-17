
package LP1;

import java.util.ArrayList;
import java.util.Scanner;

//Projeto Feito por Nicolas Milhole & Jonas Campillay
//desde 5 de Setembro
//Objetivo: Adquirir conhecimento apartir da cria��o de um sistema Bancario, 
//Onde se utilizara varias ferramentas e metodos de aplica��o novos.

public class Principal {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	static ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	static ArrayList<Agencia> listaAgencia = new ArrayList<Agencia>();
	static ArrayList<Gerente> listaGerente = new ArrayList<Gerente>();

	public static void main(String[] args) {

		String menuPrincipal = "1 - Acessar menu cliente\n" 
				+ "2 - Acessar menu conta\n" 
				+ "3 - Acessar menu agencia\n"
				+ "4 - Acessar menu gerente\n" 
				+ "5 - Acessar menu dados\n" 
				+ "6 - Acessar menu Pessoa\n";

		boolean sair = false;
		int op;

		try {
			do {
				System.out.println(menuPrincipal);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					menuCliente();

					break;

				case 2:
					menuConta();

					break;

				case 3:
					menuAgencia();
					break;

				case 4:
					menuGerente();
					break;

				case 5:
					menuDados();
					break;

				case 6:
					menuPessoa();
					break;

				default:
					System.out.println("Informe ");
					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO Principal!");
		}

	}

	public static void menuCliente() {
		boolean sair = false;
		int op;
		String menuCliente = "1 - Criar Novo Cliente\n" 
				+ "2 - Consultar Cliente\n" 
				+ "3 - Excluir Cliente\n"
				+ "4 - Alterar dados do cliente\n" 
				+ "5 - Listar CLientes\n" 
				+ "6 - Menu anterior";

		try {
			do {
				System.out.println(menuCliente);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					HandlerCliente.cadastrarCliente();

					break;

				case 2:

					Cliente clientAux = HandlerCliente.consultarCliente();

					if (clientAux != null)
						System.out.println(clientAux.toString());
					else
						System.out.println("Cliente n�o encontrada");

					break;

				case 3:
					HandlerCliente.removeCliente();
					break;

				case 4:
					HandlerCliente.alterarCliente();
					break;

				case 5:
					System.out.println(HandlerCliente.listarCliente());
					break;
				case 6:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!" + e);
		}

	}

	public static void menuConta() {

		boolean sair = false;
		int op;
		String menuconta = "1 - Criar Conta\n" 
				+ "2 - Excluir Conta\n"
				+ "3 - Consultar Conta\n" 
				+ "4 - Alterar Dados de Conta\n" 
				+ "5 - Listar Contas\n"
				+ "0 - Menu anterior";

		try {
			do {
				System.out.println(menuconta);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					boolean trava = false;
					do {

						System.out.println("1 - Criar Conta Poupan�a\n" 
								+ "2 - Criar Conta Corrente\n" 
								+ "0 - Voltar");
						int op1 = Util.leInt(entrada);
						switch (op1) {
						case 1:
							HandlerConta.criarContaPoupanca();
							break;
						case 2:
							HandlerConta.criarContaCorrente();

							break;
						case 0:
							trava = true;
							break;
						default:
							System.out.println("Op��o Inv�lida!");
							break;
						}
						break;
					} while (trava);

				case 2:
					HandlerConta.removeConta();

					break;

				case 3:
					HandlerConta.consultaConta();

	
					break;

				case 4:
					HandlerConta.alterarConta();
					break;
				case 5:
					System.out.println("Lista de contas atualizada: /n" + HandlerConta.listarContas());
					break;
				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!");
		}

	}

	public static void menuAgencia() {
		boolean sair = false;
		int op;
		String menuAgencia = "1 - Criar Nova Agencia\n" 
				+ "2 - Consultar Agencia\n" 
				+ "3 - Excluir Agencia\n"
				+ "4 - Alterar Dados de Agencia\n" 
				+ "5 - Listar Agencias\n" 
				+ "0 - Menu anterior";

		try {
			do {
				System.out.println(menuAgencia);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					HandlerAgencia.cadastrarAgencia();
					break;

				case 2:
					Agencia agenciaAux = HandlerAgencia.consultarAgencia();

					if (agenciaAux != null)
						System.out.println(agenciaAux.toString());
					else
						System.out.println("Cliente n�o encontrada");

					break;

				case 3:
					HandlerAgencia.removeAgencia();
					System.out.println(listaAgencia.toString());

					break;

				case 4:
					HandlerAgencia.alterarAgencia();
					break;

				case 5:
					System.out.println(HandlerAgencia.listarAgencia());
					break;

				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!");
		}

	}

	public static void menuGerente() {
		boolean sair = false;
		int op;
		String menuGerente = "1 - Criar Novo Gerente\n" 
		+ "2 - Consultar Gerente\n" 
				+ "3 - Excluir Gerente\n"
				+ "4 - Alterar dados do gerente\n" 
				+ "5 - Listar Gerentes\n" 
				+ "6 - Virar m�s"
				+ "0 - Menu anterior\n";

		try {
			do {
				System.out.println(menuGerente);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					HandlerGerencia.cadastraGerente();
					break;

				case 2:
					Gerente gerenteAux = HandlerGerencia.consultarGerente();

					if (gerenteAux != null)
						System.out.println(gerenteAux.toString());
					else
						System.out.println("Gerente n�o encontrado");
					break;

				case 3:
					HandlerGerencia.removeGerente();
					break;

				case 4:
					HandlerGerencia.alterarGerente();
					break;

				case 5:
					System.out.println("Lista de gerente atualizada: \n" + HandlerGerencia.listarGerente());
					break;
				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!");
		}

	}

	public static void menuDados() {
		boolean sair = false;
		int op;

		String menuDados = " 1 - Carregar dados\n" + "2 - Salvar dados\n" + "0 - sair\n";

		try {
			do {
				System.out.println(menuDados);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					listaPessoa = HandlerDAO.popularListPessoa();
					System.out.println(listaPessoa.toString());
					listaGerente = HandlerDAO.popularListGerente();
					System.out.println(listaGerente.toString());
					listaAgencia = HandlerDAO.popularListAgencia();
					System.out.println(listaAgencia.toString());
					listaCliente = HandlerDAO.popularListCliente();
					System.out.println(listaCliente.toString());

					break;

				case 2:

					break;

				case 0:
					sair = true;
					break;
				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO pq ele desceu!");
		}

	}

	public static void menuPessoa() {
		boolean sair = false;
		int op;
		String menuPessoa = "1 - Criar nova pessoa\n" + "2 - alterar Pessoa" + "3 - Consultar Pessoa\n"
				+ "4 - Excluir Pessoa\n" + "5 - Listar Pessoas\n" + "0 - Menu anterior";

		try {
			do {
				System.out.println(menuPessoa);
				op = Util.leInt(entrada);
				switch (op) {
				case 1:
					HandlerPessoa.cadastraPessoa();
					break;
				case 2:
					HandlerPessoa.alteraPessoa();
					break;

				case 3:
					Pessoa pessoaAux = HandlerPessoa.consultarPessoa();
					if (pessoaAux != null)
						System.out.println(pessoaAux.toString());
					else
						System.out.println("Cliente n�o encontrada");
					break;

				case 4:
					HandlerPessoa.removePessoa();
					break;

				case 5:
					System.out.println(HandlerPessoa.listarPessoas());
					break;
				case 0:
					sair = true;
					break;

				default:

					break;
				}

			} while (!sair);
		} catch (Exception e) {
			System.out.println("ERRO!" + e);
		}

	}
}