package LP1;

import java.util.ArrayList;

public class Agencia {
	protected static int contador = 0;
	protected String nome;
	protected ArrayList<Conta> lstContas;
	protected int codAgencia;

	public Agencia(int cod) {
		this.codAgencia = cod;
	}
	
	public Agencia(String nome) {
		this.nome = nome;
		this.codAgencia = ++contador;
		this.lstContas = new ArrayList<Conta> ();
	}
	
	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Agencia.contador = contador;
	}

	public ArrayList<Conta> getLstContas() {
		return lstContas;
	}

	public int getCodAgencia() {
		return codAgencia;
	}

	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean inserirConta(Conta conta) {
		lstContas.add(conta);
		return true;
	}
	
	public boolean removerConta(Conta conta) {
		lstContas.remove(conta);
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
		Agencia other = (Agencia) obj;
		if (codAgencia != other.codAgencia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agencia [nome=" + nome + ", lstContas=" + lstContas + ", codAgencia=" + codAgencia + "]";
	}





	
}
