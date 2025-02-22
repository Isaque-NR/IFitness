package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TelaLogin extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaLogin() {
        super("IFitness");
        inicializarComponentes();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        
        setLayout(new BorderLayout());

        JPanel painelEsquerdo = criarPainelLogin();
        JPanel painelDireito = criarPainelImagem();

        painelEsquerdo.setPreferredSize(new Dimension(540, 0));
        
        add(painelEsquerdo, BorderLayout.WEST);
        add(painelDireito, BorderLayout.CENTER);
    }

    private JPanel criarPainelLogin() {
        JPanel painelLogin = new JPanel();
        painelLogin.setBackground(Color.WHITE);
        painelLogin.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(18, 10, 15, 10);
        
        // Linha 0: Label IFitness
        JLabel lblTitulo = new JLabel("IFitness");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 56));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weighty = 0;
        painelLogin.add(lblTitulo, gbc);

        // Linha 1: Label "Selecione o tipo de Usuário"
        JLabel lblSelecioneTipo = new JLabel("Selecione o tipo de Usuário:");
        lblSelecioneTipo.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSelecioneTipo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        painelLogin.add(lblSelecioneTipo, gbc);

        // Linha 2: Botões ALUNO e INSTRUTOR
        gbc.gridwidth = 1;
        gbc.gridy = 2;

        JButton btnAluno = new JButton("ALUNO");
        estilizarBotaoVerde(btnAluno);
        gbc.gridx = 0;
        painelLogin.add(btnAluno, gbc);

        JButton btnInstrutor = new JButton("INSTRUTOR");
        estilizarBotaoVerde(btnInstrutor);
        gbc.gridx = 1;
        painelLogin.add(btnInstrutor, gbc);

        // Linha 3: Label Matrícula
        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        painelLogin.add(lblMatricula, gbc);

        // Linha 4: Campo de texto para Matrícula
        JTextField txtMatricula = new JTextField();
        gbc.gridy = 4;
        painelLogin.add(txtMatricula, gbc);

        // Linha 5: Label Senha
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 5;
        painelLogin.add(lblSenha, gbc);

        // Linha 6: Campo de senha
        JPasswordField txtSenha = new JPasswordField();
        gbc.gridy = 6;
        painelLogin.add(txtSenha, gbc);

        // Linha 7: Botão login
        JButton btnLogin = new JButton("Login");
        estilizarBotaoVerde(btnLogin);
        gbc.gridy = 7;
        painelLogin.add(btnLogin, gbc);

        // Linha 8: Label "Não possui cadastro? Cadastre clicando aqui"
        JLabel lblCadastro = new JLabel("<HTML><U>Não possui cadastro? Cadastre clicando aqui</U></HTML>");
        gbc.gridy = 8;
        lblCadastro.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCadastro.setForeground(new Color(0, 153, 0));
        lblCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblCadastro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Aqui você poderia chamar outra tela ou fazer alguma ação
                System.out.println("Clique no link de cadastro");
            }
        });
       
        painelLogin.add(lblCadastro, gbc);
        
        gbc.gridy = 9;
        gbc.weighty = 1;
        painelLogin.add(Box.createVerticalStrut(10), gbc);

        return painelLogin;
    }

    private JPanel criarPainelImagem() {
        JPanel painelImagem = new JPanel(new BorderLayout());
        painelImagem.setBackground(Color.WHITE);

        // Obtém o tamanho da tela (full screen)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       
        int painelDireitoWidth = screenSize.width - 540;
        int painelDireitoHeight = screenSize.height;

        // Carrega a imagem do corredor do pacote resources
        ImageIcon iconeOriginal = new ImageIcon(getClass().getResource("/resources/Atleta.png"));
        Image imgOriginal = iconeOriginal.getImage();

        // Redimensiona a imagem para ocupar todo o painel direito
        Image imgRedimensionada = imgOriginal.getScaledInstance(
                painelDireitoWidth,
                painelDireitoHeight,
                Image.SCALE_SMOOTH
        );
        ImageIcon iconeRedimensionado = new ImageIcon(imgRedimensionada);

        JLabel lblImagem = new JLabel(iconeRedimensionado);
        lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagem.setVerticalAlignment(SwingConstants.CENTER);

        painelImagem.add(lblImagem, BorderLayout.CENTER);

        return painelImagem;
    }

    private void estilizarBotaoVerde(JButton botao) {
        Color verde = new Color(0, 153, 0);
        botao.setBackground(verde);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botao.setPreferredSize(new Dimension(120, 35));
    }

    // Método main para testar a tela isoladamente
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}
