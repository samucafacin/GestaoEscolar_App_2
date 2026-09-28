package br.com.escola.views;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Gestão Escolar - Menu Principal");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        try {
            ImageIcon icone = new ImageIcon(getClass().getResource("/icone.png"));
            setIconImage(icone.getImage());
        } catch (Exception e) {
            System.out.println("Ícone não encontrado: " + e.getMessage());
        }


        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));
        JButton btnEspacos = new JButton("Cadastrar Espaços");
        JButton btnRecursos = new JButton("Cadastrar Recursos");


        btnEspacos.addActionListener(e -> new CadastroEspacoFrame().setVisible(true));
        btnRecursos.addActionListener(e -> new CadastroRecursoFrame().setVisible(true));

        panelBotoes.add(btnEspacos);
        panelBotoes.add(btnRecursos);
        add(panelBotoes, BorderLayout.CENTER);


        JLabel lblRodaPe = new JLabel("Desenvolvido por Samuel Facin / SENAI", SwingConstants.CENTER);
        lblRodaPe.setFont(new Font("SansSerif", Font.ITALIC, 11));
        lblRodaPe.setForeground(Color.GRAY);
        lblRodaPe.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));

        add(lblRodaPe, BorderLayout.SOUTH);
    }
}