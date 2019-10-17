package LP1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectando ao bancooooooooooooooo");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalholp1",
	                "root", "");
		}catch (ClassNotFoundException e) {
			System.out.println("aqui que ta a merda");
			System.out.println("Não conectado");
			throw new SQLException(e.getMessage());
		}
	}
	
}
