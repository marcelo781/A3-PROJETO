package factoryconection;

import java.sql.Connection;
import java.sql.DriverManager;


public class Classeconectora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
		//NOME DO USUARIO MY SQL
		private final static String USERNAME = "root";
		
		//SENHA DO BANCO
		private static final String PASSWORD = "marcelo781";
		
		//CAMINHO DO BANCO DE DADOS
				
		private static final String DATABASE_URL = "jdbc:mysql://localhost:3306";
		
		
		//conexão com o banco de dados
		
		
		//faz com que a classe seja carregada pela jvm
		public static Connection createConnectionToMySQL() throws Exception {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfil", USERNAME, PASSWORD);
		
		return connection; 
	}
		
		public static void main1(String[] args) throws Exception {
			//recuperar conexão
			Connection con = createConnectionToMySQL();
			
			//testar se a conexão é nula
			
			if (con!=null) {
				System.out.println("Conexão obtida com sucesso");
				con.close();
			}
		}
}
