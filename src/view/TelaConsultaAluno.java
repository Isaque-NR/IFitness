package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.entities.Instrutor;
import model.entities.Aluno;
import model.entities.Treinos;

public class TelaConsultaAluno extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panelDados;
    private JTextField txtMatricula;
    private Instrutor instrutorLogado;

    public TelaConsultaAluno(Instrutor instrutorLogado) {
        super("IFitness");
        this.instrutorLogado = instrutorLogado;
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
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        
        JLabel lblTitulo = new JLabel("Consultar Aluno");
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 32));
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        painelPrincipal.add(lblTitulo, gbc);
        
        JPanel panelBusca = new JPanel(new FlowLayout(FlowLayout.CENTER,40,5));
        panelBusca.setBackground(Color.GRAY);
        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 16));
        txtMatricula = new JTextField(10);
        txtMatricula.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(18,167,60));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorderPainted(true);
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 14));
        btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBuscar.setPreferredSize(new Dimension(120, 25));
        
        panelBusca.add(lblMatricula);
        panelBusca.add(txtMatricula);
        panelBusca.add(btnBuscar);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        painelPrincipal.add(panelBusca, gbc);
        
        // Painel para exibir os dados do aluno
        panelDados = new JPanel(new GridBagLayout());
        panelDados.setBackground(Color.WHITE);
        panelDados.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        GridBagConstraints gbcPlaceholder = new GridBagConstraints();
        gbcPlaceholder.insets = new Insets(12, 10, 10, 10);
        JLabel lblPlaceholder = new JLabel("Nenhum aluno consultado. Insira a matrícula e clique Buscar.");
        lblPlaceholder.setFont(new Font("Arial", Font.ITALIC, 16));
        lblPlaceholder.setForeground(Color.GRAY);
        panelDados.add(lblPlaceholder, gbcPlaceholder);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        painelPrincipal.add(panelDados, gbc);
        
        JPanel panelVoltar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelVoltar.setBackground(Color.GRAY);
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(18,167,60));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorderPainted(true);
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVoltar.setPreferredSize(new Dimension(120, 25));
          
        panelVoltar.add(btnVoltar);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        painelPrincipal.add(panelVoltar, gbc);
        
        // Ação do botão Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             buscarAluno(txtMatricula.getText().trim());
            }
        });
    }
    
    // Simula a consulta do aluno e atualiza o painel de dados
    private void buscarAluno(String matriculaConsulta) {
        if(matriculaConsulta.isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor, insira uma "
            		+ "matrícula válida.", "Erro", 
            		JOptionPane.ERROR_MESSAGE);
            return;
        }
        Aluno alunoBuscado = instrutorLogado.consultarAluno(matriculaConsulta);
        if(alunoBuscado == null) {
        	JOptionPane.showMessageDialog(this, "Intrutor não possui o aluno ", "Erro", 
            JOptionPane.ERROR_MESSAGE);
        }
        
        panelDados.removeAll();
        panelDados.setLayout(new GridBagLayout());
        GridBagConstraints gbcDados = new GridBagConstraints();
        gbcDados.insets = new Insets(5, 5, 5, 5);
        gbcDados.anchor = GridBagConstraints.WEST;
        gbcDados.fill = GridBagConstraints.HORIZONTAL;
        gbcDados.gridx = 0;
        gbcDados.weightx = 1;

        int linha = 0;
        
        // Nome
        panelDados.add(new JLabel("Nome:"), gbcDados);
        gbcDados.gridx = 1;
        panelDados.add(new JLabel(alunoBuscado.getNome()), gbcDados);
        gbcDados.gridx = 0;
        gbcDados.gridy= ++linha;
        
        // Idade
        panelDados.add(new JLabel("Idade:"), gbcDados);
        gbcDados.gridx = 1;
        panelDados.add(new JLabel(String.valueOf(alunoBuscado.getIdade())), gbcDados);
        gbcDados.gridx = 0;
        gbcDados.gridy= ++linha;
        
        // Sexo
        panelDados.add(new JLabel("Sexo:"), gbcDados);
        gbcDados.gridx = 1;
        panelDados.add(new JLabel(alunoBuscado.getSexo()), gbcDados);
        gbcDados.gridx = 0;
       	gbcDados.gridy= ++linha;
        
        // Matrícula
        panelDados.add(new JLabel("Matrícula:"), gbcDados);
        gbcDados.gridx = 1;
        panelDados.add(new JLabel(alunoBuscado.getMatricula()), gbcDados);
        gbcDados.gridx = 0;
        gbcDados.gridy= ++linha;
        
        // Peso
        panelDados.add(new JLabel("Peso:"), gbcDados);
        gbcDados.gridx = 1;
        panelDados.add(new JLabel(String.valueOf(alunoBuscado.getPeso())), gbcDados);
        gbcDados.gridx = 0;
        gbcDados.gridy= ++linha;;
        
        // Altura
        panelDados.add(new JLabel("Altura:"), gbcDados);
        gbcDados.gridx = 1;
        panelDados.add(new JLabel(String.valueOf(alunoBuscado.getAltura())), gbcDados);
        gbcDados.gridx = 0;
        gbcDados.gridy= ++linha;
        
        // Limitações
        panelDados.add(new JLabel("Limitações:"), gbcDados);
        gbcDados.gridx = 1;
        panelDados.add(new JLabel(alunoBuscado.getLimitacoesFisicasOuSaude()), gbcDados);
        gbcDados.gridx = 0;
        gbcDados.gridy= ++linha;
        
        // Treinos
        gbcDados.gridwidth = 2;
        panelDados.add(new JLabel("Treinos:"), gbcDados);
        gbcDados.gridy= ++linha;
        
        String treinos = "";
        for(Treinos t : alunoBuscado.getMeusTreinos()) {
        	treinos += t.toString();
        }
        JTextArea taTreinos = new JTextArea(treinos);
        taTreinos.setFont(new Font("Arial", Font.PLAIN, 14));
        taTreinos.setEditable(false);
        taTreinos.setLineWrap(true);
        taTreinos.setWrapStyleWord(true);
        JScrollPane scrollTreinos = new JScrollPane(taTreinos);
        scrollTreinos.setPreferredSize(new Dimension(400, 200));
        gbcDados.gridy++;
        panelDados.add(scrollTreinos, gbcDados);
        
        // Atualiza o painel
        panelDados.revalidate();
        panelDados.repaint();
    }
}


