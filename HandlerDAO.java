package LP1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Iterator;

import com.mysql.jdbc.PreparedStatement;

public class HandlerDAO {

	public HandlerDAO() {

	}

	public static ArrayList<Pessoa> popularListPessoa() throws SQLException {
		ResultSet rs = null;

		Connection cnn = ConnectionFactory.getConnection();

		try {

			PreparedStatement sql = (PreparedStatement) cnn.prepareStatement("select * from pessoa");

			rs = sql.executeQuery();

			while (rs.next()) {

				Pessoa pessoa = new Pessoa();
				pessoa.setCodPessoa(rs.getInt("codPessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEndereco(rs.getString("endereco"));
				pessoa.setCpf(rs.getString("cpf"));
				Principal.listaPessoa.add(pessoa);

			}
			cnn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return Principal.listaPessoa;
	}

	public static ArrayList<Gerente> popularListGerente()
			throws SQLException {

		ResultSet rs = null;
		Connection cnn = ConnectionFactory.getConnection();
		
		
		try {

			PreparedStatement sql = (PreparedStatement) cnn.prepareStatement("select * from gerente");
			rs = sql.executeQuery();
			
			while (rs.next()) {

				Gerente gerente = new Gerente();
				Pessoa pessoaFake1 = new Pessoa(rs.getInt("codGerente"));
				int index = Principal.listaPessoa.indexOf(pessoaFake1);
				gerente.setGerente(Principal.listaPessoa.get(index));
				gerente.setCodGerente(rs.getInt("codGerente"));
				gerente.setSalario(rs.getDouble("salario"));
				gerente.setMatricula(rs.getString("matricula"));

				Principal.listaGerente.add(gerente);

			}
			cnn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Principal.listaGerente;
	}

	public static ArrayList<Agencia> popularListAgencia() throws SQLException {
		ResultSet rs = null;

		Connection cnn1 = ConnectionFactory.getConnection();

		PreparedStatement sql = (PreparedStatement) cnn1.prepareStatement("select * from agencia");

		rs = sql.executeQuery();

		try {
			while (rs.next()) {

				Agencia agencia = new Agencia();

				Gerente gerenteFake = new Gerente(rs.getInt("codGerente"));
				int index = Principal.listaGerente.indexOf(gerenteFake);

				agencia.setGerente(Principal.listaGerente.get(index));
				agencia.setNome(rs.getString("nomeAgencia"));
				agencia.setCodigo(rs.getInt("codAgencia"));

				Principal.listaAgencia.add(agencia);

			}
			cnn1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Principal.listaAgencia;
	}

	public static ArrayList<Conta> popularListConta()
			throws SQLException {
		ResultSet rs = null;

		Connection cnn = ConnectionFactory.getConnection();
		try {

			PreparedStatement sql = (PreparedStatement) cnn.prepareStatement("select * from conta");

			rs = sql.executeQuery();

			while (rs.next()) {

				Conta conta = new Conta();

				Agencia agenciaFake = new Agencia(rs.getInt("codAgencia"));

				int index = Principal.listaAgencia.indexOf(agenciaFake);

				conta.setAgencia(Principal.listaAgencia.get(index));
				conta.setLimite(rs.getDouble("limiteConta"));
				conta.setCodigo(rs.getInt("codConta"));
				conta.setSaldo(rs.getDouble("saldoConta"));

				Principal.listaConta.add(conta);
				System.out.println("entrou na conta");
			}
			cnn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return Principal.listaConta;
	}

	public static ArrayList<Cliente> popularListCliente() throws SQLException {
		ResultSet rs = null;

		Connection cnn = ConnectionFactory.getConnection();
		try {

			PreparedStatement sql = (PreparedStatement) cnn.prepareStatement("select * from cliente");

			rs = sql.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();
				Pessoa pessoaFake = new Pessoa(rs.getInt("codCliente"));
				int index = Principal.listaPessoa.indexOf(pessoaFake);

				cliente.setCliente(Principal.listaPessoa.get(index));

				Conta contaFake = new Conta(rs.getInt("codConta"));
				int index2 = Principal.listaConta.indexOf(contaFake);

				cliente.setConta(Principal.listaConta.get(index2));

				Principal.listaCliente.add(cliente);

			}
			cnn.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return Principal.listaCliente;
	}
	
	public static void dadosGerente() {
		String sql = "insert into gerente (codGerente, matricula, salario) values (?,?,?)";
		
		try {
			Connection cnn = ConnectionFactory.getConnection();

			PreparedStatement query = (PreparedStatement) cnn.prepareStatement(sql);
			Iterator<Gerente> iterGerente = Principal.listaGerente.iterator();
			Gerente gerenteAux;

			while (iterGerente.hasNext()) {
				gerenteAux = iterGerente.next();
				query.setInt(1, gerenteAux.getCodGerente());
				query.setString(2, gerenteAux.getMatricula());
				query.setDouble(3, gerenteAux.getSalario());
	

				query.execute();
				query.close();
					
				}
			
			cnn.close();
			
			
		}catch(SQLException ex){
			System.out.println("Erro ao conectar ao banco: " + ex);
		}

	}
	public static void dadosPessoas() {
		String sql = "insert into pessoa (codPessoa, nome, cpf, endereco) values (?,?,?,?)";
		
		try {
			Connection cnn = ConnectionFactory.getConnection();

			PreparedStatement query = (PreparedStatement) cnn.prepareStatement(sql);
			Iterator<Pessoa> iterPessoa = Principal.listaPessoa.iterator();
			Pessoa pessoaAux;

			while (iterPessoa.hasNext()) {
				pessoaAux = iterPessoa.next();
				query.setInt(1, pessoaAux.getCodPessoa());
				query.setString(2, pessoaAux.getNome());
				query.setString(3, pessoaAux.getCpf());
				query.setString(4, pessoaAux.getEndereco());
				

				query.execute();
				query.close();
					
				}
			
			cnn.close();
			
			
		}catch(SQLException ex){
			System.out.println("Erro ao conectar ao banco: " + ex);
		}

	}public static void dadosCliente() {
		String sql = "insert into cliente (codCliente, codConta, senha) values (?,?,?,?)";
		
		try {
			Connection cnn = ConnectionFactory.getConnection();

			PreparedStatement query = (PreparedStatement) cnn.prepareStatement(sql);
			Iterator<Cliente> iterCliente = Principal.listaCliente.iterator();
			Cliente clienteAux;

			while (iterCliente.hasNext()) {
				clienteAux = iterCliente.next();
				query.setInt(1, clienteAux.getCliente().getCodPessoa());
				query.setInt(2, clienteAux.getConta().getCodigo());
				query.setInt(3, clienteAux.getSenha());
			

				query.execute();
				query.close();
					
				}
			
			cnn.close();
			
			
		}catch(SQLException ex){
			System.out.println("Erro ao conectar ao banco: " + ex);
		}

	}
	public static void dadosConta() {
		String sql = "insert into conta (codConta, saldoConta, limiteConta, codAgencia) values (?,?,?,?)";
		
		try {
			Connection cnn = ConnectionFactory.getConnection();

			PreparedStatement query = (PreparedStatement) cnn.prepareStatement(sql);
			Iterator<Conta> iterConta = Principal.listaConta.iterator();
			Conta contaAux;

			while (iterConta.hasNext()) {
				contaAux = iterConta.next();
				query.setInt(1, contaAux.getCodigo());
				query.setDouble(2, contaAux.getSaldo());
				query.setDouble(3, contaAux.getLimite());
				query.setInt(4, contaAux.getAgencia().getCodigo());

				query.execute();
				query.close();
					
				}
			
			cnn.close();

			
		}catch(SQLException ex){
			System.out.println("Erro ao conectar ao banco: " + ex);
		}

	}public static void dadosAgencia() {
		String sql = "insert into agencia (codAgencia, nomeAgencia, codGerente) values (?,?,?)";
		
		try {
			Connection cnn = ConnectionFactory.getConnection();

			PreparedStatement query = (PreparedStatement) cnn.prepareStatement(sql);
			Iterator<Agencia> iterConta = Principal.listaAgencia.iterator();
			Agencia agenciaAux;

			while (iterConta.hasNext()) {
				agenciaAux = iterConta.next();
				query.setInt(1, agenciaAux.getCodigo());
				query.setString(2, agenciaAux.getNome());
				query.setInt(3, agenciaAux.getGerente().getCodGerente());

				query.execute();
				query.close();
					
				}
			
			cnn.close();
			
		}catch(SQLException ex){
			System.out.println("Erro ao conectar ao banco: " + ex);
		}

	}

	}
	


