package main.java.br.edu.ifba.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.br.edu.ifba.service.ServiceCadastroUsuario;
import main.java.br.edu.ifba.view.TelaCadastroUsuario;

public class ControleCadastroUsuario implements ActionListener{
    private TelaCadastroUsuario telaCadastroUsuario;
    private ServiceCadastroUsuario serviceCadastroUsuario;

    public ControleCadastroUsuario() {
        this.telaCadastroUsuario = new TelaCadastroUsuario();
        this.serviceCadastroUsuario = new ServiceCadastroUsuario(this.telaCadastroUsuario);
        
        this.telaCadastroUsuario.getBtnCadastrarUsuario().addActionListener(this);
        
        this.telaCadastroUsuario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.telaCadastroUsuario.getBtnCadastrarUsuario())) {
            serviceCadastroUsuario.cadastrar();
        }
    }
    
}
