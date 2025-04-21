package br.com.fiap.model;

import java.math.BigDecimal;
import java.util.Date;

public class Receitas {
    private int idReceitas ;
    private BigDecimal valor;
    private String data;
    private String origem;
    private Date vencimento;
    private String categoriaReceitas;
    private String descricao;
    private String status;
    private String formaPagamento;


    public Receitas(BigDecimal valor, String data, String origem, int idReceitas, Date vencimento, String categoriaReceitas, String descricao, String status, String formaPagamento  ) {
        this.valor = valor;
        this.data = data;
        this.origem = origem;
        this.idReceitas = idReceitas;
        this.vencimento = vencimento;
        this.categoriaReceitas = categoriaReceitas;
        this.descricao= descricao;
        this.status= status;
        this.formaPagamento = formaPagamento;
    }

    public Receitas(double valor, String data, String origem) {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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

    public String getCategoriaReceitas() {
        return categoriaReceitas;
    }

    public void setCategoriaReceitas(String categoriaReceitas) {
        this.categoriaReceitas = categoriaReceitas;
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
        System.out.println("Categoria: " + categoriaReceitas);
        System.out.println("Descrição: " + descricao);
        System.out.println("Status: " + status);
        System.out.println("Forma de Pagamento: "+ formaPagamento);

    }
}