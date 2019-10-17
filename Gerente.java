package LP1;

public class Gerente extends Pessoa{
	protected Agencia agencia;
	protected int matricula;
	protected double salario;

	public Gerente(){
		super();
	}	
	
	public Gerente(int matricula){
		this.matricula = matricula;
		
	}
	public Gerente(String nome, String cpf, String endereco) {
		super(nome, cpf, endereco);
	}

	public Gerente(String nome, String cpf, String endereco, int matricula) {
		super(nome, cpf, endereco);
		this.matricula = matricula;
	}

	public Gerente(String nome, String cpf, String endereco, Agencia agencia, double salario, int matricula) {
		super(nome, cpf, endereco);
		this.agencia = agencia;
		this.salario = salario;
		this.matricula = matricula;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public boolean equals(Object obj) {
		Gerente other = (Gerente) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " Gerente [agencia=" + agencia + ", matricula=" + matricula + ", salario=" + salario + "]";
	}
	

}
