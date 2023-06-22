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
		perfil.setNomecliente("João");
		perfil.setIdade(17);
		perfil.setJogofavorito("Call of Duty Modern Warfare");
		perfil.setNacionalidade("Brasileiro");
		perfil.setQuantconquistas(60);
		perfil.setTimedocoracao("Flamengo");
		
		projetoDao.save(perfil);
		
		// ATUALIZAR O CONTATO
		
		Perfil p1 = new Perfil();

		p1.setNomecliente("João Henrique");
		p1.setIdade(20);
		p1.setJogofavorito("Call of Duty Modern Warfare 2");
		p1.setNacionalidade("Brasileiro");
		p1.setQuantconquistas(80);
		p1.setTimedocoracao("Flamengo");
		
		p1.setId(7);  //NUMERO DO ID NO BANCO DE DADOS 
		
		projetoDao.update(p1);
		
		
		// VISUALIZAÇÃO DOS REGISTROS NO BANCO 
		
		for(Perfil p : projetoDao.getPerfis());
		System.out.println("Perfil: "+ perfil.getNomecliente());
	

}
		

	

	
	
	
	
	
	
	
	

}
	
