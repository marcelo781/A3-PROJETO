package packappconsole;
import java.awt.image.renderable.ParameterBlock;

import console.Console;
import consoleDao.ConsoleDao;
public class MainappsalvardadosConsole {

	public static void main(String[] args) {
		// MVC
		// MODEL
		// VIEW
		// CONTROLLER 
		
		ConsoleDao consoleDao = new ConsoleDao();
		
		Console console = new Console();
		
		console.setNomeconsole("Xbox Series S");
		console.setAnodelançamento(2020);
		console.setProprietaria("Microsoft");
	
		// consoleDao.save(console);        // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI SALVAR UM CONSOLE
	
		// VISUALIZAÇÃO DOS REGISTROS NO BANCO 
		 
		   
				 for  (Console c : consoleDao.getConsoles());
					System.out.println("Console: "+ console.getNomeconsole());
	
		// ATUALIZAR O CONTATO
					
					Console c1 = new Console();

					c1.setNomeconsole("Playstation 4 Pro");
					c1.setAnodelançamento(2014);
					c1.setProprietaria("Sony");
					
					
					 c1.setIdconsole(1);  //NUMERO DO ID NO BANCO DE DADOS 
					 
					// consoleDao.update(c1);        // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI ATUALIZAR UM PERFIL
	
	

		//DELETAR UM CONTATO PELO SEU NUMERO DE ID
						
					//	consoleDao.deleteByID(8);      // SE ISSO AQUI DEIXAR DE SER COMENTADO, VAI DELETAR UM PERFIL PELO ID
	
	
	
	}
}
