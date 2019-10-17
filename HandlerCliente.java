package LP1;

import java.util.Iterator;
import java.util.Scanner;

public class HandlerCliente {
	static Scanner entrada = new Scanner(System.in);

	public static void cadastrarCliente() {
		boolean encontrou = false;

		System.out.println("Digite o cpf do Cliente que deseja excluir: ");
		String cpf = Util.leString(entrada);
		Cliente clienteAux = new Cliente(cpf);
		Iterator<Cliente> iterador = Principal.listaCliente.iterator();
		iterador = Principal.listaCliente.iterator(); // para o iterador retornar para o início da lista
		boolean encontrado = false;
		while (iterador.hasNext() && !encontrado) {
			clienteAux = iterador.next(); // sem casting
			encontrado = clienteAux.getCpf().equals(cpf);
		}
		if (!encontrou) {

			if (Principal.listaAgencia.size() > 0) {
				System.out.println("Digite o numero da agência do cliente: ");
				int numAgencia = Util.leInt(entrada);
				Agencia agenciaAux = new Agencia(numAgencia);
				int index = Principal.listaAgencia.indexOf(agenciaAux);

				System.out.println("Digite seu Nome: ");
				String nome = Util.leString(entrada);
				System.out.println("Digite seu Endereço: ");
				String endereco = Util.leString(entrada);
				Cliente cliente = new Cliente(nome, cpf, endereco);

				Principal.listaCliente.add(cliente);
				System.out.println("Cliente criado!\n" + cliente.toString());

			} else {
				System.out
						.println("Para cadastrar um cliente, é necessario de uma Agencia para que ele seja inserido.");
				auxiliarCliente();
				if (Principal.listaGerente.size() == 0) {
					System.out.println(
							"Para cadastrar um cliente, é necessario que exista um Gerente na agencia para que ele seja inserido.");
					auxiliarCliente();
				}

			}
		}
	}

	public static boolean removeCliente() {
		boolean removido = false;

		System.out.println("Digite o cpf do Cliente que deseja excluir: ");
		String cpf = Util.leString(entrada);
		Cliente clienteAux = new Cliente(cpf);
		Iterator<Cliente> iterador = Principal.listaCliente.iterator();
		iterador = Principal.listaCliente.iterator(); // para o iterador retornar para o início da lista
		boolean encontrado = false;
		while (iterador.hasNext() && !encontrado) {
			clienteAux = iterador.next(); // sem casting
			encontrado = clienteAux.getCpf().equals(cpf);
		}

		if (encontrado) {

			if (clienteAux.getListadeContas().isEmpty()) {
				Principal.listaCliente.remove(clienteAux);
				System.out.println("Cliente removido " + clienteAux.toString());
				removido = true;
			} else {
				System.out.println("Cliente precisa nao ter contas cadastradas");
				removido = false;
			}
		} else {
			System.out.println("Cliente não encontrado.");
			removido = false;
		}
		return removido;

	}

	public static String listarCliente() {
		String saida = "";

		if (Principal.listaCliente.size() > 0) {
			Iterator<Cliente> iterador = Principal.listaCliente.iterator(); // para o iterador retornar para o início da
			// lista
			while (iterador.hasNext()) {
				Cliente cliente = (Cliente) iterador.next(); // necessidade de casting
				saida += cliente.toString();
			}
		} else {
			saida += "Sem clientes registrados";
		}

		return saida;

	}

	public static Cliente consultarCliente() {

		System.out.println("Digite o cpf do Cliente que deseja excluir: ");
		String cpf = Util.leString(entrada);
		Cliente clienteAux = new Cliente(cpf);
		Iterator<Cliente> iterador = Principal.listaCliente.iterator();
		iterador = Principal.listaCliente.iterator(); // para o iterador retornar para o início da lista
		boolean encontrado = false;
		while (iterador.hasNext() && !encontrado) {
			clienteAux = iterador.next(); // sem casting
			encontrado = clienteAux.getCpf().equals(cpf);
		}

		if (encontrado) {
			return clienteAux;

		} else {

			return null;
		}

	}

	public static void alterarCliente() {
		System.out.println("Digite o cpf do Cliente que deseja excluir: ");
		String cpf = Util.leString(entrada);
		Cliente clienteAux = new Cliente(cpf);
		Iterator<Cliente> iterador = Principal.listaCliente.iterator();
		iterador = Principal.listaCliente.iterator(); // para o iterador retornar para o início da lista
		boolean encontrado = false;
		while (iterador.hasNext() && !encontrado) {
			clienteAux = iterador.next(); // sem casting
			encontrado = clienteAux.getCpf().equals(cpf);
		}
		if (encontrado) {
			boolean sair = false;
			int op;
			String menuAlteraCliente = "Digite a opção desejada: " + "1 - Alterar dados pessoais \n"
					+ "0 - Retornar ao menu anterior\n";

			try {
				do {
					System.out.println(menuAlteraCliente);
					op = entrada.nextInt();
					switch (op) {
					case 1:
						System.out.println("Digite o novo endereço: ");
						String endereco = Util.leString(entrada);
						System.out.println("Digite o novo nome: ");
						String nome = Util.leString(entrada);
						clienteAux.setEndereco(endereco);
						clienteAux.setNome(nome);
						System.out.println("Dados alterados \n" + clienteAux.toString());
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
			System.out.println("Gerente não encontrado!");

		}
	}

	public static void auxiliarCliente() {

		String menuConta = "Digite a opção desejada:\n" + "\n1 - Cadastrar Agencia" + "\n2 - Cadastrar Gerente"
				+ "\n0 - Retornar ao menu anterior";

		int op1;

		do {
			System.out.println(menuConta);
			op1 = Util.leInt(entrada);
			try {
				switch (op1) {
				// 1 - Realizar Saque
				case 1:
					HandlerAgencia.cadastrarAgencia();
					System.out.println(Principal.listaAgencia.toString());

					break;

				case 2:
					HandlerGerencia.cadastraGerente();

					break;

				case 0:
					System.out.println("Retorno ao menu anterior.\n");
					break;

				default:
					System.out.println("Opção invalida!");
					break;
				}

			} catch (Exception e) {
				System.out.println("Ocorreu um erro no processamento: " + e);
			}

		} while (op1 != 0);

	}

}
