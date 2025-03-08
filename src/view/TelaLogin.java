package view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import controller.InstrutorController;
import model.entities.Instrutor;

import java.io.Serializable;

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
        gbc.insets = new Insets(12, 10, 12, 10);
        
        // Linha 0: Label IFitness
        JLabel lblTitulo = new JLabel("<HTML><U>IFitness</U></HTML>");
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 56));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weighty = 0;
        painelLogin.add(lblTitulo, gbc);


        // Linha 1
        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setForeground(Color.BLACK);
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 16));
       
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        painelLogin.add(lblMatricula, gbc);

        // Linha 2
        JTextField txtMatricula = new JTextField();
        txtMatricula.setPreferredSize(new Dimension(120, 30));
        gbc.gridy++;
        painelLogin.add(txtMatricula, gbc);

        // Linha 3
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.BLACK);
        lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy++;
        painelLogin.add(lblSenha, gbc);

        // Linha 4
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setPreferredSize(new Dimension(120, 30));
        gbc.gridy++;
        painelLogin.add(txtSenha, gbc);

        // Linha 5
        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(18,167,60));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(true);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.setPreferredSize(new Dimension(120, 35));
        gbc.gridy++;
        btnLogin.addActionListener(e -> {
        	
        	String matricula = txtMatricula.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();
            
            //fazer como uma exceção 
            if (matricula.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            InstrutorController instrutorController = new InstrutorController();
            Instrutor instrutorLogado = instrutorController.autenticarInstrutor(matricula, senha);

            if (instrutorLogado != null) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                new TelaMenu(instrutorLogado).setVisible(true); // Abre a tela do menu com o instrutor logado
                dispose(); // Fecha a tela de login
            } else {
                JOptionPane.showMessageDialog(this, "Matrícula ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        });
        
        painelLogin.add(btnLogin, gbc);

        // Linha 6
        JLabel lblCadastro = new JLabel("<HTML><U>Não possui cadastro? Cadastre clicando aqui</U></HTML>");
        gbc.gridy++;
        lblCadastro.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCadastro.setForeground(new Color(18,167,60));
        lblCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblCadastro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	new TelaCadastroInstrutor().setVisible(true);
                dispose();
            }
        });
       
        painelLogin.add(lblCadastro, gbc);
        
        gbc.gridy++;
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
        ImageIcon iconeOriginal = new ImageIcon(getClass().getResource("/view/resource/Atleta.png"));
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
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
    
}
