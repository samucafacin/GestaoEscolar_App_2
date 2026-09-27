package br.com.escola.views;

import br.com.escola.models.Espaco;
import br.com.escola.repository.BancoMemoria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CadastroEspacoFrame extends JFrame {

    private JTextField txtCodigo = new JTextField();
    private JTextField txtNome = new JTextField();
    private JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Sala", "Laboratório", "Auditório"});
    private JTextField txtCapacidade = new JTextField();
    private JButton btnCadastrar = new JButton("Cadastrar Espaço");

    private DefaultTableModel modeloTabela = new DefaultTableModel(
            new String[]{"Código", "Nome", "Tipo", "Capacidade"}, 0
    );
    private JTable tabela = new JTable(modeloTabela);

    public CadastroEspacoFrame() {
        setTitle("Cadastro de Espaços");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(5, 2, 5, 5));
        panelForm.add(new JLabel("Código:"));
        panelForm.add(txtCodigo);
        panelForm.add(new JLabel("Nome:"));
        panelForm.add(txtNome);
        panelForm.add(new JLabel("Tipo:"));
        panelForm.add(cmbTipo);
        panelForm.add(new JLabel("Capacidade:"));
        panelForm.add(txtCapacidade);
        panelForm.add(new JLabel(""));
        panelForm.add(btnCadastrar);

        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrar());
    }

    private void cadastrar() {
        String codigo = txtCodigo.getText().trim();
        String nome = txtNome.getText().trim();
        String tipo = (String) cmbTipo.getSelectedItem();

        if (codigo.isBlank() || nome.isBlank()) {
            erro("Preencha código e nome.");
            return;
        }

        int capacidade;
        try {
            capacidade = Integer.parseInt(txtCapacidade.getText().trim());
        } catch (NumberFormatException ex) {
            erro("A capacidade deve ser numérica.");
            return;
        }

        if (capacidade <= 0) {
            erro("A capacidade deve ser maior que zero.");
            return;
        }

        if (BancoMemoria.existeCodigoEspaco(codigo)) {
            erro("Já existe um espaço com esse código.");
            return;
        }

        Espaco novo = new Espaco(codigo, nome, tipo, capacidade);
        BancoMemoria.adicionarEspaco(novo);
        modeloTabela.addRow(new Object[]{codigo, nome, tipo, capacidade});
        limparCampos();
    }

    private void erro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtCapacidade.setText("");
        txtCodigo.requestFocus();
    }
}