package main.java.br.edu.ifba.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioEmpresaDAO extends UsuarioDAO{

    @Override
    public Usuario acesso(String nome, String senha) {
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
                usuario.setEndereco(rs.getString("endereço"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCnpj(rs.getString("cnpj"));
            }

            rs.close();
            pst.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return usuario;
    }
    
    @Override
    public int inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha, endereco, telefone, cnpj) VALUES (?, ?, md5(?), ?, ?, ?)";
        
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
                pst.setString(6, usuario.getCnpj());
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
    
    @Override
    public void alterar(Usuario usuario){
        
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = md5(?), endereco = ?, telefone = ?, cnpj = ? WHERE id = ?";
        
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getEndereco());
            pst.setString(5, usuario.getTelefone());
            pst.setString(6, usuario.getCnpj());
            pst.setInt(7, usuario.getId());
            pst.execute();
            pst.close();                
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
}
