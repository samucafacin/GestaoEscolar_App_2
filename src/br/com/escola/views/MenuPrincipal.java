package br.com.escola.views;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Gestão Escolar - Menu Principal");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        JButton btnEspacos = new JButton("Cadastrar Espaços");
        JButton btnRecursos = new JButton("Cadastrar Recursos");

        btnEspacos.addActionListener(e -> new CadastroEspacoFrame().setVisible(true));

        btnRecursos.addActionListener(e -> {
            CadastroRecursoFrame frameRecurso = new CadastroRecursoFrame();
            frameRecurso.carregarEspacos();
            frameRecurso.setVisible(true);
        });

        add(btnEspacos);
        add(btnRecursos);
    }
}