package packapp;

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
		
		
		// VISUALIZAÇÃO DOS REGISTROS NO BANCO 
		
		for(Perfil p : projetoDao.getPerfis());
		System.out.println("Perfil: "+ perfil.getNomecliente());
	}

}
