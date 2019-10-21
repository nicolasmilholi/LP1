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
	
}
