package view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TelaCadastroAluno extends JFrame {

    private static final long serialVersionUID = 1L;

    public TelaCadastroAluno() {
        super("IFitness");
        inicializarComponentes();
        configurarJanela();
    }

    private void inicializarComponentes() {
        // Painel principal (fundo branco)
        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setBackground(Color.WHITE);
        setContentPane(painelPrincipal);

        // GridBagConstraints para organizar
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        int linha = 0;

        // ====== Nome ======
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = linha++;
        painelPrincipal.add(lblNome, gbc);

        JTextField txtNome = new JTextField();
        txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = linha++;
        painelPrincipal.add(txtNome, gbc);

        // ====== Idade ======
        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = linha++;
        painelPrincipal.add(lblIdade, gbc);

        // ComboBox de 16 a 80
        Integer[] idades = new Integer[80 - 12 + 1];
        for (int i = 12; i <= 80; i++) {
            idades[i - 12] = i;
        }
        JComboBox<Integer> cbIdade = new JComboBox<>(idades);
        cbIdade.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = linha++;
        painelPrincipal.add(cbIdade, gbc);

        // ====== Matrícula ======
        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = linha++;
        painelPrincipal.add(lblMatricula, gbc);

        JTextField txtMatricula = new JTextField();
        txtMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = linha++;
        painelPrincipal.add(txtMatricula, gbc);

        // ====== Sexo (RadioButtons) ======
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = linha++;
        painelPrincipal.add(lblSexo, gbc);

        // Painel horizontal para agrupar os dois botões
        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        painelSexo.setBackground(Color.WHITE);

        JRadioButton rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setFont(new Font("Arial", Font.PLAIN, 14));
        rbMasculino.setBackground(Color.WHITE);

        JRadioButton rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setFont(new Font("Arial", Font.PLAIN, 14));
        rbFeminino.setBackground(Color.WHITE);

        // Agrupa os RadioButtons para permitir apenas uma seleção
        ButtonGroup bgSexo = new ButtonGroup();
        bgSexo.add(rbMasculino);
        bgSexo.add(rbFeminino);

        painelSexo.add(rbMasculino);
        painelSexo.add(rbFeminino);

        // Adiciona o painelSexo ao painelPrincipal
        gbc.gridy = linha++;
        painelPrincipal.add(painelSexo, gbc);

        // ====== Peso ======
        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = linha++;
        painelPrincipal.add(lblPeso, gbc);

        JTextField txtPeso = new JTextField();
        txtPeso.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = linha++;
        painelPrincipal.add(txtPeso, gbc);

        // ====== Altura ======
        JLabel lblAltura = new JLabel("Altura (m):");
        lblAltura.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = linha++;
        painelPrincipal.add(lblAltura, gbc);

        JTextField txtAltura = new JTextField();
        txtAltura.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = linha++;
        painelPrincipal.add(txtAltura, gbc);

        // ====== Limitações ======
        JLabel lblLimitacoes = new JLabel("Limitações:");
        lblLimitacoes.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = linha++;
        painelPrincipal.add(lblLimitacoes, gbc);

        JTextField txtLimitacoes = new JTextField();
        txtLimitacoes.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = linha++;
        painelPrincipal.add(txtLimitacoes, gbc);

        // ====== Botão "Cadastrar" ======
        JButton btnCadastrar = new JButton("Cadastrar");
        estilizarBotaoVerde(btnCadastrar);
        gbc.gridy = linha++;
        painelPrincipal.add(btnCadastrar, gbc);

        // Exemplo de evento (sem lógica real):
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você poderia capturar os valores e salvar no banco
                System.out.println("Aluno cadastrado!");
            }
        });

        // Espaçador final para empurrar tudo pro topo
        gbc.weighty = 1;
        gbc.gridy = linha++;
        painelPrincipal.add(Box.createVerticalStrut(10), gbc);
    }

    private void estilizarBotaoVerde(JButton botao) {
        botao.setBackground(new Color(18,167,60));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorderPainted(true);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botao.setPreferredSize(new Dimension(140, 35));
    }

    private void configurarJanela() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Teste isolado
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastroAluno().setVisible(true);
        });
    }
}

