package model.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class Persistencia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void salvarDados (Object objeto, String caminho) {
		try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (caminho))) {
			oos.writeObject (objeto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object carregarDados (String caminho) {
		File arquivo = new File(caminho);
		if(!arquivo.exists()) {
			return new ArrayList<>();
		}
		
		try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream (caminho))) {
			return ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
