package main.java.br.edu.ifba.model;

public class Sessao {
    private static String usuarioLogado;
    private static int id;

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
