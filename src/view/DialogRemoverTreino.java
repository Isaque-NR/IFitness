package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogRemoverTreino extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTextField txtMatricula;
    private JTextField txtNomeTreino;

    public DialogRemoverTreino(Frame telaMenu) {
        super(telaMenu, "Remover Treino", true);
        inicializarComponentes();
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
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = txtMatricula.getText().trim();
                String nomeTreino = txtNomeTreino.getText().trim();
                if (matricula.isEmpty() || nomeTreino.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        DialogRemoverTreino.this,
                        "Por favor, preencha a matrícula e o nome do treino.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
                // Aqui você implementará a lógica de remoção real
                JOptionPane.showMessageDialog(
                    DialogRemoverTreino.this,
                    "Treino \"" + nomeTreino + "\" removido do aluno com matrícula " + matricula + "!",
                    "Remoção",
                    JOptionPane.INFORMATION_MESSAGE
                );
                dispose(); // Fecha o diálogo
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
