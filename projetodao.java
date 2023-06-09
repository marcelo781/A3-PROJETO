package projetoDAO;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;

import factoryconection.Classeconectora;
import perfil.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.protocol.Resultset;



public class ProjetoDao {

	
	// 
	//CRUDimport java.sql.PreparedStatement;
	// C: CREATE
	// R: READ
	// U: UPDATE
	// D: DELETE
	//
	
	
	
	 //CREATE  //INSERCAO DE DADOS
	public void save(Perfil perfil) {

	
	String sql = "INSERT INTO perfis(nome, idade, jogofav, nacionalidade, quantconquistas, timedocoracao) VALUES (?, ?, ?, ?, ?, ? )";
	
	Connection conn = null; 
	
	PreparedStatement pstm = null;
	
	try {
		//Criar uma conexão com o banco de dados
		conn = Classeconectora.createConnectionToMySQL();
		
		//Criado uma preparedstatement para executar uma query
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		//Adicionando os valores que serão esperados pela query
		pstm.setString(1, perfil.getNomecliente());
		pstm.setInt(2, perfil.getIdade());
		pstm.setString(3, perfil.getJogofavorito());
		pstm.setString(4, perfil.getNacionalidade());
		pstm.setInt(5, perfil.getQuantconquistas());
		pstm.setString(6, perfil.getTimedocoracao());;
	
		// Executar a query
		
		pstm.execute();
		
		System.out.println("PERFIL SALVO COM SUCESSO, FERA!");
	
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
		
		String sql = "DELETE FROM perfis WHERE id = ?";
		
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
	
	public List<Perfil> getPerfis(){
	
		String sql = "SELECT * FROM perfis";
		List<Perfil> perfis = new ArrayList<Perfil>();
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
	
//CLASSE PARA RECUPERAR OS DADOS SALVOS NO BANCO
	
		ResultSet rset = null;
	
	try {
		conn = Classeconectora.createConnectionToMySQL();
		pstm = (JdbcPreparedStatement) conn.prepareStatement(sql); 
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Perfil perfil = new Perfil();
			
// RECUPERAR O ID 
		
			perfil.setId(rset.getInt("id"));
			
// RECUPERAR O NOME 
			
			perfil.setNomecliente(rset.getString("nome"));
			
// RECUPERAR A IDADE
			
			perfil.setIdade(rset.getInt("idade"));
			
// RECUPERAR JOGO FAVORITO
			
			perfil.setJogofavorito(rset.getString("jogofav"));
					
// RECUPERAR NACIONALIDADE 
			
			perfil.setNacionalidade(rset.getString("nacionalidade"));
		
// RECUPERAR QT DE CONQUISTAS
			
			perfil.setQuantconquistas(rset.getInt("quantconquistas"));
			
// RECUPERAR TIME DO CORACAO
			
			perfil.setTimedocoracao(rset.getString("timedocoracao"));
			
			
			perfis.add(perfil);
			 
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
	return perfis; }

	
		
	
	
	
	
	// UPDATE // ATUALIZACAO DE DADOS NO REGISTRO
	
	
	
	public void update(Perfil perfil) {
		String sql = "UPDATE perfis SET nome = ?, idade = ?, jogofav = ?, nacionalidade = ?, quantconquistas = ?, timedocoracao = ? " +
	"WHERE id = ?";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		
		try { 
			//Criar conexão com o banco
			
			conn = Classeconectora.createConnectionToMySQL();
			
			//Criar a classe pra executar a query
			
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			//Adicionando os valores para atualizar
			
			pstm.setString(1, perfil.getNomecliente());
			pstm.setInt(2, perfil.getIdade());
			pstm.setString(3, perfil.getJogofavorito());
			pstm.setString(4, perfil.getNacionalidade());
			pstm.setInt(5, perfil.getQuantconquistas());
			pstm.setString(6, perfil.getTimedocoracao());
			
			
			
			//Qual o ID do registro que deseja atualizar
			pstm.setInt(7, perfil.getId());
			
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



















