package view;

import javax.swing.*;

import model.Aluno;
import model.Exercicio;
import model.Treinos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AlunoTesterApp extends JFrame {
    private java.util.List<Aluno> alunos = new ArrayList<>();

    public AlunoTesterApp() {
        setTitle("Tester - Classe Aluno");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos para criar um aluno
        JLabel alunoLabel = new JLabel("Criar Aluno:");
        JTextField nomeField = new JTextField(10);
        JTextField idadeField = new JTextField(5);
        JTextField matriculaField = new JTextField(10);
        JTextField sexoField = new JTextField(5);
        JTextField pesoField = new JTextField(5);
        JTextField alturaField = new JTextField(5);
        JTextField limitacoesField = new JTextField(15);
        JButton criarAlunoBtn = new JButton("Criar Aluno");

        // Campos para calcular o IMC
        JLabel imcLabel = new JLabel("Calcular IMC de Aluno:");
        JTextField alunoMatriculaIMCField = new JTextField(10);
        JButton calcularIMCBtn = new JButton("Calcular IMC");

        // Campos para listar informações do aluno
        JLabel listarLabel = new JLabel("Listar Aluno:");
        JTextField alunoMatriculaListarField = new JTextField(10);
        JButton listarAlunoBtn = new JButton("Listar Aluno");

        // Área de saída
        JTextArea outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);

        // Adicionando componentes
        add(alunoLabel);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Idade:"));
        add(idadeField);
        add(new JLabel("Matrícula:"));
        add(matriculaField);
        add(new JLabel("Sexo:"));
        add(sexoField);
        add(new JLabel("Peso:"));
        add(pesoField);
        add(new JLabel("Altura:"));
        add(alturaField);
        add(new JLabel("Limitações:"));
        add(limitacoesField);
        add(criarAlunoBtn);

        add(imcLabel);
        add(new JLabel("Matrícula:"));
        add(alunoMatriculaIMCField);
        add(calcularIMCBtn);

        add(listarLabel);
        add(new JLabel("Matrícula:"));
        add(alunoMatriculaListarField);
        add(listarAlunoBtn);

        add(new JScrollPane(outputArea));

        // Ações dos botões
        criarAlunoBtn.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String matricula = matriculaField.getText();
                String sexo = sexoField.getText();
                double peso = Double.parseDouble(pesoField.getText());
                double altura = Double.parseDouble(alturaField.getText());
                String limitacoes = limitacoesField.getText();

                Aluno aluno = new Aluno(nome, idade, matricula, sexo, peso, altura, limitacoes);
                alunos.add(aluno);

                outputArea.append("Aluno criado com sucesso: " + nome + "\n");
            } catch (Exception ex) {
                outputArea.append("Erro ao criar aluno: " + ex.getMessage() + "\n");
            }
        });

        calcularIMCBtn.addActionListener(e -> {
            String matricula = alunoMatriculaIMCField.getText();
            Aluno aluno = alunos.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null);

            if (aluno != null) {
                double imc = aluno.calcularIMC();
                outputArea.append("IMC do aluno " + aluno.getNome() + ": " + imc + "\n");
            } else {
                outputArea.append("Aluno não encontrado.\n");
            }
        });

        listarAlunoBtn.addActionListener(e -> {
            String matricula = alunoMatriculaListarField.getText();
            Aluno aluno = alunos.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().orElse(null);

            aluno.exibirInformacoes();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AlunoTesterApp();
    }
}