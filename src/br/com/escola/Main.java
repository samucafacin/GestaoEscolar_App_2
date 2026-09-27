package br.com.escola.app;

import br.com.escola.views.MenuPrincipal;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new MenuPrincipal().setVisible(true)
        );
    }
}
