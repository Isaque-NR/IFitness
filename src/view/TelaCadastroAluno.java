package view;

import java.awt.*;
import javax.swing.*;

import controller.InstrutorController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entities.Aluno;
import model.entities.Instrutor;
import model.fabrica.Fabrica;
import model.util.Excecoes;

public class TelaCadastroAluno extends JFrame {

    private static final long serialVersionUID = 1L;
    private Instrutor instrutorLogado;
    private InstrutorController instrutorController;
    
    public TelaCadastroAluno(Instrutor instrutorLogado, InstrutorController instrutorController) {
        super("IFitness");
        this.instrutorLogado = instrutorLogado;
        this.instrutorController = instrutorController;
        inicializarComponentes();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
    	
        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setBackground(Color.GRAY);
        setContentPane(painelPrincipal);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy++;
        painelPrincipal.add(lblNome, gbc);

        JTextField txtNome = new JTextField();
        txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy++;
        painelPrincipal.add(txtNome, gbc);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        painelPrincipal.add(lblIdade, gbc);

        // ComboBox de 12 a 80
        Integer[] idades = new Integer[80 - 12 + 1];
        for (int i = 12; i <= 80; i++) {
            idades[i - 12] = i;
        }
        JComboBox<Integer> cbIdade = new JComboBox<>(idades);
        cbIdade.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy++;
        painelPrincipal.add(cbIdade, gbc);

        JLabel lblMatricula = new JLabel("Matrícula: (5 dígitos)");
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        painelPrincipal.add(lblMatricula, gbc);

        JTextField txtMatricula = new JTextField();
        txtMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy++;
        painelPrincipal.add(txtMatricula, gbc);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        painelPrincipal.add(lblSexo, gbc);

        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        painelSexo.setBackground(Color.GRAY);

        JRadioButton rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setFont(new Font("Arial", Font.PLAIN, 16));
        rbMasculino.setBackground(Color.GRAY);

        JRadioButton rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setFont(new Font("Arial", Font.PLAIN, 16));
        rbFeminino.setBackground(Color.GRAY);

        ButtonGroup bgSexo = new ButtonGroup();
        bgSexo.add(rbMasculino);
        bgSexo.add(rbFeminino);

        painelSexo.add(rbMasculino);
        painelSexo.add(rbFeminino);

        gbc.gridy++;
        painelPrincipal.add(painelSexo, gbc);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        painelPrincipal.add(lblPeso, gbc);

        JTextField txtPeso = new JTextField();
        txtPeso.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy++;
        painelPrincipal.add(txtPeso, gbc);

        JLabel lblAltura = new JLabel("Altura (m):");
        lblAltura.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        painelPrincipal.add(lblAltura, gbc);

        JTextField txtAltura = new JTextField();
        txtAltura.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy++;
        painelPrincipal.add(txtAltura, gbc);

        JLabel lblLimitacoes = new JLabel("Limitações físicas/saúde:");
        lblLimitacoes.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        painelPrincipal.add(lblLimitacoes, gbc);
        
        JTextField txtLimitacoes = new JTextField();
        txtLimitacoes.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy++;
        painelPrincipal.add(txtLimitacoes, gbc);

        JButton btnCadastrar = new JButton("Cadastrar Aluno");
		btnCadastrar.setBackground(new Color(18,167,60));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(true);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCadastrar.setPreferredSize(new Dimension(140, 35));
        btnCadastrar.addActionListener(new ActionListener () {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cadastrarAluno(txtNome.getText().trim(), 12+cbIdade.getSelectedIndex(), 
			             txtMatricula.getText().trim(), (rbMasculino.isSelected()) ? "Masculino" : "Feminino", 
			             Double.parseDouble(txtPeso.getText().trim()) , Double.parseDouble(txtAltura.getText().trim()), 
			             txtLimitacoes.getText().trim());
			}
        });
        
        gbc.gridy++;
        painelPrincipal.add(btnCadastrar, gbc);
        
        
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(18,167,60));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorderPainted(true);
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVoltar.setPreferredSize(new Dimension(140, 35));
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new TelaMenu(instrutorLogado, instrutorController).setVisible(true);
             dispose();
            }
        });

        gbc.gridy++;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        painelPrincipal.add(btnVoltar, gbc);

        painelPrincipal.add(Box.createVerticalStrut(10), gbc);
    }
    
    private void cadastrarAluno (String nome, int idade, String matricula, String sexo, double peso, 
        double altura, String limitacoes) {
    	
    	try {
       	 
    		if (matricula.isEmpty() && nome.isEmpty() && limitacoes.isEmpty()) { 
        	throw new Excecoes("Preencha todos os campos!");
    		}
        
    		if(matricula.isEmpty()){ 
         	throw new Excecoes("Digite a Matricula!");
    		}
    	 
    		if (nome.isEmpty()) { 
    		 throw new Excecoes("Insira o nome!");
    		}
    	 
    		Aluno novoAluno = Fabrica.getAluno(nome, idade, matricula, sexo, peso, altura, limitacoes);

        	instrutorLogado.addAlunoInstrutor(novoAluno);
        	instrutorController.atualizarDados(instrutorLogado);
        	new TelaMenu(instrutorLogado, instrutorController).setVisible(true);
        	dispose();	
    	
    	}catch(Excecoes e){
    	 JOptionPane.showMessageDialog(TelaCadastroAluno.this, e.getMessage(), "Algo deu Errado... :(",JOptionPane.ERROR_MESSAGE);
    	 return;
    	 }
    	
    }
}

