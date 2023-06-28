package jogoDao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import jogo.Jogo;
import factoryconection.Classeconectora;



public class JogoDao {

	

	// 
		//CRUDimport java.sql.PreparedStatement;
		// C: CREATE
		// R: READ
		// U: UPDATE
		// D: DELETE
		//
		
	
	//CREATE  //INSERCAO DE DADOS
	
	
	
public void save(Jogo jogo) {

		
		String sql = "INSERT INTO jogos(nome, anodelançamento, proprietaria, genero, preco) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null; 
		
		PreparedStatement pstm = null;
	
		try {
			//Criar uma conexão com o banco de dados
			conn = Classeconectora.createConnectionToMySQL();
			
			//Criado uma preparedstatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql); 
			
			//Adicionando os valores que serão esperados pela query
			
			pstm.setString(1, jogo.getNomejogo());
			pstm.setInt(2, jogo.getAnodelançamento());
			pstm.setString(3, jogo.getProprietaria());
			pstm.setString(4, jogo.getGenero());
			pstm.setInt(5, jogo.getPreco());
			
			
			// Executar a query
			
			pstm.execute();
			
			System.out.println("JOGO SALVO COM SUCESSO, FERA!");
	
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
	
	
		//D: DELETE // EXCLUIR REGISTROS


	public void deleteByID(int id) {
	
		String sql = "DELETE FROM jogos WHERE id = ?";
		
		
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
	
		public List<Jogo> getJogos(){
			
			String sql = "SELECT * FROM jogos";
			List<Jogo> jogos = new ArrayList<Jogo>();
			Connection conn = null;
			JdbcPreparedStatement pstm = null;
			
			//CLASSE PARA RECUPERAR OS DADOS SALVOS NO BANCO
			
				ResultSet rset = null;
			
			try {
				conn = Classeconectora.createConnectionToMySQL();
				pstm = (JdbcPreparedStatement) conn.prepareStatement(sql); 
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					Jogo jogo = new Jogo();
			
			
					// RECUPERAR O ID 
					
					jogo.setIdjogo(rset.getInt("id"));
					
					// RECUPERAR O NOME 
					
					jogo.setNomejogo(rset.getString("nome"));
			
					// RECUPERAR ANO DE LANCAMENTO
					
					jogo.setAnodelançamento(rset.getInt("anodelançamento"));
			
					//  RECUPERAR PROPRIETARIA
					
					jogo.setProprietaria(rset.getString("proprietaria"));
					
					// RECUPERAR GENERO
					
					jogo.setGenero(rset.getString("genero"));
					
					// RECUPERAR PRECO
					
					jogo.setPreco(rset.getInt("Preco"));
					
					
					jogos.add(jogo);	
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
		return jogos; }
		
		

			// UPDATE // ATUALIZACAO DE DADOS NO REGISTRO
		
		public void update(Jogo jogo) {
		
			String sql = "UPDATE jogos SET nome = ?, anodelançamento = ?, proprietaria = ?, genero = ?, preco = ? " + "WHERE id = ? "; 

			Connection conn = null;
			JdbcPreparedStatement pstm = null;
			
		
			try { 
				//Criar conexão com o banco
				
				conn = Classeconectora.createConnectionToMySQL();
				
				//Criar a classe pra executar a query
				
				pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
				
				//Adicionando os valores para atualizar
				
				pstm.setString(1, jogo.getNomejogo());
				pstm.setInt(2, jogo.getAnodelançamento());
				pstm.setString(3, jogo.getProprietaria());
				pstm.setString(4, jogo.getGenero());
				pstm.setInt(5, jogo.getPreco());
				
				//Qual o ID do registro que deseja atualizar
				pstm.setInt(6, jogo.getIdjogo());
				
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

	
	
	
	
	
	
	
	
	
	

