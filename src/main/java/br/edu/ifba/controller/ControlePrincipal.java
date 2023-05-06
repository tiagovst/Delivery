package main.java.br.edu.ifba.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.java.br.edu.ifba.service.ServiceTelaPrincipal;
import main.java.br.edu.ifba.view.TelaPrincipal;

public class ControlePrincipal implements ActionListener, KeyListener{
    private TelaPrincipal telaPrincipal;
    private ServiceTelaPrincipal serviceTelaPrincipal;

    public ControlePrincipal() {
        this.telaPrincipal = new TelaPrincipal();
        this.serviceTelaPrincipal = new ServiceTelaPrincipal(telaPrincipal);
        
        this.telaPrincipal.getBtnConfiguracao().addActionListener(this);
        this.telaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.telaPrincipal.getBtnConfiguracao())) {
            ControleConfiguracao controleConfiguracao = new ControleConfiguracao(this.telaPrincipal);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(telaPrincipal.getTxtPesquisa())){
//            this.serviceTelaPrincipal.pesquisar();
        }
    }
    
    
}
