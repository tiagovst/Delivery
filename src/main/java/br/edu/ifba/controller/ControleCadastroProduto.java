package main.java.br.edu.ifba.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.br.edu.ifba.service.ServiceCadastroProduto;
import main.java.br.edu.ifba.view.TelaCadastroProduto;
import main.java.br.edu.ifba.view.TelaConfiguracaoEmpresa;

public class ControleCadastroProduto implements ActionListener {
    private TelaCadastroProduto telaCadastroProduto;
    private ServiceCadastroProduto serviceCadastroProduto;

    public ControleCadastroProduto() {
        this.telaCadastroProduto = new TelaCadastroProduto();
        this.serviceCadastroProduto = new ServiceCadastroProduto(telaCadastroProduto);
        
        this.telaCadastroProduto.getBtnCarregarFoto().addActionListener(this);
        this.telaCadastroProduto.getBtnSalvar().addActionListener(this);
        this.telaCadastroProduto.getBtnLimpar().addActionListener(this);
        
        this.telaCadastroProduto.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(telaCadastroProduto.getBtnLimpar())){
            serviceCadastroProduto.limpar();
        }
        if (e.getSource().equals(telaCadastroProduto.getBtnCarregarFoto())){
            serviceCadastroProduto.upload();
        }
        if (e.getSource().equals(telaCadastroProduto.getBtnSalvar())){
            serviceCadastroProduto.salvar();
        }
    }
    
    
}
