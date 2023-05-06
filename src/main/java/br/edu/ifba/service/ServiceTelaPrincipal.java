package main.java.br.edu.ifba.service;

import java.util.ArrayList;
import main.java.br.edu.ifba.model.Produto;
import main.java.br.edu.ifba.model.ProdutoDAO;
import main.java.br.edu.ifba.view.TelaPrincipal;

public class ServiceTelaPrincipal {
    private TelaPrincipal telaPrincipal;
    private ProdutoDAO produtoDAO;

    public ServiceTelaPrincipal(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
        this.produtoDAO = new ProdutoDAO();
    }
    
    public void listar() {
        listaDados(produtoDAO.listar());
    }
    
    private void listaDados(ArrayList<Produto> listaProdutos) {     
        this.telaPrincipal.limpaTabela();
        for(int i=0;i<listaProdutos.size();i++){
            this.telaPrincipal.adicionaItem
                           (listaProdutos.get(i).getFoto(),
                           listaProdutos.get(i).getNome(),
                           listaProdutos.get(i).getPreco(),
                           listaProdutos.get(i).getQuantidade(),
                           listaProdutos.get(i).getEmpresa());
        }      
     
    }

    public void pesquisar() {
        listaDados(produtoDAO.pesquisar(this.telaPrincipal.getTxtPesquisa().getText()));
    }
    
}
