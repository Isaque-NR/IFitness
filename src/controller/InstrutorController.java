package controller;


import model.entities.Instrutor;
import model.fabrica.Fabrica;
import java.util.List;

import model.dao.InstrutorDAO;
import model.entities.Exercicio;
import model.entities.Treinos;

public class InstrutorController {
    
    private InstrutorDAO instrutorDAO;

    public InstrutorController() {
        this.instrutorDAO = new InstrutorDAO();
    }

    public Instrutor autenticarInstrutor(String matricula, String senha) {
        return instrutorDAO.validarCredenciais(matricula, senha);
    }
    
    public Treinos CriarTreino (String nome, List<Exercicio> exercicios) {
    	return Fabrica.getTreino(nome, exercicios);
    }
    public boolean cadastrarInstrutor(String nome, int idade, String matricula, String senha) {
        Instrutor novoInstrutor = Fabrica.getInstrutor(nome, idade, matricula, senha);
        return instrutorDAO.cadastrarInstrutor(novoInstrutor);
    }
    
    public void atualizarDados (Instrutor instrutorLogado) {
    	instrutorDAO.atualizarArquivo(instrutorLogado);
    }
    
    
}

