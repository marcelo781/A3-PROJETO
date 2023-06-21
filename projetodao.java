package projetoDAO;

import java.sql.Connection;

import factoryconection.Classeconectora;
import perfil.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	
	
	 //CREATE
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
	
	//READ
	public List<Perfil> getPerfis(){
	
		String sql = "SELECT * FROM perfis";
		List<Perfil> perfis = new ArrayList<>();
		
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
		return perfis; 
		
		}
}
