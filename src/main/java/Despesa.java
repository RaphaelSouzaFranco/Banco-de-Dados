public class Despesa {
    private String data;
    private String descricao;
    private double valor;
    private String categoria;
    private String formaPagamento;
    private boolean status;


    public Despesa(String data, String descricao, double valor, String categoria, String formaPagamento, boolean pago) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.formaPagamento = formaPagamento;
        this.status = pago;
    }

    public void exibirDespesa() {
        System.out.println("Data do Pagamento: " + data);
        System.out.println("Descrição: " + descricao);
        System.out.println("Valor: " + valor);
        System.out.println("Categoria: " + categoria);
        System.out.println("Forma de Pagamento: " + formaPagamento);
        System.out.println("Status: " + (status ? "Pago" : "Pendente"));
    }

    // metodp para marcar a despesa como paga
    public void pagarDespesa() {
        if (!status) {
            status = true;
            System.out.println("Despesa marcada como paga.");
        } else {
            System.out.println("Despesa já estava paga.");
        }
    }
}
