package model.entities;

import java.io.Serializable;

import model.util.Validadores;

public class Exercicio implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private double carga;
	private int repeticoes;
	private int series;
	private int duracao; // minutos
	private String intensidade; // leve,moderado,itenso
	
	// Construtor Exercicos de Musculação
	public Exercicio(String nome, double carga, int repeticoes, int series) {
		if(Validadores.isExercicioMusculacaoValid(nome, carga, repeticoes, series)) {
		this.nome=nome;
		this.carga=carga;
		this.repeticoes=repeticoes;
		this.series=series;
		this.duracao=0;
		this.intensidade = "N/A";
		}else {
			System.out.println("Exercicio Invalido");
		}
	}
	
	// Construtor Exercicios Cardio
	
	public Exercicio (String nome, int duracao, String intensidade) {
		if(Validadores.isExercicioCardioValid(nome, duracao, intensidade)) {
		this.nome=nome;
		this.carga=0;
		this.repeticoes=0;
		this.series=0;
		this.duracao=duracao;
		this.intensidade=intensidade;
		}else {
			System.out.println("Exercicio Invalido");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
				this.nome = nome;

	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
				this.carga = carga;
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
				this.repeticoes = repeticoes;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
				this.series = series;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
				this.duracao = duracao;
	}

	public String getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(String itensidade) {
		this.intensidade = itensidade;
	}

	@Override
	public String toString() {
		return " - " + nome + ": " + series + "X" + repeticoes + " reps " + 
	"Duracao: " + duracao + " Intensidade: " + intensidade + "\n";
	}
	
	
}
