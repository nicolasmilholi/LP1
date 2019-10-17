package LP1;

import java.util.Scanner;


public class ContaCorrente extends Conta {
	private double limite;
	private double juros = 0.03;
	private double tarifa = 20;

	static Scanner entrada = new Scanner(System.in);
	
	public ContaCorrente(int codigoCliente) {
		super(codigoCliente);
	}

	
	public ContaCorrente(int codigoCliente, double saldo, double limite) {
		super(codigoCliente, saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getJuros() {
		return juros;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void viraMes() {
		this.saldo -= this.saldo * juros;
		this.saldo -= tarifa;
	}

	public boolean sacar(double valor) {
		boolean saque = false;

		if (this.saldo - valor <= 0) {
			this.saldo -= valor;
			saque = true;
		}

		return saque;
	}

	public boolean depositar(int valor) {
		boolean deposito = false;

		if (this.saldo + valor <= this.limite) {
			this.saldo += valor;
			deposito = true;
		}
		return deposito;
	}

	@Override
	public String toString() {
		return "ContaCorrente [limite=" + limite + "]";
	}
	
	
	public static void operacoesConta(Conta conta) {
		
		

		Agencia agenciaAux = Util.validaAgencia(entrada);
		
			if(agenciaAux != null) {
				try {

					boolean saida = false;
					do {
						System.out.println("Digite a operação que deseja fazer:" + "\n1 - Sacar" + "\n2 - Depositar" + "\n3 - Transferir" + "\n0 - sair");
						int op1 = Util.leInt(entrada);
						switch (op1) {
						case 1:
							conta.sacar(valor);
							break;
						case 2:
							conta.depositar(valor);
						
							break;
							
							
							
						case 3:
							conta.transferir(valor, conta1);

							
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
