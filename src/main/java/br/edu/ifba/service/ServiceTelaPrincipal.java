package main.java.br.edu.ifba.service;

import main.java.br.edu.ifba.model.ProdutoDAO;
import main.java.br.edu.ifba.view.TelaPrincipal;

public class ServiceTelaPrincipal {
    private TelaPrincipal telaPrincipal;
    private ProdutoDAO produtoDAO;

    public ServiceTelaPrincipal(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.produtoDAO = new ProdutoDAO();
    }
    
//    public void pesquisar()
}
