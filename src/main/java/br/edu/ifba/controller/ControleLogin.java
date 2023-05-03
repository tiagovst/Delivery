package main.java.br.edu.ifba.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.java.br.edu.ifba.service.ServiceLogin;
import main.java.br.edu.ifba.view.TelaLogin;

public class ControleLogin implements ActionListener, KeyListener{

    private TelaLogin telaLogin;
    private ServiceLogin servicelogin;

    public ControleLogin() {
        this.telaLogin = new TelaLogin();
        this.servicelogin = new ServiceLogin(telaLogin);
        
        this.telaLogin.getBtnEntrar().addActionListener(this);
        this.telaLogin.getBtnRegistrar().addActionListener(this);
        this.telaLogin.getBtnTrocarSenha().addActionListener(this);
        this.telaLogin.setVisible(true);
        
    }
    
//    ActionPerformed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(telaLogin.getBtnEntrar())) {
            servicelogin.login();
        }
        if (e.getSource().equals(telaLogin.getBtnRegistrar())) {
        
        }
        if (e.getSource().equals(telaLogin.getBtnTrocarSenha())) {
        
        }
    }

    
//    KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
