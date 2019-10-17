package LP1;

import java.util.Scanner;

public class ContaPoupanca extends Conta {
	static Scanner entrada = new Scanner(System.in);
	
	
	private double rendimento = 0.5;

	public ContaPoupanca(int codConta) {
		super(codConta);
	}

	public ContaPoupanca(int codigoCliente, double saldo, double rendimento) {
		super(codigoCliente, saldo);
		this.rendimento = rendimento;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	public String toString() {
		return "ContaPoupanca [rendimento=" + rendimento + "]";
	}

	public void viraMes() {
		this.saldo += this.saldo * rendimento;
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
							
							System.out.println("Informe o valor a sacar");
							double valor = Util.leDouble(entrada);
							conta.sacar(valor);
							break;
						case 2:
							
							System.out.println("Informe o valor a depositar");
							valor = Util.leDouble(entrada);
							
							conta.depositar(valor);
						
							break;
							
						case 3:
							
							System.out.println("Informe o valor a transferir");
							valor = Util.leDouble(entrada);
							System.out.println("Consultar Conta a Transferir");
							Conta conta1 = HandlerConta.consultaConta();
							this.transferir(valor, conta1);

							
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
