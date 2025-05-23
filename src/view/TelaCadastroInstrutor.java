package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.InstrutorController;
import model.util.Excecoes;

public class TelaCadastroInstrutor extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InstrutorController instrutorController;

	public TelaCadastroInstrutor(InstrutorController instrutorController) {
        super("IFitness");
        this.instrutorController = instrutorController;
        inicializarComponentes();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {

        setLayout(new BorderLayout());

        JPanel painelEsquerdo = criarPainelCadastro();
        JPanel painelDireito = criarPainelImagem();
        
        painelEsquerdo.setPreferredSize(new Dimension(540, 0)); 

        add(painelEsquerdo, BorderLayout.WEST);
        add(painelDireito, BorderLayout.CENTER);
    }

    private JPanel criarPainelCadastro() {
        JPanel painelCadastro = new JPanel();
        painelCadastro.setBackground(Color.WHITE);
        painelCadastro.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(12, 10, 12, 10);

        // Linha 0: Label "IFitness"
        JLabel lblTitulo = new JLabel("<HTML><U>IFitness</U></HTML>");
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 56));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weighty = 0;
        painelCadastro.add(lblTitulo, gbc);

        // Linha 1
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial", Font.BOLD, 16));
        lblNome.setForeground(Color.BLACK);
        gbc.gridx=0;
        gbc.gridy++;
        gbc.gridwidth = 6;
        painelCadastro.add(lblNome, gbc);

        // Linha 2
        JTextField txtNome = new JTextField();
        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNome.setPreferredSize(new Dimension(120, 30));
        painelCadastro.add(txtNome, gbc);

        // Linha 3
        gbc.gridy++;
        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setFont(new Font("Arial", Font.BOLD, 16));
        lblIdade.setForeground(Color.BLACK);
        painelCadastro.add(lblIdade, gbc);
        
     // Linha 4: JComboBox para selecionar a idade
        gbc.gridy++;
        Integer[] idades = new Integer[80 - 18 + 1];
        for (int i = 18; i <= 80; i++) {
            idades[i - 18] = i;
        }
        JComboBox<Integer> cbIdade = new JComboBox<>(idades);
        painelCadastro.add(cbIdade, gbc);

        // Linha 5
        gbc.gridy++;
        JLabel lblMatricula = new JLabel("Nº de matrícula: (5 dígitos)");
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 16));
        lblMatricula.setForeground(Color.BLACK);
        painelCadastro.add(lblMatricula, gbc);

        // Linha 6
        JTextField txtMatricula = new JTextField();
        txtMatricula.setPreferredSize(new Dimension(120, 30));
        gbc.gridy++;
        painelCadastro.add(txtMatricula, gbc);

        // Linha 7
        gbc.gridy++;
        JLabel lblSenha = new JLabel("Senha: (6 dígitos)");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
        lblSenha.setForeground(Color.BLACK);
        painelCadastro.add(lblSenha, gbc);

        // Linha 8
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setPreferredSize(new Dimension(120, 30));
        gbc.gridy++;
        painelCadastro.add(txtSenha, gbc);

        // Linha 9
        gbc.gridy++;
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBackground(new Color(18,167,60));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(true);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCadastrar.setPreferredSize(new Dimension(120, 35));
        painelCadastro.add(btnCadastrar, gbc);
        
        gbc.gridy++;
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
             new TelaLogin(instrutorController).setVisible(true);
             dispose();
            }
        });
        
        gbc.gridy++;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        painelCadastro.add(btnVoltar, gbc);
        
        btnCadastrar.addActionListener(new ActionListener () {
            
			@Override
			public void actionPerformed(ActionEvent e) {
				tentarCadastro(txtNome.getText().trim(), txtMatricula.getText().trim(), 
				new String (txtSenha.getPassword()).trim(), (int) cbIdade.getSelectedItem());
				
			}
        });

        gbc.gridy++;
        gbc.weighty = 1;
        painelCadastro.add(Box.createVerticalStrut(10), gbc);

        return painelCadastro;
    }
    
    private void tentarCadastro(String nome, String matricula, String senha, int idade) {
        
    	try {
       	 
    			if (matricula.isEmpty() && senha.isEmpty() && nome.isEmpty()) { 
    				throw new Excecoes("Preencha todos os campos!");
    			}
        
    			if(matricula.isEmpty()){ 
    				throw new Excecoes("Digite a matricula!");
    			}
    	 
    			if (senha.isEmpty()) { 
    				throw new Excecoes("Insira a senha!");
    			}
    		
    			if(nome.isEmpty()){ 
    				throw new Excecoes("Digite o nome!");
        		}
    	
    			boolean sucesso = instrutorController.cadastrarInstrutor(nome, idade, matricula, senha);

    			if (sucesso) {
    				JOptionPane.showMessageDialog(TelaCadastroInstrutor.this, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    				new TelaLogin(instrutorController).setVisible(true);
    				dispose();
    			} else {
    				JOptionPane.showMessageDialog(TelaCadastroInstrutor.this, "Matrícula já cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);
    				}
    		} catch(Excecoes e){
    			JOptionPane.showMessageDialog(TelaCadastroInstrutor.this, e.getMessage(), "Algo deu Errado... :(",JOptionPane.ERROR_MESSAGE);
    			return;
       	 		}
    }
    
    
    private JPanel criarPainelImagem() {
        JPanel painelImagem = new JPanel(new BorderLayout());
        painelImagem.setBackground(Color.WHITE);

        // Obtém dimensoes tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int painelDireitoWidth = screenSize.width - 540;
        int painelDireitoHeight = screenSize.height;

        // Carrega a imagem
        ImageIcon iconeOriginal = new ImageIcon(getClass().getResource("/view/resource/Atleta.png"));
        Image imgOriginal = iconeOriginal.getImage();

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
}
