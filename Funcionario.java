package LP1;

public abstract class  Funcionario extends Pessoa{
	protected String cargo;
	protected double salario;
	
	
	public Funcionario() {
		super();
	}
	public Funcionario(String cpf) {
		super(cpf);
	}
	public Funcionario(String nome, String cpf, String endereco) {
		super(nome, cpf, endereco);
	}
	public Funcionario(String nome, String cpf, String endereco, double salario, String cargo) {
		super(nome, cpf, endereco);
		this.cargo = cargo;
		this.salario = salario;
		
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + ", salario=" + salario + "]";
	}
	
	
	
	
	
	
}
