package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaListaAlunos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable tabelaAlunos;
    private DefaultTableModel modeloTabela;

    public TelaListaAlunos() {
        super("IFitness");
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
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.weightx = 1;

        // Tabela
        
        // Colunas
        String[] colunas = { "Nome", "Idade", "Matrícula" };
        
        // Dados de exemplo (substituir com os dados reais)
        Object[][] dadosExemplo = {
            {"João da Silva", 25, "31001"},
            {"Maria Oliveira", 30, "31002"},
            {"Carlos Souza", 22, "31003"},
            {"Ana Paula", 29, "20004"},
            {"Bruno Lima", 40, "20231"},
        };

        modeloTabela = new DefaultTableModel(dadosExemplo, colunas) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaAlunos = new JTable(modeloTabela);
        tabelaAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaAlunos.setRowHeight(20);
        tabelaAlunos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        // Centraliza o conteúdo das células:
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tabelaAlunos.getColumnCount(); i++) {
            tabelaAlunos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollTabela = new JScrollPane(tabelaAlunos);
        scrollTabela.setPreferredSize(new Dimension(600, 400));

        // Linha 0: Tabela com scroll
        gbc.gridy = 0;
        gbc.weighty = 1; 
        painelPrincipal.add(scrollTabela, gbc);

        JPanel painelbtnVoltarVoltar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelbtnVoltarVoltar.setOpaque(false); 
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(18,167,60));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorderPainted(true);
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnVoltar.setPreferredSize(new Dimension(120, 35)); // Botão compacto
        painelbtnVoltarVoltar.add(btnVoltar);

        // Linha 1: Botão "Voltar" (com weighty zero para não expandir)
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE; // Não permitir que estique o botão
        painelPrincipal.add(painelbtnVoltarVoltar, gbc);
    }


    // Teste isolado
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaListaAlunos().setVisible(true);
        });
    }
}

