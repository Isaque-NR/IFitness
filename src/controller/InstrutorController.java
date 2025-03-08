package controller;

import model.entities.Instrutor;
import model.fabrica.Fabrica;
import model.dao.InstrutorDAO;

public class InstrutorController {
    
    private InstrutorDAO instrutorDAO;

    public InstrutorController() {
        this.instrutorDAO = new InstrutorDAO();
    }

    public Instrutor autenticarInstrutor(String matricula, String senha) {
        return instrutorDAO.validarCredenciais(matricula, senha);
    }
    
    public boolean cadastrarInstrutor(String nome, int idade, String matricula, String senha) {
        Instrutor novoInstrutor = Fabrica.getInstrutor(nome, idade, matricula, senha);
        return instrutorDAO.cadastrarInstrutor(novoInstrutor);
    }
    
    public void atualizarDados (Instrutor instrutorLogado) {
    	instrutorDAO.atualizarArquivo(instrutorLogado);
    }
    
    
}

