package LP1;

import java.util.ArrayList;

public class Cliente extends Pessoa {
	private static int contador = 0;
	private int codCliente;
	static ArrayList<Conta> listadeContas;

	int index = 0;

	public Cliente() {
		this.codCliente = ++contador;

	}
	

	public ArrayList<Conta> getListadeContas() {
		return listadeContas;
	}


	public Cliente(String cpf) {
		super(cpf);
	}

	public Cliente(String nome, String cpf, String endereco) {
		super(nome, cpf, endereco);
		this.codCliente = ++contador;
	}

	@Override
	public String toString() {
		return "Cliente [codCliente=" + this.codCliente + ", cliente=" + super.nome + ", contas=" + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codCliente != other.codCliente)
			return false;
		return true;
	}

}
