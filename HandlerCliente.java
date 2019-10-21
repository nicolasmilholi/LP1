package LP1;

import java.util.Iterator;
import java.util.Scanner;

public class HandlerCliente {
	static Scanner entrada = new Scanner(System.in);

	public static boolean cadastrarCliente() {
		boolean inserido = false;
		if (!Principal.listaAgencia.isEmpty()) {
			
			System.out.println("Digite o cpf do Cliente que deseja cadastrar: ");
			String cpf = Util.leString(entrada);
			Cliente clienteAux = new Cliente(cpf);

			// verifica se o cliente não existe
			if (!Util.pesquisaCliente(clienteAux, cpf)) {

				System.out.println("Digite seu Nome: ");
				String nome = Util.leString(entrada);
				System.out.println("Digite seu Endereço: ");
				String endereco = Util.leString(entrada);
				Cliente cliente = new Cliente(nome, cpf, endereco);

				Principal.listaCliente.add(cliente);
				inserido = true;
			}

		}
		return inserido; 
	}

	public static boolean removeCliente() {
		boolean removido = false;

		System.out.println("Digite o cpf do Cliente que deseja excluir: ");
		String cpf = Util.leString(entrada);
		Cliente clienteAux = new Cliente(cpf);

		if (!Util.pesquisaCliente(clienteAux, cpf)) {

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

	public static String listarClientes() {
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

		System.out.println("Digite o cpf do Cliente que deseja consultar: ");
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

		System.out.println("Digite o CPF do cliente que deseja alterar os dados: ");
		String cpf = Util.leString(entrada);
		Cliente clienteAux = new Cliente(cpf);

		if (!Util.pesquisaCliente(clienteAux, cpf)) {
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
			System.out.println("Cliente não encontrado!");

		}
	}

}
