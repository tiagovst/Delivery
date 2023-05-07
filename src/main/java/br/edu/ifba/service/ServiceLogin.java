package main.java.br.edu.ifba.service;

import javax.swing.JOptionPane;
import main.java.br.edu.ifba.controller.ControlePrincipal;
import main.java.br.edu.ifba.model.Sessao;
import main.java.br.edu.ifba.model.Usuario;
import main.java.br.edu.ifba.model.UsuarioDAO;
import main.java.br.edu.ifba.view.TelaLogin;

public class ServiceLogin {
    private TelaLogin telaLogin;
    private UsuarioDAO usuarioDAO;

    public ServiceLogin(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public void login() {
        String senha = String.valueOf(telaLogin.getPsfSenha().getPassword());

        
        Usuario usuarioLogin = usuarioDAO.acesso(telaLogin.getTxtLogin().getText(), senha);
        if(usuarioLogin.getId() > 0){
            telaLogin.dispose();
            
            Usuario userLog = usuarioDAO.pesquisar(usuarioLogin.getId());
            Sessao.setUsuario(userLog.getNome());
            if (!userLog.getCnpj().equals("0")) {
                Sessao.setUsuarioLogado("empresa");
                Sessao.setId(userLog.getId());
            } else {
                Sessao.setUsuarioLogado("cliente");
                Sessao.setId(userLog.getId());
            }
            ControlePrincipal controlePrincipal = new ControlePrincipal();
        } else{
            JOptionPane.showMessageDialog(telaLogin, "Acesso Negado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
