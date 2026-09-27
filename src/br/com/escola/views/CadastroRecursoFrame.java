package br.com.escola.views;

import br.com.escola.models.Espaco;
import br.com.escola.models.RecursoEducacional;
import br.com.escola.repository.BancoMemoria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CadastroRecursoFrame extends JFrame {

    private JTextField txtPatrimonio = new JTextField();
    private JTextField txtDescricao = new JTextField();
    private JComboBox<String> cmbCategoria = new JComboBox<>(new String[]{"Audiovisual", "Informática", "Mobiliário"});
    private JTextField txtQuantidade = new JTextField();
    private JComboBox<Espaco> cmbEspaco = new JComboBox<>();
    private JButton btnCadastrar = new JButton("Cadastrar Recurso");

    private DefaultTableModel modeloTabela = new DefaultTableModel(
            new String[]{"Patrimônio", "Descrição", "Categoria", "Qtd", "Espaço"}, 0
    );
    private JTable tabela = new JTable(modeloTabela);

    public CadastroRecursoFrame() {
        setTitle("Cadastro de Recursos Educacionais");
        setSize(830, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(6, 2, 5, 5));
        panelForm.add(new JLabel("Patrimônio:"));
        panelForm.add(txtPatrimonio);
        panelForm.add(new JLabel("Descrição:"));
        panelForm.add(txtDescricao);
        panelForm.add(new JLabel("Categoria:"));
        panelForm.add(cmbCategoria);
        panelForm.add(new JLabel("Quantidade:"));
        panelForm.add(txtQuantidade);
        panelForm.add(new JLabel("Espaço:"));
        panelForm.add(cmbEspaco);
        panelForm.add(new JLabel(""));
        panelForm.add(btnCadastrar);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        carregarEspacos();
        btnCadastrar.addActionListener(e -> cadastrar());
    }

    public void carregarEspacos() {
        cmbEspaco.removeAllItems();
        for (Espaco espaco : BancoMemoria.listarEspacos()) {
            cmbEspaco.addItem(espaco);
        }
    }

    private void cadastrar() {
        String patrimonio = txtPatrimonio.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String categoria = (String) cmbCategoria.getSelectedItem();
        Espaco espaco = (Espaco) cmbEspaco.getSelectedItem();

        if (patrimonio.isBlank() || descricao.isBlank() || espaco == null) {
            erro("Preencha os campos e selecione um espaço.");
            return;
        }

        int quantidade;
        try {
            quantidade = Integer.parseInt(txtQuantidade.getText().trim());
        } catch (NumberFormatException ex) {
            erro("A quantidade deve ser numérica.");
            return;
        }

        if (quantidade <= 0) {
            erro("A quantidade deve ser maior que zero.");
            return;
        }

        if (BancoMemoria.existePatrimonio(patrimonio)) {
            erro("Esse patrimônio já foi cadastrado.");
            return;
        }

        RecursoEducacional novo = new RecursoEducacional(patrimonio, descricao, categoria, quantidade, espaco);
        BancoMemoria.adicionarRecurso(novo);
        modeloTabela.addRow(new Object[]{patrimonio, descricao, categoria, quantidade, espaco.getCodigo()});
        limparCampos();
    }

    private void erro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    private void limparCampos() {
        txtPatrimonio.setText("");
        txtDescricao.setText("");
        txtQuantidade.setText("");
        txtPatrimonio.requestFocus();
    }
}