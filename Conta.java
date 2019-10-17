package LP1;

public abstract class Conta {
	protected double saldo;
	protected int codigoConta;

	public Conta() {
	}

	public Conta(int codigo) {
		this.codigoConta = codigo;
	}

	public Conta(int codigo, double saldo) {
		this.saldo = saldo;
		this.codigoConta = codigo;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getCodigoCliente() {
		return codigoConta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setCodigo(int codigo) {
		this.codigoConta = codigo;
	}

	public boolean sacar(int valor) {
		boolean saque = false;

		if (this.saldo - valor >= 0) {
			this.saldo -= valor;
			saque = true;
		}

		return saque;
	}
	public abstract void viraMes();


	public boolean depositar(int valor) {
			this.saldo += valor;
			return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (codigoConta != other.codigoConta)
			return false;
		return true;
	}

	public String toString() {
		return "Conta [saldo=" + saldo + ", codigo do Cliente=" + codigoConta + "]";
	}

	public boolean transferir(int valor) {
		return false;
		//TEM QUE MEXER
	
	}

}
