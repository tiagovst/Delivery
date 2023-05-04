package main.java.br.edu.ifba.service;

import java.awt.Color;
import javax.swing.JOptionPane;
import main.java.br.edu.ifba.model.Usuario;
import main.java.br.edu.ifba.model.UsuarioDAO;
import main.java.br.edu.ifba.view.TelaCadastroUsuario;

public class ServiceCadastroUsuario {
    private TelaCadastroUsuario telaCadastroUsuario;
    private UsuarioDAO usuarioDAO;

    public ServiceCadastroUsuario(TelaCadastroUsuario telaCadastroUsuario) {
        this.telaCadastroUsuario = telaCadastroUsuario;
        this.usuarioDAO = new UsuarioDAO();
    }
    
    
    public void cadastrar() {
        String senha = String.valueOf(this.telaCadastroUsuario.getPsfSenhaUsuario().getPassword());
        String confirmacaoSenha = String.valueOf(this.telaCadastroUsuario.getPsfRepetirSenhaUsuario().getPassword());
        
        Usuario usuarioCadastrado = new Usuario();
        
        usuarioCadastrado.setNome(this.telaCadastroUsuario.getTxtNomeUsuario().getText());
        usuarioCadastrado.setEmail(this.telaCadastroUsuario.getTxtEmailUsuario().getText());
        usuarioCadastrado.setSenha(senha);
        usuarioCadastrado.setEndereco(this.telaCadastroUsuario.getTxtEnderecoUsuario().getText());
        usuarioCadastrado.setTelefone(this.telaCadastroUsuario.getfTxtTelefone().getText());
        
        if (senha.equals(confirmacaoSenha)){
            this.usuarioDAO.inserir(usuarioCadastrado);
            JOptionPane.showMessageDialog(telaCadastroUsuario, "Usuário cadastrado com sucesso!", "Info", 
                    JOptionPane.INFORMATION_MESSAGE);
            telaCadastroUsuario.dispose();
        } else {
            this.telaCadastroUsuario.getPsfSenhaUsuario().setForeground(Color.red);
            this.telaCadastroUsuario.getPsfRepetirSenhaUsuario().setForeground(Color.red);
            JOptionPane.showMessageDialog(telaCadastroUsuario, "As senhas inseridas estão diferentes.", "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
