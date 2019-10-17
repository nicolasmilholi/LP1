package LP1;

public class Pessoa {
	protected String nome;
	protected String cpf;
	protected String endereco;

	public Pessoa() {
	}

	public Pessoa(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa(String nome, String cpf, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (this.cpf != other.cpf)
			return false;
		return true;
	}

	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + "]";
	}

}
