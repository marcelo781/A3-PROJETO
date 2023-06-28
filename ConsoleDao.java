package consoleDao;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import console.Console;
import factoryconection.Classeconectora;




public class ConsoleDao {

	// 
		//CRUDimport java.sql.PreparedStatement;
		// C: CREATE
		// R: READ
		// U: UPDATE
		// D: DELETE
		//
		
	
	//CREATE  //INSERCAO DE DADOS
	
	public void save(Console console) {

		
		String sql = "INSERT INTO consoles(nome, anodelançamento, proprietaria) VALUES (?, ?, ?)";
		
		Connection conn = null; 
		
		PreparedStatement pstm = null;
	
		try {
			//Criar uma conexão com o banco de dados
			conn = Classeconectora.createConnectionToMySQL();
			
			//Criado uma preparedstatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql); 
			
			//Adicionando os valores que serão esperados pela query
			
			pstm.setString(1, console.getNomeconsole());
			pstm.setInt(2, console.getAnodelançamento());
			pstm.setString(3, console.getProprietaria());
	
			// Executar a query
			
			pstm.execute();
			
			System.out.println("CONSOLE SALVO COM SUCESSO, FERA!");
	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

			//Fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
			
				if(conn!=null) {
					conn.close();
				}	}catch (Exception e) {
					e.printStackTrace();
				}

		}
			
		}
	
		// D: DELETE // EXCLUIR REGISTROS
	
	
	public void deleteByID(int id) {
	
		String sql = "DELETE FROM consoles WHERE id = ?";
		
		
		Connection conn = null;
		
		JdbcPreparedStatement pstm = null;
		
		try { 
			conn = Classeconectora.createConnectionToMySQL();
			
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql); 
			
			pstm.setInt(1, id);
			
			pstm.execute();
	
		}catch (Exception e) {
			e.printStackTrace();
			}finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close(); }
				}catch (Exception e) {
							e.printStackTrace();
						} { 
						
						}
				}
		
	}
	
		//READ // LEITURA E LISTAGEM DE DADOS
	
	public List<Console> getConsoles(){
		
		String sql = "SELECT * FROM consoles";
		List<Console> consoles = new ArrayList<Console>();
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		//CLASSE PARA RECUPERAR OS DADOS SALVOS NO BANCO
		
			ResultSet rset = null;
		
		try {
			conn = Classeconectora.createConnectionToMySQL();
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql); 
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Console console = new Console();
		
		
				// RECUPERAR O ID 
				
				console.setIdconsole(rset.getInt("id"));
				
				// RECUPERAR O NOME 
				
				console.setNomeconsole(rset.getString("nome"));
		
				// RECUPERAR ANO DE LANCAMENTO
				
				console.setAnodelançamento(rset.getInt("anodelançamento"));
		
				//  RECUPERAR PROPRIETARIA
				
				console.setProprietaria(rset.getString("proprietaria"));
				
				consoles.add(console);	
	}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
		if (rset!=null) {
			rset.close();
			}
		if (pstm!= null) {
			pstm.close();
		}
		if (conn!= null) {
			conn.close();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	return consoles; }

		// UPDATE // ATUALIZACAO DE DADOS NO REGISTRO
	
	public void update(Console console) {
	
		String sql = "UPDATE consoles SET nome = ?, anodelançamento = ?, proprietaria = ? " + "WHERE id = ? "; 

		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
	
		try { 
			//Criar conexão com o banco
			
			conn = Classeconectora.createConnectionToMySQL();
			
			//Criar a classe pra executar a query
			
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			//Adicionando os valores para atualizar
			
			pstm.setString(1, console.getNomeconsole());
			pstm.setInt(2, console.getAnodelançamento());
			pstm.setString(3, console.getProprietaria());
			
			//Qual o ID do registro que deseja atualizar
			pstm.setInt(4, console.getIdconsole());
			
			//Executar a query
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!=null) {
					pstm.close();
			}
			if (conn!=null) {
				conn.close(); }}	
			catch (Exception e) {
				e.printStackTrace();
			}
	
			
			
			
			
			
		}
			
			
			
			
		}		
			
}
