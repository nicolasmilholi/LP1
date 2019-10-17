package LP1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class HandlerAgencia {
	static Scanner entrada = new Scanner(System.in);

	public static void cadastrarAgencia() {

		String nome = "";

		System.out.println("Digite o nome da agência: ");
		nome = Util.leString(entrada);

		Agencia agencia = new Agencia(nome);
		Principal.listaAgencia.add(agencia);

		System.out.println("Agencia Criada");
	}

	public static String listarAgencia() {
		String saida = "";

		if (Principal.listaAgencia.size() > 0) {
			Iterator<Agencia> iterador = Principal.listaAgencia.iterator(); // para o iterador retornar para o início da
																			// lista
			while (iterador.hasNext()) {
				Agencia agencia = (Agencia) iterador.next(); // necessidade de casting
				saida += agencia.toString();
			}
		} else {
			saida += "Sem agencias registradas";
		}

		return saida;

	}

	public static Agencia consultarAgencia() {

		System.out.println("\nDigite o codigo da agência: ");
		int codAgencia = Util.leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);

		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			return Principal.listaAgencia.get(index);

		} else {

			return null;
		}
	}

	public static boolean removeAgencia() {

		System.out.println("Digite o codigo da agência que deseja excluir: ");
		int codAgencia = Util.leInt(entrada);

		Agencia agenciaAux = new Agencia(codAgencia);
		int index = Principal.listaAgencia.indexOf(agenciaAux);

		boolean trava = false;

		if (index >= 0) {
			if (agenciaAux.getLstContas().isEmpty())
				trava = true;

			if (trava) {
				Principal.listaAgencia.remove(index);
				return true;
			} else {
				System.out.println("Ainda existe contas ligadas a agência.");
				return false;
			}
		}
		System.out.println("Agencia não encontrada");
		return false;

	}

	public static void alterarAgencia() {
		System.out.println("Digite o codigo da agência que deseja alterar: ");
		int codAgencia = Util.leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);

		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			agenciaAux = Principal.listaAgencia.get(index);
			boolean sair = false;
			int op;
			String menuAlteraAgencia = "Digite a opção desejada: " + "1 - Alterar nome da agência  \n"
					+ "0 - Menu anterior\n";

			try {
				do {
					System.out.println(menuAlteraAgencia);
					op = Util.leInt(entrada);
					switch (op) {
					case 1:
						System.out.println("Digite novo nome da agência: ");
						String nome = entrada.nextLine();
						agenciaAux.setNome(nome);

						System.out.println("\nNome alterado: " + agenciaAux.toString());

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
			System.out.println("Agencia não encontrado!");

		}
	}
}
