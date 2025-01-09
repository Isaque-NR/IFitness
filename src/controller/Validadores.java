package controller;

public class  Validadores {
	
	// validadores usuario
	public static boolean isNomeValid(String nome) {
		return nome!=null && !nome.isEmpty() 
		 && nome.length()>2 && nome.length()<50 && nome.matches("^[\\p{L}]+(?:\\s[\\p{L}]+)*$");
	}

	public static boolean isIdadeValid(int idade) {
		return idade >= 12 && idade <= 100; // 
	}
	
	public static boolean isMatriculaValid(String matricula) {
		return matricula!=null && !matricula.isEmpty() 
		     && matricula.length()==5
				&& matricula.matches("[0-9]+");
				
	}
	// validador construtor Usuario
	public static boolean isUsuarioValid(String nome,int idade, String matricula) {
		return isNomeValid(nome) && isIdadeValid(idade) 
				&& isMatriculaValid(matricula);
	}
	
	// validadores aluno
	public static boolean isSexoValid(String sexo) {
		return sexo!=null && !sexo.isEmpty() 
				 && sexo.equalsIgnoreCase("feminino")
				|| sexo.equalsIgnoreCase("masculino"); // nao tem "outro" somos conservadores mesmo!
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
	} // // analisar como limitacoes funcionara se é apenas um Sim ou Nao ou sera escrito com 
	// com detalhes como por exemplo "Sim" ou "Sim, 2 lesões no joelho"
	// a regex esta para o segundo caso
	
	// validador construtor Aluno
	public static boolean isAlunoValid(String sexo, double peso,double altura, String limitacoesFisicasOuSaude) {
		return isSexoValid(sexo) && isPesoValid(peso) && isAlturaValid(altura) &&
				isLimitacoesValid(limitacoesFisicasOuSaude);
	}
	
	// validadores instrutor 
	public static boolean isSenhaValid(String senha) {
		return senha!=null && !senha.isEmpty()
				&& senha.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$");
		// senha deve possuir aos menos uma letra, um numero e um caracter especial
	}
	
	// validadores Treinos
	public static boolean isDescricaoValid(String descricao) {
		return descricao!=null && !descricao.isEmpty() && 
				  descricao.matches("[a-zA-Z0-9 ]+"); 
	}

	// validadores Exercicio
	public static boolean isItensidadeValid(String itensidade) {
		return itensidade!=null && !itensidade.isEmpty() 
				 && itensidade.equalsIgnoreCase("leve") 
				&& itensidade.equalsIgnoreCase("moderada") && itensidade.equalsIgnoreCase("itenso");
	}
	
	
	// validadores construtores exercicio
	public static boolean isExercicioMusculacaoValid(String nome,double carga, int repeticoes, int series) {
		return nome.matches("^[a-zA-Z0-9 ]+$") && nome!=null && carga>0 && carga<= 1000 && 
				repeticoes>=1 && repeticoes<=500 && series>=1 && series<=200;
	}
	
	public static boolean isExercicioCardioValid(String nome, int duracao, String itensidade) {
		return nome.matches("^[a-zA-Z0-9 ]+$") && nome!=null && duracao>=1 && duracao <=240 
				&& isItensidadeValid(itensidade);
	}

	

}
