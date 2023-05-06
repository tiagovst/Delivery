package main.java.br.edu.ifba.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.br.edu.ifba.service.ServiceConfiguracao;
import main.java.br.edu.ifba.view.TelaConfiguracaoEmpresa;
import main.java.br.edu.ifba.view.TelaConfiguracaoUsuario;

public class ControleConfiguracao implements ActionListener{
    
    private TelaConfiguracaoUsuario telaCofiguracaoUsuario;
    private TelaConfiguracaoEmpresa telaConfiguracaoEmpresa;
    private ServiceConfiguracao serviceConfiguracao;

    public ControleConfiguracao(String tipoUsuario) {
        if (tipoUsuario.equals("cliente")) {
            telaCofiguracaoUsuario = new TelaConfiguracaoUsuario();
            serviceConfiguracao = new ServiceConfiguracao(telaCofiguracaoUsuario, tipoUsuario);
            //action listeners
            telaCofiguracaoUsuario.getBtnLimparCampos().addActionListener(this);
            telaCofiguracaoUsuario.getBtnSalvar().addActionListener(this);
            telaCofiguracaoUsuario.getBtnLogout().addActionListener(this);
            telaCofiguracaoUsuario.getBtnDesligar().addActionListener(this);
            telaCofiguracaoUsuario.setVisible(true);
        } else if (tipoUsuario.equals("empresa")) {
            serviceConfiguracao = new ServiceConfiguracao(telaConfiguracaoEmpresa, tipoUsuario);
            telaConfiguracaoEmpresa = new TelaConfiguracaoEmpresa();
            //action listeners
            telaConfiguracaoEmpresa.getBtnLimparCampos().addActionListener(this);
            telaConfiguracaoEmpresa.getBtnSalvar().addActionListener(this);
            telaConfiguracaoEmpresa.getBtnLogout().addActionListener(this);
            telaConfiguracaoEmpresa.getBtnDesligar().addActionListener(this);
            telaConfiguracaoEmpresa.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    
    
}
