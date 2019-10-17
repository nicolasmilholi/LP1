package LP1;

import java.util.Scanner;
import java.util.Iterator;

public class HandlerConta {
	static Scanner entrada = new Scanner(System.in);

	public HandlerConta() {

	}

	public static void criarContaPoupanca() {
		if (!Principal.listaCliente.isEmpty()) {

			System.out.println("Informe o codigo do cliente");
			int codigoCliente = Util.leInt(entrada);
			if (codigoCliente <= Principal.listaCliente.size()) {
				System.out.println("Informe a data da aniversario");
				double saldo = Util.leDouble(entrada);
				System.out.println("Informe o Rendimento para a conta poupança");
				double rendimento = Util.leDouble(entrada);

				System.out.println("codigo da Agencia");
				int codAgencia = Util.leInt(entrada);
				if (codAgencia <= Principal.listaAgencia.size()) {
					Agencia agencia = Principal.listaAgencia.get(codAgencia);
					Conta contaAux = new ContaPoupanca(codigoCliente, saldo, rendimento);
					Cliente.listadeContas.add(contaAux);
					agencia.inserirConta(contaAux);
					System.out.println("Conta Criada\n");

				} else {
					System.out.println("Agencia Inexistente");
				}

			} else {
				System.out.println("Codigo do CLiente inexistente");
			}
		}
	}

	public static void criarContaCorrente() {

		if (!Principal.listaCliente.isEmpty()) {

			System.out.println("Informe o codigo do cliente");
			int codigoCliente = Util.leInt(entrada);

			if (codigoCliente <= Principal.listaCliente.size()) {
				System.out.println("Informe o saldo do cliente");
				double limite = Util.leDouble(entrada);
				System.out.println("Informe a data da aniversario");
				double saldo = Util.leDouble(entrada);

				System.out.println("codigo da Agencia");
				int codAgencia = Util.leInt(entrada);
				if (codAgencia <= Principal.listaAgencia.size()) {
					Agencia agencia = Principal.listaAgencia.get(codAgencia);
					Conta contaAux = new ContaCorrente(codigoCliente, saldo, limite);

					Cliente.listadeContas.add(contaAux);
					
					agencia.inserirConta(contaAux);
					System.out.println("Conta Criada\n");

					System.out.println("Conta Criada\n");

				} else {
					System.out.println("Agencia Inexistente");
				}

			} else {
				System.out.println("Codigo do CLiente inexistente");
			}
		}
	}

	public static boolean removeConta() {
		boolean encontrou = false;
		boolean excluiu = false;
		// inplementar switch case declarando se é conta poupança ou corrente

		// implementar while
		System.out.println("Digite o codigo da agência que deseja alterar: ");
		int codAgencia = Util.leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);
		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			agenciaAux = Principal.listaAgencia.get(index);

		} else {
			System.out.println("Agencia não encontrada");
		}

		if (encontrou) {

			try {

				boolean saida = false;
				do {
					System.out.println("Remover Conta:" + "\n1 - Poupança" + "\n2 - Corrente" + "\n0 - sair");
					int op1 = Util.leInt(entrada);
					switch (op1) {
					case 1:

						System.out.println("Digite o codigo da conta que deseja excluir: ");
						int codConta1 = entrada.nextInt();
						ContaPoupanca contaAux1 = new ContaPoupanca(codConta1);
						int index1 = agenciaAux.getLstContas().indexOf(contaAux1);

						if (index1 >= 0) {
							agenciaAux.getLstContas().remove(index1);
							excluiu = true;

						} else {
							System.out.println("Conta não encontrada.");
						}

						break;
					case 2:

						System.out.println("Digite o codigo da conta que deseja excluir: ");
						int codConta2 = entrada.nextInt();
						ContaCorrente contaAux2 = new ContaCorrente(codConta2);
						int index2 = agenciaAux.getLstContas().indexOf(contaAux2);

						if (index2 >= 0) {
							agenciaAux.getLstContas().remove(index2);
							excluiu = true;

						} else {
							System.out.println("Conta não encontrada.");
						}

						break;
					case 0:
						saida = true;
						break;

					default:
						System.out.println("Opção Inválida");
						break;
					}
				} while (saida);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			System.out.println("Agencia não encontrada!");
			return false;
		}
		return excluiu;

	}

	public static String listarContas() {
		String saida = "";
		boolean encontrou = false;

		System.out.println("Digite o codigo da agência que deseja listar as contas: ");
		int codAgencia = Util.leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);
		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			agenciaAux = Principal.listaAgencia.get(index);
			encontrou = true;

		} else {
			System.out.println("Agencia não encontrada");
		}

		if (encontrou) {

			saida += agenciaAux.getLstContas().toString();

		}
		return saida;
	}

	public static void consultaConta() {
		// inplementar switch case declarando se é conta poupança ou corrente
		boolean encontrou = false;
		// implementar while
		System.out.println("Digite o codigo da agência que deseja consultar a conta: ");
		int codAgencia = Util.leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);
		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			agenciaAux = Principal.listaAgencia.get(index);
			encontrou = true;

		} else {
			System.out.println("Agencia não encontrada");
		}

		if (encontrou) {
			try {

				boolean saida = false;
				do {
					System.out.println("Tipo da conta:" + "\n1 - Poupança" + "\n2 - Corrente" + "\n0 - sair");
					int op1 = Util.leInt(entrada);
					switch (op1) {
					case 1:

						System.out.println("Digite o codigo da conta que deseja consultar: ");
						int codConta1 = entrada.nextInt();
						ContaPoupanca contaAux1 = new ContaPoupanca(codConta1);
						int index1 = agenciaAux.getLstContas().indexOf(contaAux1);

						if (index1 >= 0) {
							contaAux1 = (ContaPoupanca) agenciaAux.getLstContas().get(index1);
							contaAux1.toString();

						} else {
							System.out.println("Conta não encontrada.");
						}

						break;
					case 2:

						System.out.println("Digite o codigo da conta que deseja consultar: ");
						int codConta2 = entrada.nextInt();
						ContaCorrente contaAux2 = new ContaCorrente(codConta2);
						int index2 = agenciaAux.getLstContas().indexOf(contaAux2);

						if (index2 >= 0) {
							contaAux2 = (ContaCorrente) agenciaAux.getLstContas().get(index2);
							contaAux2.toString();

						} else {
							System.out.println("Conta não encontrada.");
						}

						break;
					case 0:
						saida = true;
						break;

					default:
						System.out.println("Opção Inválida");
						break;
					}
				} while (saida);
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			System.out.println("Agencia não encontrada");
		}

	}

	public static void alterarConta() {
		boolean encontrou = false;

		System.out.println("Digite o codigo da agência que deseja alterar: ");
		int codAgencia = Util.leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);
		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			agenciaAux = Principal.listaAgencia.get(index);
			encontrou = true;

		} else {
			System.out.println("Agencia não encontrada");
		}
		if (encontrou) {
			System.out.println("Digite o codigo da conta que deseja alterar:");
			int codContaC = entrada.nextInt();
			ContaCorrente contaAuxC = new ContaCorrente(codContaC);

			int indexC = agenciaAux.getLstContas().indexOf(contaAuxC);
			if (indexC >= 0) {
				contaAuxC = (ContaCorrente) agenciaAux.getLstContas().get(indexC);
				boolean sair = false;
				int op;
				String menuAlteraGerente = "Digite a opção desejada: " + "1 - Alterar limite\n" + "0 - Menu anterior\n";

				try {
					do {

						System.out.println(menuAlteraGerente);
						op = entrada.nextInt();
						switch (op) {
						case 1:
							System.out.println("Digite novo limite: ");
							double limite = entrada.nextDouble();
							contaAuxC.setLimite(limite);

							System.out.println("\nLimite alterado: " + contaAuxC.toString());

							break;
						case 0:
							sair = true;
							break;

						default:
							System.out.println("Insira uma opção valida.");
							break;
						}

					} while (!sair);
				} catch (Exception e) {
					System.out.println("ERRO!");
				}

			} else {
				System.out.println("Conta não encontrada!");

			}

		} else {
			System.out.println("Agencia não encontrada");
		}
	}
}
