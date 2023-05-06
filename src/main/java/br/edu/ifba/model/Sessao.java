package main.java.br.edu.ifba.model;

public class Sessao {
    private static String usuarioLogado;

    public static String getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(String usuarioLogado) {
        Sessao.usuarioLogado = usuarioLogado;
    }
}
