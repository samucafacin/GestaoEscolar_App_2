package br.com.escola.models;

public class RecursoEducacional {
    private final String patrimonio;
    private String descricao;
    private String categoria;
    private int quantidade;
    private Espaco espaco;

    public RecursoEducacional(String patrimonio, String descricao, String categoria, int quantidade, Espaco espaco) {
        this.patrimonio = patrimonio;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.espaco = espaco;
    }

    public String getPatrimonio() { return patrimonio; }
    public String getDescricao() { return descricao; }
    public String getCategoria() { return categoria; }
    public int getQuantidade() { return quantidade; }
    public Espaco getEspaco() { return espaco; }

    @Override
    public String toString() {
        return patrimonio + " - " + descricao;
    }
}
