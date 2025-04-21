package br.com.fiap.model;

public class Categoria {

    private String nome;
    private String tipo;
    private String descricao;

    public Categoria(String nome, String tipo, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;

        System.out.println("Categoria criada: " + nome + ", Tipo: " + tipo + ", descrição: " + descricao);

    }

     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}