package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.InstrutorController;

import java.util.List;

import model.entities.Aluno;
import model.entities.Instrutor;

public class TelaListaAlunos extends JFrame implements ViewDadosAluno {

    private static final long serialVersionUID = 1L;
    private JTable tabelaAlunos;
    private DefaultTableModel modeloTabela;
    private Instrutor instrutorLogado;
    private InstrutorController instrutorController;

    public TelaListaAlunos(Instrutor instrutorLogado, InstrutorController instrutorController) {
        super("IFitness");
        this.instrutorLogado = instrutorLogado;
        this.instrutorController = instrutorController;
        VisualizarDados();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void VisualizarDados() {

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
        
        List<Aluno> listaAlunos = instrutorLogado.getAlunos();
        
        // Isso cria a matriz de dados da tabela com base na lista real do instrutor
        Object[][] Alunos = new Object[listaAlunos.size()][3];
        
        //E aqui é feito o preencimento dos dados 
        for (int i = 0; i < listaAlunos.size(); i++) {
            Aluno aluno = listaAlunos.get(i);
            Alunos[i][0] = aluno.getNome();
            Alunos[i][1] = aluno.getIdade();
            Alunos[i][2] = aluno.getMatricula();
        }

        modeloTabela = new DefaultTableModel(Alunos, colunas) {
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

        // Centraliza o conteúdo das células
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
        btnVoltar.setPreferredSize(new Dimension(120, 35));
        btnVoltar.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaMenu(instrutorLogado, instrutorController).setVisible(true);
	        	dispose();				
			}
        	
        });
        painelbtnVoltarVoltar.add(btnVoltar);
     
        gbc.gridy = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE; // Não permitir que estique o botão
        painelPrincipal.add(painelbtnVoltarVoltar, gbc);
    }

}

