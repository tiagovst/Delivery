package main.java.br.edu.ifba.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.br.edu.ifba.model.Sessao;
import main.java.br.edu.ifba.service.ServiceConfiguracao;
import main.java.br.edu.ifba.view.TelaConfiguracaoEmpresa;
import main.java.br.edu.ifba.view.TelaConfiguracaoUsuario;
import main.java.br.edu.ifba.view.TelaPrincipal;

public class ControleConfiguracao implements ActionListener{
    
    private TelaConfiguracaoUsuario telaConfiguracaoUsuario;
    private TelaConfiguracaoEmpresa telaConfiguracaoEmpresa;
    private ServiceConfiguracao serviceConfiguracao;
    private TelaPrincipal telaPrincipal;

    public ControleConfiguracao(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.telaPrincipal.setVisible(false);
        if (Sessao.getUsuarioLogado().equals("cliente")) {
            this.telaConfiguracaoUsuario = new TelaConfiguracaoUsuario();
            this.serviceConfiguracao = new ServiceConfiguracao(telaConfiguracaoUsuario);
            
            //action listeners
            this.telaConfiguracaoUsuario.getBtnLimparCampos().addActionListener(this);
            this.telaConfiguracaoUsuario.getBtnSalvar().addActionListener(this);
            this.telaConfiguracaoUsuario.getBtnLogout().addActionListener(this);
            this.telaConfiguracaoUsuario.getBtnDesligar().addActionListener(this);
            
            this.telaConfiguracaoUsuario.setVisible(true);
        } else if (Sessao.getUsuarioLogado().equals("empresa")) {
            this.telaConfiguracaoEmpresa = new TelaConfiguracaoEmpresa();
            this.serviceConfiguracao = new ServiceConfiguracao(telaConfiguracaoEmpresa);
            
            //action listeners
            this.telaConfiguracaoEmpresa.getBtnLimparCampos().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnSalvar().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnLogout().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnDesligar().addActionListener(this);
            
            this.telaConfiguracaoEmpresa.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        Ações para usuário cliente
        
        if (Sessao.getUsuarioLogado().equals("cliente")){
            if (ae.getSource().equals(this.telaConfiguracaoUsuario.getBtnLogout())) {
                serviceConfiguracao.logout();
            }        
        }
        
//        Ações para usuário empresa
        if (Sessao.getUsuarioLogado().equals("empresa")){
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnLogout())) {
                serviceConfiguracao.logout();
            }
        
        }

    }
    
    
    
}
