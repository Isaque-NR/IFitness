package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.InstrutorController;
import model.entities.Instrutor;

public class TelaMenu extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Instrutor instrutorLogado;
	private InstrutorController instrutorController;
	
	public TelaMenu(Instrutor instrutorLogado, InstrutorController instrutorController) {
        super("IFitness");
        inicializarComponentes();
        this.instrutorLogado = instrutorLogado;
        this.instrutorController = instrutorController;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        // Painel de fundo com a imagem do corredor ofuscado
        PainelFundo painelFundo = new PainelFundo();
        
        painelFundo.setLayout(new GridBagLayout());
        setContentPane(painelFundo);

        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.insets = new Insets(80, 15, 0, 15);
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        
        JLabel lblTitulo = new JLabel("<HTML><U>IFitness</U></HTML>");
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 60));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        painelFundo.add(lblTitulo, gbc);
     
        gbc.gridy = 1;
        gbc.weighty = 0;
        painelFundo.add(new JLabel(), gbc);
        
        // Cria um painel para agrupar os 6 botões
        JPanel painelBotoes = new JPanel(new GridLayout(3, 2, 150, 60));
        painelBotoes.setOpaque(false);

        JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
        btnCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroAluno(instrutorLogado,instrutorController).setVisible(true);
                dispose();
            }
        });
        JButton btnListarAlunos = new JButton("Listar Alunos");
        btnListarAlunos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaListaAlunos(instrutorLogado, instrutorController).setVisible(true);
	        	dispose();				
			}
        	
        });
        
        JButton btnConsultarAluno = new JButton("Consultar Aluno");
        btnConsultarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaConsultaAluno(instrutorLogado, instrutorController).setVisible(true);
                dispose();
            }
        });
        JButton btnRemoverAluno = new JButton("Remover Aluno");
        btnRemoverAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogRemoverAluno dialog = new DialogRemoverAluno(TelaMenu.this, instrutorLogado, instrutorController);
                dialog.setVisible(true);
            }
        });
        
        JButton btnCriarTreino = new JButton("Criar Treino");
        btnCriarTreino.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCriarTreino(instrutorLogado, instrutorController).setVisible(true);
				dispose();
			}
        	
        });
        
        JButton btnApagarTreino = new JButton("Apagar Treino");
        btnApagarTreino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogRemoverTreino dialog = new DialogRemoverTreino(TelaMenu.this, instrutorLogado, instrutorController);
                dialog.setVisible(true);
                
            }
        });
                

        // Estiliza todos com o mesmo padrão
        estilizarBotaoVerde(btnCadastrarAluno);
        estilizarBotaoVerde(btnListarAlunos);
        estilizarBotaoVerde(btnConsultarAluno);
        estilizarBotaoVerde(btnRemoverAluno);
        estilizarBotaoVerde(btnCriarTreino);
        estilizarBotaoVerde(btnApagarTreino);

        painelBotoes.add(btnCadastrarAluno);
        painelBotoes.add(btnListarAlunos);
        painelBotoes.add(btnConsultarAluno);
        painelBotoes.add(btnRemoverAluno);
        painelBotoes.add(btnCriarTreino);
        painelBotoes.add(btnApagarTreino);

        gbc.gridy = 2;
        gbc.weighty = 0; 
        gbc.anchor = GridBagConstraints.CENTER;
        painelFundo.add(painelBotoes, gbc);

        gbc.gridy = 3;
        gbc.weighty = 1;
        painelFundo.add(new JLabel(), gbc);
    }

    private void estilizarBotaoVerde(JButton botao) {
 
        botao.setBackground(new Color(18,167,60)); 
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorderPainted(true);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botao.setPreferredSize(new Dimension(165, 35)); 
    }

    // Painel personalizado para desenhar a imagem de fundo com alpha
    private class PainelFundo extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image imagemFundo;

        public PainelFundo() {
                ImageIcon iconeOriginal = new ImageIcon(getClass().getResource("/view/resource/Atleta.png"));
                imagemFundo = iconeOriginal.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (imagemFundo != null) {
                Graphics2D g2d = (Graphics2D) g.create();

                // Define o alpha para 25% opaco
                float alpha = 0.25f; 
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

                // Desenha a imagem redimensionada para preencher o painel
                g2d.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        }
    }  
}

