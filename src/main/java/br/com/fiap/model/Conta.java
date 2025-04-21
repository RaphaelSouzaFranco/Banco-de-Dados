package br.com.fiap.model;

import java.math.BigDecimal;

public class Conta {
    private Long idConta;  // Alterado de String para Long
    private String nomeConta;
    private String banco;
    private BigDecimal saldo;
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

    // Getters e Setters atualizados
    public Long getIdConta() { return idConta; }
    public void setIdConta(Long idConta) { this.idConta = idConta; }




    public Conta(Long id, String nome, String banco, BigDecimal saldo, TipoConta tipoConta) {
        this.idConta = id;
        this.nomeConta = nome;
        this.banco = banco;
        this.saldo = saldo;
        this.tipoConta = tipoConta;

    }
        public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nome) {
        this.nomeConta = nome;
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


    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nomeConta + '\'' +
                ", banco=" + banco + '\'' +
                ", saldo='" + saldo + '\'' +
                ", tipoConta='" + tipoConta + '\'' +
                '}';
    }


}
