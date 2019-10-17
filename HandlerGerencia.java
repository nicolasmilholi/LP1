package LP1;

import java.util.Iterator;
import java.util.Scanner;

public class HandlerGerencia {
	static Scanner entrada = new Scanner(System.in);

	public static void cadastraGerente() {

		if (Principal.listaAgencia.size() > 0) {

			System.out.println("Digite o codigo da Agencia: ");
			int codagencia = Util.leInt(entrada);
			Agencia agenciaAux = new Agencia(codagencia);
			int index = Principal.listaAgencia.indexOf(agenciaAux);
			agenciaAux = Principal.listaAgencia.get(index);

		} else {
			System.out.println("Para cadastrar um Gerente é necessario ter uma Agencia cadastrada.");
			auxiliarAgencia();

		}

		boolean encontrou = false;
		Iterator<Pessoa> iterPessoa = Principal.listaPessoa.iterator();
		Pessoa pessoaAux = null;
		Pessoa pessoaAux2 = null;

		System.out.println("Digite seu CPF: ");
		String cpf = Util.leString(entrada);

		if (Principal.listaPessoa.size() > 0) {
			pessoaAux2 = new Pessoa(cpf);
			while (iterPessoa.hasNext() && !encontrou) {
				pessoaAux = iterPessoa.next(); // sem casting
				encontrou = pessoaAux.getCpf().equals(cpf);
			}

		}
		if (!encontrou) {

			Agencia agencia = HandlerAgencia.consultarAgencia();
			System.out.println("Digite nome:");
			String nome = Util.leString(entrada);

			System.out.println("Digite Endereco:");
			String endereco = Util.leString(entrada);

			System.out.println("Digite o numero de matricula do gerente");
			int matricula = Util.leInt(entrada);

			System.out.println("Digite o salario do gerente");
			double salario = Util.leDouble(entrada);

			Gerente gerente = new Gerente(nome, cpf, endereco, agencia, salario, matricula);

			Principal.listaGerente.add(gerente);

			System.out.println("Gerente criado!\n" + gerente.toString());

		} else {

			System.out.println("Pessoa =" + pessoaAux2.toString());
			System.out.println("\nAgora é Gerente");
		}

	}

	public static boolean removeGerente() {
		Iterator<Gerente> gerente = Principal.listaGerente.iterator();

		System.out.println("Digite a matricula do gerente que deseja excluir: ");
		int matricula = Util.leInt(entrada);
		Gerente gerenteAux = new Gerente(matricula);
		int index = Principal.listaGerente.indexOf(gerenteAux);

		if (index >= 0) {
			Principal.listaPessoa.remove(Principal.listaGerente.remove(index));

			System.out.println("Gerente removido " + gerente.toString());
			return true;

		} else {
			System.out.println("Gerente não encontrado.");
			return false;

		}

	}

	public static Gerente consultarGerente() {

		System.out.println("Digite a matricula do gerente que deseja consultar: ");
		int matricula = Util.leInt(entrada);
		Gerente gerenteAux = new Gerente(matricula);

		int index = Principal.listaGerente.indexOf(gerenteAux);

		if (index >= 0) {
			return Principal.listaGerente.get(index);

		} else {
			return null;
		}
	}

	public static String listarGerente() {

		String saida = "";

		if (Principal.listaGerente.size() > 0) {
			Iterator<Gerente> iterador = Principal.listaGerente.iterator(); // para o iterador retornar para o início da
			// lista
			while (iterador.hasNext()) {
				Gerente gerente = (Gerente) iterador.next(); // necessidade de casting
				saida += gerente.toString();
			}
		} else {
			saida += "Sem gerentes registrados";
		}

		return saida;

	}

	public static void alterarGerente() {

		System.out.println("Digite a matricula do gerente que deseja alterar: ");

		int matricula = Util.leInt(entrada);
		Gerente gerenteAux = new Gerente(matricula);

		int index = Principal.listaGerente.indexOf(gerenteAux);

		if (index >= 0) {
			gerenteAux = Principal.listaGerente.get(index);
			boolean sair = false;
			int op;
			String menuAlteraGerente = "Digite a opção desejada: " + "1 - Alterar dados pessoais \n"
					+ "2 - Alterar matricula\n" + "3 - Alterar salario\n" + "0 - Retornar ao menu anterior\n";

			try {
				do {
					System.out.println(menuAlteraGerente);
					op = Util.leInt(entrada);
					switch (op) {
					case 1:
						System.out.println("Digite o novo endereço: ");
						String endereco = Util.leString(entrada);
						System.out.println("Digite o novo nome: ");
						String nome = Util.leString(entrada);
						gerenteAux.setEndereco(endereco);
						gerenteAux.setNome(nome);
						System.out.println("Dados alterados \n" + gerenteAux.toString());
						break;

					case 2:
						System.out.println("Digite o novo numero de matricula: ");
						matricula = Util.leInt(entrada);
						gerenteAux.setMatricula(matricula);
						System.out.println("Matricula alterada \n" + gerenteAux.toString());
						break;

					case 3:
						System.out.println("Digite o novo salario: ");
						double salario = Util.leDouble(entrada);
						gerenteAux.setSalario(salario);
						System.out.println("Salario alterado \n" + gerenteAux.toString());
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

	public static void auxiliarAgencia() {
		String menuConta = "Digite a opção desejada:\n" + "\n1 - Cadastrar Agencia" + "\n0 - Retornar ao menu anterior";

		int op1;

		do {
			System.out.println(menuConta);
			op1 = Util.leInt(entrada);
			try {
				switch (op1) {
				// 1 - Realizar Saque
				case 1:
					HandlerAgencia.cadastrarAgencia();

					break;

				case 0:

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
