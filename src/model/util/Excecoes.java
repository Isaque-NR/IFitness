package model.util;

import javax.swing.*;

public class Excecoes extends Exception{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Excecoes(JFrame tela, String mensagem) {
		
	JOptionPane.showMessageDialog(tela, mensagem, "Algo deu errado :(", JOptionPane.ERROR_MESSAGE);	}

}
