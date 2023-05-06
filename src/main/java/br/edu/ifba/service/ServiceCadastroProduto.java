package main.java.br.edu.ifba.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.java.br.edu.ifba.model.Produto;
import main.java.br.edu.ifba.model.ProdutoDAO;
import main.java.br.edu.ifba.view.TelaCadastroProduto;
import main.java.br.edu.ifba.view.TelaConfiguracaoEmpresa;

public class ServiceCadastroProduto {
    private TelaCadastroProduto telaCadastroProduto;
    private TelaConfiguracaoEmpresa telaConfiguracaoEmpresa;
    private ProdutoDAO produtoDAO;
    private BufferedImage imagem;

    public ServiceCadastroProduto(TelaCadastroProduto telaCadastroProduto) {
        this.telaCadastroProduto = telaCadastroProduto;
//        this.telaConfiguracaoEmpresa = telaConfiguracaoEmpresa;
        this.produtoDAO = new ProdutoDAO();
        this.imagem = null;
//        this.telaConfiguracaoEmpresa.setVisible(false);
    }
    
    public void salvar() {
        if (validaCampos()) {
            Produto produto = new Produto();
            
            produto.setNome(telaCadastroProduto.getTxtCadastroNomeProduto().getText());
            
            
            produto.setPreco(Float.parseFloat(telaCadastroProduto.getTxtCadastroPrecoProduto().getText()));
            produto.setQuantidade(Integer.parseInt(telaCadastroProduto.getTxtCadastroQuantidadeProduto().getText()));
            produto.setEmpresa("tiago");
            produto.setFoto(this.telaCadastroProduto.getCaminhoImagem());
            produtoDAO.inserir(produto);
            
            this.salvarImagem();
            this.telaCadastroProduto.dispose();
//            this.telaConfiguracaoEmpresa.setVisible(true);
            
        } else{
            JOptionPane.showMessageDialog(telaCadastroProduto, "Preencha todos os campos!","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void upload() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imagens (*.bmp, *.png, *.jpg)", 
                "bmp", "png", "jpg"));
        fileChooser.setDialogTitle("Abrir Imagem");
        fileChooser.showOpenDialog(telaCadastroProduto);//abre o arquivo
        
        File file = fileChooser.getSelectedFile();//abre o arquivo selecionados
		
        try{	
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            icon.setImage(icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
            telaCadastroProduto.getLblCadastroFotoProduto().setIcon(icon);
            this.telaCadastroProduto.setCaminhoImagem(file.getAbsolutePath());
            imagem = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            imagem.getGraphics().drawImage(icon.getImage(), 0, 0, null);
                  
        }catch(Exception e){
            JOptionPane.showMessageDialog(telaCadastroProduto, "Não obteve o carregamento do arquivo");
        }
    }
    
    private void salvarImagem(){
        
        try {
            File arquivo = new File(telaCadastroProduto.getCaminhoImagem());
            ImageIO.write(imagem, "jpg", arquivo);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(telaCadastroProduto, "Não foi possível enviar a imagem");
        }
        
    }
    
    public void limpar() {
        telaCadastroProduto.limpar();
    }
    
    private boolean validaCampos() {
        if(this.telaCadastroProduto.getTxtCadastroNomeProduto().getText().equals("")){
            return false;
        }
        else if(this.telaCadastroProduto.getTxtCadastroPrecoProduto().getText().equals("")){
            return false;
        }
        else if (this.telaCadastroProduto.getTxtCadastroQuantidadeProduto().getText().equals("")) {
            return false;
        }
        else if (this.telaCadastroProduto.getCaminhoImagem() == null) {
            return false;
        }
        else{
            return true;
        }
    }
}
