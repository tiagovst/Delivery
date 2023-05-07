package main.java.br.edu.ifba.model;

public class Sessao {
    private static String usuarioLogado;
    private static String usuario;
    private static int id;

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String nomeUsuario) {
        Sessao.usuario = nomeUsuario;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Sessao.id = id;
    }
    
    public static String getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(String usuarioLogado) {
        Sessao.usuarioLogado = usuarioLogado;
    }
}
