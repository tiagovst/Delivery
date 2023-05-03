/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifba.model;

/**
 *
 * @author tiago
 */
public class UsuarioEmpresa extends Usuario {
    
    private String cnpj;
    
    public UsuarioEmpresa(String nome, String email, String senha, String endereco, 
            String telefone, String cnpj) {
        super(nome, email, senha, endereco, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
