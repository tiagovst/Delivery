package main.java.br.edu.ifba.components;

import javax.swing.*;
import main.java.br.edu.ifba.view.TelaLogin;

public class JOptionPaneCustomizado {
    
    public static String showConfirmationDialog(String message, TelaLogin telaLogin) {
        String[] options = {"Cliente", "Empresa"};
        int choice = JOptionPane.showOptionDialog(telaLogin, message, "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == JOptionPane.YES_OPTION) {
            return options[0];
        } else if (choice == JOptionPane.NO_OPTION) {
            return options[1];
        } else {
            return null;
        }
    }
}