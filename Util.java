// Autor @Nicolas Milholi
package LP1;

import java.util.Scanner;

public class Util {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// LEITURA
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// DE
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// DADOS
	public static int leInt(Scanner entrada) {
		int LeInt = Integer.valueOf(entrada.nextLine());
		return LeInt;
	}

	public static String leString(Scanner entrada) {
		String leString = entrada.nextLine();
		return leString;
	}

	public static Agencia procuraAgencia() {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o codigo da agência");
		int codAgencia = leInt(entrada);
		Agencia agenciaAux = new Agencia(codAgencia);
		int index = Principal.listaAgencia.indexOf(agenciaAux);

		if (index >= 0) {
			agenciaAux = Principal.listaAgencia.get(index);

		} else {
			System.out.println("Agencia não encontrada");
			agenciaAux = null;
		}
		return agenciaAux;

	}

	public static double leDouble(Scanner entrada) {
		Double LeDouble = Double.valueOf(entrada.nextLine());
		return LeDouble;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// VETOR
	// preenche o vetor automaticamente
	public static void populaVet(int vet[], int min, int max) {

		for (int i = 0; i < vet.length; i++) {
			vet[i] = Util.geraIntAleatorio(min, max);
		}

		// o usuário preenche o vetor
	}

	public static void populaVetNulo(String[] vet) {
		// Popula o vetor com aleatórios de min a max
		for (int i = 0; i < vet.length; i++) {
			vet[i] = "*";
		}
	}

	public static void populaVetUsuario(int vet[], Scanner entrada) {

		for (int i = 0; i < vet.length; i++) {
			System.out.println("Digite o " + (i + 1) + "º valor");
			vet[i] = Util.leInt(entrada);
		}

	}

	// exibe o vetor no console
	public static void imprimeVet(int vet[]) {
		String saida = "";
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] < 10) {
				saida += "|0" + vet[i];
			} else {
				saida += "|" + vet[i];
			}
		}
		saida += "|";
		System.out.println(saida);
	}

	// exibe o vetor de String
	public static void imprimeVetString(String vet[]) {
		String saida = "";
		for (int i = 0; i < vet.length; i++) {
			saida += "|" + vet[i];
		}
		saida += "|";
		System.out.println(saida);
	}

	// transforma o vetor em ordem crescente
	public static int[] OrdenaVet(int vet[]) {

		for (int i = 0; i < vet.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < vet.length; j++) {
				if (vet[j] < vet[index])
					index = j;
			}

			int menorValor = vet[index];
			vet[index] = vet[i];
			vet[i] = menorValor;
		}
		return vet;
	}

	// proucura o maior valor no vetor
	public static int maiorValorVet(int vet[]) {
		int maior = vet[0];
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] >= maior) {
				maior = vet[i];
			}
		}
		return maior;

	}

	public static int[] getNumerosRepetidos(int[] vetor) {
		int qtd = 0;
		boolean isRepetido = false, isOnArray = false;
		int[] repetidos = new int[vetor.length];

		for (int i = 0; i < vetor.length; i++) {
			isRepetido = Util.procuraIntRepetido(vetor, vetor[i]);
			isOnArray = Util.intOnVet(repetidos, vetor[i]);

			if (isRepetido && !isOnArray) {
				repetidos[qtd] = vetor[i];
				qtd++;
			}
		}
		return repetidos;

	}

	public static boolean intOnVet(int[] vetor, int numero) {
		int cont = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == numero) {
				cont++;
			}
		}
		if (cont == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean procuraIntRepetido(int[] vetor, int numero) {
		int cont = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == numero) {
				cont++;
			}
		}

		if (cont > 1) {
			return true;
		} else {
			return false;
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////// MATRIZ
	public static void populaMatriz(int[][] matriz, int min, int max) {

		// Popula o vetor com aleatórios de min a max
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = Util.geraIntAleatorio(min, max);
			}

		}
	}

	public static void populaMatrizNulo(String[][] matriz) {
		// Popula o vetor com aleatórios de min a max
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = "*";
			}
		}
	}

	public static void imprimeMatriz(int[][] matriz) {
		String result = "";

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {

				if (matriz[i][j] < 10) {
					result += "|0" + matriz[i][j];
				} else {
					result += "|" + matriz[i][j];
				}
			}
			result += "|\n";

		}

		System.out.println(result);
	}

	public static void imprimeMatriz(String[][] matriz) {
		String result = "";

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				result += matriz[i][j] + "|";

			}
			result += "\n";

		}
		System.out.println(result);

	}

	public static int procuraMaiorValorMatriz(int matriz[][]) {
		int maior = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] > maior) {
					maior = matriz[i][j];
				}
			}
		}
		return maior;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ENTRADAS
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ALEATORIAS
	public static int geraIntAleatorio(int min, int max) {
		int numAleatorio = min + (int) (Math.random() * ((max - min) + 1));

		return numAleatorio;

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// CALCULO
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////// VARIADOS
	// calcula a média
	public static double calculaMedia(int A, int B, int C) {
		double media = (double) (A + B + C) / 3;

		return media;

	}

	// calcula o tempo a partir da entrada dos segundos
	public static String calculaHoraMinutosSegundos(int tempo) {
		int minutos = (tempo / 60);
		int horas = minutos / 60;
		int segundos = tempo % 60;
		minutos -= 60;
		String resul = horas + "'" + minutos + "''" + segundos + "'''";
		return resul;
	}

	public static boolean valorLogicoPrimo(int numeroVerificado) {
		boolean primo = true;

		if (numeroVerificado == 0 || numeroVerificado == 1)
			primo = false;

		else {
			for (int i = 2; primo && i < numeroVerificado; i++) {
				if ((numeroVerificado % i) == 0) {
					primo = false;

				}
			}
		}

		return primo;
	}

	/// teste se um numero é perfeito (1+2+3 = 6)
	public static boolean testeNumPerfeito(int numPerfeito) {
		int soma = 0;

		for (int i = 1; i < numPerfeito - 1; i++) {
			if (numPerfeito % i == 0) {
				soma += i;
			}
		}
		if (soma == numPerfeito) {
			return true;
		} else
			return false;
	}

}
