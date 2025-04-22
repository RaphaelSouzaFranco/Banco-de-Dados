package br.com.fiap.model;

import java.time.LocalDate;

public class Divida {

    private int ID_DIVIDA;
    private double VALOR;
    private LocalDate DATA_INICIO;
    private LocalDate DATA_VENCIMENTO;
    private String DESCRICAO;
    private int PARCELAS;
    private double VALOR_PARCELAS;
    private String STATUS_DIVIDA;
    private String CREDOR;
    private double TAXA_JUROS;
    private String FORMA_PAGAMENTO;
    private String ORIGEM_DIVIDA;
    private int USUARIO_ID_USUARIO;
    private int CONTA_ID_CONTA;

    public Divida() {
    }

    public Divida(int ID_DIVIDA, double VALOR, LocalDate DATA_INICIO, LocalDate DATA_VENCIMENTO, String DESCRICAO,
                  int PARCELAS, double VALOR_PARCELAS, String STATUS_DIVIDA, String CREDOR, double TAXA_JUROS,
                  String FORMA_PAGAMENTO, String ORIGEM_DIVIDA, int USUARIO_ID_USUARIO, int CONTA_ID_CONTA) {
        this.ID_DIVIDA = ID_DIVIDA;
        this.VALOR = VALOR;
        this.DATA_INICIO = DATA_INICIO;
        this.DATA_VENCIMENTO = DATA_VENCIMENTO;
        this.DESCRICAO = DESCRICAO;
        this.PARCELAS = PARCELAS;
        this.VALOR_PARCELAS = VALOR_PARCELAS;
        this.STATUS_DIVIDA = STATUS_DIVIDA;
        this.CREDOR = CREDOR;
        this.TAXA_JUROS = TAXA_JUROS;
        this.FORMA_PAGAMENTO = FORMA_PAGAMENTO;
        this.ORIGEM_DIVIDA = ORIGEM_DIVIDA;
        this.USUARIO_ID_USUARIO = USUARIO_ID_USUARIO;
        this.CONTA_ID_CONTA = CONTA_ID_CONTA;
    }

    public int getID_DIVIDA() {
        return ID_DIVIDA;
    }

    public void setID_DIVIDA(int ID_DIVIDA) {
        this.ID_DIVIDA = ID_DIVIDA;
    }

    public double getVALOR() {
        return VALOR;
    }

    public void setVALOR(double VALOR) {
        this.VALOR = VALOR;
    }

    public LocalDate getDATA_INICIO() {
        return DATA_INICIO;
    }

    public void setDATA_INICIO(LocalDate DATA_INICIO) {
        this.DATA_INICIO = DATA_INICIO;
    }

    public LocalDate getDATA_VENCIMENTO() {
        return DATA_VENCIMENTO;
    }

    public void setDATA_VENCIMENTO(LocalDate DATA_VENCIMENTO) {
        this.DATA_VENCIMENTO = DATA_VENCIMENTO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public int getPARCELAS() {
        return PARCELAS;
    }

    public void setPARCELAS(int PARCELAS) {
        this.PARCELAS = PARCELAS;
    }

    public double getVALOR_PARCELAS() {
        return VALOR_PARCELAS;
    }

    public void setVALOR_PARCELAS(double VALOR_PARCELAS) {
        this.VALOR_PARCELAS = VALOR_PARCELAS;
    }

    public String getSTATUS_DIVIDA() {
        return STATUS_DIVIDA;
    }

    public void setSTATUS_DIVIDA(String STATUS_DIVIDA) {
        this.STATUS_DIVIDA = STATUS_DIVIDA;
    }

    public String getCREDOR() {
        return CREDOR;
    }

    public void setCREDOR(String CREDOR) {
        this.CREDOR = CREDOR;
    }

    public double getTAXA_JUROS() {
        return TAXA_JUROS;
    }

    public void setTAXA_JUROS(double TAXA_JUROS) {
        this.TAXA_JUROS = TAXA_JUROS;
    }

    public String getFORMA_PAGAMENTO() {
        return FORMA_PAGAMENTO;
    }

    public void setFORMA_PAGAMENTO(String FORMA_PAGAMENTO) {
        this.FORMA_PAGAMENTO = FORMA_PAGAMENTO;
    }

    public String getORIGEM_DIVIDA() {
        return ORIGEM_DIVIDA;
    }

    public void setORIGEM_DIVIDA(String ORIGEM_DIVIDA) {
        this.ORIGEM_DIVIDA = ORIGEM_DIVIDA;
    }

    public int getUSUARIO_ID_USUARIO() {
        return USUARIO_ID_USUARIO;
    }

    public void setUSUARIO_ID_USUARIO(int USUARIO_ID_USUARIO) {
        this.USUARIO_ID_USUARIO = USUARIO_ID_USUARIO;
    }

    public int getCONTA_ID_CONTA() {
        return CONTA_ID_CONTA;
    }

    public void setCONTA_ID_CONTA(int CONTA_ID_CONTA) {
        this.CONTA_ID_CONTA = CONTA_ID_CONTA;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "ID_DIVIDA=" + ID_DIVIDA +
                ", VALOR=" + VALOR +
                ", DATA_INICIO=" + DATA_INICIO +
                ", DATA_VENCIMENTO=" + DATA_VENCIMENTO +
                ", DESCRICAO='" + DESCRICAO + '\'' +
                ", PARCELAS=" + PARCELAS +
                ", VALOR_PARCELAS=" + VALOR_PARCELAS +
                ", STATUS_DIVIDA='" + STATUS_DIVIDA + '\'' +
                ", CREDOR='" + CREDOR + '\'' +
                ", TAXA_JUROS=" + TAXA_JUROS +
                ", FORMA_PAGAMENTO='" + FORMA_PAGAMENTO + '\'' +
                ", ORIGEM_DIVIDA='" + ORIGEM_DIVIDA + '\'' +
                ", USUARIO_ID_USUARIO=" + USUARIO_ID_USUARIO +
                ", CONTA_ID_CONTA=" + CONTA_ID_CONTA +
                '}';
    }
}