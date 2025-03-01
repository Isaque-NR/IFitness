package utils;

public class  Validadores {
	
	// validadores usuario
	public static boolean isNomeValid(String nome) {
		return nome!=null && !nome.isEmpty() 
		 && nome.length()>2 && nome.length()<50 && nome.matches("^[\\p{L}]+(?:\\s[\\p{L}]+)*$");
	}

	public static boolean isIdadeValid(int idade) {
		return idade >= 12 && idade <= 80; 
	}
	
	public static boolean isMatriculaValid(String matricula) {
		return matricula!=null && !matricula.isEmpty() 
		     && matricula.length()==5
				&& matricula.matches("[0-9]+");
				
	}
	
	// validadores aluno
	public static boolean isSexoValid(String sexo) {
		return sexo!=null && !sexo.isEmpty() 
				 && sexo.equalsIgnoreCase("feminino")
				|| sexo.equalsIgnoreCase("masculino");
	}
	
	public static boolean isPesoValid(double peso) {
		return peso>=30 && peso<=650; // valor minimo e max em kgs
	}
	
	public static boolean isAlturaValid(double altura) {
		return altura>=1.30 && altura <= 2.60; // altura minima e max em metros
	}
	
	public static boolean isLimitacoesValid(String limitacoes) {
		return limitacoes!= null && !limitacoes.isEmpty()
			 && limitacoes.matches("[\\p{L}0-9.,!?;:'\"()\\[\\]{\\\s-]+"); 
	}
	
	// validadores instrutor 
	public static boolean isSenhaValid(String senha) {
		return senha!=null && !senha.isEmpty()
				&& senha.matches("^[a-zA-Z0-9!@#$%^&*()_+={}\\[\\]|\\\\:;\\\"'<>,.?/`~\\-]{6}$\r\n");
	}
	
	// validadores Treinos
	public static boolean isDescricaoValid(String descricao) {
		return descricao!=null && !descricao.isEmpty() && 
				  descricao.matches("[a-zA-Z0-9 ]+"); 
	}

	// validadores Exercicio
	public static boolean isIntensidadeValid(String itensidade) {
		return itensidade!=null && !itensidade.isEmpty() 
				 && itensidade.equalsIgnoreCase("leve") 
				|| itensidade.equalsIgnoreCase("moderada") || itensidade.equalsIgnoreCase("itenso");
	}
	
	
	// validadores construtores exercicio
	public static boolean isExercicioMusculacaoValid(String nome,double carga, int repeticoes, int series) {
		return nome.matches("^[a-zA-Z0-9 ]+$") && nome!=null && carga>0 && carga<= 1000 && 
				repeticoes>=1 && repeticoes<=500 && series>=1 && series<=200;
	}
	
	public static boolean isExercicioCardioValid(String nome, int duracao, String itensidade) {
		return nome.matches("^[a-zA-Z0-9 ]+$") && nome!=null && duracao>=1 && duracao <=240 
				&& isIntensidadeValid(itensidade);
	}

	

}
