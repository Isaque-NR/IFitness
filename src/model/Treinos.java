package model;

import java.util.List;
import java.util.ArrayList;

public class Treinos {
	
	private String descricao;
	private List<Exercicio> exercicios;
	
	public Treinos(String descricao) {
		this.descricao=descricao;
		this.exercicios=new ArrayList<>();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	
	public void adicionarExercicio(Exercicio exercicio) {
		exercicios.add(exercicio);
	}
	
	public void removerExercicios(Exercicio exercicio) {
		exercicios.remove(exercicio);
	}

	@Override
	public String toString() {
		return "Descricao:" + descricao + ", exercicios: " + exercicios.toString();
	}
	

}
