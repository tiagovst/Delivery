package main.java.br.edu.ifba.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutoDAO {
    
    public int inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, foto, preco, quantidade, empresa) VALUES (?, ?, ?, ?, ?)";
        
            PreparedStatement pst;
            ResultSet rs;
            int lastId = 0;
            
            try {                
                pst = Conexao.getConexao().prepareStatement(sql);
                pst.setString(1, produto.getNome());
                pst.setBytes(2, produto.getFoto());
                pst.setFloat(3, produto.getPreco());
                pst.setInt(4, produto.getQuantidade());
                pst.setString(5, produto.getEmpresa());
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
    
    public void alterar(Produto produto){
        
        String sql = "UPDATE produto SET nome = ?, foto = ?, preco = ?, quantidade = ?, empresa = ? WHERE id = ?";
        
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setBytes(2, produto.getFoto());
            pst.setFloat(3, produto.getPreco());
            pst.setInt(4, produto.getQuantidade());
            pst.setString(5, produto.getEmpresa());
            pst.setInt(6, produto.getId());
            pst.execute();
            pst.close();                
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                      
        
    }
    
    public boolean excluir(Produto produto){
        String sql = "DELETE FROM produto WHERE id = ?";
        
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, produto.getId());
            pst.execute();
            pst.close();                
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
        return true;
    }
    
    // pesquisar por nome
    public ArrayList<Produto> pesquisar(String nome){
        String sql = "SELECT * FROM produto WHERE nome LIKE ? ORDER BY nome, preco, foto";
        
        ArrayList<Produto> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, "%" + nome + "%");
            rs = pst.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setFoto(rs.getBytes("foto"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setEmpresa(rs.getString("empresa"));
                lista.add(produto);
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return lista;
    }
    
    // pesquisar por id
    public Produto pesquisar(int id){
        String sql = "SELECT * FROM produto WHERE id = ?";
        
        Produto produto = new Produto();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            if(rs.next()){
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setFoto(rs.getBytes("foto"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return produto;
    }
    
    
    public ArrayList<Produto> listarPorEmpresa(String empresa){
        String sql = "SELECT * FROM produto WHERE empresa = ? ORDER BY nome, preco, foto";
        
        ArrayList<Produto> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, empresa);

            rs = pst.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setFoto(rs.getBytes("foto"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setEmpresa(rs.getString("empresa"));
                lista.add(produto);
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println("listarPorEmpresa: " + ex);
        }
        
        return lista;  
    }
    
      
    public ArrayList<Produto> listar(){
        String sql = "SELECT * FROM produto ORDER BY nome, preco, foto";
        
        ArrayList<Produto> lista = new ArrayList<>();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setFoto(rs.getBytes("foto"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setEmpresa(rs.getString("empresa"));
                lista.add(produto);
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return lista;  
    }
    
    public int proximoId(){
        
        String sql = "SELECT AUTO_INCREMENT AS ID FROM INFORMATION_SCHEMA.TABLES " +
                        "WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?";
        
        int id = 0;
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, "delivery");
            pst.setString(2, "produto");
            rs = pst.executeQuery();
            
            if(rs.next()){
                id = rs.getInt("ID");
            }
            
            rs.close();
            pst.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return id;
        
    }
    
}
