package controller;

public class Validadores {
	
	// validadores usuario
	public static boolean isNomeValid(String nome) {
		return isStringNotNull(nome) && isStringNotEmpty(nome) 
		 && isTamanhoValid(nome,2,100) && nome.matches("^[\\p{L}]+(?:\\s[\\p{L}]+)*$");
	}

	public static boolean isIdadeValid(int idade) {
		return isIntValorValid(idade,12,100); // 
	}
	
	public static boolean isMatriculaValid(String matricula) {
		return isStringNotNull(matricula) && isStringNotEmpty(matricula) 
		    && isNotBlankSpace(matricula) && Validadores.isTamanhoValid(matricula,5,5)
				&& matricula.matches("[0-9]+");
	}
	// validador construtor Usuario
	public static boolean isUsuarioValid(String nome,int idade, String matricula) {
		return isNomeValid(nome) && isIdadeValid(idade) 
				&& isMatriculaValid(matricula);
	}
	
	// validadores aluno
	public static boolean isSexoValid(String sexo) {
		return isStringNotNull(sexo) && isStringNotEmpty(sexo) 
				&& isNotBlankSpace(sexo) && sexo.equalsIgnoreCase("feminino")
				|| sexo.equalsIgnoreCase("masculino"); // nao tem "outro" somos conservadores mesmo!
	}
	
	public static boolean isPesoValid(double peso) {
		return isDoubleValorValid(peso,30,650); // valor minimo e max em kgs
	}
	
	public static boolean isAlturaValid(double altura) {
		return isDoubleValorValid(altura,1.30,2.60); // altura minima e max em metros
	}
	
	public static boolean isLimitacoesValid(String limitacoes) {
		return isStringNotNull(limitacoes) && isStringNotEmpty(limitacoes)
				&& isNotBlankSpace(limitacoes) && limitacoes.matches("\\d+\\s+\\p{L}+(\\p{M}*)"); 
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
		return isStringNotNull(senha) && isStringNotEmpty(senha) && isNotBlankSpace(senha)
				&& senha.matches("^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]+$");
		// senha deve possuir aos menos uma letra, um numeri e um caracter especial
	}
	// validador construtor instrutor
	public static boolean isInstrutorValid(String senha) {
		return isSenhaValid(senha);
	}
	
	// validadores Treinos
	public static boolean isDescricaoValid(String descricao) {
		return isStringNotNull(descricao) && isStringNotEmpty(descricao) && 
				isNotBlankSpace(descricao) && descricao.matches("[a-zA-Z0-9]+");
	}
	// validador construtor treinos 
	public static boolean isTreinosValid(String descricao) {
		return isDescricaoValid(descricao);
	}
	
	// validadores Exercicio
	public static boolean isItensidadeValid(String itensidade) {
		return isStringNotNull(itensidade) && isStringNotEmpty(itensidade) 
				&& isNotBlankSpace(itensidade) && itensidade.equalsIgnoreCase("leve") 
				&& itensidade.equalsIgnoreCase("moderada") && itensidade.equalsIgnoreCase("itenso");
	}
	
	
	// validadores construtores exercicio
	public static boolean isExercicioMusculacaoValid(String nome,double carga, int repeticoes, int series) {
		return isNomeValid(nome) && isDoubleValorValid(carga,0.2,1000) && 
				isIntValorValid(repeticoes,1,500) && isIntValorValid(series,1,200);
	}
	
	public static boolean isExercicioCardioValid(String nome, int duracao, String itensidade) {
		return isNomeValid(nome) && isIntValorValid(duracao,1,240) && isItensidadeValid(itensidade);
	}
	
	// validadores que podem ser reutilizados 
	public static boolean isStringNotNull(String string) {
		return string != null;
	}
	
	public static boolean isStringNotEmpty(String string){
		return !string.trim().isEmpty();
	}
	
	public static boolean isNotBlankSpace(String string) {
		return !string.contains(" ");
	}
	
	public static boolean isTamanhoValid(String string, int minlength, int maxlength) {
		return string.length() >= minlength && string.length() <= maxlength;
	}
	
	public static boolean isDoubleValorValid(double valor, double minvalor, double maxvalor){
		return valor >= minvalor && valor <= maxvalor;
	}
	
	public static boolean isIntValorValid(int valor, int minvalor, int maxvalor){
		return valor >= minvalor && valor <= maxvalor;
	}

}
