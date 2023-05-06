package main.java.br.edu.ifba.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    private static Connection conexao;
    
    public static Connection getConexao(){
        
        if(conexao == null){
            try{
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/delivery","root","");
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados!");
                throw new RuntimeException(e);
            }
        }
        return conexao;
        
    }

}
