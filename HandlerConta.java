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

				} else {
					System.out.println("Agencia Inexistente");
				}

			} else {
				System.out.println("Codigo do cliente inexistente");
			}
		}
	}

	public static boolean removeConta() {
		boolean encontrou = false;
		boolean excluiu = false;

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

	
	

	public static Conta consultaConta() {
		
		Agencia agenciaAux = Util.validaAgencia(entrada);
		
		if(agenciaAux != null) {
			try {

				boolean saida = false;
				do {
					System.out.println("Consultar Conta:" + "\n1 - Poupança" + "\n2 - Corrente" + "\n0 - sair");
					int op1 = Util.leInt(entrada);
					switch (op1) {
					case 1:
						Conta contaAux1 = Util.consultaContaP(agenciaAux);

						if(contaAux1 != null) {
						contaAux1.toString();
						return contaAux1;

					}else {
						System.out.println("conta não encontrada");}
						break;
					case 2:
						Conta contaAux2 = Util.consultaContaC(agenciaAux);
						
						if(contaAux2 != null) {
						contaAux2.toString();
						return contaAux2;

					}else {
						System.out.println("Conta não encontrada");}
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
		}
		return null;
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
				String menuAlteraConta = "Digite a opção desejada: " + "1 - Alterar limite\n" + "0 - Menu anterior\n";

				try {
					do {

						System.out.println(menuAlteraConta);
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


	public static void entrarConta() {
Agencia agenciaAux = Util.validaAgencia(entrada);
		
		if(agenciaAux != null) {
			try {

				boolean saida = false;
				do {
					System.out.println("Consultar Conta:" + "\n1 - Poupança" + "\n2 - Corrente" + "\n0 - sair");
					int op1 = Util.leInt(entrada);
					switch (op1) {
					case 1:
						Conta contaAux1 = Util.consultaContaP(agenciaAux);

						if(contaAux1 != null) {
						
						
					}else {
						System.out.println("conta não encontrada");}
						break;
					case 2:
						Conta contaAux2 = Util.consultaContaC(agenciaAux);
						
						if(contaAux2 != null)
						contaAux2.toString();
						
						else
						System.out.println("Conta não encontrada");
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
		}	

	
	
	}

}
