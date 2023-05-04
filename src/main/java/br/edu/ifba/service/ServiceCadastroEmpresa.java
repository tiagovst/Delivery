package main.java.br.edu.ifba.service;

import java.awt.Color;
import javax.swing.JOptionPane;
import main.java.br.edu.ifba.model.Usuario;
import main.java.br.edu.ifba.model.UsuarioEmpresaDAO;
import main.java.br.edu.ifba.view.TelaCadastroEmpresa;

public class ServiceCadastroEmpresa {
    private TelaCadastroEmpresa telaCadastroEmpresa;
    private UsuarioEmpresaDAO usuarioEmpresaDAO;

    public ServiceCadastroEmpresa(TelaCadastroEmpresa telaCadastroEmpresa) {
        this.telaCadastroEmpresa = telaCadastroEmpresa;
        this.usuarioEmpresaDAO = new UsuarioEmpresaDAO();
    }
    
    
    public void cadastrar() {
        String senha = String.valueOf(this.telaCadastroEmpresa.getPsfSenhaEmpresa().getPassword());
        String confirmacaoSenha = String.valueOf(this.telaCadastroEmpresa.getPsfRepetirSenhaEmpresa().getPassword());
        
        Usuario usuarioCadastrado = new Usuario();
        
        usuarioCadastrado.setNome(this.telaCadastroEmpresa.getTxtNomeEmpresa().getText());
        usuarioCadastrado.setEmail(this.telaCadastroEmpresa.getTxtEmailEmpresa().getText());
        usuarioCadastrado.setSenha(senha);
        usuarioCadastrado.setEndereco(this.telaCadastroEmpresa.getTxtEnderecoEmpresa().getText());
        usuarioCadastrado.setTelefone(this.telaCadastroEmpresa.getfTxtTelefoneEmmpresa().getText());
        usuarioCadastrado.setCnpj(this.telaCadastroEmpresa.getfTxtCnpj().getText());
        
        if (senha.equals(confirmacaoSenha)){
            this.usuarioEmpresaDAO.inserir(usuarioCadastrado);
            JOptionPane.showMessageDialog(telaCadastroEmpresa, "Usuário cadastrado com sucesso!", "Info", 
                    JOptionPane.INFORMATION_MESSAGE);
            telaCadastroEmpresa.dispose();
        } else {
            this.telaCadastroEmpresa.getPsfSenhaEmpresa().setForeground(Color.red);
            this.telaCadastroEmpresa.getPsfRepetirSenhaEmpresa().setForeground(Color.red);
            JOptionPane.showMessageDialog(telaCadastroEmpresa, "As senhas inseridas estão diferentes.", "Erro", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
