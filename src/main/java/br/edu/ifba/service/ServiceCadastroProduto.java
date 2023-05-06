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
            Produto produto = new Produto();
            
            produto.setNome(telaCadastroProduto.getTxtCadastroNomeProduto().getText());
            
            
            produto.setPreco(Float.parseFloat(telaCadastroProduto.getTxtCadastroPrecoProduto().getText()));
            produto.setQuantidade(Integer.parseInt(telaCadastroProduto.getTxtCadastroQuantidadeProduto().getText()));
            
            Usuario usuario = usuarioDAO.pesquisar(Sessao.getId());
            produto.setEmpresa(usuario.getNome());
            
            produto.setFoto(this.telaCadastroProduto.getCaminhoImagem());
            produtoDAO.inserir(produto);
            
            this.salvarImagem();
            this.telaCadastroProduto.dispose();
            this.serviceConfiguracao.listar();
            this.telaConfiguracaoEmpresa.setVisible(true);
            
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
//    
//    FileInputStream fis = new FileInputStream(imagemArquivo);
//    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//    byte[] buffer = new byte[4096];
//    int bytesRead;
//    while ((bytesRead = fis.read(buffer)) != -1) {
//        baos.write(buffer, 0, bytesRead);
//    }
//    byte[] imagemBytes = baos.toByteArray();
    
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
    
    public void recebeImagem() {
            // converter o array de bytes em um objeto ImageIcon
        ImageIcon imagemIcon = new ImageIcon(this.telaCadastroProduto.getCaminhoImagem());

        // criar um JLabel e adicionar o ImageIcon
        this.telaCadastroProduto.getLblCadastroFotoProduto().setIcon(imagemIcon);
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
