package packapp;

import perfil.Perfil;
import projetoDAO.ProjetoDao;

public class Mainappsalvardados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ProjetoDao projetoDao = new ProjetoDao();
		
		
		Perfil perfil = new Perfil();
		perfil.setNomecliente("Marcelo");
		perfil.setCpf (709,536,984,40);
		perfil.setIdade(22);
		perfil.setJogofavorito("Persona 5 Royal");
		perfil.setNacionalidade("Brasileiro");
		perfil.setQuantconquistas(45);
		perfil.setTimedocoracao("Corinthians");
		
		projetoDao.save(perfil);
		
		
		
		
	}

}
