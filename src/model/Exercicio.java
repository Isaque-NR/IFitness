package model;

public class Exercicio {
	
	private String nome;
	private double carga;
	private int repeticoes;
	private int series;
	private int duracao; // min
	private String intensidade; // leve,moderado,itenso
	
	// Construtor Exercicos de Musculação
	public Exercicio(String nome, double carga, int repeticoes, int series) {
		if(Validadores.isExercicioMusculacaoValid(nome, carga, repeticoes, series)) {
		this.nome=nome;
		this.carga=carga;
		this.repeticoes=repeticoes;
		this.series=series;
		this.intensidade = "N/A";
		}else {
			System.out.println("Exercicio Invalido");
		}
	}
	
	// Construtor Exercicios Cardio
	
	public Exercicio (String nome, int duracao, String itensidade) {
		if(Validadores.isExercicioCardioValid(nome, duracao, itensidade)) {
		this.nome=nome;
		this.duracao=duracao;
		this.intensidade=itensidade;
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
		return  nome + ", carga: " + carga + ", repeticoes; " + repeticoes + ", series: " + series
				+ ", duracao: " + duracao + ", itensidade: " + intensidade ;
	}
	
}
