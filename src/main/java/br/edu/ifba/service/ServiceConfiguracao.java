package main.java.br.edu.ifba.service;

import main.java.br.edu.ifba.controller.ControleLogin;
import main.java.br.edu.ifba.model.Sessao;
import main.java.br.edu.ifba.model.UsuarioDAO;
import main.java.br.edu.ifba.model.UsuarioEmpresaDAO;
import main.java.br.edu.ifba.view.TelaConfiguracaoEmpresa;
import main.java.br.edu.ifba.view.TelaConfiguracaoUsuario;

public class ServiceConfiguracao {
    
    private TelaConfiguracaoUsuario telaConfiguracaoUsuario;
    private TelaConfiguracaoEmpresa telaConfiguracaoEmpresa;
    private UsuarioDAO usuarioDAO;
    private UsuarioEmpresaDAO usuarioEmpresaDAO;

    public ServiceConfiguracao(TelaConfiguracaoUsuario telaConfiguracaoUsuario) {
        this.telaConfiguracaoUsuario = telaConfiguracaoUsuario;
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public ServiceConfiguracao(TelaConfiguracaoEmpresa telaConfiguracaoEmpresa){
        this.telaConfiguracaoEmpresa = telaConfiguracaoEmpresa;
        this.usuarioEmpresaDAO = new UsuarioEmpresaDAO();
    }
    
    public void limparCampos(){
        if (Sessao.getUsuarioLogado().equals("cliente")) {
            telaConfiguracaoUsuario.getTxtEditNome().setText("");
            telaConfiguracaoUsuario.getTxtEditEndereco().setText("");
            telaConfiguracaoUsuario.getTxtEditTelefone().setText("");
            telaConfiguracaoUsuario.getTxtEditEmail().setText("");
            telaConfiguracaoUsuario.getPsfEditSenha().setText("");
        } else if (Sessao.getUsuarioLogado().equals("empresa")) {
            telaConfiguracaoEmpresa.getTxtEditNome().setText("");
            telaConfiguracaoEmpresa.getTxtEditEndereco().setText("");
            telaConfiguracaoEmpresa.getTxtEditTelefone().setText("");
            telaConfiguracaoEmpresa.getTxtEditEmail().setText("");
            telaConfiguracaoEmpresa.getPsfEditSenha().setText("");
            telaConfiguracaoEmpresa.getTxtEditCNPJ().setText("");
        }
    }
    
    public void salvar(){
        if (Sessao.getUsuarioLogado().equals("cliente")) {
            
        } else if (Sessao.getUsuarioLogado().equals("empresa")) {
            
        }
    }
    
    public void logout() {
        if (Sessao.getUsuarioLogado().equals("cliente")) {
            this.telaConfiguracaoUsuario.dispose();
            Sessao.setUsuarioLogado("");
            ControleLogin controleLogin = new ControleLogin();
        }
        
        
        if (Sessao.getUsuarioLogado().equals("empresa")) {
            this.telaConfiguracaoEmpresa.dispose();
            Sessao.setUsuarioLogado("");
            ControleLogin controleLogin = new ControleLogin();
        }
    }
    
    public void desligar() {
        
    }
    
    public void mostrar() {
    
    }
    
    public boolean validaCamposEdicao() {
        if (Sessao.getUsuarioLogado().equals("cliente")) {
            
            String senha = String.valueOf(this.telaConfiguracaoUsuario.getPsfEditSenha().getPassword());
            
            if (telaConfiguracaoUsuario.getTxtEditNome().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoUsuario.getTxtEditEndereco().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoUsuario.getTxtEditTelefone().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoUsuario.getTxtEditEmail().getText().equals("")) {
                return false;
            } else if (senha.equals("")) {
                return false;
            }
        
        } else if (Sessao.getUsuarioLogado().equals("empresa")) {
            
            String senha = String.valueOf(this.telaConfiguracaoEmpresa.getPsfEditSenha().getPassword());
            
            if (telaConfiguracaoEmpresa.getTxtEditNome().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getTxtEditEndereco().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getTxtEditTelefone().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getTxtEditEmail().getText().equals("")) {
                return false;
            } else if (senha.equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getTxtEditCNPJ().getText().equals("")) {
                return false;
            } 
            
        }
        return true;
        
    }
    
}
