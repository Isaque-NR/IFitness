package model;

import java.util.List;
import java.util.ArrayList;
import controller.Validadores;

public class Treinos {
	
	private String descricao;
	private List<Exercicio> exercicios;
	
	public Treinos(String descricao) {
		if(Validadores.isTreinosValid(descricao)) {
		this.descricao=descricao;
		this.exercicios=new ArrayList<>();
		}else {
			System.out.println("Treino Invalido");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if(Validadores.isDescricaoValid(descricao)) {
		this.descricao = descricao;
		}else {
			System.out.println("Insira uma descricao válida!");
		}
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
