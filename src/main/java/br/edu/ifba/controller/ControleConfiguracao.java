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
            this.telaConfiguracaoUsuario.getBtnEncerrar().addActionListener(this);
            
            this.telaConfiguracaoUsuario.setVisible(true);
        } else if (Sessao.getUsuarioLogado().equals("empresa")) {
            this.telaConfiguracaoEmpresa = new TelaConfiguracaoEmpresa();
            this.serviceConfiguracao = new ServiceConfiguracao(telaConfiguracaoEmpresa);
            
            //action listeners
            this.telaConfiguracaoEmpresa.getBtnLimparCampos().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnSalvar().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnLogout().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnDesligar().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnMeusProdutosAdicionar().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnMeusProdutosExcluir().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnMeusProdutosEditar().addActionListener(this);
            this.telaConfiguracaoEmpresa.getBtnEncerrar().addActionListener(this);

            this.serviceConfiguracao.listar();
            
            this.telaConfiguracaoEmpresa.setVisible(true);
        }
        serviceConfiguracao.mostrar();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        Ações para usuário cliente
        
        if (Sessao.getUsuarioLogado().equals("cliente")){
            if (ae.getSource().equals(this.telaConfiguracaoUsuario.getBtnLogout())) {
                this.serviceConfiguracao.logout();
            }
            if (ae.getSource().equals(this.telaConfiguracaoUsuario.getBtnSalvar())) {
                this.serviceConfiguracao.salvar();
            }
            if (ae.getSource().equals(this.telaConfiguracaoUsuario.getBtnLimparCampos())) {
                this.serviceConfiguracao.limparCampos();
            }
            if (ae.getSource().equals(this.telaConfiguracaoUsuario.getBtnDesligar())) {
                this.serviceConfiguracao.desligar();
            }
            if (ae.getSource().equals(this.telaConfiguracaoUsuario.getBtnEncerrar())) {
                this.serviceConfiguracao.encerrar();
            }
                   
        }
        
//        Ações para usuário empresa
        if (Sessao.getUsuarioLogado().equals("empresa")){
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnLogout())) {
                serviceConfiguracao.logout();
            }
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnSalvar())) {
                this.serviceConfiguracao.salvar();
            }
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnLimparCampos())) {
                this.serviceConfiguracao.limparCampos();
            }
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnDesligar())) {
                this.serviceConfiguracao.desligar();
            }
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnMeusProdutosAdicionar())) {
                this.serviceConfiguracao.manejoProduto("novo");
            }
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnMeusProdutosExcluir())) {
                this.serviceConfiguracao.excluirProduto();
            }
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnMeusProdutosEditar())) {
                this.serviceConfiguracao.manejoProduto("editar");
            }
            if (ae.getSource().equals(this.telaConfiguracaoEmpresa.getBtnEncerrar())) {
                this.serviceConfiguracao.encerrar();
            }
        
        }

    }
    
    
    
}
