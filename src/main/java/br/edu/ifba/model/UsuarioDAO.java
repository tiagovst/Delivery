package main.java.br.edu.ifba.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public int inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha, endereco, telefone) VALUES (?, ?, md5(?), ?, ?)";
        
            PreparedStatement pst;
            ResultSet rs;
            int lastId = 0;
            
            try {                
                pst = Conexao.getConexao().prepareStatement(sql);
                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getEmail());
                pst.setString(3, usuario.getSenha());
                pst.setString(4, usuario.getEndereco());
                pst.setString(5, usuario.getTelefone());
                pst.execute();
                rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    lastId = rs.getInt("id");
                }
                pst.close();
                rs.close();
                
            } catch (SQLException ex) {
                System.out.println(ex);
            } 
            
            return lastId;
    }
    
    public Usuario acesso(String nome, String senha){
        
        String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = md5(?)";
        Usuario usuario = new Usuario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
            rs = pst.executeQuery();

            while(rs.next()){
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setTelefone(rs.getString("telefone"));
            }

            rs.close();
            pst.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return usuario;
        
    }
    
    // pesquisar por nome
    public Usuario pesquisar(String nome){
        String sql = "SELECT * FROM usuario WHERE nome LIKE ?";
        
        Usuario usuario = new Usuario();
        usuario.setNome("");
        usuario.setEndereco("");
        usuario.setTelefone("");
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            
            while(rs.next()){
                usuario.setNome(rs.getString("nome"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setTelefone(rs.getString("telefone"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return usuario;
    }
    
    
    public void alterarSenha(Usuario usuario){
        
        String sql = "UPDATE usuario SET senha = md5(?) WHERE nome LIKE ?";
        
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getSenha());
            pst.setString(2, usuario.getNome());
            pst.execute();
            pst.close();                
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        // alterar endereço
        // apagar do banco
        
    }

}
