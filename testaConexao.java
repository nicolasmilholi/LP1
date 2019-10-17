package LP1;
import java.sql.Connection;
import java.sql.SQLException;



public class testaConexao {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		System.out.println("conectado");
		con.close();
	}
}


