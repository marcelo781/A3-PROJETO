package packapp;

import java.sql.Connection;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import perfil.Perfil;
import projetoDAO.ProjetoDao;

public class Mainappsalvardados {

	public static void main(String[] args) {
		// MVC
		// MODEL
		// VIEW
		// CONTROLLER 
		
		ProjetoDao projetoDao = new ProjetoDao();
		
		
		Perfil perfil = new Perfil();
		perfil.setNomecliente("Kauan");
		perfil.setIdade(18);
		perfil.setJogofavorito("Fortnite");
		perfil.setNacionalidade("Brasileiro");
		perfil.setQuantconquistas(5);
		perfil.setTimedocoracao("nenhum");
		
		 projetoDao.save(perfil);     // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI SALVAR UM PERFIL
		
		// ATUALIZAR O CONTATO
		
		Perfil p1 = new Perfil();

		p1.setNomecliente("Jonatha");
		p1.setIdade(19);
		p1.setJogofavorito("Rocket League");
		p1.setNacionalidade("Brasileiro");
		p1.setQuantconquistas(30);
		p1.setTimedocoracao("nenhum");
		
		 p1.setId(3);  //NUMERO DO ID NO BANCO DE DADOS 
		 
		// projetoDao.update(p1);        // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI ATUALIZAR UM PERFIL	
		
		
		//DELETAR UM CONTATO PELO SEU NUMERO DE ID
		
		//	projetoDao.deleteByID(7);      // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI DELETAR UM PERFIL PELO ID
		
		
		
		
		
		
		// VISUALIZAÇÃO DOS REGISTROS NO BANCO 
		
		for(Perfil p : projetoDao.getPerfis());
		System.out.println("Perfil: "+ perfil.getNomecliente());
	

}
		

	

	
	
	
	
	
	
	
	

}
	
	
	

}
	
