package main.java.br.edu.ifba.service;

import javax.swing.JOptionPane;
import main.java.br.edu.ifba.controller.ControleLogin;
import main.java.br.edu.ifba.model.Sessao;
import main.java.br.edu.ifba.model.Usuario;
import main.java.br.edu.ifba.model.UsuarioDAO;
import main.java.br.edu.ifba.model.UsuarioEmpresaDAO;
import main.java.br.edu.ifba.view.TelaConfiguracaoEmpresa;
import main.java.br.edu.ifba.view.TelaConfiguracaoUsuario;

public class ServiceConfiguracao {
    
    private Usuario usuario;
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
            Usuario usuarioEditado = new Usuario();
            String senha = String.valueOf(telaConfiguracaoUsuario.getPsfEditSenha().getPassword());
            
            usuarioEditado.setNome(telaConfiguracaoUsuario.getTxtEditNome().getText());
            usuarioEditado.setEndereco(telaConfiguracaoUsuario.getTxtEditEndereco().getText());
            usuarioEditado.setTelefone(telaConfiguracaoUsuario.getTxtEditTelefone().getText());
            usuarioEditado.setEmail(telaConfiguracaoUsuario.getTxtEditEmail().getText());
            usuarioEditado.setSenha(senha);
            usuarioEditado.setCnpj("0");
            usuarioEditado.setId(Sessao.getId());
            
            if (validaCamposEdicao()) {
                usuarioDAO.alterar(usuarioEditado);
                JOptionPane.showMessageDialog(telaConfiguracaoUsuario, "Alterações salvas!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(telaConfiguracaoUsuario, "Preencha todos os campos!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (Sessao.getUsuarioLogado().equals("empresa")) {
            Usuario usuarioEditado = new Usuario();
            
            String senha = String.valueOf(telaConfiguracaoEmpresa.getPsfEditSenha().getPassword());
            
            usuarioEditado.setNome(telaConfiguracaoEmpresa.getTxtEditNome().getText());
            usuarioEditado.setEndereco(telaConfiguracaoEmpresa.getTxtEditEndereco().getText());
            usuarioEditado.setTelefone(telaConfiguracaoEmpresa.getTxtEditTelefone().getText());
            usuarioEditado.setEmail(telaConfiguracaoEmpresa.getTxtEditEmail().getText());
            usuarioEditado.setSenha(senha);
            usuarioEditado.setCnpj(telaConfiguracaoEmpresa.getTxtEditCNPJ().getText());
            usuarioEditado.setId(Sessao.getId());
            
            if (validaCamposEdicao()) {
                usuarioEmpresaDAO.alterar(usuarioEditado);
                JOptionPane.showMessageDialog(telaConfiguracaoUsuario, "Alterações salvas!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(telaConfiguracaoUsuario, "Preencha todos os campos!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
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
        System.exit(0);
    }
    
    public void mostrar() {
        if (Sessao.getUsuarioLogado().equals("cliente")) {
            telaConfiguracaoUsuario.getLblConfigCNPJ().setVisible(false);
            telaConfiguracaoUsuario.getTxtConfigCNPJ().setVisible(false);
            telaConfiguracaoUsuario.getLblEditCNPJ().setVisible(false);
            telaConfiguracaoUsuario.getTxtEditCNPJ().setVisible(false);
            
            Usuario usuario = usuarioDAO.pesquisar(Sessao.getId());
            
            telaConfiguracaoUsuario.getTxtConfigNome().setText(usuario.getNome());
            telaConfiguracaoUsuario.getTxtConfigEndereco().setText(usuario.getEndereco());
            telaConfiguracaoUsuario.getTxtConfigTelefone().setText(usuario.getTelefone());
            telaConfiguracaoUsuario.getTxtConfigEmail().setText(usuario.getEmail());
            
            telaConfiguracaoUsuario.getTxtEditNome().setText(usuario.getNome());
            telaConfiguracaoUsuario.getTxtEditEndereco().setText(usuario.getEndereco());
            telaConfiguracaoUsuario.getTxtEditTelefone().setText(usuario.getTelefone());
            telaConfiguracaoUsuario.getTxtEditEmail().setText(usuario.getEmail());
            telaConfiguracaoUsuario.getPsfEditSenha().setText(usuario.getSenha());

            
        } else if (Sessao.getUsuarioLogado().equals("empresa")) {
            Usuario usuario = usuarioEmpresaDAO.pesquisar(Sessao.getId());
            
            telaConfiguracaoEmpresa.getTxtConfigNome().setText(usuario.getNome());
            telaConfiguracaoEmpresa.getTxtConfigEndereco().setText(usuario.getEndereco());
            telaConfiguracaoEmpresa.getTxtConfigTelefone().setText(usuario.getTelefone());
            telaConfiguracaoEmpresa.getTxtConfigEmail().setText(usuario.getEmail());
            telaConfiguracaoEmpresa.getTxtConfigCNPJ().setText(usuario.getCnpj());
            
            telaConfiguracaoEmpresa.getTxtEditNome().setText(usuario.getNome());
            telaConfiguracaoEmpresa.getTxtEditEndereco().setText(usuario.getEndereco());
            telaConfiguracaoEmpresa.getTxtEditTelefone().setText(usuario.getTelefone());
            telaConfiguracaoEmpresa.getTxtEditEmail().setText(usuario.getEmail());
            telaConfiguracaoEmpresa.getPsfEditSenha().setText(usuario.getSenha());
            telaConfiguracaoEmpresa.getTxtEditCNPJ().setText(usuario.getCnpj());
            
        }
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
