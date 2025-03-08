package model.dao;

import model.entities.Instrutor;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO {

    private static final String ARQUIVO = "instrutores.dat";
    private List<Instrutor> instrutores;

    public InstrutorDAO() {
        instrutores = (List<Instrutor>) Persistencia.carregarDados(ARQUIVO);
        if (instrutores == null) {
            instrutores = new ArrayList<>();
        }
    }

    public boolean cadastrarInstrutor(Instrutor instrutor) {
        
    	for (Instrutor i : instrutores) {
            if (i.getMatricula().equals(instrutor.getMatricula())) {
                return false; // Já existe um instrutor com essa matrícula no arquivo então não podemos salvar outro
            }
        }
    	
    	instrutores.add(instrutor);
        Persistencia.salvarDados(instrutores, ARQUIVO);
        return true;
    }

    public Instrutor validarCredenciais(String matricula, String senha) {
        for (Instrutor instrutor : instrutores) {
            if (instrutor.getMatricula().equals(matricula) && instrutor.getSenha().equals(senha)) {
                return instrutor;
            }
        }
        return null;
    }
}

