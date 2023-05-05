package main.java.br.edu.ifba.service;

import main.java.br.edu.ifba.model.UsuarioDAO;
import main.java.br.edu.ifba.model.UsuarioEmpresaDAO;
import main.java.br.edu.ifba.view.TelaConfiguracaoEmpresa;
import main.java.br.edu.ifba.view.TelaConfiguracaoUsuario;

public class ServiceConfiguracao {
    
    private TelaConfiguracaoUsuario telaConfiguracaoUsuario;
    private TelaConfiguracaoEmpresa telaConfiguracaoEmpresa;
    private UsuarioDAO usuarioDAO;
    private UsuarioEmpresaDAO usuarioEmpresaDAO;
    private String tipoUsuario;

    public ServiceConfiguracao(TelaConfiguracaoUsuario telaConfiguracaoUsuario, String tipoUsuario) {
        this.telaConfiguracaoUsuario = telaConfiguracaoUsuario;
        this.usuarioDAO = new UsuarioDAO();
        this.tipoUsuario = tipoUsuario;
    }
    
    public ServiceConfiguracao(TelaConfiguracaoEmpresa telaConfiguracaoEmpresa, String tipoUsuario){
        this.telaConfiguracaoEmpresa = telaConfiguracaoEmpresa;
        this.usuarioEmpresaDAO = new UsuarioEmpresaDAO();
        this.tipoUsuario = tipoUsuario;
    }
    
    public void limparCampos(){
        if (tipoUsuario.equals("cliente")) {
            telaConfiguracaoUsuario.getTxtEditNome().setText("");
            telaConfiguracaoUsuario.getTxtEditEndereco().setText("");
            telaConfiguracaoUsuario.getTxtEditTelefone().setText("");
            telaConfiguracaoUsuario.getTxtEditEmail().setText("");
            telaConfiguracaoUsuario.getPsfEditSenha().setText("");
        } else if (tipoUsuario.equals("empresa")) {
            telaConfiguracaoEmpresa.getTxtEditNome().setText("");
            telaConfiguracaoEmpresa.getTxtEditEndereco().setText("");
            telaConfiguracaoEmpresa.getTxtEditTelefone().setText("");
            telaConfiguracaoEmpresa.getTxtEditEmail().setText("");
            telaConfiguracaoEmpresa.getPsfEditSenha().setText("");
            telaConfiguracaoEmpresa.getTxtEditCNPJ().setText("");
        }
    }
    
    public void salvar(){
        if (tipoUsuario.equals("cliente")) {
            
        } else if (tipoUsuario.equals("empresa")) {
            
        }
    }
    
    public void logout() {
        
    }
    
    public void desligar() {
        
    }
    
    public void mostrar() {
    
    }
    
    public boolean validaCamposEdicao(String tipoUsuario) {
        if (tipoUsuario.equals("cliente")) {
            if (telaConfiguracaoUsuario.getTxtEditNome().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoUsuario.getTxtEditEndereco().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoUsuario.getTxtEditTelefone().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoUsuario.getTxtEditEmail().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoUsuario.getPsfEditSenha().getText().equals("")) {
                return false;
            }
        
        } else if (tipoUsuario.equals("empresa")) {
            if (telaConfiguracaoEmpresa.getTxtEditNome().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getTxtEditEndereco().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getTxtEditTelefone().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getTxtEditEmail().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getPsfEditSenha().getText().equals("")) {
                return false;
            } else if (telaConfiguracaoEmpresa.getTxtEditCNPJ().getText().equals("")) {
                return false;
            } 
            
        }
        return true;
        
    }
    
}
