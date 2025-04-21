package br.com.fiap.model;

import java.math.BigDecimal;

public class Conta {

    private String idConta;
    private String nome;
    private BigDecimal saldo;
    private String banco;
    private String agencia;
    private String conta;
    private TipoConta tipoConta;

    public enum TipoConta {
        CORRENTE("org.example.Conta Corrente"),
        POUPANCA("org.example.Conta Poupança"),
        SALARIO("org.example.Conta Salário");

        private final String descricao;

        TipoConta(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }
    }

    public Conta(String joão, BigDecimal bigDecimal, String bancoA, String number, String s, TipoConta corrente) {
    }

    public Conta(String idConta, String nome, BigDecimal saldo, String banco, String agencia, String conta, TipoConta tipoConta) {
        this.idConta = idConta;
        this.nome = nome;
        this.saldo = saldo;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.tipoConta = tipoConta;
    }


    public String getIdConta() { return idConta; }

    public void setIdConta(String idConta) { this.idConta = idConta; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "org.example.Conta{" +
                "nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", banco='" + banco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", tipoConta='" + tipoConta + '\'' +
                '}';
    }


}