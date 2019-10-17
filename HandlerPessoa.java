package LP1;

import java.util.Iterator;
import java.util.Scanner;

public class HandlerPessoa {
	static Scanner entrada = new Scanner(System.in);

	public static Pessoa cadastraPessoa() {

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
			System.out.println("Digite o nome: ");
			String nome = Util.leString(entrada);

			System.out.println("Digite o endereço: ");
			String endereco = Util.leString(entrada);

			Pessoa pessoa = new Pessoa(nome, cpf, endereco);

			Principal.listaPessoa.add(pessoa);

			System.out.println("Pessoa criada!\n" + pessoa.toString());
			return pessoa;
		} else {
			System.out.println("Pessoa já existente " + pessoaAux2.toString());
		}
		return null;

		
	}

	public static Pessoa consultarPessoa() {

		System.out.println("Digite o CPF da Pessoa que deseja consultar: ");
		String cpf = Util.leString(entrada);
		Pessoa pessoaAux = new Pessoa(cpf);

		int index = Principal.listaPessoa.indexOf(pessoaAux);

		if (index >= 0) {
			return Principal.listaPessoa.get(index);

		} else {

			return null;
		}

	}

	public static boolean removePessoa() {
		System.out.println("Digite o cpf da Pessoa que deseja excluir: ");
		String cpfPessoa = Util.leString(entrada);

		Pessoa PessoaAux = new Pessoa(cpfPessoa);
		int index = Principal.listaPessoa.indexOf(PessoaAux);

		if (index >= 0) {
			Principal.listaPessoa.remove(index);
			return true;
		}
		return false;
	}

	public static String listarPessoas() {
		String saida = "";

		if (Principal.listaPessoa.size() > 0) {
			Iterator<Pessoa> iterador = Principal.listaPessoa.iterator(); // para o iterador retornar para o início da
			// lista
			while (iterador.hasNext()) {
				Pessoa pessoa = (Pessoa) iterador.next(); // necessidade de casting
				saida += pessoa.toString();
			}
		} else {
			saida += "Sem gerentes registrados";
		}

		return saida;

	}

	public static void alteraPessoa() {
		
		
		System.out.println("Digite o cpf da pessoa que deseja alterar: ");
		String cpf = Util.leString(entrada);
		Pessoa pessoaaux = new Pessoa(cpf);

		int index = Principal.listaPessoa.indexOf(pessoaaux);

		if (index >= 0) {
			pessoaaux = Principal.listaPessoa.get(index);
			boolean sair = false;
			int op;
			String menuAlteraGerente = "Digite a opção desejada: " 
					+ "1 - Alterar dados \n"
					+ "0 - Retornar ao menu anterior\n";

			try {
				do {
					System.out.println(menuAlteraGerente);
					op = Util.leInt(entrada);
					switch (op) {
					case 1:
						System.out.println("Digite o novo nome: ");
						String nome = Util.leString(entrada);
						System.out.println("Digite o novo endereço: ");
						String endereco = Util.leString(entrada);
						
						pessoaaux.setEndereco(endereco);
						pessoaaux.setNome(nome);
						
						System.out.println("Dados alterados \n" + pessoaaux.toString());
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
			System.out.println("Pessoa não encontrada!");

		}
	}

}
