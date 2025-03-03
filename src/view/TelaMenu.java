package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaMenu extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaMenu() {
        super("IFitness");
        inicializarComponentes();
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
        JButton btnListarAlunos = new JButton("Listar Alunos");
        JButton btnConsultarAluno = new JButton("Consultar Aluno");
        JButton btnRemoverAluno = new JButton("Remover Aluno");
        btnRemoverAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Supondo que "this" seja um JFrame do menu
                DialogRemoverAluno dialog = new DialogRemoverAluno(TelaMenu.this);
                dialog.setVisible(true);
                // Aqui, quando o diálogo fechar, você pode atualizar a tela de menu, se necessário
            }
        });
        JButton btnCriarTreino = new JButton("Criar Treino");
        JButton btnApagarTreino = new JButton("Apagar Treino");
        btnApagarTreino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Supondo que "this" seja um JFrame do menu
                DialogRemoverTreino dialog = new DialogRemoverTreino(TelaMenu.this);
                dialog.setVisible(true);
                // Aqui, quando o diálogo fechar, você pode atualizar a tela de menu, se necessário
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
                ImageIcon iconeOriginal = new ImageIcon(getClass().getResource("/resources/Atleta.png"));
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

    // Teste isolado
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaMenu().setVisible(true);
        });
    }
}

