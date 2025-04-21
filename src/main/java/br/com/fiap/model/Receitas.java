package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.Date;

public class Receitas {
    private int idReceitas ;
    private double valor;
    private String data;
    private String origem;
    private Date vencimento;
    private String categoriaReceita;
    private String descricao;
    private String status;
    private String formaPagamento;
    private int conta;


    public Receitas(double valor, String data, String origem, int idReceitas, Date vencimento, String categoriaReceitas, String descricao, String status, String formaPagamento, int conta ) {
        this.valor = valor;
        this.data = data;
        this.origem = origem;
        this.idReceitas = idReceitas;
        this.vencimento = vencimento;
        this.categoriaReceita = categoriaReceita;
        this.descricao= descricao;
        this.status= status;
        this.formaPagamento = formaPagamento;
        this.conta= conta;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public Receitas(double valor, String data, String origem) {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getCategoriaReceita() {
        return categoriaReceita;
    }

    public void setCategoriaReceita(String categoriaReceita) {
        this.categoriaReceita = categoriaReceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getIdReceitas() {
        return idReceitas;
    }

    public void setIdReceitas(int idReceitas) {
        this.idReceitas = idReceitas;
    }

    public Receitas() {
    }

    public void exibirDados() {
        System.out.println("id: "+ idReceitas);
        System.out.println("Valor: R$" + valor);
        System.out.println("Data: " + data);
        System.out.println("Origem: " + origem);
        System.out.println("Vencimento: " + vencimento);
        System.out.println("Categoria: " + categoriaReceita);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
        System.out.println("Forma de Pagamento: "+ formaPagamento);
        System.out.println("Conta: "+ conta);

    }
}