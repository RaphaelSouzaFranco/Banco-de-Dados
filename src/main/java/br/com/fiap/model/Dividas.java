package br.com.fiap.model;

public class Dividas {

    private int idDivida;
    private double valor;
    private String dataInicio;
    private String dataVencimento;
    private String descricao;
    private int parcelas;
    private double valorParcelas;
    private String statusDivida;
    private String credor;
    private double taxaJuros;
    private String formaPagamento;
    private String origemDivida;
    private int idUsuario;
    private int idConta;

    public Dividas() {
    }


    public Dividas(int idDivida, double valor, String dataInicio, String dataVencimento, String descricao,
                   int parcelas, double valorParcelas, String statusDivida, String credor, double taxaJuros,
                   String formaPagamento, String origemDivida, int idUsuario, int idConta) {
        this.idDivida = idDivida;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataVencimento = dataVencimento;
        this.descricao = descricao;
        this.parcelas = parcelas;
        this.valorParcelas = valorParcelas;
        this.statusDivida = statusDivida;
        this.credor = credor;
        this.taxaJuros = taxaJuros;
        this.formaPagamento = formaPagamento;
        this.origemDivida = origemDivida;
        this.idUsuario = idUsuario;
        this.idConta = idConta;
    }


    public int getIdDivida() {
        return idDivida;
    }

    public void setIdDivida(int idDivida) {
        this.idDivida = idDivida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public String getStatusDivida() {
        return statusDivida;
    }

    public void setStatusDivida(String statusDivida) {
        this.statusDivida = statusDivida;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getOrigemDivida() {
        return origemDivida;
    }

    public void setOrigemDivida(String origemDivida) {
        this.origemDivida = origemDivida;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "idDivida=" + idDivida +
                ", valor=" + valor +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataVencimento='" + dataVencimento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", parcelas=" + parcelas +
                ", valorParcelas=" + valorParcelas +
                ", statusDivida='" + statusDivida + '\'' +
                ", credor='" + credor + '\'' +
                ", taxaJuros=" + taxaJuros +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", origemDivida='" + origemDivida + '\'' +
                ", idUsuario=" + idUsuario +
                ", idConta=" + idConta +
                '}';
    }
}