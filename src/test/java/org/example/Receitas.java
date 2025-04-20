package org.example;

public class Receitas {
    private double valor;
    private String data;
    private String origem;

    public Receitas(double valor, String data, String origem) {
        this.valor = valor;
        this.data = data;
        this.origem = origem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public String getOrigem() {
        return origem;
    }

    public void exibirDados() {
        System.out.println("Valor: R$" + valor);
        System.out.println("Data: " + data);
        System.out.println("Origem: " + origem);
    }
}


