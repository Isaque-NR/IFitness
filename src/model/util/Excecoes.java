package model.util;

import javax.swing.*;

public class Excecoes extends Exception{	
	
	public void excecaoM(String mensagem) {
		JFrame f = new JFrame("Erro");
		JOptionPane.showMessageDialog(f,mensagem,"ERRO",JOptionPane.ERROR_MESSAGE);
	}

}
