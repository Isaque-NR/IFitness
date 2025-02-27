package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Instrutor extends Usuario{
	
	private String senha;
	private List<Aluno> alunos;
	private List<Treinos> treinosCriados;
	
	public Instrutor(String nome, int idade, String matricula, String senha) {
		super(nome,idade,matricula);
		if(Validadores.isSenhaValid(senha)) {
		this.senha=senha;
		this.alunos=new ArrayList<>();
		this.treinosCriados=new ArrayList<>();
		}else {
		     System.out.println("Instrutor Invalido");
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
			this.senha = senha;			
	}
	
	public List<Aluno> getAlunos() { 
		return alunos;
	}
	
	public List<Treinos> getTreinosCriados (){ // provavel sair 
		return treinosCriados;
	}
    
	public void addAlunoInstrutor(Aluno aluno) { // vai funcionar ao cadastrar uum aluno 
		alunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) { 
		alunos.remove(aluno);
	}
	
	public void criarTreino(Treinos treino) { // fora
		treinosCriados.add(treino);
	}
	
	public void removerTreino(String descricao) {
	    Iterator<Treinos> iterator = treinosCriados.iterator();
	    while (iterator.hasNext()) {
	        Treinos treino = iterator.next();
	        if (treino.getDescricao().equals(descricao)) {
	            iterator.remove();
	        }
	    }
	}

	public void associarTreino(Aluno aluno, Treinos treino) {
		aluno.getMeusTreinos().add(treino);
	}
	
	public void dissociarTreino(Aluno aluno, Treinos treino) {
		aluno.getMeusTreinos().remove(treino);
	}
	
	public Aluno consultarAluno(String matricula) { 
		for(Aluno aluno : alunos) {
			if(aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}

}
