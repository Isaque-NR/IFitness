package app;

import javax.swing.SwingUtilities;

import view.TelaLogin;

public class IFitness {

	public static void main(String[] args) {
		
		 SwingUtilities.invokeLater(() -> {
	            new TelaLogin().setVisible(true);
	        });

	}

}
