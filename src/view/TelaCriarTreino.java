package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class TelaCriarTreino extends JFrame {

    private static final long serialVersionUID = 1L;

    // Componentes principais
    private JTextField tfNomeTreino;
    private JComboBox<String> cbAlunos; 
    private JRadioButton rbMusculacao, rbCardio;
    private ButtonGroup bgTipoExercicio;

    // Painel que alterna entre Musculação e Cardio
    private JPanel panelCardLayout;
    private CardLayout cardLayout;

    // Campos para exercicio de musculação
    private JTextField tfNomeExercicioMusc;
    private JTextField tfCarga;
    private JTextField tfRepeticoes;
    private JTextField tfSeries;

    // Campos para exercicio de cardio
    private JTextField tfNomeExercicioCardio;
    private JTextField tfDuracao;
    private JTextField tfIntensidade;

    // Área para exibir exercícios adicionados
    private JTextArea taExercicios;

    // Lista interna para armazenar exercícios (exemplo simples de teste remover depois)
    private List<String> listaExercicios;

    public TelaCriarTreino() {
        super("IFitness");
        listaExercicios = new ArrayList<>();
        inicializarComponentes();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        // Painel principal 
        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setBackground(Color.GRAY);
        setContentPane(painelPrincipal);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 0;
        gbc.weightx = 1;

        JLabel lblTitulo = new JLabel("Criar Treino");
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 32));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        painelPrincipal.add(lblTitulo, gbc);

        // Painel superior como FlowLayout
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panelSuperior.setBackground(Color.GRAY);

        JLabel lblNomeTreino = new JLabel("Nome do Treino:");
        lblNomeTreino.setFont(new Font("Arial", Font.BOLD, 16));
        panelSuperior.add(lblNomeTreino);

        tfNomeTreino = new JTextField(10);
        tfNomeTreino.setFont(new Font("Arial", Font.PLAIN, 14));
        panelSuperior.add(tfNomeTreino);

        JLabel lblAluno = new JLabel("Selecione o Aluno:");
        lblAluno.setFont(new Font("Arial", Font.BOLD, 16));
        panelSuperior.add(lblAluno);

        // Exemplo estático de alunos
        cbAlunos = new JComboBox<>(new String[]{
            "João (20231001)",
            "Maria (20231002)",
            "Carlos (20231003)"
        });
        cbAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
        panelSuperior.add(cbAlunos);

        // Tipo de Exercício (RadioButtons)
        JLabel lblTipo = new JLabel("Tipo de Exercício:");
        lblTipo.setFont(new Font("Arial", Font.BOLD, 16));
        panelSuperior.add(lblTipo);

        rbMusculacao = new JRadioButton("Musculação");
        rbMusculacao.setBackground(Color.GRAY);
        rbMusculacao.setFont(new Font("Arial", Font.BOLD, 16));

        rbCardio = new JRadioButton("Cardio");
        rbCardio.setBackground(Color.GRAY);
        rbCardio.setFont(new Font("Arial", Font.BOLD, 16));

        bgTipoExercicio = new ButtonGroup();
        bgTipoExercicio.add(rbMusculacao);
        bgTipoExercicio.add(rbCardio);

        rbMusculacao.setSelected(true);

        // Listeners para alternar CardLayout
        ActionListener tipoListener = e -> {
            if (rbMusculacao.isSelected()) {
                cardLayout.show(panelCardLayout, "Musculação");
            } else {
                cardLayout.show(panelCardLayout, "Cardio");
            }
        };
        rbMusculacao.addActionListener(tipoListener);
        rbCardio.addActionListener(tipoListener);

        panelSuperior.add(rbMusculacao);
        panelSuperior.add(rbCardio);

        // Adiciona o painelSuperior na primeira linha do painelPrincipal
        gbc.gridy++;
        gbc.weighty = 0;
        painelPrincipal.add(panelSuperior, gbc);

        // Painel CardLayout para o tipo de exercício
        panelCardLayout = new JPanel();
        cardLayout = new CardLayout();
        panelCardLayout.setLayout(cardLayout);
        panelCardLayout.setBackground(Color.GRAY);

        // Painel Musculação
        JPanel panelMusculacao = criarPanelMusculacao();
        // Painel Cardio
        JPanel panelCardio = criarPanelCardio();

        panelCardLayout.add(panelMusculacao, "Musculação");
        panelCardLayout.add(panelCardio, "Cardio");

        // Exibe inicialmente o painel de Musculação
        cardLayout.show(panelCardLayout, "Musculação");

        gbc.gridy++;
        gbc.weighty = 0;
        painelPrincipal.add(panelCardLayout, gbc);

        JButton btnNovoExercicio = new JButton("Novo Exercício");
        btnNovoExercicio.setBackground(new Color(18,167,60));
        btnNovoExercicio.setForeground(Color.WHITE);
        btnNovoExercicio.setFocusPainted(false);
        btnNovoExercicio.setBorderPainted(true);
        btnNovoExercicio.setFont(new Font("Arial", Font.BOLD, 14));
        btnNovoExercicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNovoExercicio.setPreferredSize(new Dimension(150, 35));
        btnNovoExercicio.addActionListener(e -> adicionarExercicio());

        gbc.gridy++;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        painelPrincipal.add(btnNovoExercicio, gbc);

        // Área de exibir exercícios adicionados 
        gbc.gridy++;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        taExercicios = new JTextArea("Exercícios adicionados:\n");
        taExercicios.setEditable(false);
        taExercicios.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollExercicios = new JScrollPane(taExercicios);
        painelPrincipal.add(scrollExercicios, gbc);

        gbc.gridy++;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton btnPronto = new JButton("Pronto");
        btnPronto.setBackground(new Color(18,167,60));
        btnPronto.setForeground(Color.WHITE);
        btnPronto.setFocusPainted(false);
        btnPronto.setBorderPainted(true);
        btnPronto.setFont(new Font("Arial", Font.BOLD, 14));
        btnPronto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPronto.setPreferredSize(new Dimension(150, 35));
        btnPronto.addActionListener(e -> finalizarTreino());
        painelPrincipal.add(btnPronto, gbc);
    }

    private JPanel criarPanelMusculacao() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,5,8,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(new JLabel("Nome Exercicio:"), gbc);
        gbc.gridx = 1;
        tfNomeExercicioMusc = new JTextField(12);
        panel.add(tfNomeExercicioMusc, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Carga (kg):"), gbc);
        gbc.gridx = 1;
        tfCarga = new JTextField(6);
        panel.add(tfCarga, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Repetições:"), gbc);
        gbc.gridx = 1;
        tfRepeticoes = new JTextField(6);
        panel.add(tfRepeticoes, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Séries:"), gbc);
        gbc.gridx = 1;
        tfSeries = new JTextField(6);
        panel.add(tfSeries, gbc);

        return panel;
    }

    private JPanel criarPanelCardio() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,5,8,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Nome do exercício
        panel.add(new JLabel("Nome Exercicio:"), gbc);
        gbc.gridx = 1;
        tfNomeExercicioCardio = new JTextField(12);
        panel.add(tfNomeExercicioCardio, gbc);

        // Duração
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Duração (min):"), gbc);
        gbc.gridx = 1;
        tfDuracao = new JTextField(6);
        panel.add(tfDuracao, gbc);

        // Intensidade
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Intensidade:"), gbc);
        gbc.gridx = 1;
        tfIntensidade = new JTextField(6);
        panel.add(tfIntensidade, gbc);

        return panel;
    }

    private void adicionarExercicio() {
 
        boolean isMusc = rbMusculacao.isSelected();
        String exercicioStr = "";

        if (isMusc) {
            // Musculação
            String nome = tfNomeExercicioMusc.getText().trim();
            String carga = tfCarga.getText().trim();
            String repet = tfRepeticoes.getText().trim();
            String series = tfSeries.getText().trim();
            
            if (nome.isEmpty() || carga.isEmpty() || repet.isEmpty() || series.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos de Musculação!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            exercicioStr = String.format("[MUSCULAÇÃO] %s - Carga:%skg, Repet:%s, Séries:%s", nome, carga, repet, series);

            // Limpa campos
            tfNomeExercicioMusc.setText("");
            tfCarga.setText("");
            tfRepeticoes.setText("");
            tfSeries.setText("");
            
        } else {
            String nome = tfNomeExercicioCardio.getText().trim();
            String duracao = tfDuracao.getText().trim();
            String intensidade = tfIntensidade.getText().trim();

            if (nome.isEmpty() || duracao.isEmpty() || intensidade.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos de Cardio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            exercicioStr = String.format("[CARDIO] %s - Duração:%smin, Intensidade:%s", nome, duracao, intensidade);

            // Limpa campos
            tfNomeExercicioCardio.setText("");
            tfDuracao.setText("");
            tfIntensidade.setText("");
        }

        listaExercicios.add(exercicioStr);
        atualizarTextArea();
    }

    private void atualizarTextArea() {
        taExercicios.setText("Exercícios adicionados:\n");
        for (String ex : listaExercicios) {
            taExercicios.append(" - " + ex + "\n");
        }
    }

    private void finalizarTreino() {
        String nomeTreino = tfNomeTreino.getText().trim();
        String alunoSelecionado = (String) cbAlunos.getSelectedItem();
        
        if (nomeTreino.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do treino!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (listaExercicios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Adicione ao menos um exercício!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Exemplo de mensagem final
        JOptionPane.showMessageDialog(this, 
            "Treino criado para " + alunoSelecionado + "!\nNome do Treino: " + nomeTreino + 
            "\nExercícios: " + listaExercicios.size(), 
            "Sucesso", 
            JOptionPane.INFORMATION_MESSAGE);
        
        // Aqui poderia salvar no banco de dados, etc.
        dispose(); // fecha a tela
    }

    // Teste isolado
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCriarTreino().setVisible(true);
        });
    }
}


