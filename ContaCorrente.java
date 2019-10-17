package LP1;

public class ContaCorrente extends Conta {
	private double limite;
	private double juros = 0.03;
	private double tarifa = 20;

	
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

}
