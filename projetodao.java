package projetoDAO;

import java.sql.Connection;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import factoryconection.Classeconectora;
import perfil.Perfil;

public class projetodao {

	
	// 
	//CRUD
	// C: CREATE
	// R: READ
	// U: UPDATE
	// D: DELETE
	//
	
	public void save(Perfil perfil) {
	
	String sql = "INSERT INTO perfis(nome, idade, cpf, datansc, jogofav, nacionalidade, quantconquistas, timedocoracao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	Connection conn = null; 
	
	PreparedStatement pstm = null;
	
	try {
		//Criar uma conexão com o banco de dados
		conn = Classeconectora.createConnectionToMySQL();
		
		//Criado uma preparedstatement para executar uma query
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		//Adicionando os valores que serão esperados pela query
		pstm.setString(1, perfil.getNomecliente());
		pstm.setInt(2, perfil.getCpf());
		pstm.setInt(3, perfil.getIdade());
		pstm.setString(4, perfil.getJogofavorito());
		pstm.setString(5, perfil.getNacionalidade());
		pstm.setInt(6, perfil.getQuantconquistas());
		pstm.setString(7, perfil.getTimedocoracao());;
	
		// Executar a query
		
		pstm.execute();
	
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
}
	

