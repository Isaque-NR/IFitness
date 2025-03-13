package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Iterator;

import model.entities.Aluno;
import model.entities.Instrutor;
import model.entities.Treinos;
import controller.InstrutorController;

public class DialogRemoverTreino extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTextField txtMatricula;
    private JTextField txtNomeTreino;
    private Instrutor instrutorLogado;
    private InstrutorController instrutorController;
    

    public DialogRemoverTreino(Frame telaMenu, Instrutor instrutorLogado, InstrutorController instrutorController) {
        super(telaMenu, "Remover Treino", true);
        inicializarComponentes();
        this.instrutorLogado = instrutorLogado;
        this.instrutorController = instrutorController;
        setPreferredSize(new Dimension(420,250));
        pack();
        setLocationRelativeTo(telaMenu);
    }

    private void inicializarComponentes() {
        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        getContentPane().add(painelPrincipal);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblMatricula = new JLabel("Matrícula do Aluno:");
        painelPrincipal.add(lblMatricula, gbc);

        gbc.gridy++;
        txtMatricula = new JTextField(15);
        txtMatricula.setPreferredSize(new Dimension(100,30));
        txtMatricula.setFont(new Font ("Arial", Font.BOLD, 14));
        painelPrincipal.add(txtMatricula, gbc);

        gbc.gridy++;
        JLabel lblNomeTreino = new JLabel("Nome do Treino:");
        painelPrincipal.add(lblNomeTreino, gbc);

        gbc.gridy++;
        txtNomeTreino = new JTextField(15);
        txtNomeTreino.setPreferredSize(new Dimension(100,30));
        txtNomeTreino.setFont(new Font ("Arial", Font.BOLD, 14));
        painelPrincipal.add(txtNomeTreino, gbc);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton btnRemover = new JButton("Remover");
        btnRemover.setBackground(new Color(18,167,60));
        btnRemover.setForeground(Color.WHITE);
        btnRemover.setFont(new Font("Arial", Font.BOLD, 14));
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(18,167,60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
        
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnCancelar);

        gbc.gridy++;
        painelPrincipal.add(painelBotoes, gbc);

        // Ação para o botão Remover
        btnRemover.addActionListener(new ActionListener () {
      
		@Override
		public void actionPerformed(ActionEvent e) {
			String matricula = txtMatricula.getText().trim();
	          String nomeTreino = txtNomeTreino.getText().trim();
	          if (matricula.isEmpty() || nomeTreino.isEmpty()) {
	             JOptionPane.showMessageDialog(
	             DialogRemoverTreino.this,"Por favor, preencha a matrícula e o nome do treino.",
	             "Erro", JOptionPane.ERROR_MESSAGE);
	                   
	             return;
	          }
	                               
	           	Aluno aluno = instrutorLogado.consultarAluno(matricula);
	                
	           	if(aluno != null) {	                	                           
	              
	              Iterator<Treinos> iterator = aluno.getMeusTreinos().iterator();
	              while (iterator.hasNext()) {
	                  Treinos treino = iterator.next();
	                  if (treino.getNome().equals(nomeTreino)) {
	                      
	  	                instrutorLogado.dissociarTreino(aluno, treino);
	  	                instrutorController.atualizarDados(instrutorLogado);
	  	                    
	  	                JOptionPane.showMessageDialog(DialogRemoverTreino.this, "Treino--> " + nomeTreino +
	  	                "\n" + "Do aluno de matrícula " + matricula + " foi removido com sucesso!",
	  	                "Treino removido", JOptionPane.INFORMATION_MESSAGE);
	  	                break;
	  	               } else {
	  	                 JOptionPane.showMessageDialog(DialogRemoverTreino.this, "Treino não encontrado!",
	  	                 "Erro", JOptionPane.ERROR_MESSAGE);
	  	                 }  
	  	              
	  	                	
	  	           } 
	             
               } else {
	  	          JOptionPane.showMessageDialog(DialogRemoverTreino.this, "Aluno não encontrado!",
	  	          "Erro", JOptionPane.ERROR_MESSAGE);
	  	          }
	     }
           
    });

        // Ação para o botão Cancelar
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
