package main.java.br.edu.ifba.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.java.br.edu.ifba.model.Produto;
import main.java.br.edu.ifba.model.ProdutoDAO;
import main.java.br.edu.ifba.model.Sessao;
import main.java.br.edu.ifba.model.Usuario;
import main.java.br.edu.ifba.model.UsuarioDAO;
import main.java.br.edu.ifba.view.TelaCadastroProduto;
import main.java.br.edu.ifba.view.TelaConfiguracaoEmpresa;

public class ServiceCadastroProduto {
    private TelaCadastroProduto telaCadastroProduto;
    private TelaConfiguracaoEmpresa telaConfiguracaoEmpresa;
    private ProdutoDAO produtoDAO;
    private BufferedImage imagem;
    private UsuarioDAO usuarioDAO;
    private ServiceConfiguracao serviceConfiguracao;

    public ServiceCadastroProduto(TelaCadastroProduto telaCadastroProduto,
            TelaConfiguracaoEmpresa telaConfiguracaoEmpresa) {
        this.telaCadastroProduto = telaCadastroProduto;
        this.usuarioDAO = new UsuarioDAO();
        this.telaConfiguracaoEmpresa = telaConfiguracaoEmpresa;
        this.serviceConfiguracao = new ServiceConfiguracao(telaConfiguracaoEmpresa);
        this.produtoDAO = new ProdutoDAO();
        this.imagem = null;
        this.telaConfiguracaoEmpresa.setVisible(false);
    }
    
    public void salvar() {
        if (validaCampos()) {
            FileInputStream fis = null;
            try {
                Produto produto = new Produto();
                produto.setNome(telaCadastroProduto.getTxtCadastroNomeProduto().getText());
                produto.setPreco(Float.parseFloat(telaCadastroProduto.getTxtCadastroPrecoProduto().getText()));
                produto.setQuantidade(Integer.parseInt(telaCadastroProduto.getTxtCadastroQuantidadeProduto().getText()));
                Usuario usuario = usuarioDAO.pesquisar(Sessao.getId());
                produto.setEmpresa(usuario.getNome());
                fis = new FileInputStream(this.telaCadastroProduto.getCaminhoImagem());
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1536000000];
                
                int bytesRead;
                
                try {
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        baos.write(buffer, 0, bytesRead);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ServiceCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                byte[] imagemBytes = baos.toByteArray();
                produto.setFoto(imagemBytes);
                produtoDAO.inserir(produto);
//                this.salvarImagem();
                this.telaCadastroProduto.dispose();
                this.serviceConfiguracao.listar();
                this.telaConfiguracaoEmpresa.setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServiceCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(ServiceCadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
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
    
    public void mostrar(int id) {
        
        Produto produto = produtoDAO.pesquisar(id);
        
        this.telaCadastroProduto.getTxtCadastroNomeProduto().setText(produto.getNome());
        this.telaCadastroProduto.getTxtCadastroPrecoProduto().setText(String.valueOf(produto.getPreco()));
        this.telaCadastroProduto.getTxtCadastroQuantidadeProduto().setText(String.valueOf(produto.getQuantidade()));
        
        ImageIcon icon = new ImageIcon(produto.getFoto());
        this.telaCadastroProduto.getLblCadastroFotoProduto().setIcon(icon);
    }
    
    
}
