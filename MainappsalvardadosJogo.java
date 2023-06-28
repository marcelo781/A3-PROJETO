package packappjogo;
import java.awt.image.renderable.ParameterBlock;

import console.Console;
import jogo.Jogo;
import jogoDao.JogoDao;



public class MainappsalvardadosJogo {

	public static void main(String[] args) {
	// MVC
	// MODEL
	// VIEW
	// CONTROLLER 
	
	JogoDao jogoDao = new JogoDao(); 
	Jogo jogo = new Jogo();
	
	jogo.setNomejogo("Mortal Kombat 11");
	jogo.setAnodelançamento(2019);
	jogo.setProprietaria("Netherrealms");
	jogo.setGenero("Luta");
	jogo.setPreco(230);

	// jogoDao.save(jogo);        // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI SALVAR UM JOGO
	
	
	// VISUALIZAÇÃO DOS REGISTROS NO BANCO 
	 
	   
	 for  (Jogo j : jogoDao.getJogos());
		System.out.println("Jogo: "+ jogo.getNomejogo());

// ATUALIZAR O CONTATO
		
		Jogo j1 = new Jogo();

		j1.setNomejogo("Persona 5 Royal");
		j1.setAnodelançamento(2021);
		j1.setProprietaria("Atlus");
		j1.setGenero("JRPG");
		j1.setPreco(250);
		
		
		
		 j1.setIdjogo(1);  //NUMERO DO ID NO BANCO DE DADOS 
		 
		// jogoDao.update(j1);        // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI ATUALIZAR UM JOGO


	 
	 
		//DELETAR UM CONTATO PELO SEU NUMERO DE ID
			
			//	jogoDao.deleteByID(1);      // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI DELETAR UM JOGO PELO ID



}


	 
	
}
