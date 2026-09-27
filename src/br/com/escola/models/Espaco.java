package br.com.escola.models;

public class Espaco {private final String codigo;
    private String nome;
    private String tipo;
    private int capacidade;

    public Espaco(String codigo, String nome, String tipo, int capacidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.capacidade = capacidade;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getCapacidade() { return capacidade; }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }
}
