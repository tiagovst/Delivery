package main.java.br.edu.ifba.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.br.edu.ifba.service.ServiceCadastroEmpresa;
import main.java.br.edu.ifba.view.TelaCadastroEmpresa;

public class ControleCadastroEmpresa implements ActionListener{
    private TelaCadastroEmpresa telaCadastroEmpresa;
    private ServiceCadastroEmpresa serviceCadastroEmpresa;

    public ControleCadastroEmpresa() {
        this.telaCadastroEmpresa = new TelaCadastroEmpresa();
        this.serviceCadastroEmpresa = new ServiceCadastroEmpresa(this.telaCadastroEmpresa);
        
        this.telaCadastroEmpresa.getBtnCadastrarEmpresa().addActionListener(this);
        
        this.telaCadastroEmpresa.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.telaCadastroEmpresa.getBtnCadastrarEmpresa())){
            this.serviceCadastroEmpresa.cadastrar();
        }
    }
    
    
}
