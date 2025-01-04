package model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class IFitnessApp extends JFrame {
    private List<Aluno> alunos = new ArrayList<>();
    private List<Treinos> treinos = new ArrayList<>();

    public IFitnessApp() {
        setTitle("IFitness - Teste de Funcionalidades");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos para cadastrar aluno
        JLabel alunoLabel = new JLabel("Cadastrar Aluno:");
        JTextField matriculaField = new JTextField(10);
        JTextField nomeField = new JTextField(10);
        JTextField pesoField = new JTextField(5);
        JTextField alturaField = new JTextField(5);
        JTextField idadeField= new JTextField(5);
        JTextField limitacoesFisicasOuSaudeField = new JTextField(5);
        JTextField sexoField = new JTextField(5);
        JButton cadastrarAlunoBtn = new JButton("Cadastrar Aluno");

        // Campos para criar treino
        JLabel treinoLabel = new JLabel("Criar Treino:");
        JTextField descricaoField = new JTextField(10);
        JButton criarTreinoBtn = new JButton("Criar Treino");

        // Campos para adicionar exercício
        JLabel exercicioLabel = new JLabel("Adicionar Exercício:");
        JTextField treinoDescricaoField = new JTextField(10);
        JTextField exercicioNomeField = new JTextField(10);
        JTextField cargaField = new JTextField(5);
        JTextField repeticoesField = new JTextField(5);
        JTextField seriesField = new JTextField(5);
        JButton adicionarExercicioBtn = new JButton("Adicionar Exercício");

        // Botão para associar treino ao aluno
        JLabel associarLabel = new JLabel("Associar Treino ao Aluno:");
        JTextField alunoMatriculaField = new JTextField(10);
        JTextField treinoParaAssociarField = new JTextField(10);
        JButton associarTreinoBtn = new JButton("Associar Treino");

        // Botão para listar treinos de um aluno
        JLabel listarTreinosLabel = new JLabel("Listar Treinos de Aluno:");
        JTextField alunoParaListarField = new JTextField(10);
        JButton listarTreinosBtn = new JButton("Listar Treinos");

        // Área de saída
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Adicionar componentes à janela
        add(alunoLabel);
        add(new JLabel("Matrícula:"));
        add(matriculaField);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Peso:"));
        add(pesoField);
        add(new JLabel("Altura:"));
        add(alturaField);
        add(new JLabel("Idade: "));
        add(idadeField);
        add(new JLabel("Limitacoes Fisicas ou de Saude: "));
        add(limitacoesFisicasOuSaudeField);
        add(new JLabel("Sexo: "));
        add(sexoField);
        add(cadastrarAlunoBtn);

        add(treinoLabel);
        add(new JLabel("Descrição:"));
        add(descricaoField);
        add(criarTreinoBtn);

        add(exercicioLabel);
        add(new JLabel("Treino:"));
        add(treinoDescricaoField);
        add(new JLabel("Nome:"));
        add(exercicioNomeField);
        add(new JLabel("Carga:"));
        add(cargaField);
        add(new JLabel("Repetições:"));
        add(repeticoesField);
        add(new JLabel("Séries:"));
        add(seriesField);
        add(adicionarExercicioBtn);

        add(associarLabel);
        add(new JLabel("Aluno:"));
        add(alunoMatriculaField);
        add(new JLabel("Treino:"));
        add(treinoParaAssociarField);
        add(associarTreinoBtn);

        add(listarTreinosLabel);
        add(new JLabel("Aluno:"));
        add(alunoParaListarField);
        add(listarTreinosBtn);

        add(new JScrollPane(outputArea));

        // Ações dos botões
        cadastrarAlunoBtn.addActionListener(e -> {
            String matricula = matriculaField.getText();
            String nome = nomeField.getText();
            String sexo = sexoField.getText();
            String limitacoesFisicasOuSaude = limitacoesFisicasOuSaudeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            double peso = Double.parseDouble(pesoField.getText());
            double altura = Double.parseDouble(alturaField.getText());
            alunos.add(new Aluno(nome, idade, matricula,sexo,peso,altura,limitacoesFisicasOuSaude));
            outputArea.append("Aluno " + nome + " cadastrado com sucesso!\n");
        });

        criarTreinoBtn.addActionListener(e -> {
            String descricao = descricaoField.getText();
            treinos.add(new Treinos(descricao));
            outputArea.append("Treino '" + descricao + "' criado com sucesso!\n");
        });

        adicionarExercicioBtn.addActionListener(e -> {
            String treinoDescricao = treinoDescricaoField.getText();
            Treinos treino = treinos.stream().filter(t -> t.getDescricao().equals(treinoDescricao)).findFirst().orElse(null);
            if (treino != null) {
                String nome = exercicioNomeField.getText();
                double carga = Double.parseDouble(cargaField.getText());
                int repeticoes = Integer.parseInt(repeticoesField.getText());
                int series = Integer.parseInt(seriesField.getText());
                treino.adicionarExercicio(new Exercicio(nome, carga, repeticoes, series));
                outputArea.append("Exercício '" + nome + "' adicionado ao treino '" + treinoDescricao + "'\n");
            } else {
                outputArea.append("Treino não encontrado.\n");
            }
        });

        associarTreinoBtn.addActionListener(e -> {
            String matricula = alunoMatriculaField.getText();
            String treinoDescricao = treinoParaAssociarField.getText();
            Aluno aluno = alunos.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null);
            Treinos treino = treinos.stream().filter(t -> t.getDescricao().equals(treinoDescricao)).findFirst().orElse(null);
            if (aluno != null && treino != null) {
                aluno.getTreinos().add(treino);
                outputArea.append("Treino '" + treinoDescricao + "' associado ao aluno '" + aluno.getNome() + "'\n");
            } else {
                outputArea.append("Aluno ou treino não encontrado.\n");
            }
        });

        listarTreinosBtn.addActionListener(e -> {
            String matricula = alunoParaListarField.getText();
            Aluno aluno = alunos.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null);
            if (aluno != null) {
                outputArea.append("Treinos do aluno " + aluno.getNome() + ":\n");
                for (Treinos treino : aluno.getTreinos()) {
                    outputArea.append("- " + treino.toString() + "\n");
                }
            } else {
                outputArea.append("Aluno não encontrado.\n");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new IFitnessApp();
    }
}