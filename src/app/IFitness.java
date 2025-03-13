package app;

import javax.swing.SwingUtilities;

import controller.InstrutorController;
import view.TelaLogin;

public class IFitness {

	public static void main(String[] args) {
		try {
			InstrutorController instrutorController = new InstrutorController();
		
		    SwingUtilities.invokeLater(() -> {
	        new TelaLogin(instrutorController).setVisible(true);
	        });
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
